<%@page import="java.util.List"%>
<%@ page import="stl.Course" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
</head>
<body>
	<%
		List<Course> courseList = (List<Course>) request.getAttribute("courseList");
	%>

	<a href="<%=request.getContextPath()%>/courseinsert.jsp?zuihou=${pe}">添加</a>
	<table border="1">
		<tr>
			<td>cid</td>
			<td>cname</td>
			<td>tid</td>
			<td>操作</td>
		</tr>

		<%
			for (int i = 0; i < courseList.size(); i++) {
				Course course = courseList.get(i);
		%>

		<tr>
			<td><%=course.getCid()%></td>
			<td><%=course.getCname()%></td>
			<td><%=course.getTid()%></td>
			<td>
				<a href="<%=request.getContextPath()%>/DelCourseController?cid=<%=course.getCid()%>&pageNo=${page.pageNum}&pageSize=${page.pageSize}">删除</a>
				<a href="<%=request.getContextPath()%>/QueryIdCourseController?cid=<%=course.getCid()%>&pageNo=${page.pageNum}&pageSize=${page.pageSize}">修改</a>
			</td>

		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="9"><a
					href="<%=request.getContextPath()%>/CourseContrller?pageNo=1&pageSize=${page.pageSize}">第一页</a>
				<a href="<%=request.getContextPath()%>/CourseContrller?pageNo=${page.pre}&pageSize=${page.pageSize}">上一页</a>
				<a href="<%=request.getContextPath()%>/CourseContrller?pageNo=${page.next}&pageSize=${page.pageSize}">下一页</a>
				<a href="<%=request.getContextPath()%>/CourseContrller?pageNo=${page.pe}&pageSize=${page.pageSize}">最后一页</a>
				当前${page.pageNum}页/共${page.pe}页 共${page.total}条
				跳转到第 <select name="pageNo" id="se" onchange="cp(this)"><!-- this 指的是select框 -->
					<c:forEach begin="1" end="${page.pe}" var="p">
						<option <c:if test="${page.pageNum==p}">selected</c:if> value="${p}">${p}</option>
					</c:forEach>
				</select> 页
				跳转到第 <input value="${page.pageNum}" id="pnvId" name="pnv">页
				<button onclick="jump()">跳转</button>

				每页
				<select name="pageSize" id="ps" onchange="psize()">
					<option <c:if test="${ps==3 }">selected</c:if> value="3">3</option>
					<option <c:if test="${ps==5 }">selected</c:if> value="5">5</option>
					<option  <c:if test="${ps==10 }">selected</c:if> value="10">10</option>
				</select>
				条
			</td>



		</tr>
	</table>

	<script type="text/javascript">
		function psize(){
			ps=document.getElementById("ps");
			h=ps.value;
			window.location="<%=request.getContextPath()%>/CourseContrller?pageNo=${page.pageNum}&pageSize="+ps.value;
		}
	</script>


	<script type="text/javascript">
		function cp(sel){
			se=document.getElementById("se");
			pageNo=se.options[se.selectedIndex].value
			window.location="<%=request.getContextPath()%>/CourseContrller?pageNo="+pageNo+"&pageSize=${page.pageSize}";
		}
	</script>

	<script type="text/javascript">
		function jump(){
			pi=document.getElementById("pnvId");
			debugger;
			pageNo=pi.value;
			//console.log(pageNo);
			pn=parseInt(pageNo);

			if(isNaN(pn)){
				pi.value="";
				return;
			}
			if((pn> ${pe} )||pn<1){
				pi.value="";
				return;
			}
			window.location="<%=request.getContextPath()%>/CourseContrller?pageNo="+ pageNo+"&pageSize=${page.pageSize}";
		}
	</script>
</body>
</html>