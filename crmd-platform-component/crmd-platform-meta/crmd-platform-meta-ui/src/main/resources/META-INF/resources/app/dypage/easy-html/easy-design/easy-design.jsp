<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.ffcs.crmd.platform.ui.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <link rel="stylesheet"
          href="<%=JspUtil.path(request)%>/app/dypage/easy-html/css/styles.css?<%=JspUtil.version()%>"/>
    <link rel="stylesheet"
          href="<%=JspUtil.path(request)%>/app/dypage/easy-html/css/zTreeStyle/metro.css?<%=JspUtil.version()%>"/>
    <title>界面配置</title>
    <style type="text/css">
        .tab-content {
            border-top: 0px solid #c8d1d5;
            margin-top: -1px;
            margin-top: -1px;
        }

        body {
            padding-top: 0px;
        }
    </style>
</head>
<body ng-app="easyDesignApp" ng-controller="easyDesignCtrl" style="width: 95%">
<div class="col-md-12" style="height: 8px"></div>
<div class="row" style="padding-left: 12px;">
    <div class="col-md-3">
        <div class="panel panel-default" style="height: 420px">
            <div class="panel-body tabs">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#pilltab1" data-toggle="tab">布局组件</a></li>
                    <li><a href="#pilltab2" data-toggle="tab">对象组件</a></li>
                    <li><a href="#pilltab6" data-toggle="tab"
                           ng-show="display.item !='part'">构件信息</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="pilltab1">
                        <div id="baseComp" class="ztree"></div>
                    </div>
                    <div class="tab-pane fade" id="pilltab2">
                        <div id="objComp" class="ztree"></div>
                    </div>
                    <div class="tab-pane fade" id="pilltab6"
                         ng-show="display.item !='part'">
                        <div id="partComp" class="ztree"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-9" style="padding-right: 40px;">
        <div class="panel panel-default" style="height: 420px">
            <div class="panel-body" style="overflow-y: auto; height: 420px">
                <div class="col-sm-6">
                    <!-- 界面配置 -->
                    <div id="designPage" class="ztree"></div>
                </div>
                <div class="col-sm-6">
                    <div class="panel-body tabs">
                        <ul class="nav nav-pills">
                            <li class="active"><a href="#pilltab4" data-toggle="tab">组件信息</a></li>
                            <li><a href="#pilltab5" data-toggle="tab">样式信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="pilltab4">
                                <!-- 表单信息 -->
                                <form id="designCompForm" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label" for="componentType">组件类型:</label>
                                        <div class="col-sm-8">
                                            <select class="form-control" id="componentType"
                                                    ng-model="compForm.componentType"
                                                    ng-options="item.id as item.action for item in comType.typeData"></select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label" for="componentName">组件名称:</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="componentName"
                                                   ng-model="compForm.componentName" placeholder="组件名称">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label" for="componentCode">组件编码:</label>
                                        <div class="col-sm-8">
                                            <input type="text" id="componentCode" class="form-control"
                                                   ng-model="compForm.componentCode" placeholder="组件编码">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label" for="componentExp">表达式:</label>
                                        <div class="col-sm-8">
                                            <input type="text" id="componentExp" class="form-control"
                                                   ng-model="compForm.componentExp"
                                                   placeholder="表达式(日期格式、校验格式...)">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label" for="groupCode">模版类型:</label>
                                        <div class="col-sm-8">
                                            <select class="form-control" id="groupCode"
                                                    ng-model="compForm.groupCode"
                                                    ng-options="item.templateCode as item.templateName for item in groupCode"></select>
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="tab-pane fade" id="pilltab5">
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <div id="designStyle" class="ztree"></div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="text-align: right;">
                        <button class="btn btn-primary btn-md" ng-click="submitDesignWin()">提交视图
                        </button>
                        &nbsp;
                        <button class="btn btn-primary btn-md"
                                ng-click="updateDesignTree()">更新视图
                        </button>
                        &nbsp;
                        <button class="btn btn-primary btn-md"
                                ng-click="reSetDesignTree()">重置
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row" style="padding-left: 12px;padding-right: 27px;">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">实时视图</div>
            <div class="panel-body" id="pageHtml"></div>
        </div>
    </div>
</div>
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>

<!-- ztree -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/dypage/easy-html/lib/jquery.ztree.all-3.5.min.js?<%=JspUtil.version()%>"></script>
<!--兼容性相关脚本-->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/dypage/easy-html/lib/lumino.glyphs.js?<%=JspUtil.version()%>"></script>
<!--[if lt IE 9]>
<script src="<%=JspUtil.path(request)%>/app/dypage/easy-html/lib/html5shiv.min.js"></script>
<script src="<%=JspUtil.path(request)%>/app/dypage/easy-html/lib/respond.min.js"></script>
<![endif]-->

<!-- 压缩版-->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/dypage/easy-html/min/easy-html-min.js?<%=JspUtil.version()%>"></script>


<!-- 源码
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
-->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/dypage/easy-html/easy-design/easy-design-controller.js?<%=JspUtil.version()%>"></script>
</body>
</html>