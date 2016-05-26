<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div ng-controller="partCtrl">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home"> <use
							xlink:href="#stroked-home"></use></svg></a></li>
			<li class="active">构件配置</li>
		</ol>
	</div>
	<div class="row" style="height: 10px" style="padding-left: 0px;"></div>
	<div class="row">
		<div class="col-md-12" style="padding-left: 0px;">
			<div class="panel panel-default">
				<div class="panel-heading">构件列表</div>
				<div class="panel-body">
					<form class="form-horizontal" role="search">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" class="form-control" ng-model="queryName"
									placeholder="构件查询">
							</div>
							<!-- <label class="col-sm-2 control-label">构件类型</label>
							<div class="col-sm-3">
								<select class="form-control" ng-model="queryType"
									ng-options="item.id as item.action for item in select.partType"></select>
							</div> -->
							<div class="col-sm-8">
								<button type="button" class="btn btn-default"
									ng-click="queryPart()">查询</button>
								<button type="button" class="btn btn-default"
									ng-click="addPart()">新增</button>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body">
					<table id="partTable" data-toggle="table"
						class="table table-bordered table-hover" data-pagination="true"
						data-side-pagination="server" data-page-size="10"
						data-page-list="[10, 25, 50, 100, ALL]">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="partId" data-width="5%">构件序号</th>
								<th data-field="partName">构件名称</th>
								<th data-field="partDesc">构件描述</th>
								<th data-field="op" data-formatter="part.partOp">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- 新增/修改弹出页面 -->
	<div id="partOpPage" class="modal fade sysTabModal" tabindex="-1"
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
							ng-model="partForm.partId" />
						<div class="form-group">
							<!-- <label class="col-sm-2 control-label">构件类型</label>
							<div class="col-sm-3">
								<select class="form-control" ng-model="partForm.partType"
									ng-options="item.id as item.action for item in select.partType"></select>
							</div> -->
							<label class="col-sm-2 control-label">构件名称</label>
							<div class="col-sm-3">
								<input class="form-control" type="text"
									ng-model="partForm.partName" placeholder="" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">构件描述</label>
							<div class="col-sm-8">
								<textarea ng-model="partForm.partDesc" class="form-control"
									rows="3"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" ng-click="savePart()">保存</button>
					<button type="button" class="btn btn-default"
						ng-click="cancelPart()" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

</div>
