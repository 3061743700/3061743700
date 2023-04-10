<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/AddStuController" method="get">

编号:      <input type="text" name="sid"><br>
姓名:      <input type="text" name="sname"><br>
年龄:      <input type="date" name="sage"><br>
性别:      <input type="text" name="ssex"><br>
<input type="submit" value="提交"><br>


</form>
</body>
</html>