<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<div id="sys-config-query" ng-controller="sysConfigBtnCtrl"
	 class="modal fade" tabindex="-1" role="dialog" data-backdrop="true"
	 aria-hidden="true" style="display: none;">
	<div class="modal-dialog" style="width: 50%;">
		<div class="modal-content">
			<div class="modal-header">
				<div>
					<i class="mark"></i><span class="title">查询上级节点</span> <a
						type="button" class="close" data-dismiss="modal"
						aria-hidden="true"> &times; </a>
				</div>
			</div>
			<div class="modal-body">
				<div class="div-toolbar" style="height: 60px;">
					<form class="navbar navbar-form navbar-left form-inline searchtool">

						<div class="form-group">
							<input class="form-control" type="text" placeholder="节点名称"
								   ng-model="qryName">
						</div>
						<button type="button" class="btn btn-inner-all-blue"
								ng-click="querySysConfig()">查询</button>
					</form>
				</div>
				<table id="parentSysConfigTable" data-toggle="table"
					   data-side-pagination="server" data-click-to-select="true"
					   data-row-style="rowStyle" data-pagination="true"
					   data-page-size="10" data-query-params-type=""
					   data-page-list="[5, 10, 20]">
					<thead>
<tr>
                <!-- <th data-field="state" data-checkbox="true"></th> -->
                <th data-field="confId" data-align="center">ID</th>
                <th data-field="name" data-align="center" data-sortable="true">节点名称</th>
                <th data-formatter="parentFormatter" data-align="center">上级节点</th>
                <th data-field="code" data-align="center">节点编码</th>
                <th data-field="nodeValue" data-align="center">节点值</th>
                <th data-formatter="statusCdFormatter" data-align="center">状态</th>
                <th data-field="createDate"
                        data-formatter="ffc.util.tableDateFormatter" data-align="center">创建时间
                </th>
                <th data-field="updateDate"
                        data-formatter="ffc.util.tableDateFormatter" data-align="center">修改时间
                </th>
                <th data-field="sysConfDesc" data-align="center">配置描述</th>
            </tr>
					</thead>
				</table>
			</div>
			<div align="center" class="div-toolbar">
				<button class="btn btn-inner-all-blue" style="width: 10%"
						ng-click="confirmSysConfig()">确定</button>
			</div>
			</br>
		</div>
	</div>
</div>