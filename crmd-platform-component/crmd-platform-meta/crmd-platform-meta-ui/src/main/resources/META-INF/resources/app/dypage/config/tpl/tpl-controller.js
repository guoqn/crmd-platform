/**
 * 模版
 */

var tpl = {};

var tplCtrl = angular.module("dypageApp").controller("tplCtrl",
		[ "$scope", "commonService", "dypageService", "$compile", "$timeout", function($scope, commonService, dypageService, $compile, $timeout) {
			// 表单对象
			$scope.tplForm = {};
			// 显示对象
			$scope.display = {};

			// 下拉数据
			$scope.select = {
				tplType : [ {
					id : '',
					action : '请选择...'
				}, {
					id : 'wtpl',
					action : '窗体模版'
				} ]
			}
			// 初始化
			$scope.tplForm.templateType = '';
			// 事件table初始化
			$('#tplTable').bootstrapTable({
				onResetView : function() {
					$compile($('#tplTable'))($scope);
				},
				queryParams : function(params) {
					// 查询条件
					var querys = {
						name : $scope.queryName
					};
					return $.extend({}, params, querys);
				},
				ajax : function(render) {
					eh.data.callMethod("queryTpls", render.data, function(data) {
						ffc.util.loadTableData(render, data);
					})
				},
				onClickRow : function(row, $element) {
					// 暂时没有操作
				}
			});
			// 查询
			$scope.queryTpl = function() {
				$('#tplTable').bootstrapTable("selectPage", 1);
			}
			// 新增
			$scope.addTpl = function() {
				$("#tplOpPage").modal('show');
				$scope.display.title = '新增';
			}

			// 取消
			$scope.cancelTpl = function() {
				$scope.tplForm = {};
				$scope.tplForm.templateType = '';
				$("#tplOpPage").modal('hide');
			}
			// 保存
			$scope.saveTpl = function() {
				// 保存
				$scope.tplForm.statusCd = '1000';
				eh.data.callMethod("saveTpl", $scope.tplForm, function(rt) {
					if (rt.result) {
						MESSAGE_DIALOG.alert('保存成功');
						// 清空表单
						$scope.tplForm = {};
						$scope.tplForm.templateType = '';
						// 关闭信息框
						$("#tplOpPage").modal('hide');
						// 刷新
						$('#tplTable').bootstrapTable("selectPage", 1);
					} else {
						MESSAGE_DIALOG.error(rt.detailMsg);
					}
				})
			}
			// 删除
			$scope.deleteTpl = function(id) {
				MESSAGE_DIALOG.confirm('确定要删除？', function() {
					eh.data.callMethod("delTpl", {
						templateId : id
					}, function(rt) {
						if (rt.result) {
							// 更新列表
							$('#tplTable').bootstrapTable("selectPage", 1);
						} else {
							MESSAGE_DIALOG.error(rt.detailMsg);
						}
					})
				}, function() {
					return;
				})
			}
			// 更新
			$scope.updateTpl = function(index) {
				var curData = $('#tplTable').bootstrapTable('getData')[index];
				$scope.display.title = '修改';
				$("#tplOpPage").modal('show');
				$scope.tplForm = curData;
			}
			// 界面设计
			$scope.designPage = function(index) {
				var curData = $('#tplTable').bootstrapTable('getData')[index];
				switch (curData.templateType) {
				case 'wtpl':
					dypageWin.loadWinData("tpl", curData.templateId);
					$("#main > * ").hide().siblings("#main-win-design").show();
					break;
				default:
					break;
				}
			}
		} ]);

tpl.tplOp = function(value, row, index) {
	var btn = [ '<a ng-click="designPage(' + index + ')">模版设计</a>', '<a ng-click="updateTpl(' + index + ')">修改</a>',
			'<a ng-click="deleteTpl(' + row.templateId + ')">删除</a>' ].join(' &nbsp;');
	return btn;
}