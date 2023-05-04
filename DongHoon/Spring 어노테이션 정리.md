# Spring 어노테이션 정리

## @PathVariable

- Spring MVC에서 URL 경로의 일부를 파라미터로 사용할 수 있게 하는 어노테이션
- @RequestMapping 어노테이션 내부에서 사용
- /~/{id} 경로에서 id라는 변수를 parameter로 받아 사용할 때 @PathVariable을 사용

## @RequestBody

- HTTP 요청 본문을 자바 객체로 변환해주는 어노테이션
- POST, PUT, PATCH 같은 HTTP 요청에서 요청 본문에 담긴 데이터를 처리할 때 사용

## @RequestParam

- HTTP 요청에서 파라미터를 받아서 사용하는 어노테이션
- 요청 파라미터의 이름과 매핑되는 변수를 사용

## @RestController

- @Controller 어노테이션과 @ResponseBody 어노테이션을 합친 것
- JSON, XML 등의 형식으로 응답할 때 사용

## @Service

- **비즈니스 로직을 처리**하는 서비스 클래스임을 나타내는 어노테이션

## @Repository

- 데이터베이스와 연동되는 DAO(Data Access Object) 클래스임을 나타내는 어노테이션

## @RequestMapping

- 요청 URL과 요청 처리 메서드를 매핑하는 어노테이션
- value, method, params 등의 속성을 사용하여 URL과 요청 메서드를 설정할 수 있습니다.

## @PostMapping

- HTTP POST 요청을 처리하는 어노테이션
- CRUD 중 Create할 때 사용

## @GetMapping

- HTTP GET 요청을 처리하는 어노테이션
- CRUD 중 read할 때 사용

## @PatchMapping

- HTTP PATCH 요청을 처리하는 어노테이션
- CRUD 중 updata할 때 사용 → 일부만 수정할 때

## @DeleteMapping

- HTTP DELETE 요청을 처리하는 어노테이션
- CRUD 중 delete할 때 사용

## @Getter

- 해당 클래스의 모든 필드에 대한 Getter 메서드 생성

## @Setter

- 해당 클래스의 모든 필드에 대한 Setter 메서드 생성

## @Data

- @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 어노테이션을 한번에 적용

## @NoArgsConstructor

- 파라미터 없는 생성자를 생성합니다.

## @RequiredArgsConstructor

- 필드가 final이나 @NonNull인 필드만을 파라미터로 받는 생성자 생성

## @AllArgsConstructor

- 모든 필드를 파라미터로 받는 생성자를 생성

> **pathVariable**은 URL 경로에서 변수 값을 추출할 때 사용. 

**RequestBody**는 HTTP 요청 본문의 내용을 파싱하여 객체로 변환할 때 사용

**RequestParam**은 URL 쿼리 문자열에서 값을 추출할 때 사용합니다. 각각의 용도에 맞게 적절하게 사용
>