# Validation
데이터가 알맞게 들어오는지 검사

- 형식적 Validation : null, 형식에 맞는지, 정해진 길이에 맞는지 등을 검사
-> Controller에서 검사

- 논리적 Validation : DB를 통해 같은 이메일이 있는 지 등 검사
-> Service 에서 검사

## 정규표현식
#### ex) 이메일
문자 + @ + 문자 + . + 문자
->  `^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$`
- `^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*` : ^[0-9a-zA-Z]로 시작. [-_.]? 존재 할수도 안할수도, [0-9a-zA-Z]있는게 반복 할 수도 안할수도
- @
- `[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*` : [0-9a-zA-Z] 있고. [-_.]? 중간에 있을 수도 있고, [0-9a-zA-Z] 있는게 반복할수도 안할수도
- .
- `[a-zA-Z]{2,3}$` 


```java
public class RegexExample {
	public static void main(String[] args)  {
          String name = "홍길동";
          String tel = "010-1234-5678";
          String email = "test@naver.com";
         
          //유효성 검사
          boolean name_check = Pattern.matches("^[가-힣]*$", name);
          boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
          boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);

          //출력
          System.out.println("이름 : " + name_check);
          System.out.println("전화번호 : " + tel_check);
          System.out.println("이메일 : " + email_check);
	}
}
```

## @Valid이용
- dependency 추가
`implementation ‘org.springframework.boot:spring-boot-starter-validation:2.7.8`

* @NotNull: 해당 값이 null이 아닌지 검증함
* @NotEmpty: 해당 값이 null이 아니고, 빈 스트링(“”) 아닌지 검증함(“ “은 허용됨)
* @NotBlank: 해당 값이 null이 아니고, 공백(“”과 “ “ 모두 포함)이 아닌지 검증함
* @AssertTrue: 해당 값이 true인지 검증함
* @Size: 해당 값이 주어진 값 사이에 해당하는지 검증함(String, Collection, Map, Array에도 적용 가능)
* @Min: 해당 값이 주어진 값보다 작지 않은지 검증함
* @Max: 해당 값이 주어진 값보다 크지 않은지 검증함
* @Pattern: 해당 값이 주어진 패턴과 일치하는지 검증함

```java
@Getter
@RequiredArgsConstructor
public class SignUpUserRes {//Entity X, 컨트롤러로 들어오는 Param

	@NotNull
	private final String name;

	@Min(12)
	private final int age;

	@Email
	private final String email;

	@NotBlank
	private final String pw;
}
```

```java
//Controller의 createUser메서드
@PostMapping("/signup")
public String createUser(@RequestBody @Valid SignUpUserReq signUpUserReq) {
    userService.createUser(signUpUserReq);
    return "ok";
}
```

@Valid -> Controller에서만 동작

Dispatcher Servlet -> Controller  요청 전달
전달 과정에서 @Valid 처리

**직접 만들어야하는 경우**
```java
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(“\\d{3}-\\d{4}-\\d{4}”);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
```
```java
@Getter
@RequiredArgsConstructor
public class AddPhoneRequest {

    @Phone
    private final String phone;

}
```


## 코드 구현
### V1

```java
@PostMapping("/signup")
public String createUser(@RequestBody SignUpUserReq signUpUserReq) {
    String emailRegex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
    String email = signUpUserReq.getEmail();

    boolean email_check = Pattern.matches(emailRegex, email);

    if (!email_check) {
        return "not valid email";
    }

    userService.createUser(signUpUserReq);
    return "ok";
}
```

### V2
```java
@PostMapping("/signup")
public String createUser(@RequestBody @Valid SignUpUserReq signUpUserReq, BindingResult result) {
    if (result.hasErrors()) {
        return result.getFieldError().getDefaultMessage();
    }
    userService.createUser(signUpUserReq);
    return "ok";
}
```

**BindingResult**
검증오류가 발생할 시 오류 내용을 보관하는 객체
검증오류가 발생 -> BindingResult에 오류정보 담기 -> Controller호출 계속 진행

### V3
- @Pattern으로 정규표현식 지정 가능
- message = “내용” 으로 에러 메시지 지정 할 수 있음.

```java
@Getter
public class SignUpUserReq {
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    private int age;

    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", message = "올바른 형식의 이메일을 입력해주세요.")
    private String email;

    private String password;
}
```

# 논리적 Validation
회원가입 시 이미 존재하는 이메일이라면 가입을 제한해야 함.

**작업 흐름**
1. SignUpReq에 정보를 담아 Controller에 도착함.
2. Controller에서 email의 형식이 맞는지, 비밀번호의 강도 등을 검사. (형식적)
3. 유저를 저장하기 위해 Controller에서 Service로 이동.
4. SignUpReq에 담긴 email로 DB검색.
5. DB에 이미 그 이메일로 가입한 유저 있을 시 가입 차단. (논리적)
6. 유저 없을 시 DB에 유저 저장.

