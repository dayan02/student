<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<jsp:include page="/pages/header.jsp" />

	<!-- 主体内容编写 -->
	<div id="page-wrapper">

		<div class="col-md-12">
			<table class="table table-bordered table-hover" id="classesTable">

				<tr>
					<th>班级编号</th>
					<th>班级名称</th>
					<th>班级简介</th>
					
				</tr>

			</table>
		</div>
	</div>
	<jsp:include page="/pages/footer.jsp" />
	<script src="jquery/jquery.validate.min.js"></script>
	<script src="jquery/additional-method.min.js"></script>
	<script src="jquery/jquery.metadata.js"></script>
	<script src="jquery/Message_zh_CN.js"></script>
	<script src="jquery/classes_list.js"></script>
</body>
</html>
