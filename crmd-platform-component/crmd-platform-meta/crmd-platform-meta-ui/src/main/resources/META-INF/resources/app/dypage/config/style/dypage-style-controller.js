/**
 * 样式配置
 * 
 * @author LAIYONGMIN-PC
 */

var dypageStyle = {};

// 默认查询
var querys = {
	styleId : 0,
	styleType : "table"

};

// 样式列表操作
dypageStyle.styleOp = function(value, row, index) {
	var btn = [ '<a ng-click="getStyle(' + row.styleId + ')" href="#event">修改</a>', '<a ng-click="deleteStyle(' + row.styleId + ')">删除</a>' ]
			.join(' &nbsp;');
	return btn;
}

// 刷新树和列表数据
dypageStyle.refreshData = function() {
	// 刷新
	eh.data.callMethod("qryStylesById", querys, function(rt) {
		$("#styleTable").bootstrapTable('load', rt.object);
	});
	// 刷新树
	var style = $.fn.zTree.getZTreeObj("styleTree");
	var nodes = style.getSelectedNodes();
	if (nodes.length > 0) {
		style.reAsyncChildNodes(nodes[0], "refresh");
	} else {
		// 加载主题
		winStyle.loadTheme();
	}
}

var styleCtrl = angular.module("dypageApp").controller("styleCtrl",
		[ "$scope", "commonService", "dypageService", "$compile", "$timeout", function($scope, commonService, dypageService, $compile, $timeout) {

			$scope.display = {};
			$scope.styleForm = {};
			// 下拉数据
			$scope.select = {
				styleType : [ {
					id : '0',
					action : '请选择...'
				}, {
					id : 'class',
					action : '(class)类样式'
				}, {
					id : 'style',
					action : '(style)属性样式'
				}, {
					id : 'theme',
					action : '(theme)主题样式'
				} ]
			}

			$scope.styleForm.styleType = '0';

			// 样式table初始化
			$('#styleTable').bootstrapTable({
				onResetView : function() {
					$compile($('#styleTable'))($scope);
				}
			});
			// 新增样式
			$scope.addStyle = function() {
				$("#styleOpPage").modal('show');
				$scope.display.title = '新增';
			}
			// 新增or更新操作
			$scope.insertOrUpdate = function() {
				if (typeof ($scope.styleForm.styleId) === 'undefined') {
					// 状态默认1000
					$scope.styleForm.statusCd = '1000';
					// 父节点
					$scope.styleForm.pStyleId = querys.styleId;
					// 发起服务
					eh.data.callMethod("insertDyStyle", $scope.styleForm, function(rt) {
						if (rt.result) {
							MESSAGE_DIALOG.alert('保存成功');
							// 清空表单
							$scope.styleForm = {};
							// 关闭信息框
							$("#styleOpPage").modal('hide');
							// 刷新
							dypageStyle.refreshData();
						} else {
							MESSAGE_DIALOG.error(rt.detailMsg);
						}
					})
				} else {
					eh.data.callMethod("updateDyStyle", $scope.styleForm, function(rt) {
						if (rt.result) {
							MESSAGE_DIALOG.alert('修改成功');
							$scope.styleForm = {};
							// 关闭信息框
							$("#styleOpPage").modal('hide');
							// 刷新
							dypageStyle.refreshData();
						} else {
							MESSAGE_DIALOG.error(rt.detailMsg);
						}
					})

				}
			}
			// 删除
			$scope.deleteStyle = function(styleId) {
				MESSAGE_DIALOG.confirm('确定要删除？', function() {
					eh.data.callMethod("deleteDyStyle", {
						styleId : styleId
					}, function(rt) {
						if (rt.result) {
							// 刷新
							dypageStyle.refreshData();
						} else {
							MESSAGE_DIALOG.error(rt.detailMsg);
						}
					});
				}, function() {
					return;
				})

			}
			// 获取对象
			$scope.getStyle = function(styleId) {
				eh.data.callMethod("getDyStyleById", {
					styleId : styleId
				}, function(rt) {
					if (rt.result) {
						$scope.display.title = '修改';
						$("#styleOpPage").modal('show');
						$timeout(function() {
							$scope.styleForm = rt.object;
						}, 0)
					} else {
						MESSAGE_DIALOG.error(rt.detailMsg);
					}
				})
			}
			// 取消
			$scope.cancelStyle = function() {
				$scope.styleForm = {};
				$("#styleOpPage").modal('hide');
			}
		} ]);