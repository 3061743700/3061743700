<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/AddTeacherController" method="get">

编号:      <input type="text" name="tid"><br>
姓名:      <input type="text" name="tname"><br>
<input type="submit" value="提交"><br>


</form>
</body>
</html>