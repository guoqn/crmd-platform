<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="busiObjAttrCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">属性规格</span>
    </div>
    <div class="panel-body">
        <div class="btn-group busiObjAttr-btgroup">
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
        <table class="table table-striped" bs-table-control="busiObjAttrControl">
            <thead>
            <tr>
                <th data-field="busiObjAttrId">#</th>
                <th data-field="busiObjId">业务对象</th>
                <th data-field="attrId">属性规格</th>
                <th data-field="tabId">库表</th>
                <th data-field="colId">字段</th>
                <th data-field="remark">备注</th>
                <%--<th data-field="operation" data-formatter="BusiObjAttrFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade busiObjAttrModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".busiObjAttrBase"
                                   aria-controls="busiObjAttrBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".busiObjAttrComm"
                                   aria-controls="busiObjAttrComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane busiObjAttrBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" ng-show="formModel.busiObjAttrId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.busiObjAttrId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiObjAttrId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">业务对象标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiObjId"
                                               placeholder=""/>
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
                                    <label class="col-sm-2 control-label">库表字段标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.colId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">属性最大数量</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrMaxCount"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">默认值</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.defaultValue"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">起始值</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.valueFrom"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">结束值</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.valueTo" placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane busiObjAttrOther">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">唯一性</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.isUnique" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">是否可空</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.isNullable"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">适用区域标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.applyRegionId"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">序列化名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.seqName" placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane busiObjAttrComm">
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
