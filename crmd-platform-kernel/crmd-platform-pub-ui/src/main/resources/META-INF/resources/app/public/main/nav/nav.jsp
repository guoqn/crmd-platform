<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ffcs.crmd.platform.ui.utils.JspUtil"%>
<!DOCTYPE html>
<html>
<head>
<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<title>导航</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">logo</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">营业菜单 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">订单查询</a></li>
							<li><a href="#">档案查询</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">登出</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 通用资源引入 -->
	<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
</body>
</html>
