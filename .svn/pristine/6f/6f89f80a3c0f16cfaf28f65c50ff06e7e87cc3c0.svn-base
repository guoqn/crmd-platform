<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="sysTabCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">系统表</span>
    </div>
    <div class="panel-body">
        <div class="btn-group sysTab-btgroup">
            <button type="button" class="btn btn-default btn-primary" data-toggle="modal"
                    ng-click="changeState('add')">新增
            </button>
            <button type="button" class="btn btn-default btn-primary" data-toggle="modal"
                    ng-click="changeState('update')">编辑
            </button>
            <button type="button" class="btn btn-default btn-primary" ng-click="changeState('del')"
                    ng-click="del()">删除
            </button>
        </div>
        <table class="table table-striped" bs-table-control="sysTableControl">
            <thead>
            <tr>
                <th data-field="tabId">#</th>
                <th data-field="tabName">系统表名称</th>
                <th data-field="tabType">表类型</th>
                <th data-field="mstrTabId">归属表</th>
                <th data-field="tabKeyColName">主键</th>
                <%--<th data-field="operation" data-formatter="SysTabFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade sysTabModal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" ng-bind="modalOption.title"></h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <ul class="nav nav-tabs" role="tabList">
                            <li role="presentation" class="active">
                                <a href="javascript:;" data-target=".sysTableBase"
                                   aria-controls="sysTableBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".sysTableComm"
                                   aria-controls="sysTableComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane sysTableBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"
                                           ng-show="formModel.tabId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.tabId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.tabId" placeholder="系统表ID"/>
                                    </div>
                                    <label class="col-sm-2 control-label">系统表名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.tabName" placeholder="系统表名称"/>
                                    </div>
                                    <label class="col-sm-2 control-label">系统表类型</label>
                                    <div class="col-sm-2">
                                        <%--<input class="form-control" type="text"
                                               ng-model="formModel.tabType" placeholder="系统表类型"/>--%>
                                        <select class="form-control" ng-model="formModel.tabType"
                                                ng-options="item.id as item.action for item in select.busiType"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">主键</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.tabKeyColName" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">归属主表</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.mstrTabId" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">纵表实例字段名</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.slaTabInstColName"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">纵表属性字段名</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.slaTabAttrColName"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">纵表属性值字段名</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.slaTabAttrValColName"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">历史表名</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.hisTableName" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">历史序列名</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.hisSeqName" placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane sysTableComm">
                                <jsp:include page="../meta-comForm.jsp"></jsp:include>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <jsp:include page="../meta-comFooter.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </div>
</div>
