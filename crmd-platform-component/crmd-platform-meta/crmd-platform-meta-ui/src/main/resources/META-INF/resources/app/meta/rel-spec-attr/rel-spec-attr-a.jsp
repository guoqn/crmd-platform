<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="relSpecAttrCtrlA">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">关系规格属性</span>
    </div>
    <div class="panel-body">
        <div class="btn-group relSpecAttrA-btgroup">
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
        <table class="table table-striped" bs-table-control="relSpecAttrAControl">
            <thead>
            <tr>
                <th data-field="relSpecAttrId">#</th>
                <th data-field="relSpecId">关系规格标识</th>
                <th data-field="attrId">属性规格标识</th>
                <th data-field="tabId">表ID</th>
                <th data-field="colId">字段ID</th>
                <%--<th data-field="operation" data-formatter="relSpecAttrAFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade relSpecAttrAModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".relSpecAttrABase"
                                   aria-controls="relSpecAttrABase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".relSpecAttrAComm"
                                   aria-controls="relSpecAttrAComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane relSpecAttrABase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"
                                           ng-show="formModel.relSpecAttrAId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.relSpecAttrAId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.relSpecAttrAId"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">关系规格标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.relSpecId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">属性标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrId" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">库表标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.tabId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">字段标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.colId" placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane relSpecAttrAComm">
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
