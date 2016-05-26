<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div ng-controller="eventCtrl">
	<div class="row" style="padding-left: 0px;">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home"> <use
							xlink:href="#stroked-home"></use></svg></a></li>
			<li class="active">事件配置</li>
		</ol>
	</div>
	<div class="row" style="height: 10px" style="padding-left: 0px;"></div>
	<div class="row">
		<div class="col-md-3" style="padding-left: 0px;">
			<jsp:include page="../dy-page-intf/bus-spec/bus-spec.jsp"></jsp:include>
		</div>
		<div class="col-md-9" style="padding-left: 0px;">
			<div class="panel panel-default">
				<div class="panel-heading">事件列表</div>
				<div class="panel-body">
					<form role="search">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" class="form-control" placeholder="事件查询">
							</div>
							<div class="col-sm-8">
								<button type="button" class="btn btn-default">查询</button>
								<button type="button" ng-click="eventOp('add')"
									class="btn btn-default">新增</button>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body">
					<table id="eventTable" class="table table-bordered table-hover"
						data-pagination="true" data-side-pagination="server"
						data-page-size="10" data-page-list="[10, 25, 50, 100, ALL]">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="eventId">事件编号</th>
								<th data-field="busSpec">适用规格</th>
								<th data-field="busService">适用服务</th>
								<th data-field="busRegion">适用区域</th>
								<th data-field="busChannel">适用渠道</th>
								<th data-field="op" data-formatter="dypageEvent.eventOp">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 新增/修改弹出页面 -->
	<div id="eventOpPage" class="modal fade sysTabModal" tabindex="-1"
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
							ng-model="eventForm.eventId" placeholder="事件ID" /> <input
							class="form-control" type="text" style="display: none;"
							ng-model="eventForm.busSpec" placeholder="" />
						<div class="form-group">
							<label class="col-sm-2 control-label">适用服务</label>
							<div class="col-sm-2">
								<input class="form-control" type="text"
									ng-model="eventForm.busService" placeholder="" />
							</div>
							<label class="col-sm-2 control-label">适用区域</label>
							<div class="col-sm-2">
								<input class="form-control" type="text"
									ng-model="eventForm.busRegion" placeholder="" />
							</div>
							<label class="col-sm-2 control-label">适用渠道</label>
							<div class="col-sm-2">
								<input class="form-control" type="text"
									ng-model="eventForm.busChannel" placeholder="" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						ng-click="insertOrUpdate()">保存</button>
					<button type="button" class="btn btn-default"
						ng-click="cancelEvent()" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</div>
