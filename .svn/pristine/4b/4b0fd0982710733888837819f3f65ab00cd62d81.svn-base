<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="busiTypeCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">业务大类</span>
    </div>
    <div class="panel-body">
        <form class="navbar-form navbar-left searchtool" role="search">
            <span class="">主题域:</span>
            <div class="form-group">
                <select class="form-control" ng-model="busiDomainId" ng-change="qrySysDomain()"
                        ng-options="item.id as item.action for item in select.busiDomainItems">
                </select>
            </div>
        </form>

        <div class="btn-group type-btgroup">
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
        <table class="table table-striped" bs-table-control="busiTypeControl">
            <thead>
            <tr>
                <th data-field="busiTypeId">#</th>
                <th data-field="busiTypeName">业务大类名称</th>
                <th data-field="domainId">隶属域</th>
                <th data-field="busiTypeDesc">业务大类描述</th>
                <%--<th data-field="operation" data-formatter="BusiTypeFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade busiTypeModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".busiTypeBase"
                                   aria-controls="busiTypeBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".busiTypeComm"
                                   aria-controls="busiTypeComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane busiTypeBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"
                                           ng-show="busiTypeId">#ID</label>
                                    <div class="col-sm-2" ng-show="busiTypeId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiTypeId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">主题域标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.domainId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">业务大类名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiTypeName" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">业务大类编码</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiTypeNbr" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">变更是否写历史</label>
                                    <div class="col-sm-2">
                                        <select class="form-control"
                                                ng-model="formModel.changeLogLevel"
                                                ng-options="item.id as item.action for item in select.changeLogLevelItems">
                                        </select>
                                    </div>
                                    <label class="col-sm-2 control-label">删除是否写历史</label>
                                    <div class="col-sm-2">
                                        <select class="form-control"
                                                ng-model="formModel.deleteLogLevel"
                                                ng-options="item.id as item.action for item in select.deleteLogLevelItems">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">缓存记录</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.cacheLevel"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">管理等级</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.managerGrade"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">跟业务对象关系</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.metaType" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">业务大类描述</label>
                                    <div class="col-sm-10">
                                    <textarea class="form-control"
                                              ng-model="formModel.busiTypeDesc" rows="6"
                                              placeholder=""></textarea>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane busiTypeComm">
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
