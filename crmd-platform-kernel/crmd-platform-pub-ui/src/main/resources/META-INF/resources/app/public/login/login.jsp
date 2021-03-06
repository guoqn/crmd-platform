<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ffcs.crmd.platform.ui.utils.JspUtil"%>
<!DOCTYPE html>
<html>
<head>
<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<title>登录</title>
</head>
<body ng-app="loginApp" ng-controller="loginCtrl">
<div class="container">
  <form class="form-horizontal" style="margin-top: 20%;margin-left: 25%">
  <div class="form-group">
    <label for="userName" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="userName" placeholder="userName">
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="password" placeholder="password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-15">
      <div class="checkbox">
        <label>
          <input type="checkbox"> 记住一周
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">登陆</button>
    </div>
  </div>
</form>
</div>
	<!-- 通用资源引入 -->
	<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/public/login/login-service.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/public/login/login-controller.js?<%=JspUtil.version()%>"></script>
</body>
</html>
