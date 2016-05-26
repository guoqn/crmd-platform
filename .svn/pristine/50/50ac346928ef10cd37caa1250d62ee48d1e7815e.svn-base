/**
 * 动态配置界面
 */

var dypageEvent = {};

// 事件查询全局变量
var querys = {};
// 当前选择规格
var curSpec = 0;

// 选中节点事件
dypageEvent.onSelectSpecNode = function(event, treeId, treeNode, clickFlag) {
	// 记录当前点击的规格ID
	curSpec = treeNode.id;
	// 设置查询条件
	querys = {
		busSpec : treeNode.id
	}
	$('#eventTable').bootstrapTable("selectPage", 1);
}
// 事件列表操作
dypageEvent.eventOp = function(value, row, index) {
	var btn = [ '<a ng-click="designPage(' + row.eventId + ')">窗体设计</a>', '<a ng-click="getDyEvent(' + row.eventId + ')" href="#event">修改</a>',
			'<a ng-click="deleteEvent(' + row.eventId + ')">删除</a>' ].join(' &nbsp;');
	return btn;
}

var eventCtrl = angular.module("dypageApp").controller(
		"eventCtrl",
		[ "$scope", "commonService", "dypageService", "$compile", "$timeout", "ehDataService",
				function($scope, commonService, dypageService, $compile, $timeout, ehDataService) {
					// 显示
					$scope.display = {};
					// 表单信息
					$scope.eventForm = {};
					// 事件table初始化
					$('#eventTable').bootstrapTable({
						onResetView : function() {
							$compile($('#eventTable'))($scope);
						},
						queryParams : function(params) {
							// 查询条件
							return $.extend({}, params, querys);
						},
						ajax : function(render) {
							eh.data.callMethod("queryEventsByBusspec", render.data, function(data) {
								ffc.util.loadTableData(render, data);
							})
						},
						onClickRow : function(row, $element) {
							// 暂时没有操作
						}
					});
					// 操作
					$scope.eventOp = function(type) {
						// 当前操作规格
						$scope.eventForm.busSpec = curSpec;
						if (ffc.util.isEmpty($scope.eventForm.busSpec) || $scope.eventForm.busSpec === 0) {
							MESSAGE_DIALOG.alert('请先选择规格');
						} else {
							switch (type) {
							case 'add':
								if (type === 'add') {
									$("#eventOpPage").modal('show');
									$scope.display.title = '新增';
								}
								break;
							case 'update':
								break;
							default:
								break;
							}
						}
					}
					// 新增or更新操作
					$scope.insertOrUpdate = function() {
						// 新增
						if (typeof ($scope.eventForm.eventId) === 'undefined') {
							// 状态默认1000
							$scope.eventForm.statusCd = '1000';
							// 发起服务
							eh.data.callMethod("insertDyEvent", $scope.eventForm, function(rt) {
								if (rt.result) {
									MESSAGE_DIALOG.alert('保存成功');
									// 规格相同则更新列表
									if (curSpec === $scope.eventForm.busSpec) {
										// 刷新
										$('#eventTable').bootstrapTable("selectPage", 1);
										// 清空表单
										$scope.eventForm = {};
										// 关闭信息框
										$("#eventOpPage").modal('hide');
									}
								} else {
									MESSAGE_DIALOG.error(rt.detailMsg);
								}
							})
						} else {
							// 接口提供
							ehDataService.updateEvent($scope.eventForm, function(rt) {
								if (rt.result) {
									MESSAGE_DIALOG.alert('修改成功');
									// 规格相同则更新列表
									if (curSpec === $scope.eventForm.busSpec) {
										$('#eventTable').bootstrapTable("selectPage", 1);
									}
									$scope.eventForm = {};
									// 关闭信息框
									$("#eventOpPage").modal('hide');
								} else {
									MESSAGE_DIALOG.error(rt.detailMsg);
								}
							});
							/*
							 * eh.data.callMethod("updateDyEvent",
							 * $scope.eventForm, function(rt) { if (rt.result) {
							 * MESSAGE_DIALOG.alert('修改成功'); // 规格相同则更新列表 if
							 * (curSpec === $scope.eventForm.busSpec) {
							 * $('#eventTable').bootstrapTable("selectPage", 1); }
							 * $scope.eventForm = {}; // 关闭信息框
							 * $("#eventOpPage").modal('hide'); } else {
							 * MESSAGE_DIALOG.error(rt.detailMsg); } })
							 */
						}
					}
					// 删除
					$scope.deleteEvent = function(eventId) {
						MESSAGE_DIALOG.confirm('确定要删除？', function() {
							eh.data.callMethod("deleteDyEvent", {
								eventId : eventId
							}, function(rt) {
								if (rt.result) {
									// 更新列表
									$('#eventTable').bootstrapTable("selectPage", 1);
								} else {
									MESSAGE_DIALOG.error(rt.detailMsg);
								}
							});
						}, function() {
							return;
						})
					}
					// 获取修改信息
					$scope.getDyEvent = function(eventId) {
						eh.data.callMethod("getDyEventByEventId", {
							eventId : eventId
						}, function(rt) {
							if (rt.result) {
								$scope.display.title = '修改';
								$("#eventOpPage").modal('show');
								$timeout(function() {
									$scope.eventForm = rt.object;
								}, 0)
							} else {
								MESSAGE_DIALOG.error(rt.detailMsg);
							}
						})
					}
					// 取消
					$scope.cancelEvent = function() {
						$scope.eventForm = {};
						$("#eventOpPage").modal('hide');
					}
					// 事件界面设计
					$scope.designPage = function(eventId) {
						$("#main > * ").hide().siblings("#main-win-design").show();
						dypageWin.loadWinData("event", eventId);
					}
				} ]);