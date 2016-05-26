/**
 * 窗体配置
 * 
 * @author LAIYONGMIN-PC
 * 
 */

if (!window) {
	var window = {};
}

var windowCtrl = angular.module("dypageApp").controller("windowCtrl",
		[ "$scope", "commonService", "dypageService", "$compile", "$timeout", function($scope, commonService, dypageService, $compile, $timeout) {

			$scope.window = {};
			$scope.display = {};
			// 事件table初始化
			$('#windowTable').bootstrapTable({
				onResetView : function() {
					$compile($('#windowTable'))($scope);
				},
				queryParams : function(params) {
					// 查询条件
					var querys = {
						winName : $scope.window.queryName
					};
					return $.extend({}, params, querys);
				},
				ajax : function(render) {
					eh.data.callMethod("qryWindowPageInfoByWin", render.data, function(data) {
						ffc.util.loadTableData(render, data);
					})
				},
				onClickRow : function(row, $element) {
					// 暂时没有操作
				}
			});
			// 查询
			$scope.querywin = function() {
				$('#windowTable').bootstrapTable("selectPage", 1);
			};
			// 打开新增窗体
			$scope.addWindow = function() {
				$("#windowOpPage").modal('show');
				$scope.display.title = '新增';
			};
			// 保存或更新操作
			$scope.insertOrUpdate = function() {
				// 后台保存和更新
				$scope.window.statusCd = '1000';
				$scope.window.windowType = 'W_WIN';
				eh.data.callMethod("submitSimpleWindow", $scope.window, function(rt) {
					if (rt.result) {
						MESSAGE_DIALOG.alert('保存成功');
						// 清空表单
						$scope.window = {};
						// 关闭信息框
						$("#windowOpPage").modal('hide');
						// 刷新
						$('#windowTable').bootstrapTable("selectPage", 1);
					} else {
						MESSAGE_DIALOG.error(rt.detailMsg);
					}
				})
			};
			// 更新
			$scope.updateWindow = function(id) {
				eh.data.callMethod("getSimpleWindow", {
					winId : id
				}, function(rt) {
					if (rt.result) {
						$scope.display.title = '修改';
						$("#windowOpPage").modal('show');
						$timeout(function() {
							$scope.window = rt.object;
						}, 0)
					} else {
						MESSAGE_DIALOG.error(rt.detailMsg);
					}
				})

			}
			// 删除
			$scope.deleteWindow = function(id) {
				MESSAGE_DIALOG.confirm('确定要删除？', function() {
					eh.data.callMethod("deleteWindow", {
						winId : id
					}, function(rt) {
						if (rt.result) {
							// 更新列表
							$('#windowTable').bootstrapTable("selectPage", 1);
						} else {
							MESSAGE_DIALOG.error(rt.detailMsg);
						}
					})
				}, function() {
					return;
				})
			}
			// 取消
			$scope.cancelWin = function() {
				$scope.window = {};
			}
			// 界面设计
			$scope.designPage = function(id) {
				$("#main > * ").hide().siblings("#main-win-design").show();
				dypageWin.loadWinData("window", id);
			}
		} ]);

// 窗体列表操作
window.windowOp = function(value, row, index) {
	var btn = [ '<a ng-click="designPage(' + row.windowId + ')">窗体设计</a>', '<a ng-click="updateWindow(' + row.windowId + ')">修改</a>',
			'<a ng-click="deleteWindow(' + row.windowId + ')">删除</a>' ].join(' &nbsp;');
	return btn;
}