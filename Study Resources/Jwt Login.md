# JWT 이용 로그인 기능 구현

## 의존성 추가

```java
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-security:2.7.8'          // Spring Security
    implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
	implementation 'io.jsonwebtoken:jjwt-impl:0.11.5'
	implementation 'io.jsonwebtoken:jjwt-jackson:0.11.5'                                    // Spring Json-Web-Token
}
```

## 흐름

**login**

1. User의 정보 클라이언트에서 넘어옴

2. User의 정보를 바탕으로 Access Token, Refresh Token 생성

3. TokenDto를 통해 Access Token, Refresh Token 응답



**인증 필요 요청**

1. 클라이언트의 Header에 X-ACCESS-TOKEN 확인

2. X-ACCESS-TOKEN을 내가 가지고 있는 Secret Key를 이용해 유효한지 확인

3. 권한 생성

4. Controller 도착

5. 비즈니스 로직에서 처리후 응답.

---

## SecurityConfig.class

dependency로 spring security를 추가함에 따라 모든 API로 요청을 보낼 시 인증이 필요하다. 하지만 홈 화면, 로그인 페이지, 회원가입 페이지 등은 인증이 필요 없이 접근이 가능해야하기 때문에 SecurityConfig 클래스를 만들어 401 unauthorized 에러를 해결할 필요가 있다.



```java
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/signup").permitAll()
                .antMatchers("/user/session-login").permitAll()
                .anyRequest().authenticated();
    }
}

```

---

## JWT secret key 준비

HS256 알고리즘을 사용할 계획이므로 256비트보다 큰 key를 준비한다.

터미널에 `openssl rand -hex 64` 명령어를 치면 64바이트의 무작위 키를 생성한다.

application.properties 또는 application.yml에 jwt의 secret key를 추가한다

```java
// application.properties
jwt.secret = 1623e1f2fa840cdb8997fe794295e78b312cfc2e6e007f2c4c16f87ad504cb0bfbbfb73785b01c608b5a8735c02b5b43c7d6e0bdabb7496c2a9904444d9e3aed;

// application.yml

jwt:
    secret: 1623e1f2fa840cdb8997fe794295e78b312cfc2e6e007f2c4c16f87ad504cb0bfbbfb73785b01c608b5a8735c02b5b43c7d6e0bdabb7496c2a9904444d9e3aed
```

---

## TokenDto

client에서 server로 토큰을 보내기 위한 DTO를 생성.

```java
public class PostJwtRes {
    private Long userId;
    private String accessToken;
    private String refreshToken;
}
```

---

## JwtUtils.class

```java
@Component
public class JwtUtils {

    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30; // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7; // 1주일

    private final Key key;

    public JwtUtils(@Value("${jwt.secret}") String jwtSecret) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public Map<String, String> generateToken(Long userId, String role) {
        int roleNo = 1;
        if (Objects.equals(role, "ROLE_ADMIN")) {
            roleNo = 99999;
        }

        String accessToken = Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .claim("uid", userId)
                .claim("uAuth", roleNo)
                .setExpiration(new Date(System.currentTimeMillis()+ACCESS_TOKEN_EXPIRE_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRE_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        Map<String, String> tokenInfo = new HashMap<>();
        tokenInfo.put("accessToken", accessToken);
        tokenInfo.put("refreshToken", refreshToken);

        return tokenInfo;
    }

    public String getJwt() {
        HttpServletRequest request
                = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        return request.getHeader("X-ACCESS-TOKEN");
    }

    public Long getUserId() throws BaseException{
        String accessToken = getJwt();

        if (accessToken == null) {
            throw new BaseException(BaseResponseStatus.NO_JWT);
        }

        try {
            Long userId = Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody()
                    .get("uid", Long.class);
            return userId;
        } catch (ExpiredJwtException expiredJwt) {
            throw new BaseException(BaseResponseStatus.EXPIRED_TOKEN);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.INVALID_TOKEN);
        }
    }

    public int getRoleNo() throws BaseException{
        String accessToken = getJwt();

        if (accessToken == null) {
            throw new BaseException(BaseResponseStatus.NO_JWT);
        }

        try {
            int roleNo = Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody()
                    .get("uAuth", Integer.class);
            return roleNo;
        } catch (ExpiredJwtException expiredJwt) {
            throw new BaseException(BaseResponseStatus.EXPIRED_TOKEN);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.INVALID_TOKEN);
        }
    }
}

```

@Component : class를 Bean에 등록하기 위한 어노테이션

@Value : application.properties 에서 값을 읽어오기



#### JwtUtils Constructor

```java
public JwtUtils(@Value("${jwt.secret}") String jwtSecret) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
}
```

생성자 부분이다. 파라미트를 jwtSecret(jwt의 secret key)를 입력해 jwtSecret을 BASE64로 디코딩 한 후 byte[] 배열에 넣는다. 이후 새로운 SecretKey를 HMAC-SHA알고리즘을 이용해 만들어준다. (만약 key byte array의 길이가 256비트보다 짧으면 예외를 발생시킨다고 한다.)



#### generateToken() - token 생성 메서드

```java
public Map<String, String> generateToken(Long userId, String role) {
        int roleNo = 1;
        if (Objects.equals(role, "ROLE_ADMIN")) {
            roleNo = 99999;
        }

        String accessToken = Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .claim("uid", userId)
                .claim("uAuth", roleNo)
                .setExpiration(new Date(System.currentTimeMillis()+ACCESS_TOKEN_EXPIRE_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRE_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        Map<String, String> tokenInfo = new HashMap<>();
        tokenInfo.put("accessToken", accessToken);
        tokenInfo.put("refreshToken", refreshToken);

        return tokenInfo;
    }
```

Returns : 메서드가 반환하는 형태는 accessToken과 refreshToken을 Map으로 반환을 할 것이다.

Params : user의 idx와 role을 jwt 의 payload에 넣기 위해 userId, role을 파라미터로 받았다.

**주요 메서드**

- setHeaderParams(String name, Object value) : header의 정보를 추가할 수 있는 메서드

- claim(String name, Object value) : jwt의 payload안 정보의 한 조각. (iss, sub, aud, exp, nbf, iat, jti 와 같은 registered claim같은 경우는 setSubject()와 같은 메서드를 통해 따로 설정할 수 있다.)

- setExpiration(Date exp) : jwt의 registered claim 설정하는 메서드. 현재 시간에서 Access Token의 수명을 더해주어 파라미터로 입력하였다.

- signWith(Key key, SignatureAlgorithm alg) : 지정된 알고리즘을 사용해 key로 서명하여 토큰을 생성한다.

- compact() : JWT를 빌드하고 규칙에 따라 직렬화한다.



#### getJwt()

```java
public String getJwt() {
        HttpServletRequest request
                = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        return request.getHeader("X-ACCESS-TOKEN");
    }
```

Return : 문자열 형태로 토큰을 반환.

헤더에서 "X-ACCESS-TOKEN"이라는 이름을 가진 헤더의 Value를 빼온다.



#### getUserId()

```java
public Long getUserId() throws BaseException{
        String accessToken = getJwt();

        if (accessToken == null) {
            throw new BaseException(BaseResponseStatus.NO_JWT);
        }

        try {
            Long userId = Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody()
                    .get("uid", Long.class);
            return userId;
        } catch (ExpiredJwtException expiredJwt) {
            throw new BaseException(BaseResponseStatus.EXPIRED_TOKEN);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.INVALID_TOKEN);
        }
    }
```

Return : userId를 Long 타입으로 반환해준다.

getJwt() 메서드를 통해 String 형태로 accessToken을 가져온다. 만약 JWT가 없거나, 만료되었거나, 유효하지 않다면 그에 맞는 예외를 발생시킨다.

**주요 메서드**

- `Jwts.parserBuilder().setSigningKey(key).build()` : key를 입력하여 JwtParser를 만든다. JwtParser는 jwt를 읽기 위해 사용된다.

- `parseClaimsJws(accessToken).getBody().get("uid", Long.class)` : accessToken을 입력해 Jws<Claims>를 만들어 getBody로 Claims를 빼온다. 이 Claims는 Map의 형태로 정보들이 저장되어있어 get()을 통해 우리가 원하는 userId를 뺄 수 있다.

getRoleNo는 getUserId와 구성이 같다.

---

## JwtFilter.class

```java
@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    public JwtFilter(JwtUtils jwtUtils, UserRepository userRepository) {
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        List<String> uriList = Arrays.asList(
                "/user/login",
                "/user/signup");

        // 1. Token이 필요 없는 경우.
        // 2. Http Method 가 OPTIONS인 경우.
        // - 1, 2와 같은 경우는 JWT토큰 확인하지 않음.
        // OPTIONS ? : 브라우저가 서버에게 지원하는 옵션들을 미리 요청 하는 목적 (preflight)
        if (uriList.contains(request.getRequestURI())
                || request.getMethod().equalsIgnoreCase("OPTIONS")) {

            if (uriList.contains(request.getRequestURI())) {
                log.info("NO NEED TOKEN URI : {}", request.getRequestURI());
            }

            filterChain.doFilter(request, response);
            return;
        }

        try {
            log.info("NEED TOKEN URI");
            Long userId = jwtUtils.getUserId();// getUserId() 메서드 안에 NO_JWT, EXPIRED_TOKEN, INVALID_TOKEN exception 있음.
            int roleNo = jwtUtils.getRoleNo();
            log.info("USER ID : {}", userId);

            if (roleNo == 99999) {
                User user = userRepository.findById(userId).orElseThrow(() -> new BaseException(BaseResponseStatus.NON_EXIST_USER));
                if (!Objects.equals(user.getRole(), User.Role.ROLE_ADMIN)) {
                    throw new BaseException(BaseResponseStatus.NO_AUTH);
                }
            }

            if (userId != null ) {
                log.info("DO FILTER");
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, roleNo, null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);
            }
        } catch (BaseException e) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter printWriter = response.getWriter();
            BaseResponse<Object> baseResponse = new BaseResponse<>(e.getStatus());
            String jsonRes = new ObjectMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(baseResponse); // BaseResponse 를 JSON object 로 직접 변환 시킴.
            printWriter.print(jsonRes);
            printWriter.flush();
            printWriter.close();
        }
    }

}
```

우리가 이 필터를 통해 얻고 싶은 것은 권한이 필요한 URI에 대하여 권한을 부여하고 이 필터를 통과하길 원한다. 회원가입 페이지, 로그인 페이지 등에는 이 필터를 바로 거쳐가며 나머지 권한이 필요한 URI면 이 필터에서 권한을 부여하고 거쳐가야한다.

#### doFilterInternal()

doFilter와 동일한 contract이지만 단일 요청 스레드 내에서 요청당 한번만 호출된다.

uriList라는 리스트에 필터를 바로 거쳐도 되는 URI를 저장한다.

```java
UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, roleNo, null);
SecurityContextHolder.getContext().setAuthentication(authenticationToken);
```

위 코드는 메서드 내에서 권한을 부여하는 부분이다.

UsernamePasswordAuthenticationToken : Authentication의 구현체, Spring Security에서 인증에 사용되는 특정 유형의 인증 토큰, 사용자 이름, 비밀번호를 기반으로 하는 인증 방식에 사용. 

UsernamePasswordAuthenticationToken의 생성자를 보면 두 종류가 있음

```java
public UsernamePasswordAuthenticationToken(Object principal, Object credentials) {
		super(null);
		this.principal = principal;
		this.credentials = credentials;
		setAuthenticated(false);


public UsernamePasswordAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true); // must use super, as we override
	}
```

공통된 파라미터로는 principle, credentials이 입력되는데 principle는 사용자를 식별하는 주체로 보통 사용자 이름이나 아이디 등이 입력된다. credentials은 사용자의 인증 자격 증명을 입력하는 부분으로 보통 비밀번호가 입력이 된다.

두번째 생성자에 있는 authorities는 사용자가 가지고 있는 권한 또는 역할 목록인데 이는 GrantedAuthority를 구현한 Collection의 형태로 입력하면 된다. 대표적으로 SimpleGrantedAuthority가 있다.



첫번째 생성자를 이용할 시 `setAuthenticated(false)`에 의해 해당 Authentication 객체를 사용하여 인증된 작업을 수행 할 수 없고 또한 UsernamePasswordAuthenticationToken.class의 setAuthenticated()을 사용해서 바꾸더라도 예외가 발생하게 된다. 그러므로 인증 작업을 수행하기 위해 두번째 생성자를 사용할 수 있도록 하자.

나는 권한 따로 설정하지 않고 credential에 역할을 넣고 authorities는 null로 넣었음.

```java
//UsernamePasswordAuthenticationToken.class의 setAuthenticated 메서드
@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		Assert.isTrue(!isAuthenticated,
				"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		super.setAuthenticated(false);
	}
```

##### 추가 설명) Filter 란?

Client에서 Server로 요청이 들어오는 상황을 보면 DispatcherServlet에 도착하기 이전에 Filter가 동작하고 그 다음 DispatcherServlet에 도착해 각 Controller로 맵핑된다.

필터를 사용하면 인코딩, CORS, XSS, LOG, 인증, 권한, 인가 등과 같은 작업에 대한 중복 코드를 줄여줄 수 있다.

필터의 작동방식

OncePerRequestFilter

Redirect가 있는 경우 여러번 Filter를 반복할 수 있다. 이런 문제를 해결하기 위해 OncePerRequestFilter가 나옴.

```java

public class myFilter extends OncePerRequestFilter {

    
    @Override
    protected void doFilterInternal(HttpServletRequest req
                                    , HttpServletResponse res
                                    , FilterChain fc) throws ServletException, IOException {
        log.info("first filter");
        fc.doFilter(req, res);

    }
}
```

프로젝트를 실행해보면 요청을 해보면 컨트롤러에 매핑 되기 전 "first filter"라는 로그가 찍히는 것을 확인할 수 있다.

---

## WebSecurityConfig.class

Spring security의 환경설정을 구성하기 위한 클래스

```java
@EnableWebSecurity
@Configuration
@Slf4j
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // csrf 보안 비활성화.
                .formLogin().disable()
                .authorizeRequests() // 요청에 대해 보안검사 시작
                .antMatchers("/user/signup").permitAll() // 해당 URI에 대해 모든 접근 허용
                .antMatchers("/user/session-login").permitAll()
                .antMatchers("/user/login").permitAll()
                .anyRequest().authenticated() // 나머지 요청에 대해 보안 검사.
                .and()
                .addFilterBefore(new JwtFilter(jwtUtils, userRepository), UsernamePasswordAuthenticationFilter.class);
    }
}
```










