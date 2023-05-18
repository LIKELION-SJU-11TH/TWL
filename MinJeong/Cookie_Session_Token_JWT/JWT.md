# JWT (Json Web Token)   
**인터넷 표준 인증 방식**  
인증에 필요한 정보들을 Token에 담아 암호화시켜 사용하는 토큰   

### JWT 구성요소   
* Header   
    * Header에는 보통 토큰의 타입이나, 서명 생성에 어떤 알고리즘이 사용되었는지 저장    

* Payload   
    * payload에는 보통 Claim이라는 사용자에 대한, 혹은 토큰에 대한 property를 key-value의 형태로 저장 (*토큰에서 사용할 정보의 조각*)
    * 표준 스펙상 key의 이름은 3글자로 되어있다.
        * iss(Issuer): 토큰 발급자
        * sub(Subject): 토큰 제목 -> 토큰에서 사용자에 대한 식별 값이 됨   
        * aud(Audience): 토큰 대상자   
        * exp(Expriation Time): 토큰 만료 시간   

* Signature   
    * signature(서명)는 서버에 있는 개인키로만 암호화를 풀 수 있으므로 다른 클라이언트는 임의로 signature를 복호화할 수 없다.    