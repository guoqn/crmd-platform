<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ffcs.crmd.platform.ui.utils.JspUtil"%>
<script type="text/javascript">
//全局变量
	 path = "<%=JspUtil.path(request)%>";//path;
	 contextPath = "<%=JspUtil.contextPath(request)%>";//contextPath;
</script>
<!--BASE JS FILES -->
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/jquery/jquery-1.11.1.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/js/bootstrap-3.2.0.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/angularjs/angular-ie8-1.4.7.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/angularjs/angular-sanitize.min.js?<%=JspUtil.version()%>"></script>
<!-- BOOTSTRAP PLUGINS JS FILES -->
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/buttons/js/buttons.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-table/js/bootstrap-table.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-table/js/bootstrap-table-angular.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-select/js/bootstrap-select.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-dialog/js/bootstrap-dialog.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-treeview/js/bootstrap-treeview.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-validator/js/bootstrap-validator.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/angularjs/plugins/ui-select/select.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/jquery-treetable/js/jquery.treeTable.js?<%=JspUtil.version()%>"></script>

<!-- 自定义通用 JS common.js -->
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/public/common/js/common.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/app/app-common/js/app-common.js?<%=JspUtil.version()%>"></script>
<!-- 自定义组件 -->
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/public/component/loading-comp/js/loading.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/public/component/message-dialog-comp/js/message-dialog.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/public/component/right-suspension-menu/js/common.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/public/component/right-suspension-menu/js/quick-links.js?<%=JspUtil.version()%>"></script>
<!-- 下拉菜单组织树封装脚本-start -->
<script type="text/javascript" src="<%=JspUtil.path(request)%>/resources/lib/angularjs/plugins/jsTree/jstree.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript" src="<%=JspUtil.path(request)%>/resources/public/component/angular-jstree/ng-jsTree.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript" src="<%=JspUtil.path(request)%>/resources/public/component/drop-tree-comp/js/dropTree.js?<%=JspUtil.version()%>"></script>
<!-- 下拉菜单组织树封装脚本-end -->
<!-- 选择框 start -->
<script type="text/javascript" src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/select2-3.5.4/js/select2.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript" src="<%=JspUtil.path(request)%>/resources/lib/angularjs/plugins/ng-select2/ng-select2.js?<%=JspUtil.version()%>"></script>
<!-- 选择框 end -->
