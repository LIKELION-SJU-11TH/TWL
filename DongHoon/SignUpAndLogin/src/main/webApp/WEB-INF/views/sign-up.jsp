<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-Up</title>
</head>
<body>
	<h1>Sign-Up Page</h1>
	<form action="/sign-up" method="post">
		이름 : <input type="text" name="name" placeholder="name"><br><br>
        나이 : <input type="text" name="age" placeholder="age"><br><br>
        이메일 : <input type="text" name="email" placeholder="email"><br><br>
		비밀번호 : <input type="password" name="password" placeholder="password"><br><br>
		<button type = "submit">가입하기</button>
	</form>
</body>
</html>s