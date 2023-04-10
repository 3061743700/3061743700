<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/UpStuController" method="get">
    <input type="text" name="pageNum" value="<%=request.getAttribute("pageNum")%>" hidden="hidden">
    <input type="text" name="pageSize" value="<%=request.getAttribute("pageSize")%>" hidden="hidden">

    编号:      <%=request.getAttribute("sid")%><input type="text" name="sid" value="<%=request.getAttribute("sid")%>" hidden="hidden"><br>
姓名:      <input type="text" name="sname" value="<%=request.getAttribute("sname")%>"><br>
年龄:      <input type="text" name="sage" value="<%=request.getAttribute("sage")%>"><br>
性别:      <input type="text" name="ssex" value="<%=request.getAttribute("ssex")%>"><br>
<input type="submit" value="提交"><br>


</form>
</body>
</html>