# Cookie   
key-Value 형식의 문자열   
HTTP의 일종으로 사용자가 어떠한 웹 사이트를 방문할 경우, 그 사이트가 사용하고 있는 서버에서 **사용자의 컴퓨터에 저장하는 작은 기록 정보 파일**   
HTTP에서 클라이언터의 상태 정보를 클라이언트의 PC에 저장하였다가 **필요시 정보를 참조하거나 재사용할 수 있다.**

### Cookie 특징   
1. 이름, 값, 만료일(저장 기간 설정), 경로 정보로 구성되어 있다.   
2. 클라이언터에 총 300개의 쿠키를 저장할 수 있다.   
3. 하나의 도메인 당 20개의 쿠키를 가질 수 있다.   
4. 하나의 쿠키는 4KB(= 4096byte)까지 저장 가능하다.   

### Cookie의 동작 순서   
1. 클라이언트가 페이지를 요청 (사용자가 웹사이트 접근)   
2. 웹 서버는 쿠키를 생성한다.   
3. 생성한 쿠키에 정보를 담아 HTTP 화면을 돌려줄 때, 같이 클라이언트에게 돌려준다.    
4. 넘겨 받은 쿠키는 클라이언트가 가지고 있다가(로컬 PC에 저장) 다시 서버에 요청할 때 요청과 함께 쿠키를 전송   
5. 동일 사이트에 재방문 시 클라이언트의 PC에 해당 쿠키가 있는 경우, 요청 페이지와 함께 쿠키를 전송    
*방문했던 사이트에 다시 방문했을 때, 아이디와 비밀번호 자동 입력*   


# Session   
일정 시간동안 같은 사용자로부터 들어오는 일련의 요구를 하나의 상태로 보고, 그 상태를 일정하게 유지시키는 기술   
여기서 일정 시간은 방문자가 웹 브라우저를 통해 웹 서버에 접속한 시점으로부터 웹 브라우저를 종료하여 연결을 끝내는 시점을 말함.   
**방문자가 웹 서버에 접속해 있는 상태를 하나의단위로 보고 그것을 세션이라고 함**

### Session 특징   
1. 웹 서버에 웹 컨테이너의 상태를 유지하기 위한 정보를 저장한다.   
2. 웹 서버의 저장되는 세션 쿠키   
3. 브라우저를 닫거나, 서버에서 세션을 삭제했을 때만 삭제가 되므로, 쿠키보다 비교적 보안이 좋다.   
4. 저장 데이터에 제한이 없다.   
5. 각 클라이언트 고유 Session ID를 부여한다. Session ID로 클라이언트를 구분하여 각 클라이언트 요구에 맞는 서비스 제공   

### Session의 동작 순서   
1. 클라리언트가 페이지를 요청   
2. 서버는 접근 가능한 클라이언트의 Request-Header 필드인 Cookie를 확인하여, 클라이언트가 해당 session-id를 보냈는지 확인   
3. session-id가 존재하지 않는다면, 서버는 session-id를 생성해 클라이언트에게 돌려준다.   
4. 서버에서 클라이언트로 돌려준 session-id를 쿠키를 사용해 서버에 저장한다.   
5. 클라이언트는 재접속 시, 이 쿠키를 이용하여 session-id 값을 서버에 전달   
*화면이 이동해도 로그인이 풀리지 않고 로그아웃하기 전까지 유지*


# Token   
토큰 기반 인증 시스템은 클라이언트가 서버에 접속을 하면 서버에서 해당 클라이언트에게 인증이 되었다는 의미로 '토큰'을 부여한다. 이 토큰은 **유일**하며 토큰을 발급받은 클라이언트는 또 다시 서버에 요청을 보낼 때 요청 헤더에 토큰을 심어서 보낸다. 그러면 서버에서는 클라이언트로부터 받은 토큰을 서버에서 제공한 토큰과의 일치 여부를 체크하여 인증 과정을 처리하게 된다. 

### Token 인증 방식   
1. 사용자가 아이디와 비밀번호로 로그인을 한다.   
2. 서버 측에서 사용자(클라이언트)에게 **유일한 토큰**을 발급한다.   
3. 클라이언트는 서버 측에서 전달받은 토큰을 쿠키나 스토리지에 저장해 두고, 서버에 요청을 할 때마다 해당 토큰을 HTTP 요청 헤더에 포함시켜 전달한다.   
4. 서버는 전달받은 토큰을 검증하고 요청에 응답한다.   
*토큰은 탈취당하면 대처가 어려움*