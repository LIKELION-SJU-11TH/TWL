# HTTP

## - HTTP header/ body

HTTP 통신을 사용하면 클라이언트와 서버 간에 두 가지 유형의 메세지를 전송할 수 있다. 클라이언트/브라우저가 요청을 서버로 보내고 서버가 브라우저로 응답을 보낸다. 두 메세지는 공통 포맷을 가지고 있고, 이는 HTTP Header와 HTTP Body를 포함한다.

- HTTP Header : HTTP Header는 HTTP 본문 및 요청/응답에 대한 정보를 포함한다. 본문에 대한 정보는 본문 컨텐츠 길이 등 본문 컨텐츠와 관련 있다. 
  - 요청/응답에 대한 정보는 요청 시간, 요청에 사용된 브라우저 등 일반 정보를 포함한다.
  - Header의 Property는 Name-Value 쌍으로 설정되며, ':'으로 구분된다.

- HTTP Body : 가져올 실제 데이터 컨텐츠/메세지 본문이 나타난다. 컨텐츠에는 요청한 리소스에 따라 HTML 코드, 이미지, CSS 스타일 시트, JavaScript 파일이 포함될 수 있다.

---
## - HTTP Method

HTTP Method란 클라이언트와 서버 사이에 이루어지는 요청과 응답 데이터를 전송하는 방식을 말한다. 간단하게 서버가 수행해야 할 동작을 지정하는 요청을 보내는 방법이다.

- 주요 메소드
  - GET : 리소스 조회
  - POST : 요청 데이터 처리
  - PUT : 리소스 덮어쓰기, 해당 리소스가 없다면 생성
  - PATCH : 리소스 부분 변경
  - DELETE : 리소스 삭제

- 기타 메소드
  - HEAD : 메시지 부분을 제외하고 상태 줄과 헤더만 반환
  - OPTIONS : 대상 리소스에 대한 통신 가능 옵션을 설명 (주로 CORS에서 사용)
  - CONNECT : 대상 자원으로 식별되는 서버에 대한 터널을 설정
  - TRACE : 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행

---
## - HTTP Status Code (상태 코드)

- 1xx (Information) : 조건부 응답

  - 100 : Continue (클라이언트로부터 일부 요청을 받았으며 나머지 정보를 계속 요청함)

- 2xx (Successful) : 성공

  - 200 : OK (요청이 성공적으로 수행되었음)

  - 201 : Created (PUT 메소드에 의해 원격지 서버에 파일 생성됨)

  - 202 : Accepted (웹 서버가 명령 수신함)
  
  - 203 : Non-Authoritative Information (요청이 성공적으로 수행 되었으나, 요청에 대한 검증이 되지 않음)
  
  - 204 : No Content (요청이 성공적으로 수행되었고, 응답 Payload에 보낼 데이터가 없음을 의미)
  
  - 205 : Reset Content (클라이언트가 컨텐츠를 재설정할 것을 요구)
  
  - 206 : Partial Content (서버가 GET 요청의 일부만 성공적으로 처리)

- 3xx (Redirection) : 리다이렉션 완료
  
  - 300 : Multiple Choices (요청에 대해 하나 이상의 리소스가 존재함)

  - 301 : Moved Permanently (요청 자원의 위치가 영구적으로 변경됨, Location 응답 헤더를 통해 자원의 변경된 URL 정보 전달)

  - 302 : Found (요청 자원의 위치가 임시적으로 변경됨, Location 응답 헤더를 통해 자원의 변경된 URL 정보 전달)
  
  - 303 : See Other (요청한 리소스를 다른 url에서 GET 요청을 통해 얻어야 함)

  - 304 : Not Modified (요청한 자원이 변경되지 않았으므로 클라이언트 로컬 캐시에 저장된 자원을 이용하라는 의미)
  
  - 307 : Temporary Redirect (302와 유사하며, 클라이언트는 HTTP 메소드를 유지한채 요청을 재송신할 필요가 있음을 의미)
  
  - 308 : Permanent Redirect (301과 유사하며, 클라이언트는 HTTP 메소드를 유지한채 요청을 재송신할 필요가 있음을 의미)

- 4xx (Client Error) : 요청 오류

  - 400 : Bad Request (요청 메시지 문법 오류)

  - 401 : Unauthorized (요청한 자원에 대한 인가 필요, 요청 자원을 실행하는데 필요한 적절한 권한이 없음을 의미)

  - 403 : Forbidden (요청한 자원에 대한 접근 차단)

  - 404 : Not Found (요청한 자원이 존재하지 않음)
  
  - 405 : Method Not Allowed (현재 리소스에 맞지 않는 메서드를 사용했음)
  
  - 406 : No Acceptable (알맞은 컨텐츠 타입이 없음)
  
  - 408 : Request Timeout (요청에 대한 응답 시간을 초과함)
  
  - 409 : Conflict (요청이 현재 서버 상태와 충돌)
  
  - 412 : Precondition Failed (서버가 요청자가 요청 시 부과한 사전조건을 만족하지 않음)
  
  - 413 : Payload Too Large (요청이 너무 커서 서버가 처리할 수 없음)
  
  - 429 : Too many Requests (클라이언트가 지정된 시간에 너무 많은 요청을 보냄)

- 5xx (Server Error) : 서버 오류

  - 500 : Internal Server Error (내부 서버 오류)
  
  - 501 : Not Implemented (클라이언트 요청에 대한 서버의 응답 수행 기능이 없음)
  
  - 502 : Bad Gateway (서버가 Gateway로부터 잘못된 응답을 수신)
  
  - 503 : Service Unavailable (서버가 요청을 처리할 준비가 되지 않음)
  
  - 504 : Gateway Timeout (서버가 Gateway 역할을 수행 중이며, 한 서버가 액세스하고 있는 다른 서버에서 적시에 응답을 받지 못함)
