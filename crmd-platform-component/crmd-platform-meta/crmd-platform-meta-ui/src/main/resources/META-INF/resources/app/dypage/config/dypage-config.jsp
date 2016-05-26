<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ffcs.crmd.platform.ui.utils.JspUtil"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=JspUtil.path(request)%>/app/dypage/config/css/styles.css?<%=JspUtil.version()%>" />
<link rel="stylesheet"
	href="<%=JspUtil.path(request)%>/app/dypage/config/css/zTreeStyle/metro.css?<%=JspUtil.version()%>" />
<title>动态配置界面</title>
<style type="text/css">
.tab-content {
	border-top: 0px solid #c8d1d5;
	margin-top: -1px;
	margin-top: -1px;
}

body {
	padding-top: 0px;
}

.sidebar {
	top: 0px;
}

.row {
	margin-right: -4px
}
</style>
</head>
<body>
	<div class="col-sm-1">
		<div id="sidebar-collapse" class="sidebar">
			<div class="form-group"></div>
			<ul id="navmenu" class="nav menu">
				<li id="style"><a href="#"><svg class="glyph stroked table"> 
						<use xlink:href="#stroked-table"></use></svg>样</a></li>
				<li id="window"><a href="#"><svg
							class="glyph stroked calendar">
						<use xlink:href="#stroked-calendar"></use></svg>窗</a></li>
				<li id="part"><a href="#"><svg
							class="glyph stroked line-graph">
						<use xlink:href="#stroked-line-graph"></use></svg>构 </a></li>
				<li id="tpl"><a href="#"><svg class="glyph stroked table"> 
						<use xlink:href="#stroked-table"></use></svg>模</a></li>

				<li class="active" id="event"><a href="#"><svg
							class="glyph stroked dashboard-dial">
						<use xlink:href="#stroked-dashboard-dial"></use></svg>事</a></li>
			</ul>
		</div>
	</div>
	<div class="col-sm-11" style="padding-left: 0px;">
		<div ng-app="dypageApp" ng-controller="dypageCtrl" id="main"
			class="main">
			<div id="main-event">
				<jsp:include page="./event/dypage-event.jsp"></jsp:include>
			</div>
			<div id="main-groupwin">
				<jsp:include page="./group-win/dypage-group-win.jsp"></jsp:include>
			</div>
			<div id="main-win-design">
				<jsp:include page="./win-design/win-design.jsp"></jsp:include>
			</div>
			<div id="main-style">
				<jsp:include page="./style/dypage-style.jsp"></jsp:include>
			</div>
			<div id="main-tpl">
				<jsp:include page="./tpl/tpl.jsp"></jsp:include>
			</div>
			<div id="main-window">
				<jsp:include page="./window/window.jsp"></jsp:include>
			</div>
			<div id="main-part">
				<jsp:include page="./part/part.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/js/lumino.glyphs.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/dypage-config-controller.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/dypage-config-service.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/js/jquery.ztree.all-3.5.min.js?<%=JspUtil.version()%>"></script>
	<!-- eh -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/easy-html/eh-data.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/easy-html/eh-parse.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/easy-html/eh-style.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/easy-html/eh-script.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/easy-html/eh-util.js?<%=JspUtil.version()%>"></script>
	<!--[if lt IE 9]>
		<script src="<%=JspUtil.path(request)%>/app/dypage/config/js/html5shiv.min.js"></script>
		<script src="<%=JspUtil.path(request)%>/app/dypage/config/js/respond.min.js"></script>
	<![endif]-->
	<!-- 基本组件 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/dy-page-intf/base/base.js?<%=JspUtil.version()%>"></script>
	<!-- 规格 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/dy-page-intf/bus-spec/bus-spec.js?<%=JspUtil.version()%>"></script>
	<!-- 样式配置 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/dy-page-intf/style/sys-style.js?<%=JspUtil.version()%>"></script>
	<!-- 对象 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/dy-page-intf/bus-obj/bus-obj.js?<%=JspUtil.version()%>"></script>
	<!-- 组件 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/dy-page-intf/part/part.js?<%=JspUtil.version()%>"></script>
	<!-- 构件 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/event/dypage-event-controller.js?<%=JspUtil.version()%>"></script>
	<!-- 样式配置 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/style/dypage-style-controller.js?<%=JspUtil.version()%>"></script>
	<!-- 窗体配置 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/win-design/win-design-controller.js?<%=JspUtil.version()%>"></script>
	<!-- 构件配置 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/part/part-controller.js?<%=JspUtil.version()%>"></script>
	<!-- 模版配置 -->
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/tpl/tpl-controller.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="<%=JspUtil.path(request)%>/app/dypage/config/window/window-controller.js?<%=JspUtil.version()%>"></script>
</body>
</html>