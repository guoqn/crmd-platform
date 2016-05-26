/**
 * 构件配置
 * 
 * @author LAIYONGMIN-PC
 */

var part = {};

var partCtrl = angular.module("dypageApp").controller("partCtrl",
		[ "$scope", "commonService", "dypageService", "$compile", "$timeout", function($scope, commonService, dypageService, $compile, $timeout) {

			// 表单对象
			$scope.partForm = {};
			// 显示对象
			$scope.display = {};

			// 下拉数据
			$scope.select = {
				partType : [ {
					id : '',
					action : '请选择...'
				}, {
					id : 'prod',
					action : '产品信息'
				} ]
			}
			// 默认选中
			$scope.partForm.partType = '';
			$scope.queryType = '';
			// 事件table初始化
			$('#partTable').bootstrapTable({
				onResetView : function() {
					$compile($('#partTable'))($scope);
				},
				queryParams : function(params) {
					// 查询条件
					var querys = {
						name : $scope.queryName,
						type : $scope.queryType
					};
					return $.extend({}, params, querys);
				},
				ajax : function(render) {
					eh.data.callMethod("qryPageInfoPart", render.data, function(data) {
						ffc.util.loadTableData(render, data);
					})
				},
				onClickRow : function(row, $element) {
					// 暂时没有操作
				}
			});

			// 查询方法
			$scope.queryPart = function() {
				$('#partTable').bootstrapTable("selectPage", 1);
			}
			// 新增
			$scope.addPart = function() {
				$("#partOpPage").modal('show');
				$scope.display.title = '新增';
			}

			// 取消
			$scope.cancelPart = function() {
				$scope.partForm = {};
				$("#eventOpPage").modal('hide');
				// 默认选中
				$scope.partForm.partType = '';
			}
			// 保存
			$scope.savePart = function() {
				// 保存
				$scope.partForm.statusCd = '1000';
				eh.data.callMethod("savePart", $scope.partForm, function(rt) {
					if (rt.result) {
						MESSAGE_DIALOG.alert('保存成功');
						// 清空表单
						$scope.partForm = {};
						// 关闭信息框
						$("#partOpPage").modal('hide');
						// 刷新
						$('#partTable').bootstrapTable("selectPage", 1);
					} else {
						MESSAGE_DIALOG.error(rt.detailMsg);
					}
				})
			}
			// 删除
			$scope.deletePart = function(id) {
				MESSAGE_DIALOG.confirm('确定要删除？', function() {
					eh.data.callMethod("deletePart", {
						partId : id
					}, function(rt) {
						if (rt.result) {
							// 更新列表
							$('#partTable').bootstrapTable("selectPage", 1);
						} else {
							MESSAGE_DIALOG.error(rt.detailMsg);
						}
					})
				}, function() {
					return;
				})
			}
			// 更新
			$scope.updatePart = function(id) {
				eh.data.callMethod("getSimplePart", {
					objId : id
				}, function(rt) {
					if (rt.result) {
						$scope.display.title = '修改';
						$("#partOpPage").modal('show');
						$timeout(function() {
							$scope.partForm = rt.object;
						}, 0)
					} else {
						MESSAGE_DIALOG.error(rt.detailMsg);
					}
				})

			}
			// 界面设计
			$scope.designPage = function(id) {
				$("#main > * ").hide().siblings("#main-win-design").show();
				dypageWin.loadWinData("part", id);
			}
		} ]);

part.partOp = function(value, row, index) {
	var btn = [ '<a ng-click="designPage(' + row.partId + ')">构件设计</a>', '<a ng-click="updatePart(' + row.partId + ')">修改</a>',
			'<a ng-click="deletePart(' + row.partId + ')">删除</a>' ].join(' &nbsp;');
	return btn;
}
