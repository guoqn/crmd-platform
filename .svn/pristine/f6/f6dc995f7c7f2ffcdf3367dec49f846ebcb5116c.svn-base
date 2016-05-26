<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- 表单公共字段 --%>
<div class="form-group">
    <label class="col-sm-2 control-label">状态</label>
    <div class="col-sm-2">
        <%--<input class="form-control" type="text"
               ng-model="formModel.statusCd" placeholder="" />--%>
        <select class="form-control"
                ng-model="formModel.statusCd"
                ng-options="item.id as item.action for item in statusCdItems">
        </select>
    </div>
    <label class="col-sm-2 control-label">创建员工</label>
    <div class="col-sm-2">
        <input class="form-control" type="text"
               ng-model="formModel.createStaff" placeholder=""/>
    </div>
    <label class="col-sm-2 control-label">修改员工</label>
    <div class="col-sm-2">
        <input class="form-control" type="text"
               ng-model="formModel.updateStaff" placeholder=""/>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-2 control-label">状态时间</label>
    <div class="col-sm-2">
        <%--<input class="form-control" type="text"
               ng-model="formModel.statusDate" placeholder=""/>--%>
        <div>
            <input class="form-control date" placeholder=""
                   type="text" ng-model="formModel.statusDate"/>
        </div>
    </div>
    <label class="col-sm-2 control-label">创建时间</label>
    <div class="col-sm-2">
        <%--<input class="form-control" type="text"
               ng-model="formModel.createDate" placeholder=""/>--%>
        <input class="form-control date" placeholder=""
               type="text" readonly
               ng-model="formModel.createDate"/>
    </div>
    <label class="col-sm-2 control-label">修改时间</label>
    <div class="col-sm-2">
        <%--<input class="form-control" type="text"
               ng-model="formModel.updateDate" placeholder=""/>--%>
        <input class="form-control date" placeholder=""
               type="text" readonly
               ng-model="formModel.updateDate"/>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-2 control-label">C3区域</label>
    <div class="col-sm-2">
        <%--<input class="form-control" type="text"
               ng-model="formModel.areaId" placeholder=""/>--%>
        <select class="form-control"
                ng-model="formModel.areaIdItems"
                ng-options="item.id as item.action for item in areaIdItems">
        </select>
    </div>
    <label class="col-sm-2 control-label">C4区域</label>
    <div class="col-sm-2">
        <%--<input class="form-control" type="text"
               ng-model="formModel.regionCd" placeholder=""/>--%>
        <select class="form-control"
                ng-model="formModel.regionCd"
                ng-options="item.id as item.action for item in regionCdItems">
        </select>
    </div>
    <label class="col-sm-2 control-label">物理变更时间</label>
    <div class="col-sm-2">
        <%--<input class="form-control" type="text"
               ng-model="formModel.dTimestamp" placeholder=""/>--%>
        <input class="form-control date" placeholder=""
               type="text" readonly
               ng-model="formModel.dtimestamp"/>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-2 control-label">分片键标识</label>
    <div class="col-sm-2">
        <input class="form-control" type="text"
               ng-model="formModel.shardingId"
               placeholder=""/>
    </div>
    <label class="col-sm-2 control-label">分片键关联标识</label>
    <div class="col-sm-2">
        <input class="form-control" type="text"
               ng-model="formModel.relShardingId"
               placeholder=""/>
    </div>
    <label class="col-sm-2 control-label">删除到历史表时间</label>
    <div class="col-sm-2">
        <%-- <input class="form-control" type="text"
                ng-model="formModel.recUpdateDate" placeholder=""/>--%>
        <input class="form-control date" placeholder=""
               type="text" readonly
               ng-model="formModel.recUpdateDate"/>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-2 control-label">版本</label>
    <div class="col-sm-2">
        <input class="form-control" type="text"
               ng-model="formModel.dversion" placeholder=""/>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-2 control-label">备注</label>
    <div class="col-sm-10">
        <textarea class="form-control" rows="6" ng-model="formModel.remark"></textarea>
    </div>
</div>
