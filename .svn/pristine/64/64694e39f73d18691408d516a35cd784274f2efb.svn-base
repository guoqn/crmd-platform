<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="busiObjAttrValueCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">属性值规格</span>
    </div>
    <div class="panel-body">
        <div class="btn-group busiObjAttrValue-btgroup">
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
        <table class="table table-striped" bs-table-control="busiObjAttrValueControl">
            <thead>
            <tr>
                <th data-field="id">#</th>
                <th data-field="busiObjAttrId">业务对象</th>
                <th data-field="attrValueId">属性值规格</th>
                <th data-field="valueRelaId">属性值关系</th>
                <th data-field="busValueRelaId">业务属性值关系</th>
                <th data-field="applyRegionId">适用区域</th>
                <th data-field="remark">描述</th>
                <%--<th data-field="operation" data-formatter="BusiObjAttrValueFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade busiObjAttrValueModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".busiObjAttrValueBase"
                                   aria-controls="busiObjAttrValueBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".busiObjAttrValueComm"
                                   aria-controls="busiObjAttrValueComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane busiObjAttrValueBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" ng-show="formModel.id">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.id">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.id" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">对象属性标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiObjAttrId"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">属性值标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrValueId"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性值关联标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.valueRelaId"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">业务属性值关系ID</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busValueRelaId"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">适用区域标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.applyRegionId"
                                               placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane busiObjAttrValueComm">
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
