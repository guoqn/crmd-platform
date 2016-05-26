/**
 * config controller app
 * 
 * @author LAIYONGMIN
 */
registNS("config");
// module
var sysConfigApp = angular.module("sysConfigApp", [ "configMainServiceApp" ,"sysConfigButtonApp"]);
// controller
sysConfigApp.controller("sysConfigCtrl", [
		"$scope",
		"configMainService",
		"commonService",
		"$compile",
		function($scope, configMainService, commonService,$compile) {
			// 表单初始化
			commonService.initFrom(ffc.util.getPageMetas($scope));
			// 新增修改数据信息
			$scope.saveInfo = {

			};

			// 表格初始化
			$('#sysConfigTable').bootstrapTable(
					{
		                // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
		                onResetView: function () {
		                    $compile($('#sysConfigTable'))($scope);
		                },
						// 条件
						queryParams : function(params) {
							// 查询条件
							var selfParams = {
								name : $scope.name
							}
							return $.extend({}, params, selfParams);
						},
						// 服务请求
						ajax : function(render) {
							// 服务请求
							configMainService.qrySysConfigData(
									render.data, function(result) {
										ffc.util.setPageResult($scope,
												'sysConfigQueryErrorAlert',
												render, result);
									});
						}
					});
			// 查询按钮事件
			$scope.qrySysConfig = function() {
				// 方法调用
				$('#sysConfigTable').bootstrapTable("selectPage", 1);
			};

			// 新增
			$scope.addSysConfig = function() {
				// 方法调用
				$scope.saveInfo = {};
				$scope.sysConfigList = [{
					sysConfigName : '请选择..'
				}];
				$('#sys_config_add').modal('show');
			};
			// 修改
			$scope.modifySysConfig = function(rowIndex) {
				$scope.saveInfo ={};
				var allTable = $('#sysConfigTable').bootstrapTable("getData");
				var selectRow = allTable[rowIndex];
//				$scope.saveInfo = selectRow;
				$scope.saveInfo.confId = selectRow.confId;
				$scope.saveInfo.parentId = selectRow.parentId;
				$scope.sysConfigList = [{
					confId : selectRow.parentId,
					sysConfigName : selectRow.parentName
				}];
				$scope.saveInfo.nodeValue = selectRow.nodeValue;
				$scope.saveInfo.code = selectRow.code;
				$scope.saveInfo.sysConfDesc = selectRow.sysConfDesc;
				$scope.saveInfo.name = selectRow.name;
				// // 上级仓库信息
				// $scope.mktResoStoreList = [ {
				// storeName : selectRow.parStoreId,
				// storeId : selectRow.parStoreId
				// } ];
				$('#sys_config_add').modal('show');
			};
			// 删除
			$scope.deleteSysConfig = function(confId) {
				var deleteInfo = {
					confId : confId
				// shardingId : 1
				};
				MESSAGE_DIALOG.confirm("确认删除？", function() {
					configMainService.delSysConfig(deleteInfo,
							function(result) {
								if (result.result != undefined
										&& result.result == true) {
									MESSAGE_DIALOG.alert("删除成功！");
									$scope.qrySysConfig();
								} else {
									MESSAGE_DIALOG.alert(result.msgTitle +".删除失败！");
								}
							}, function() {
								MESSAGE_DIALOG.alert("删除失败！");
							});
				});
			};
			// 保存
			$scope.saveSysConfig = function() {
				if (undefined != $scope.sysConfigList[0]) {
					$scope.saveInfo.parentId = $scope.sysConfigList[0].confId;
					//选择上级节点前端校验
					if ($scope.saveInfo.confId == $scope.saveInfo.parentId) {
						MESSAGE_DIALOG.alert("上级节点不能为本身!");
						return ;
					}
				}
				
				configMainService.saveSysConfig($scope.saveInfo, function(result) {
					if (result.result != undefined && result.result == true) {
						MESSAGE_DIALOG.alert("保存成功！");
						$('#sys_config_add').modal('hide');
						$scope.qrySysConfig();
					} else {
						MESSAGE_DIALOG.alert(result.msgTitle + ",保存失败！");
					}
				}, function() {
					MESSAGE_DIALOG.alert("保存失败！");
				});
			};
		} ]);

// table按钮格式化
function sysConfigFormatter(value, row, index) {
	var btn = [
			'<button class="btn btn-info" ng-click="modifySysConfig(' + index
					+ ')">修改</button>',
			'<button class="btn btn-danger"  ng-click="deleteSysConfig('
					+ row.confId + ')">删除</button>' ].join(' &nbsp;');
	return btn;
}

//状态
function statusCdFormatter(value,row,index){
	var statusCdName = (row.statusCd == '1000' ? '有效':'无效');
	return statusCdName;
}

//上级节点
function parentFormatter(value,row,index) {
	if (undefined != row.parentId) {
		return row.parentName +"(id:"+row.parentId+")";
	}
}
