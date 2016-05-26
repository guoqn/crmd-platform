<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="attrValueCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">属性值规格</span>
    </div>
    <div class="panel-body">
        <div class="btn-group attrValue-btgroup">
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
        <table class="table table-striped" bs-table-control="attrValueControl">
            <thead>
            <tr>
                <th data-field="attrValueId">#</th>
                <th data-field="attrValueName">名称</th>
                <th data-field="attrNbr">编码</th>
                <th data-field="attrId">隶属规格</th>
                <th data-field="parentValueId">父级</th>
                <th data-field="attrValueDesc">描述</th>
                <%--<th data-field="operation" data-formatter="AttrValueFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade attrValueModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".attrValueBase"
                                   aria-controls="attrValueBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".attrValueOther"
                                   aria-controls="attrValueOther"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>其他信息</a></li>
                            </li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".attrValueComm"
                                   aria-controls="attrValueComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane attrValueBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"
                                           ng-show="formModel.attrValueId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.attrValueId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrValueId"
                                               placeholder="属性值标识"/>
                                    </div>
                                    <label class="col-sm-2 control-label">隶属属性标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">父级</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.parentValueId"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性值名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrValueName"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">属性值</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrValue"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性值描述</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control"
                                                  ng-model="formModel.attrValueDesc" rows="6"
                                                  placeholder=""></textarea>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane attrValueOther">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">排序</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrValueSort"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">割接状态</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isTrans"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">管理级别</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isTrans"
                                                ng-options="item.id as item.action for item in manageGrade"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">集团实体编码</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.groupCd" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">生效时间</label>
                                    <div class="col-sm-2">
                                        <input class="form-control date" placeholder=""
                                               type="text" readonly
                                               ng-model="formModel.effDate"/>
                                    </div>
                                    <label class="col-sm-2 control-label">失效时间</label>
                                    <div class="col-sm-2">
                                        <input class="form-control date" placeholder=""
                                               type="text" readonly
                                               ng-model="formModel.expDate"/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane attrValueComm">
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
