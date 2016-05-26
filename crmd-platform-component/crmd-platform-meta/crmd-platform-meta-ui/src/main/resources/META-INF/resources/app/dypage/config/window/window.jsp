<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div ng-controller="windowCtrl">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home"> <use
							xlink:href="#stroked-home"></use></svg></a></li>
			<li class="active">窗体配置</li>
		</ol>
	</div>
	<div class="row" style="height: 10px" style="padding-left: 0px;"></div>
	<div class="row">
		<div class="col-md-12" style="padding-left: 0px;">
			<div class="panel panel-default">
				<div class="panel-heading">窗体列表</div>
				<div class="panel-body">
					<form role="search">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" class="form-control"
									ng-model="window.queryName" placeholder="窗体名称">
							</div>
							<div class="col-sm-8">
								<button type="button" class="btn btn-default"
									ng-click="querywin()">查询</button>
								<button type="button" class="btn btn-default"
									ng-click="addWindow()">新增</button>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body">
					<table id="windowTable" data-toggle="table"
						class="table table-bordered table-hover" data-pagination="true"
						data-side-pagination="server" data-page-size="10"
						data-page-list="[10, 25, 50, 100, ALL]">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="windowId" data-width="5%">窗体序号</th>
								<th data-field="windowCode" data-width="20%">窗体编码</th>
								<th data-field="windowName">窗体名称</th>
								<th data-field="windowDesc">窗体描述</th>
								<th data-field="op" data-width="15%"
									data-formatter="window.windowOp">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- 新增/修改弹出页面 -->
	<div id="windowOpPage" class="modal fade sysTabModal" tabindex="-1"
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
							ng-model="window.windowId" placeholder="窗体ID" /> <input
							class="form-control" style="display: none;" type="text"
							ng-model="window.windowType" value="WIN" placeholder="窗体类型" />
						<div class="form-group">
							<label class="col-sm-2 control-label">窗体名称</label>
							<div class="col-sm-4">
								<input class="form-control" type="text"
									ng-model="window.windowName" placeholder="" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">窗体描述</label>
							<div class="col-sm-8">
								<textarea ng-model="window.windowDesc" class="form-control"
									rows="3"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						ng-click="insertOrUpdate()">保存</button>
					<button type="button" class="btn btn-default"
						ng-click="cancelWin()" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

</div>
