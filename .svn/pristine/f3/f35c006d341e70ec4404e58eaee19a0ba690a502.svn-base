<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="busiObjCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">业务对象</span>
    </div>
    <div class="panel-body">
        <form class="navbar-form navbar-left searchtool" role="search">
            <span class="">主题域:</span>
            <div class="form-group">
                <select class="form-control" ng-model="busiDomainId" ng-change="qrySysDomain()"
                        ng-options="item.id as item.action for item in select.busiDomainItems">
                </select>
            </div>
            <span class="">业务大类:</span>
            <div class="form-group">
                <select class="form-control" ng-model="busiTypeId" ng-change="qryBusiType()"
                        ng-options="item.id as item.action for item in select.busiTypeItems">
                </select>
            </div>
        </form>

        <div class="btn-group busiObj-btgroup">
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
        <table class="table table-striped treetable tree-table" bs-table-control="busiObjControl">
            <%--<script type="text/ng-template" id="tree_node">
                <tr tt-node is-branch="node.type == 'folder'">
                    <td><span class="expander"></span><span ng-bind="node.name"></span></td>
                    <td ng-bind="node.type"></td>
                    <td ng-bind="node.size"></td>
                </tr>
            </script>--%>
            <%--<table class="tbCustom treeTable" width="100%" border="0" cellspacing="0" cellpadding="0" id="busiObjTreeTable" tt-table tt-params="dynamic_params">
                <thead>
                <tr>
                    <th>Filename</th>
                    <th>Type</th>
                    <th>Size</th>
                </tr>
                </thead>
                <tbody></tbody>--%>
            <thead>
            <tr>
                <th data-field="busiObjId">#</th>
                <th data-field="busiObjName">名称</th>
                <th data-field="busiObjNbr">编码</th>
                <th data-field="parBusiObjId">父级</th>
                <th data-field="busiTypeId">隶属大类</th>
                <th data-field="applyRegionId">适用区域</th>
                <th data-field="busiObjDesc">描述</th>
                <%--<th data-field="operation" data-formatter="BusiObjFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade busiObjModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".busiObjBase"
                                   aria-controls="busiObjBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".busiObjComm"
                                   aria-controls="busiObjComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane busiObjBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"
                                           ng-show="formModel.busiObjId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.busiObjId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiObjId" placeholder="业务对象标识"/>
                                    </div>
                                    <label class="col-sm-2 control-label">业务大类</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiTypeId"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">父级</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.parBusiObjId"
                                               placeholder=""/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">业务对象名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiObjName"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">业务对象编码</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiObjNbr"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">适用区域</label>
                                    <div class="col-sm-2">
                                        <select class="form-control"
                                                ng-model="formModel.applyRegionId"
                                                ng-options="item.id as item.action for item in select.applyRegionIdItems">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">隶属系统表</label>
                                    <div class="col-sm-2">
                                        <select class="form-control"
                                                ng-model="formModel.tabId"
                                                ng-options="item.id as item.action for item in select.sysTabItems">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">业务对象描述</label>
                                    <div class="col-sm-10">
                                    <textarea class="form-control" type="text"
                                              ng-model="formModel.busiObjDesc" rows="6"
                                              placeholder=""></textarea>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane busiObjComm">
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
