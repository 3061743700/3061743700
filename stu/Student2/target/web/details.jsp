<%@page import="stl.Student"%>
<%@page import="java.util.List"%>
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
		List<Student> studentList = (List<Student>) request.getAttribute("studentList");
	%>

	<h3>详细信息</h3>
	<table border="1">
		<tr>
			<td>学生编号</td>
			<td>学生姓名</td>
			<td>学生出生日期</td>
			<td>学生性别</td>
		</tr>
		<tr>
			<td><%=studentList.get(0).getSid()%></td>
			<td><%=studentList.get(0).getSname()%></td>
			<td><%=studentList.get(0).getSage()%></td>
			<td><%=studentList.get(0).getSsex()%></td>
		</tr>
		</table>

	<h3>课程信息</h3>
		<table border="1">
		<tr>
<%--			<td>sl</td>--%>
<%--			<td>zcj</td>--%>
			<td>课程编号</td>
			<td>课程名称</td>
			<td>教师编号</td>
			<td>教师名称</td>
			<td>学生成绩</td>
		</tr>

		<%
			for (int i = 0; i < studentList.size(); i++) {
				Student student = studentList.get(i);

		%>

		<tr>
			<td><%=student.getCid()%></td>
			<td><%=student.getCname()%></td>
			<td><%=student.getTid()%></td>
			<td><%=student.getTname()%></td>
			<td><%=student.getScore()%></td>
		</tr>
		<%
				if (i == studentList.size()-1){
		%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>课程数量</td>
					<td><%=student.getSl()%></td>
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>总成绩</td>
					<td><%=student.getZcj()%></td>
				</tr>
		<%
				}
			}
		%>
			<tr>
				<td colspan="9"><a
						href="<%=request.getContextPath()%>/StuDetailsController?pageNo=1&pageSize=${page.pageSize}&sid=<%=studentList.get(0).getSid()%>">第一页</a>
					<a href="<%=request.getContextPath()%>/StuDetailsController?pageNo=${page.pre}&pageSize=${page.pageSize}&sid=<%=studentList.get(0).getSid()%>">上一页</a>
					<a href="<%=request.getContextPath()%>/StuDetailsController?pageNo=${page.next}&pageSize=${page.pageSize}&sid=${studentList.get(0).getSid()}">下一页</a>
					<a href="<%=request.getContextPath()%>/StuDetailsController?pageNo=${page.pe}&pageSize=${page.pageSize}&sid=<%=studentList.get(0).getSid()%>">最后一页</a>
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
		window.location="<%=request.getContextPath()%>/StuDetailsController?pageNo=${page.pageNum}&pageSize="+ps.value+"&sid=<%=studentList.get(0).getSid()%>";
	}
	</script>
	
	
	<script type="text/javascript">
		function cp(sel){
			se=document.getElementById("se");
			pageNo=se.options[se.selectedIndex].value
		 window.location="<%=request.getContextPath()%>/StuDetailsController?pageNo="+pageNo+"&pageSize=${page.pageSize}&sid=<%=studentList.get(0).getSid()%>";
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
			window.location="<%=request.getContextPath()%>/StuDetailsController?pageNo="+ pageNo+"&pageSize=${page.pageSize}&sid=<%=studentList.get(0).getSid()%>";
		}
	</script>

</body>
</html>