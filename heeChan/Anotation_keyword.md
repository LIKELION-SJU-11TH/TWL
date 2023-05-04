<h2>1. @PathVariable</h2>

<br>

해당하는 값을 그대로 받아오고 링크에 그대로 연결됨<br>
보통 REST 통신에 사용한다. 어떤 자원을 식별할 떄 보통 사용한다.<br>
즉, /user 는 그냥 유저목록을 가져오는 것이고
/user/123의 경우 user중 id가 123인 유저를 가져오는것으로 볼 수 있다.
<br>

ex)<br>
```java

@GetMapping("/{userID}/{memo}")<br>
public String test(@PathVariable("UserID") String userId, @PathVariable("memo") String memo){
    /**logic**/
}

이상태에서 userID="123" 과 memo="test"를 입력시
http://~~.com/123/test 로 url이 열린다.

```

---
<h2>2. @RequestBody </h2>
이 어노테이션이 붙은 인자에는 http요청의 본문(body)이 그대로 전달된다.
HTTP 요청의 바디 내용을 통째로 자바 객체로 변환해서 매핑된 메소드 파라미터로 전달<br>


```java
@PostMapping("creat")
public void creatDto(@RequestBody PostDto postDto){
	this.postList.add(postDto)
}
create라는 url에서 postDto라는 데이터를 입력받으면 그 입력받는 내용을 객체 그대로 받는 것이 RequestBody 이다.
```

---
<h2>3. @RequestParam</h2>

<br>
@RequestParam은 사용자가 전달하는 값을 1:1로 매핑해주는 어노테이션이다. 보통 파라미터를 통해 값을 전달할 때 자주 사용한

```java
@PostMapping("delete")
public void deleteDto(@RequestParam("id") int id{
	this.postList.remove(id);
}

이 코드처럼 특정 값을 전달해서 매핑시키는 어노테이션으로 주로 검색에 사용된다.
```
---
<h2>4.@RestController</h2>

@Controller에 @ResponseBody가 결합된 어노테이션입니다. 즉, 백엔드 개발에서 데이터만 클라이언트에서 사용할 수 있게 보내주면 되는데 이 때 @ResponseBody가 필요합니다. 이걸 편안하게 해주는게 바로 RestController 이다. 그러면 클라이언트에서는 json 형태로 데이터를 받아서 마음대로 사용할 수 있다. 컨트롤러에서는 따로 뷰에 대해서는 생각하지 않아도 된다. <br>
Json 으로 반환할 거라면 Controller 대신 RestController를 쓰자

--- 
<h2>5.@Service</h2>

비즈니스 로직이나 respository layer 호출하는 함수에 사용된다. 서비스 레이어 클래스로 캡슐화 없이 모델 내 단독 인터페이스로써 제공되는 동작을 의미한다.

---
<h2>6.@Repository</h2>
스프링에서 지원핮 않는 Exception을 Spring Exception 으로 전환하기 위해서 사용하고 주로 데이터 접근에 사용 

---
<h2>7.@RequestMapping</h2>
특정 URL로 요청을 보내면 Controller에서 어떠한 방식으로 처리할지 정의 들어온 요청을 특정 메서드와 매핑 하기 위해 사용하는 것이 RequestMapping<br>

```java
@RequestMapping("/delete",method=RequsetMethod.GET)
public void deleteDto(@RequestParam("id") int id{
	this.postList.remove(id);
}

위의 코드를 긁어 왔는데 RequestMapping을 사용한다면 HTTP method를 정의해줘야한다.
```
--- 
<h2>8.@PostMapping,@GetMapping, @PatchMapping, @ DeletMapping</h2>

7번 어노테이션만 사용한다면 매번 URL로 요청을 보낼때 메서드 방식까지 써줘야하는 번거러움을 단 한 단어로 해결 해준 어노테이션들이다.<br>
공통적인 URL은 RequestMapping으로 클래스위에 설정해주고 이후에 연결될 URL을 8번 어노테이션들로 연결 시켜줄 수 있다.

---

<h1>LOMBOK</h1>

<h2>9.@Getter, @Setter</h2>
get,set 메서드를 변수 선언시 자동으로 생성해주는 개발에 있어서 편리한 요소이다.

---
<h2>10.@NoArgsController, @AllArgsConstructor</h2>
각각 default 생성자와 클래스 내의 모든 변수를 인스턴스로 갖는 생성자를 만들어 준다. 역시 java 개발의 감초같은 요소이다.

---

<h2>11.@RequiredArgsConstructor</h2>
클래스의 멤버변수중 final 키워드, 혹은 lombok 어노테이션인 @NonNull 이 붙은 멤버 변수만을 인스턴스로 갖는 생성자를 만들어 준다.
---
<h2>12.@Data</h2>

lombok의 모든 어노테이션을 포함하고있는 어노테이션 간편하게 사용하기에 좋다.