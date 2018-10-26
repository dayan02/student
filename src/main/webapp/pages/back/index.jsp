<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线教育管理系统</title>
<base href="<%=basePath%>">
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<div id="page-wrapper">
<h1>管理员身份:<%=request.getSession().getAttribute("email") %></h1>
<h2>上次登录日期:<%=request.getSession().getAttribute("lastdate") %></h2>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>
