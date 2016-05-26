<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="sysDomainCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">主题域</span>
    </div>
    <div class="panel-body">
        <div class="btn-group domain-btgroup">
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
        <table class="table table-striped" bs-table-control="domainControl">
            <thead>
            <tr>
                <th data-field="domainId">#</th>
                <th data-field="domainName">域名</th>
                <th data-field="domainNbr">域编码</th>
                <th data-field="domainDesc">表类型</th>
                <%--<th data-field="operation" data-formatter="SysDomainFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade doMainModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".sysDomainBase"
                                   aria-controls="sysDomainBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".sysDomainComm"
                                   aria-controls="sysDomainComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane sysDomainBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"
                                           ng-show="formModel.domainId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.domainId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.domainId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">主题域名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.domainName"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">主题域编码</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.domainNbr"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">主题域描述</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="6"
                                                  ng-model="formModel.domainDesc"
                                                  placeholder=""></textarea>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane sysDomainComm">
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
