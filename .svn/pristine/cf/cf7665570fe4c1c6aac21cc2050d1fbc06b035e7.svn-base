<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<script type="text/javascript">
	function showResource() {
		var injector = angular.injector([ "commonApp", "ng" ]);
		injector.invoke([ 'commonService', function(commonService) {
			commonService.call("/test/showResource", {}, function(result) {
				document.getElementById("resTxt").value = result;
			});
		} ]);
	}

	function startTest() {
		var injector = angular.injector([ "commonApp", "ng" ]);
		injector.invoke([ 'commonService', function(commonService) {
			commonService.call("/test/startTest", {}, function(result) {
				document.getElementById("testResultTxt").value = result;
			});
		} ]);
		
	}
</script>
<title>集成测试管理</title>
</head>
<body>
	<h4>集成测试</h4>
	<div id="resourceDiv">
		<input type="button" value="显示资源加载情况" onclick="showResource();" /> </br> <input
			type="input" style="width: 800px; height: 200px;" id="resTxt" />
	</div>
	<div id="testResultDiv">
		<input type="button" value="开始测试" onclick="startTest();" /> </br> <input
			type="input" style="width: 800px; height: 200px;" id="testResultTxt" />
	</div>
</body>
<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
</html>