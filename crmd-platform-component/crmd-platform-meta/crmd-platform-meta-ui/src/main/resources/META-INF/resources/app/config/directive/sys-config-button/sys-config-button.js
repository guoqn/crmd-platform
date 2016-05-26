/**
 * 选择上级的控件 使用此控件需要 在一级界面导入此文件“<jsp:include
 * page="/app/pulbic/directive/sys-config-button/sys-config-query-tmpl.jsp"></jsp:include>”
 * 需要定义sysConfigList，用于保存选择的仓库,设置一个默认值如下： $scope.sysConfigList = [ {name : "请选择...", id : 0 } ];
 * 
 * 示例：
 * <sys-config-button store-data-bind="sysConfigList" checkbox = "false" readonly="true"> </sys-config-button>
 * 
 * add by linyzh
 */
var sysConfigButtonApp = angular.module("sysConfigButtonApp", ["commonApp","sysConfigButtonServiceApp" ]);

// 将模板放到缓存中
sysConfigButtonApp
		.run(function($templateCache) {
			$templateCache
					.put(
							"sysConfigButton.html",
							'<div >'
									+ '<div data-toggle="popover" data-placement="bottom" data-content="该组件不可用！">'
									+ '<div class="input-group">'
									+ '<input id = "sysConfigInput" class="form-control" ng-model="sysConfigName" />'
									+ '<span class="input-group-btn">'
									+ '<button id="sysConfigButtonId" class="btn btn-default" type="button" >选择</button>'
									+ '</span>' + '</div>' + '</div>'
									+ '</div>')

		});

sysConfigButtonApp.directive("sysConfigButton", function() {
	return {
		scope : {
			sysConfigName : '=', // 用于界面输入框的展示
			sysConfigList : '=sysConfigDataBind' // 保存仓库的数据
		},
		restrict : "E",
		templateUrl : "sysConfigButton.html",
		replace : true,
		transclude : true,
		link : function(scope, element, attrs) {
			if (attrs.sysConfigDataBind == undefined) {
				// 将按钮置灰,展示提示信息
				$('#sysConfigButtonId').attr("disabled", "true");
				$("[data-toggle='popover']").bind('mouseover', function() {
					$(this).popover("show");
					$(this).on("mouseleave", function() {
						$(this).popover('hide');
					});
				});
				$("[data-toggle='popover']").bind('mouseleave', function() {
					setTimeout(function() {
						if (!$(".popover:hover").length) {
							$(this).popover("hide")
						}
					}, 50);
				});
			}
			//表格是否可以复选
			if (attrs.checkbox != undefined && attrs.checkbox == "false") {
				var table = $('#parentSysConfigTable');
				if(table!=undefined){
					$('#parentSysConfigTable').bootstrapTable('hideColumn', 'check');
				}
			}
			
			$('#sysConfigButtonId').on("click", function() {
				$('#sys-config-query').modal();
			});
			// 根据属性设置输入框的readonly属性
			if (attrs.readonly == "true") {
				$('#sysConfigInput').attr("readonly", "readonly");
			} else {
				$('#sysConfigInput').removeAttr("readonly");
			}
			// 监听选择仓库的变化,并将值赋给scope.sysConfigName，展示在界面上
			scope.$watch("sysConfigList", function(newValue, oldValue) {
				var temp = "";
				if (newValue != undefined) {
					for (var i = 0; i < newValue.length; i++) {
						if (i == newValue.length - 1) {
							temp = temp + newValue[i].sysConfigName;
						} else {
							temp = temp + newValue[i].sysConfigName + ",";
						}
					}
				}
				scope.sysConfigName = temp;
			});
			
			$('#parentSysConfigTable tbody').delegate('tr', 'click', function () {
		        $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
		    });
		},
		controller : "sysConfigBtnCtrl"
	}
});

sysConfigButtonApp.controller('sysConfigBtnCtrl', ['$scope','commonService','sysConfigButtonService','$compile',
		function($scope,commonService, sysConfigButtonService, $compile) {
			$scope.qryName = "";
			// 下拉框 参数
			$scope.queryParams = {
				paramType : ""
			};
			$scope.selectConfig = {
				minimumResultsForSearch : -1,
				data : [],
				placeholder : '请选择 状态'
			};

			$scope.selectedRow = "";//选中行的数据
			// 初始化表格
			$("#parentSysConfigTable").bootstrapTable(
					{
						// 加载成功后重新编译，试点formatter后的dom元素支持angularjs
						onResetView : function() {
							$compile($('#parentSysConfigTable'))($scope);
						},
						onLoadError : function() {
						},
						onClickRow : function(row, $element) {
							$scope.selectedRow = row;
						},
						// 条件
						queryParams : function(params) {
							// 查询条件
							var selfParams = {
								//areas : $scope.dropConfig.selectedData,
								name : $scope.qryName
							}
							return $.extend({}, params, selfParams);
						},
						ajax : function(render) {
							if (render.data) {
								$('#parentSysConfigTable').bootstrapTable('removeAll');
								sysConfigButtonService.qrySysConfigButton(
										render.data, function(result) {
											ffc.util.setPageResult($scope,
													'sysConfigQueryErrorAlert',
													render, result);
										}, function() {
											// ffc.util.setPageResult($scope,
											// 'orderQueryErrorAlert');
										});
							}
						}
					});

			// 调用服务查询可用仓库
			$scope.querySysConfig = function() {
				$('#parentSysConfigTable').bootstrapTable("selectPage", 1);
			};
			// 确认
			$scope.confirmSysConfig = function() {
				// 收集表格中选中的数据，放到$scope.sysConfigList中
				var allSelectStore = $('#parentSysConfigTable').bootstrapTable(
						'getAllSelections');
				var dataList = [];//返回的数据
				if(allSelectStore == undefined || allSelectStore.length == 0){
					allSelectStore[0] = $scope.selectedRow;
				}
				for (var i = 0; i < allSelectStore.length; i++) {
					var store = {};
					store['confId'] = allSelectStore[i].confId;
					store['sysConfigName'] = allSelectStore[i].name;
					dataList.push(store);
				}
				$scope.$parent.sysConfigList = dataList;
				$('#sys-config-query').modal('hide');
			};

			// 模态框全部展示之后处理
			$('#sys-config-query').on('shown.bs.modal', function() {
				//$scope.querysysConfig();
			});

		} ]);
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
