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

<!-- 主体内容编写 -->
	<div id="page-wrapper">
		<div class="col-md-12">
			<h2 class="h2" style="text-align:center">学生增加</h2>
			<br><br>
		</div>
		<div>
			<form action="<%=basePath%>pages/back/student/student_insert.action"
			method="post" id="insertForm" class="form-horizontal">
			
			<%--学生编号--%>
				<div class="form-group" >
					<label for="sid" class="control-label col-md-2">学生编号</label>
					<div class="col-md-5">
					<input type="text" class="form-control" id="sid" name="sid" 
					placeholder="请输入学生编号">
					</div>
				</div>
				
				<!-- 班级编号 -->
				<div class="form-group">
				<label for="classes.cid" class="control-label col-md-2">班级编号</label>
				<div class="col-md-5">
				<select class="form-control" id="classes.cid" name="classes.cid"></select>
				
				</div>
				</div>
				
				
				
			<%--学生姓名--%>
			<div class="form-group" >
					<label for="name" class="control-label col-md-2">学生姓名</label>
					<div class="col-md-5">
					<input type="text" class="form-control" id="name" name="name" 
					placeholder="请输入学生姓名">
					</div>
					
				</div>
				
				<%--学生年龄--%>
				<div class="form-group" >
					<label for="age" class="control-label col-md-2">学生年龄</label>
					<div class="col-md-5">
					<input type="text" class="form-control" id="age" name="age" 
					placeholder="请输入学生年龄">
					</div>
					
				</div>
			
			<%--学生性别--%>
			<div class="form-group" >
					<label for="sex" class="control-label col-md-2">学生性别</label>
					 <div class="col-md-5">
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex1" value="0" checked> 女
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex2" value="1"> 男
                            </label>
                        </div>
					
				</div>
				
				<%--学生地址--%>
				<div class="form-group" >
					<label for="address" class="control-label col-md-2">联系地址</label>
					<div class="col-md-5">
					<input type="text" class="form-control" id="address" name="address" 
					placeholder="请输入学生联系地址">
					</div>
					
				</div>
				
			 <div class="form-group">
                    <div class="col-md-4 col-md-offset-6">
                        <button type="submit" class="btn btn-success btn-sm">增加</button>
                        <button type="reset" class="btn btn-danger btn-sm">重置</button>
                    </div>
                </div>
			</form>
		</div>
	</div>
	<jsp:include page="/pages/footer.jsp"/>
	<script src="jquery/jquery.validate.min.js"></script>
     <script src="jquery/additional-method.min.js"></script>
     <script src="jquery/jquery.metadata.js"></script>
     <script src="jquery/Message_zh_CN.js"></script>
     <script src="jquery/student_insert.js"></script>
</body>
</html>
