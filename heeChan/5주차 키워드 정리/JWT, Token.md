# JWT, Token

**Token이란?**

- 클라이언트에 인증정보를 보관하는 방법을 말함, 세션 기반 인증은 클라이언트에서 유저정보를 요청 할 때마다 해당 정보를 줘도 되는지에 대해 세션 값 일치 여부를 확인했었다. 매 요청마다 DB를 살펴보는 것이 불편하고, 부담이 되었기 때문에 토큰 기반 인증 개념이 생겨 났다.
- 토큰은 쿠키를 한단계 발전시킨 방법으로 클라이언트에 유저정보를 암호화 한 상태로 담고 있어서 보안에 취약하지 않다. 이런 토큰의 한종류가 JWT이다.

**JWT (JSON Web Token)**

JSON 형식을 이용하여 사용자에 대한 속성을 저장하는 Claim 기반의 Web Token이다. JWT는 토큰 자체를 정보로 사용하는 Self-Contained 방식으로 정보를 안전하게 전달한다. 주로 **회원 인증**이나 정보 전달에 사용된다. ****

## JWT의 구성요소 3가지

1. 헤더 (Header)
    
    어떠한 알고리즘으로 암호화 할 것인지, 어떠한 토큰을 사용할 것 인지에 대한 정보가 들어있음
    
2. 정보 (Payload)
    
    전달하려는 정보가 들어있다. 인증이 필요한 최소한의 정보를 담아야한다.
    
3. 서명 (Signature)
    
    가장 중요한 부분으로 헤더와 페이로드를 합친 후 서버가 지정한 secret key로 암호화 시켜 토큰을 변조하기 어렵게 만들어 준다.
    

## JWT토큰의 종류

- Access 토큰 & Refresh Token
    
    보호된 정보들에 접근할 수 있는 권한 부여에 사용된다. 클라이언트가 처음 인증을 받게 될 때(로그인할 때) 두 토큰을 받는데 실제 권한을 얻는데 사용하는 토큰이 Access토큰이고 Access토큰이 기간이 만료될 때 마다 토큰을 재발급 해주는 것이 Refresh Token이다.
    

## JWT의 동작 원리

1. 사용자가 id와 password를 입력하여 로그인 요청을 한다.
2. 서버는 회원DB에 들어가 있는 사용자인지 확인을 한다.
3. Service에서 이 확인 과정을 거쳐 확인이 완료되면 서버는 로그인 요청을 확인 후 클라이언트에게 보낼 Signature 토큰을 생성한다.
4. 클라이언트는 받은 토큰을 저장한다. 이후 서비스 요청과 권한을 확인하기 위해서 헤더에 토큰을 담아보낸다.
5. 서버는 토큰을 확인하고 발급 된 토큰이 맞다면 클라이언트 요청을 처리한 후 응답을 보내준다.

토큰 기반의 인증방식은 사용자의 인증이 완료된 후에 토큰을 발급한다. 클라이언트는 전달 받은 토큰을 저장해두고 서버에 요청을 할 때 마다 해당 토큰을 서버에 함께 전달한다. 그 이후부터는 서버는 DB에 접근하는 멍청한 짓을 하지 않고 토큰을 검증해 응답하는 방식으로 작동한다.

### 일반 토큰 기반

토큰을 검증할 때 필요한 정보들을 서버에 저장해두고 있었기 때문에 항상 DB에 접근 해야만 했었다. Session 방식 또한 저장소에 저장해두었던 session ID를 찾아와 검증하는 절차를 가져 다소 번거롭게 느껴짐

### 클레임 토큰 기반 (JWT)

사용자 인증에 필요한 모든 정보를 토큰 자체에 담고 있기 때문에 별도의 인증 저장소가 필요 없다.