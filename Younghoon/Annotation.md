# Anotation

# @PathVariable, @RequestParam
@PathParam과 @PathVariable 두개의 어노테이션 모두 http의 비연결성을 극복하고 데이터를 전달하기 위한 방법들 중 하나로, uri를 통해 전달된 값을 파라미터로 받아오는 역할을 한다. 
<br>

# @RequestBody
@RequestBody 어노테이션은 HttpRequest의 본문 requestBody의 내용을 자바 객체로 매핑하는 역할을 합니다. 해당하는 어노테이션이 붙어있는 메서드로 클라이언트의 요청이 들어왔을 때, DispatcherServlet에서는 먼저 해당 HttpRequest의 미디어 타입을 확인하고, 타입에 맞는 MessageConverter를 통해 요청 본문인 requestBody를 통째로 변환해서 메서드로 전달해주게 됩니다.
<br>

# @RestController
@RestController는 @Controller에 @ResponseBody가 추가된 것입니다. 당연하게도 RestController의 주용도는 Json 형태로 객체 데이터를 반환하는 것입니다. 최근에 데이터를 응답으로 제공하는 REST API를 개발할 때 주로 사용하며 객체를 ResponseEntity로 감싸서 반환합니다. 이러한 이유로 동작 과정 역시 @Controller에 @ReponseBody를 붙인 것과 완벽히 동일합니다.
<br>

# @Request Mapping
Spring 개발 시 특정 URL로 요청(Request)을 보내면 Controller에서 어떠한 방식으로 처리할지 정의합니다. 이때 들어온 요청을 특정 method와 매핑하기 위해 사용하는 어노테이션이 바로 @RequestMapping입니다.
@RequestMapping은 Controller단에서 사용되는데, DispatcherServlet이 Controller 파일을 찾고, 논리적 주소가 매핑된 Method를 찾기 위해서는 @Controller와 @RequesetMapping이 작성되어야 합니다.
URL와 Controller의 method 매핑을 설정하는 어노테이션
<br>


# PostMapping / GetMapping / PatchMapping
Spring 4.3 버전에 추가된 내용으로는 기존의 @RequestMapping(value = "/", method="...")의 어노테이션의 사용을 조금 더 명시적고 효율적인 방법으로 사용하기 위해 @GetMapping, @PostMapping, DeleteMapping, @PutMapping, @PatchMapping의 메소드가 생기게 되었다.
<h2>작동 원리</h2>
*GET의 HTTP(S) request를 처리하는 @GetMapping<br>
*POST의 HTTP(S) request를 처리하는 PostMapping<br>
*DELETE의 HTTP(S) request를 처리하는 @DeleteMapping<br>
*PATCH와 PUT의 HTTP(S) request를 처리하는 @PutMapping과 @PatchMapping으로 사용됩니다.
<br><br>


# NoArgsConstructor
파라미터가 없는 생성자를 생성한다.
<br>
 
# RequiredArgesConstructor
초기화 되지 않은 모든 final 필드, @NonNull과 같이 제약조건이 설정되어있는 모든 필드들에 대한 생성자를 자동으로 생성한다.
<br>

# AllArgsConstructor
클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성한다.
<br>


