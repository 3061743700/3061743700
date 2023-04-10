<%@ page language="java"
         import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po" %>
<%PageOfficeCtrl pageOfficeCtrl = (PageOfficeCtrl)request.getAttribute("pageOfficeCtrl");%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>添加水印</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<!--**************   卓正 PageOffice组件 ************************-->
<div style=" width:auto; height:700px;">
    <%=pageOfficeCtrl.getHtmlCode("PageOfficeCtrl1")%>
</div>

</body>
</html>
