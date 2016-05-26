<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="sysColumnCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">系统字段</span>
    </div>
    <div class="panel-body">
        <div class="btn-group sysColumn-btgroup">
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
        <table class="table table-striped" bs-table-control="sysColumnControl">
            <thead>
            <tr>
                <th data-field="colId">#</th>
                <th data-field="colName">字段名称</th>
                <th data-field="colType">字段类型</th>
                <th data-field="colLength">字段长度</th>
                <th data-field="colForeignKey">是否外键</th>
                <th data-field="colNullable">是否可空</th>
                <th data-field="colDesc">字段描述</th>
                <%--<th data-field="operation" data-formatter="SysColumnFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade sysColModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".sysColumnBase"
                                   aria-controls="sysColumnBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".sysColumnComm"
                                   aria-controls="sysColumnComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane sysColumnBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" ng-show="formModel.colId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.colId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.colId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">隶属表</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.tabId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">字段名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.colName" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">字段类型</label>
                                    <div class="col-sm-2">
                                        <%--<input class="form-control" type="text"
                                               ng-model="formModel.colType" placeholder=""/>--%>
                                        <select class="form-control" ng-model="formModel.colType"
                                                ng-options="item.id as item.action for item in select.colType"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">字段长度</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.colLenght"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">字段是否可以空</label>
                                    <div class="col-sm-2">
                                        <select class="form-control"
                                                ng-model="formModel.colNullable"
                                                ng-options="item.id as item.action for item in isOrNotItems"
                                                placeholder="">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">字段是否外键</label>
                                    <div class="col-sm-2">
                                        <select class="form-control"
                                                ng-model="formModel.colForeignKey"
                                                ng-options="item.id as item.action for item in isOrNotItems"
                                                placeholder="">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">字段描述</label>
                                    <div class="col-sm-10">
                                    <textarea class="form-control" ng-model="formModel.colDesc"
                                              rows="6" placeholder=""></textarea>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane sysColumnComm">
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
