<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="panel panel-default" ng-controller="attrSpecCtrl">
    <div class="panel-heading">
        <i class="mark"></i><span class="title">属性规格</span>
    </div>
    <div class="panel-body">
        <div class="btn-group attrSpec-btgroup">
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
        <table class="table table-striped" bs-table-control="attrSpecControl">
            <thead>
            <tr>
                <th data-field="attrId">#</th>
                <th data-field="attrName">名称</th>
                <th data-field="attrNbr">编码</th>
                <th data-field="busiTypeId">隶属大类</th>
                <th data-field="parAttrId">父级</th>
                <th data-field="attrDesc">描述</th>
                <%--<th data-field="operation" data-formatter="AttrSpecFormatter.operation">操作</th>--%>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <!-- 模态框 -->
    <div class="modal fade attrSpecModal" tabindex="-1" role="dialog">
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
                                <a href="javascript:;" data-target=".attrSpecBase"
                                   aria-controls="attrSpecBase"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>基本信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".attrSpecOther"
                                   aria-controls="attrSpecOther"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>附加信息</a></li>
                            <li role="presentation" class="">
                                <a href="javascript:;" data-target=".attrSpecComm"
                                   aria-controls="attrSpecComm"
                                   role="tab"
                                   data-toggle="tab"><i class="mark"></i>公共信息</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane attrSpecBase active">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"
                                           ng-show="formModel.attrId">#ID</label>
                                    <div class="col-sm-2" ng-show="formModel.attrId">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">业务大类</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.busiTypeId" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">父级</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.parAttrId" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性名称</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrName" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">属性编码</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrNbr" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">属性值数据类型</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.attrValueDataType"
                                            ng-options="item.id as item.action for item in select.attrValDataType"></select>
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
                                               ng-model="formModel.startValue" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">结束值</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.endValue" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性值分类</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.attrValueType"
                                            ng-options="item.id as item.action for item in select.attrValType"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性描述</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" ng-model="formModel.attrDesc"
                                                  rows="6" placeholder=""></textarea>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane attrSpecOther">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">唯一性</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isUnique"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">是否可空</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isNullable"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">是否动态属性</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isDanyAttr"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">是否多选值</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isMultiValue"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">属性格式</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrFormat" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">属性长度</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrLength" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">外部属性编码</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.extAttrCd" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">持久化类型</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.attrPersistType"
                                                ng-options="item.id as item.action for item in select.attrPerType"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">输入流</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrIoType" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性顺序</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrSort" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">约束类型</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.procType"
                                                ng-options="item.id as item.action for item in select.procType"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">关联业务标识</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.refBusyTypeId"
                                                ng-options="item.id as item.action for item in select.busiTypeItem"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性级别</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.attrLevel"
                                                ng-options="item.id as item.action for item in select.attrLevel"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">打印格式</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.printFormat"
                                                ng-options="item.id as item.action for item in select.printFormat"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">编码对应生产类</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.codeBuilder"
                                               placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">编码参数</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.codeParam" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">竣工标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.completeAction"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">是否可见</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isVisible"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">默认有效期</label>
                                    <div class="col-sm-2">
                                        <input class="form-control date" type="text"
                                               ng-model="formModel.defaultTypePeriod"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">失效方式</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.expireType"
                                                ng-options="item.id as item.action for item in select.expireType"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">新增生效方式</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.addEffType"
                                                ng-options="item.id as item.action for item in select.addEffType"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">变更生效方式</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.modEffType"
                                                ng-options="item.id as item.action for item in select.modEffType"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">约束类型扩展</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.cnsTypeExtra"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">割接状态</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.isTrans"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">是否送PF系统</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.pfPost"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">是否送计费系统</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" ng-model="formModel.hbPost"
                                                ng-options="item.id as item.action for item in isOrNotItems"></select>
                                    </div>
                                    <label class="col-sm-2 control-label">属主应用</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.ownerApp" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">属性编码扩展</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.attrSpecExtRule"
                                               placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">跨本地网标识</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.extFlag" placeholder=""/>
                                    </div>
                                    <label class="col-sm-2 control-label">集团编码</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.groupCd" placeholder=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">序列名</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" type="text"
                                               ng-model="formModel.seqName" placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane attrSpecComm">
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
