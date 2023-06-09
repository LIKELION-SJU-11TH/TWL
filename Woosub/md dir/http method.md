# HTTP
HTTP(Hypertext Transfer Protocol)는 인터넷에서 데이터를 주고 받기 위해 사용되는 프로토콜 중 하나이다.
HTTP는 웹 브라우저와 웹 서버 간의 통신에 사용된다.

* HTTP는 클라이언트가 서버에게 요청(Request)를 보내면, 서버는 해당 요청에 대한 응답(Response)을 보내는 구조이다. <br>클라이언트는 요청 메서드(Request Method)를 사용하여 서버에게 데이터를 요청하면, 서버는 상태 코드(Status Code)를 사용하여 응답 상태를 전달한다.
    * Request 란?
        * HTTP Method와 요청 URL, 요청 헤더, 요청 바디 등으로 구성된다.
        * 요청 메시지를 보낼 때, 클라이언트는 서버에게 필요한 정보를 요청 헤더와 요청 바디에 담아 보낸다.
        * 요청 URL은 요청한 자원의 위치를 나타낸다.
        > 요청 헤더는 HTTP 메서드, URL, 사용자 에이전트 정보, 쿠키 정보 등이 포함된다.<br>클라이언트가 서버에게 어떤 페이지를 요청할 때, 브라우저 유형, 언어 설정, 쿠키 정보 등을 포함하여 요청 헤더에 담아 보낼 수 있다.<br><br>요청 바디는 주로 POST 메서드에서 사용되며, 클라이언트가 서버에게 데이터를 전송할 때, 요청 바디에 데이터를 담아 보냅니다.<br>예를 들어, 회원 가입 폼에 입력한 정보를 서버에 전송할 때, 요청 바디에 입력한 정보를 담아 보냅니다.
      
    * Response 란?
        * HTTP 상태 코드와 응답 헤더, 응답 바디 등으로 구성된다.
        * HTTP 상태 코드는 요청에 대한 처리 결과를 나타낸다.
            * 예를 들어 200번대 코드는 성공, 400번대 코드는 클라이언트 오류, 500번대 코드는 서버 오류를 의미한다.
        > 응답 헤더는 HTTP 상태 코드, 쿠키 정보, 캐시 정보 등이 포함된다.<br>예를 들어, 서버에서 클라이언트가 요청한 페이지를 찾을 수 없을 때, 404 Not Found 상태 코드를 응답 헤더에 포함하여 클라이언트에게 전송한다.<br><br>응답 바디는 HTML, JSON, XML 등의 형식으로 클라이언트에게 전송되며, 클라이언트는 응답 바디에서 전송받은 데이터를 이용하여 웹 페이지를 표시하거나 앱에서 사용하는 데이터를 처리합니다.
* HTTP는 웹에서 가장 널리 사용되는 프로토콜 중 하나이며, 웹 브라우저와 웹 서버 간의 통신뿐만 아니라, 웹 API를 이용하여 다양한 애플리케이션 간의 통신에도 사용됩니다.

<br>

### Http 메서드 
클라인언트가 서버에게 요청을 보낼 때 어떤 종류의 요청인지를 나타내는 방식이다.
<br>
HTTP Method를 이용하여 클라이언트와 서버 간에 데이터를 주고받으며, 웹 애플래케이션을 만드는데 필수적이다.

* GET
    * 서버로부터 정보를 요청하는 메서드
    * URL 뒤에 파라미터를 붙여서 정보를 요청하며, 요청 결과가 URL에 노출됩니다.
    * 데이터를 조회할 때 주로 사용됩니다.

* POST
    * 서버에 데이터를 생성하거나 업데이트하는 메서드
    * URL 뒤에 데이터를 붙여서 요청하며, 요청 결과가 URL에 노출되지 않습니다.
    * 데이터를 생성하거나 수정할 때 사용됩니다.

* PUT
    * 서버에 데이터를 업데이트하는 메서드
    * URL 뒤에 데이터를 붙여서 요청하며, 요청 결과가 URL에 노출되지 않습니다.
    * 데이터를 업데이트할 때 사용됩니다.

* PATCH
    * 서버에 데이터의 일부를 업데이트하는 메서드
    * URL 뒤에 데이터를 붙여서 요청하며, 요청 결과가 URL에 노출되지 않습니다.
    * 데이터의 일부를 수정할 때 사용됩니다.

* DELETE
    * 서버에 데이터를 삭제하는 메서드
    * URL 뒤에 데이터를 붙여서 요청하며, 요청 결과가 URL에 노출되지 않습니다.
    * 데이터를 삭제할 때 사용됩니다.