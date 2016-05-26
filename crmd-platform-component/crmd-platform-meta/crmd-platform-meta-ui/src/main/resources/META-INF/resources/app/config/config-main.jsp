<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.platform.ui.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>节点查询</title>
</head>
<body ng-app="sysConfigApp" ng-controller="sysConfigCtrl">
<div class="panel-body" >
    <div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" ng-model="name"
                       placeholder="请输入节点名称">
            </div>
            <button type="button" ng-click="qrySysConfig()"
                    class="btn btn-default">查询
            </button>
            <button type="button" class="btn btn-primary"
                    ng-click="addSysConfig()">新增
            </button>
        </form>
        <table id="sysConfigTable" data-toggle="table"
               data-side-pagination="server" data-click-to-select="true"
               data-row-style="rowStyle" data-pagination="true"
               data-page-size="10" data-query-params-type=""
               data-page-list="[5, 10, 20]">
            <thead>
            <tr>
                <!-- <th data-field="state" data-checkbox="true"></th> -->
                <th data-field="confId" data-align="center">ID</th>
                <th data-field="name" data-align="center" data-sortable="true">节点名称</th>
                <th data-formatter="parentFormatter" data-align="center">上级节点</th>
                <th data-field="code" data-align="center">节点编码</th>
                <th data-field="nodeValue" data-align="center">节点值</th>
                <th data-formatter="statusCdFormatter" data-align="center">状态</th>
                <th data-field="createDate"
                        data-formatter="ffc.util.tableDateFormatter" data-align="center">创建时间
                </th>
                <th data-field="updateDate"
                        data-formatter="ffc.util.tableDateFormatter" data-align="center">修改时间
                </th>
                <th data-field="sysConfDesc" data-align="center">配置描述</th>
                <th data-width="200" data-formatter="sysConfigFormatter">操作</th>
            </tr>
            </thead>
        </table>
    </div>
    <div id="sys_config_add" class="modal fade" tabindex="-1"
         role="dialog" data-backdrop="true" aria-hidden="true">
        <div class="modal-dialog" style="width: 30%;">
            <div class="modal-content">
                <div class="modal-header">
                    <div>
                        <i class="mark"></i><span class="title">配置编辑</span> <a
                            type="button" class="close" data-dismiss="modal"
                            aria-hidden="true"> &times; </a>
                    </div>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="name" class="col-sm-5 control-label"
                                   style="text-align: center;">节点名称</label>

                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="name"
                                       placeholder="请输入..." ng-model="saveInfo.name">
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="nodeValue" class="col-sm-5 control-label"
                                   style="text-align: center;">节点值</label>

                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="nodeValue"
                                       placeholder="请输入..." ng-model="saveInfo.nodeValue">
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="code" class="col-sm-5 control-label"
                                   style="text-align: center;">节点编码</label>

                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="code"
                                       placeholder="请输入..." ng-model="saveInfo.code">
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="parentId" class="col-sm-5 control-label"
                                   style="text-align: center;">上级节点</label>

                            <div class="col-sm-6" align="left">
                                <sys-config-button sys-config-data-bind="sysConfigList" checkbox = "false"
									readonly="true"> </sys-config-button>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="sysConfDesc" class="col-sm-5 control-label"
                                   style="text-align: center;">配置描述</label>

                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="sysConfDesc"
                                       placeholder="请输入..." ng-model="saveInfo.sysConfDesc">
                            </div>
                        </div>
                        <div align="center" class="div-toolbar">
                            <button class="btn btn-inner-all-blue"
                                    ng-click="saveSysConfig()">保存
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/app/config/directive/sys-config-button/sys-config-query-tmpl.jsp"></jsp:include>
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/config-main-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/config/config-main-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/config/directive/sys-config-button/sys-config-button.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/config/directive/sys-config-button/sys-config-button-service.js?<%=JspUtil.version()%>"></script>
</body>

</html>
