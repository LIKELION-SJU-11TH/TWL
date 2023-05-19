# BaseResponse

```json
//회원가입 시
{
    "isSuccess": true,
    "code": 200,
    "message": "요청에 성공하였습니다.",
    "result": "회원가입에 성공하였습니다."
}

//userIdx를 통해 user를 조회 시
{
    "isSuccess": true,
    "code": 200,
    "message": "요청에 성공하였습니다.",
    "result": {
        "email": "ldc991104@gmail.com",
        "name": "이동찬",
        "age": 25
    }
}
```
우리는 클라이언트에게 응답을 보낼 때 위와 같은 형태로 요청이 성공 했는지, HttpStatus Code 등을 정해진 양식으로 보내고 싶음.

BaseResponse.class, BaseResponseStatus.class를 통해 위와 같은 JSON양식을 보낼 것.

---

## BaseResponse.class
```java
@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class BaseResponse<T> {
    private final Boolean isSuccess;
    private final String message;
    private final int code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 요청에 성공한 경우 (1번 생성자)
    public BaseResponse(T result) {
        this.isSuccess = true;
        this.message = "요청에 성공하였습니다.";
        this.code = 200;
        this.result = result;
    }

    // 요청에 실패한 경우 (2번 생성자)
    public BaseResponse(BaseResponseStatus status) {
        this.isSuccess = status.isSuccess();
        this.message = status.getMessage();
        this.code = status.getCode();
    }

}
```
**어노테이션 설명**
- @JsonPropertyOrder({"isSuccess", "code", "message", "result"}) : Json 직렬화 순서를 제어, 객체가 JSON의 형식의 문자열로 변환될 때 isSuccess, code, message, result순서로 변환.
- @JsonInclude(JsonInclude.Include.NON_NULL) : null인 객체는 직렬화 시 문자열로 변환하지 않음.

**\<T>**

- 제네릭 타입 매개변수, 클래스나 메서드에서 사용되는 타입을 일반화하는 데 사용.

- `BaseResponse<String> response = new BaseResponse<>(str);`와 같이 객체를 생성하면 result의 타입은 String이 되며 `BaseResponse<List> response = new BaseResponse<>(list);` 와 같이 생성하면 result의 타입은 List가 된다. 

- 위 두 코드에서 객체를 생성할 때 "1번 생성자"를 이용해 객체를 생성하였다. 1번 생성자를 이용해 객체를 생성했으므로 필드의 isSuccess, message, code는 각각 true, "요청에 성공하였습니다.", 200으로 값이 부여된다.

- 2번 생성자는 아래의 BaseResponseStatus를 학습하고 다시 알아보자.

---

## BaseResponseStatus.enum

```java
//BaseResponseStatus.enum
@Getter
public enum BaseResponseStatus {

	SCCUESS(true, 200, "요청에 성공하였습니다"), 
    NO_AUTH(false, 401, "권한이 없습니다."), 
    DATABASE_ERROR(false, 500, "데이터베이스 에러가 발생했습니다.");

	private final boolean isSuccess;
	private final int code;
	private final String message;
	
	private BaseResponseStatus(boolean isSuccess, int code, String message) {
		this.isSuccess = isSuccess;
		this.code = code;
		this.message = message;
	}
}
```
위 코드를 이해하기 위해 Enum을 알아야 한다.

**enum**

- enum은 열거형을 나타내는 java의 타입.
```java
public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}
```
- 위 코드는 계절을 나타내는 Enum을 만드는 간단한 예시이다.

- `Season currentSeason = Season.SPRING` 으로 currentSeason이라는 변수에 Season.enum의 SPRING이라는 Enum 상수를 할당할 수 있다.

- 각 Enum 상수에는 속성 또한 부여할 수 있다. 아래 코드를 보자
```java
public enum Season {
    SPRING(3,5),
    SUMMER(6,8), 
    AUTUMN(9,11), 
    WINTER(12,2);

    private final int startMonth;
    private final int endMonth;

    Season(int startMonth, int endMonth) {
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }
}
```
- 각 Enum 상수들을 startMonth, endMonth라는 속성을 가지며 생성자를 통해 해당 속성의 값을 초기화 하고 Enum 상수는 계절과 관련된 속성을 가질 수 있다.

다시 BaseResponseStatus.enum코드를 보면 SUCCESS, NO_AUTH, DATABASE_ERROR와 같은 Enum 상수를 가지고 각 상수는 요청이 성공했는지, HttpStatus Code, message를 나타내는 속성을 가지고 있다는 것을 알 수 있다.

아까 BaseResponseStatus를 학습한 이후에 알아보자고 하였던 BaseResponse.class의 2번 생성자를 보면 파라미터로 BaseResponseStatus의 Enum상수가 들어오면 Enum상수의 속성을 getter를 이용해 가져와 필드의 값을 부여하는 것을 이제 이해할 수 있다.

2번 생성자를 이용해 객체를 생성하려면 `BaseResponse<Object> response = new BaseResponse<>(BaseResponseStatus.NO_AUTH);`와 같이 생성할 수 있다. 

이렇게 코드를 작성하면 isSuccess, code, message에는 각각 false, 401, "권한이 없습니다."로 필드에 값이 부여가 된다. result에는 아무것도 할당하지 않았으므로 null이 되고 @JsonInclue 어노테이션에 따라 JSON으로 직렬화 시 생략되어 클라이언트에게는 보이지 않게 된다.

---
## BaseException.class

일반적인 예외 처리 로직과 달리, 예외가 발생한 상태를 명시적으로 표현하기 위해 사용자 정의 예외 클래스인 BaseException이 필요하다.

```java
//BaseException.class
@Getter
@Setter
public class BaseException extends RuntimeException {
    private BaseResponseStatus status;

    public BaseException(BaseResponseStatus status) {
        super(status.getMessage());
        this.status = status;
    }
}
```

- private BaseResponseStatus status; : 해당 예외의 상태를 나타내는 BaseResponseStatus객체. 예외가 발생한 상태에 대한 정보를 가지고 있음.
- public BaseException(BaseResponseStatus status) : 생성자. 예외 객체를 생성할 때 `this.status = status`로 해당 예외의 상태를 설정.
- super(status.getMessage()); : 부모 클래스인 RuntimeException의 생성자 호출. 예외의 메시지로 status의 message 사용.

---

## 코드 사용 에시

### 1. 요청에 성공해 GetUserRes.class라는 DTO를 result로 반환
```java
// UserController.class
@GetMapping(value = "/", params = "userId")
    public BaseResponse<GetUserRes> getUserById(@RequestParam Long userId) { 
        GetUserRes userRes = userService.getUserById(userId);
        return new BaseResponse<>(userRes);
    }
```
- getUserById 라는 메서드는 반환하는 값으로 BaseResponse\<GetUserRes>를 반환함.
- BaseResponse의 result 타입은 GetUserRes가 된다.
- UserService클래스의 getUserById 메서드를 통하여 GetUserRes의 객체를 만든다.
- 생성자를 통하여 GetUserRes의 객체를 파라미터로 입력해 BaseResponse라는 객체를 생성하고 반환한다.

<br>

### 2. UserService.class의 getUserById 메서드 안에서 예외 발생 시키기.
```java
// UserService.class
public GetUserRes getUserById(Long userId) throws BaseException {
        //아이디로 유저 조회, 만약 해당 아이디의 유저가 없으면 optionalUser는 null.
        Optional<User> optionalUser = userRepository.findById(userId);

        // 만약 유저 아이디에 따른 유저가 없다면 예외 발생
        if (optionalUser.isEmpty()) {
            throw new BaseException(BaseResponseStatus.NON_EXIST_USER);
        }

        User user = optionalUser.get();
        GetUserRes getUserRes = new GetUserRes(user);
        return getUserRes;
    }
```
- 만약 optionalUser가 null이라면 클라이언트에서 서버에게 잘못된 userId를 주었으므로 예외를 발생시킴.
- BaseResponseStatus의 Enum 상수를 파라미터로 입력해 BaseException의 생성자를 호출해 예외 객체를 생성.
- throw를 통해서 예외를 발생시킴.

<br>

### 3. 예외가 발생하였을 때 클라이언트에게 응답 보내기
```java
// UserController.class
@GetMapping(value = "/", params = "userId")
    public BaseResponse<GetUserRes> getUserById(@RequestParam Long userId) {
        try {
            GetUserRes userRes = userService.getUserById(userId);
            return new BaseResponse<>(userRes);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
```

- try-catch구문을 통해 예외처리를 할 수 있음.
- UserService 클래스의 getUserById 메서드 실행 도중 BaseException 발생해 catch 구문이 실행 됨.
- e.getStatus()를 이용해 발생한 BaseException의 BaseResponseStatus를 가져올 수 있음. (즉 e.getStatus()는 BaseResponseStatus의 객체.)
- BaseResponseStatus를 파라미터로 BaseResponse의 생성자에 입력 시 예외의 코드, 메시지를 필드의 값으로 하는 객체 생성되어 반환됨. (BaseResponse.class의 2번 생성자 호출.)