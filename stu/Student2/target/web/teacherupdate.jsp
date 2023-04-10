<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/UpTeacherController" method="get">
    <input type="text" name="pageNum" value="<%=request.getAttribute("pageNum")%>" hidden="hidden">
    <input type="text" name="pageSize" value="<%=request.getAttribute("pageSize")%>" hidden="hidden">

编号:      <%=request.getAttribute("tid")%><input type="text" name="tid" value="<%=request.getAttribute("tid")%>" hidden="hidden"><br>
姓名:      <input type="text" name="tname" value="<%=request.getAttribute("tname")%>"><br>
<input type="submit" value="提交"><br>


</form>
</body>
</html>