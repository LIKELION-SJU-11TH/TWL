# HTTP

## - HTTP header/ body
---
## - HTTP Method
---
## - HTTP Status Code

- 100 : Continue (클라이언트로부터 일부 요청을 받았으며 나머지 정보를 계속 요청함)

- 200 : OK (요청이 성공적으로 수행되었음)

- 201 : Created (PUT 메소드에 의해 원격지 서버에 파일 생성됨)

- 202 : Accepted (웹 서버가 명령 수신함)

- 301 : Moved Permanently (요청 자원의 위치가 영구적으로 변경됨, Location 응답 헤더를 통해 자원의 변경된 URL 정보 전달)

- 302 : Found (요청 자원의 위치가 임시적으로 변경됨, Location 응답 헤더를 통해 자원의 변경된 URL 정보 전달)

- 304 : Not Modified (요청한 자원이 변경되지 않았으므로 클라이언트 로컬 캐시에 저장된 자원을 이용하라는 의미)

- 400 : Bad Request (요청 메시지 문법 오류)

- 401 : Unauthorized (요청한 자원에 대한 인가 필요, 요청 자원을 실행하는데 필요한 적절한 권한이 없음을 의미)

- 403 : Forbidden (요청한 자원에 대한 접근 차단)

- 404 : Not Found (요청한 자원이 존재하지 않음)

- 500 : Internal Server Error (내부 서버 오류)
