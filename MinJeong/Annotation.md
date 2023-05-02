# Annotation   

### @PathVariable   
URI 경로의 일부를 파라미터로 사용할 때 이용(URI 경로에서 값을 가져온다)   
템플릿 변수의 값을 추출하고 그 값을 메소드 변수에 할당하는데 사용된다.   
URI 템플릿 변수 이름과 메소드 매개변수 이름이 반드시 동일해야 하는 것은 아님   
```java   
@RequestMapping("/owners/{ownerId}", method=RequestMethod.GET)
public String findOwner(@PathVariable("ownerId") String theOwner, Model model) {
  // implementation omitted
}
```   
### @RequestBody   
JSON 데이터를 원하는 타입의 객체로 변환해야 하는 경우에 사용   
HTTP 요청의 body 내용을 전달받아 자바 객체로 변환/매핑하는 어노테이션   
```java   
@Controller 
public class MainController {
	// home.jsp 
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String home() { 
		return "home"; 
	} 

	@ResponseBody 
	@RequestMapping(value = "/test", method = RequestMethod.POST) 
	public void init(@RequestBody UserVO userVO) {
		userVO.getName(); // "kim" 
		userVO.getAge(); // 30 
	} 
}
```    
### @RequestParam   
쿼리 스트링에서 값을 가져온다.   
URL에 전달되는 파라미터를 메소드의 인자와 매칭시켜, 파라미터를 받아서 처리할 수 있다.   
**해당 어노테이션에 명시된 매개변수 값은 반드시 파라미터 값이 넘어와야 한다.** 넘어오지 않으면 400에러 발생함   
```java   
@GetMapping("/api/foos")
@ResponseBody
public String getFoos(@RequestParam(required = false) String id, defaultValue="charlie") { 
    return "ID: " + id;
}
```   
### @RequestMapping   
클라이언트에게 요청받는 주소를 클래스와 연결시켜주는 어노테이션/디폴트 GET 방식   
클래스와 메소드 두 곳에서 모두 사용 가능   
@RequstMapping(value="")와 같은 형태로 작성하며, 요청 들어온 URI의 요청과 Annotation value 값이 일치하면 해당 클래스나 메소드가 실행된다.    
```java
@Controller                   // 이 Class는 Controller 역할을 합니다
@RequestMapping("/user")      // 이 Class는 /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model) {
        //  GET method, /user 요청을 처리
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(Model model) {
        //  POST method, /user 요청을 처리
    }
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String addUser(Model model) {
        //  GET method, /user/info 요청을 처리
    }
}

```   
### @RestController   
(@Controller + @ResponseBody) 결합 형태의 어노테이션으로, 주 용도는 해당 클래스가 ajax 요청을 받아 Json/Xml 형태로 객체 데이터를 반환하는 것이다. 데이터 리턴   

### @Service   
비즈니스 로직이 들어가는 Service로 사용되는 클래스임을 명시하는 어노테이션   

### @Repository   
DB연동 작업을 하는 클래스인 DAO에 특화된 어노테이션   
해당 클래스에서 발생하는 DB 관련 예외를 spring의 DAOException으로 전환할 수 있는 장점이 있다.   



### @GetMapping   
RequestMapping(Method=RequestMethod.GET)과 똑같은 역할을 한다.   
```java   
@Controller                   // 이 Class는 Controller 역할을 합니다
@RequestMapping("/user")      // 이 Class는 /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @GetMapping("/")
    public String getUser(Model model) {
        //  GET method, /user 요청을 처리
    }
}
```     
### @PostMapping   
RequestMapping(Method=RequestMethod.POST)과 똑같은 역할을 한다.   
```java   
@Controller                   // 이 Class는 Controller 역할을 합니다
@RequestMapping("/user")      // 이 Class는 /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(Model model) {
        //  POST method, /user 요청을 처리
    }
}
```   
### @PatchMapping   
일부 정보를 수정할 때 Patch를 사용    
### @DeleteMapping   
기존의 정보를 삭제할 때 사용   
   
   
## Lombok의 대표적인 Annotation   
Lombok: 코드를 크게 줄여주어 가독성을 높일 수 있는 라이브러리   

### @Setter   
Class 모든 필드의 Setter method를 생성   
### @Getter   
Class 모든 필드의 Getter method를 생성   
### @NoArgsConstructor   
매개변수가 없는 생성자 구현   
### @RequiredArgsConstructor   
final, @NonNull이 있는 필드가 포함된 생성자를 구현   
### @AllArgsConstructor   
모든 필드를 매개변수로 갖는 생성자를 구현   
### @Data   
@Data = @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 를 한번에 설정해주는 편리한 어노테이션   
```java 
@Data
public class User{

}
```     