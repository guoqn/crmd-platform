<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="relSpecACtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">A端对象</span>
    </div>
    <div class="panel-body">
        <div class="btn-group specRelA-btgroup">
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
        <table class="table table-striped" bs-table-control="specRelAControl">
            <thead>
            <tr>
                <th data-field="relSpecId">#</th>
                <th data-field="aObjId">A端对象ID</th>
                <th data-field="relType">关系类型</th>
                <%--<th data-field="operation" data-formatter="SysTabFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade specRelAModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".specRelABase"
                                   aria-controls="specRelABase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".specRelAComm"
                                   aria-controls="specRelAComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane specRelABase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" ng-show="formModel.relSpecId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.relSpecId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.relSpecId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">Z端对象</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.zObjId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">关联类型</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.relType" placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane specRelAComm">
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
