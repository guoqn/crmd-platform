<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.platform.ui.utils.JspUtil" %>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <link rel="stylesheet"
          href="<%=JspUtil.path(request)%>/app/clearCache/css/demo.css?<%=JspUtil.version()%>">
    <title>清理缓存</title>
</head>
<body ng-app="clearCacheApp">
<div class="panel-body" ng-controller="clearCacheCtrl">
    <div class="panel-default">
        <div class="row">
            <div class="col-sm-4 column">
                <h2 STYLE="padding-left: 20px;">清理缓存模块</h2>
                <form id="myForm1" class="form-horizontal">
                    <div class="form-group">
                        <input type="text" class="form-control" ng-model="cachePath"
                               placeholder="例如: /root/child/child1-2">
                    </div>
                    <button type="button" ng-click="clearCacheByPath()"
                            class="btn btn-default">清理
                    </button>
                    <button type="button" class="btn btn-danger"
                            ng-click="clearChildByPath()">清理路径子节点缓存
                    </button>
                    <button type="button" class="btn btn-danger"
                            ng-click="clearAllCache()">清理所有缓存
                    </button>
                </form>
            </div>
            <div class="col-sm-4 column">
                <h2 STYLE="padding-left: 20px;">清理开关缓存模块</h2>
                <form id="myForm2" class="form-horizontal">
                    <div class="form-group">
                        <input type="text" class="form-control" ng-model="switchPath"
                               placeholder="例如: /child/child1-2">
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-default" ng-click="clearCacheByPath()">清理</button>
                        <button type="button" class="btn btn-danger"
                                ng-click="clearSwiChildByPath()">清理路径子节点
                        </button>
                        <button type="button" class="btn btn-danger"
                                ng-click="clearAllSwitch()">清理所有开关
                        </button>
                    </div>
                </form>
            </div>
            <div class="col-sm-4 column">
                <h2 STYLE="padding-left: 20px;">清理抽样缓存模块</h2>
                <form id="myForm3" class="form-horizontal">
                    <div class="form-group">
                        <input type="text" class="form-control" ng-model="samplingPath"
                               placeholder="例如: /child/child1-2">
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-default" ng-click="clearCacheByPath()">清理</button>
                        <button type="button" class="btn btn-danger"
                                ng-click="clearSChildByPath()">清理路径子节点
                        </button>
                        <button type="button" class="btn btn-danger"
                                ng-click="clearAllSampling()">清理所有抽样
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/config-main-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/clearCache/clear-cache-controller.js?<%=JspUtil.version()%>"></script>
</body>
</html>
