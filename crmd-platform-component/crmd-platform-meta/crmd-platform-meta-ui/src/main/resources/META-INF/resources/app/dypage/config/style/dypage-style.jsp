<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div ng-controller="styleCtrl">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home"> <use
							xlink:href="#stroked-home"></use></svg></a></li>
			<li class="active">样式配置</li>
		</ol>
	</div>
	<div class="row" style="height: 10px"></div>
	<div class="row">
		<div class="col-md-3" style="padding-left: 0px;">
			<jsp:include page="../dy-page-intf/style/sys-style.jsp"></jsp:include>
		</div>
		<div class="col-md-9" style="padding-left: 0px;">
			<div class="panel panel-default">
				<div class="panel-heading">样式列表</div>
				<div class="panel-body">
					<form role="search">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" class="form-control" placeholder="样式查询">
							</div>
							<div class="col-sm-8">
								<button type="button" class="btn btn-default">查询</button>
								<button type="button" class="btn btn-default"
									ng-click="addStyle()">新增</button>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body">
					<table id="styleTable" data-toggle="table">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="styleId">样式编号</th>
								<th data-field="styleName">样式名称</th>
								<th data-field="styleType">样式类型</th>
								<th data-field="styleAttr">样式属性名称</th>
								<th data-field="styleAttrValue">样式属性值</th>
								<th data-field="op" data-formatter="dypageStyle.styleOp">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- 新增/修改弹出页面 -->
	<div id="styleOpPage" class="modal fade sysTabModal" tabindex="-1"
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
						<div class="form-group">
							<input class="form-control" style="display: none;" type="text"
								ng-model="styleForm.styleId" placeholder="事件ID" />
							<div class="form-group">
								<label class="col-sm-2 control-label">样式名称</label>
								<div class="col-sm-3">
									<input class="form-control" type="text"
										ng-model="styleForm.styleName" placeholder="" />
								</div>
								<label class="col-sm-2 control-label">样式类型</label>
								<div class="col-sm-3">
									<select class="form-control" ng-model="styleForm.styleType"
										ng-options="item.id as item.action for item in select.styleType"></select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">样式属性</label>
								<div class="col-sm-3">
									<input class="form-control" type="text"
										ng-model="styleForm.styleAttr" placeholder="" />
								</div>
								<label class="col-sm-2 control-label">样式属性值</label>
								<div class="col-sm-3">
									<input class="form-control" type="text"
										ng-model="styleForm.styleAttrValue" placeholder="" />
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						ng-click="insertOrUpdate()">保存</button>
					<button type="button" class="btn btn-default"
						ng-click="cancelStyle()" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

</div>
