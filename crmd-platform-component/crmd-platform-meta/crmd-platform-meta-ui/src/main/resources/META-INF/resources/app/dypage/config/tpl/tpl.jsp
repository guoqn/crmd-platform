<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div ng-controller="tplCtrl">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home"> <use
							xlink:href="#stroked-home"></use></svg></a></li>
			<li class="active">模版配置</li>
		</ol>
	</div>
	<div class="row" style="height: 10px" style="padding-left: 0px;"></div>
	<div class="row">
		<div class="col-md-12" style="padding-left: 0px;">
			<div class="panel panel-default">
				<div class="panel-heading">模版列表</div>
				<div class="panel-body">
					<form role="search">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" ng-model="queryName" class="form-control"
									placeholder="模版查询">
							</div>
							<div class="col-sm-8">
								<button type="button" ng-click="queryTpl()"
									class="btn btn-default">查询</button>
								<button type="button" class="btn btn-default"
									ng-click="addTpl()">新增</button>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body">
					<table id="tplTable" data-toggle="table"
						class="table table-bordered table-hover" data-pagination="true"
						data-side-pagination="server" data-page-size="10"
						data-page-list="[10, 25, 50, 100, ALL]">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field=templateId data-width="5%">模板序号</th>
								<th data-field="templateCode" data-width="15%">模板编码</th>
								<th data-field="templateType" data-width="10%">模板类型</th>
								<th data-field="templateName" data-width="15%">模板名称</th>
								<th data-field="templateDesc">模板描述</th>
								<th data-field="op" data-formatter="tpl.tplOp">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- 新增/修改弹出页面 -->
	<div id="tplOpPage" class="modal fade sysTabModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" ng-bind="display.title"></h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<!-- 隐藏域 -->
						<input class="form-control" style="display: none;" type="text"
							ng-model="tplForm.templateId" />
						<div class="form-group">
							<label class="col-sm-2 control-label">模版名称</label>
							<div class="col-sm-3">
								<input class="form-control" type="text"
									ng-model="tplForm.templateName" placeholder="" />
							</div>
							<label class="col-sm-2 control-label">模版类型</label>
							<div class="col-sm-3">
								<select class="form-control" ng-model="tplForm.templateType"
									ng-options="item.id as item.action for item in select.tplType"></select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">模版描述</label>
							<div class="col-sm-8">
								<textarea ng-model="tplForm.templateDesc" class="form-control"
									rows="3"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" ng-click="saveTpl()">保存</button>
					<button type="button" class="btn btn-default"
						ng-click="cancelTpl()" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</div>
