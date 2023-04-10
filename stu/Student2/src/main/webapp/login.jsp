<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>


<body>

<form action="<%=request.getContextPath()%>/Usercontroller" method="post">
	用户名：<input type="text"  name="username"><br>
	密    码：<input type="password" name="password"> <br>
	<input type="submit"  value="登录">
</form>
</body>
</html>