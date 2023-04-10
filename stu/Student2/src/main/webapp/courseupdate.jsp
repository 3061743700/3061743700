<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/UpCourseController" method="get">
    <input type="text" name="pageNum" value="<%=request.getAttribute("pageNum")%>" hidden="hidden">
    <input type="text" name="pageSize" value="<%=request.getAttribute("pageSize")%>" hidden="hidden">

编号:      <%=request.getAttribute("cid")%><input type="text" name="cid" value="<%=request.getAttribute("cid")%>" hidden="hidden"><br>
姓名:      <input type="text" name="cname" value="<%=request.getAttribute("cname")%>"><br>
教师编号:      <input type="text" name="tid" value="<%=request.getAttribute("tid")%>"><br>
<input type="submit" value="提交"><br>


</form>
</body>
</html>