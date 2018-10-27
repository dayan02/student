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
	<jsp:include page="/pages/header.jsp" />

	<!-- 主体内容编写 -->
	<div id="page-wrapper">

		<div class="col-md-12">
			<h2 class="h2" style="text-align: center">增加班级</h2>
			<br> <br>
		</div>

		<form action="<%=basePath%>pages/back/classes/classes_insert.action"
			method="post" class="form-horizontal" id="insertForm">
			<div class="form-group">
				<label for="cname" class="control-lable col-md-2">班级名称</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="cname" id="cname"
						placeholder="请输入班级名称">
				</div>
			</div>

			<div class="form-group">
				<label for="note" class="control-lable col-md-2">班级简介</label>
				<div class="col-md-5">
					<textarea class="form-control" name="note" id="note"
						placeholder="请输入班级简介"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-4 col-md-offset-5">
					<button type="submit" class="btn btn-success btn-sm">增加</button>
					<button type="reset" class="btn btn-danger btn-sm">重置</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/pages/footer.jsp" />
	<script src="jquery/jquery.validate.min.js"></script>
	<script src="jquery/additional-method.min.js"></script>
	<script src="jquery/jquery.metadata.js"></script>
	<script src="jquery/Message_zh_CN.js"></script>
	<script src="jquery/classes_insert.js"></script>
</body>
</html>
