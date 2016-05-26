/**
 * 下拉框组织树模块
 * @author caiwl
 */
(function(angular) {
	'use strict';

	function dropTreeCtrl($scope) {
		$scope.infoShow = true;
		$scope.infoMsg = "加载中....";
	}

	function toggleTreePanel(obj) {
		if ($(obj).parent().hasClass("open")) {
			$(obj).attr("aria-expanded", "false").parent().removeClass("open");
		} else {
			$(obj).attr("aria-expanded", "true").parent().addClass("open");
		}
	}

	function createHtml() {
		var _html = "<div class='dropdown'>" +
			"<div class='dropdown-toggle'>" +
			"<div class='input-group'>" +
			"<input readonly type='text' class='form-control' placeholder='请选择区域' />" +
			"<div class='input-group-addon' style='width:30px;cursor:pointer;border-left:none;'><span class='caret'></span></div>" +
			"</div></div>" +
			"<div class='dropdown-menu' style='min-width: 220px;' aria-labelledby='dLabel'>" +
			"<div ng-transclude class='panel-body' style='max-height:300px;overflow-y:auto; padding-top: 15px;padding-right:15px;'></div>" +
			"<p style='margin-left:25px;' class='drop-info text-info' ng-if='infoShow' ng-bind='infoMsg'></p>" +
			"</div></div>";
		return _html;
	}

	function showInfoMsg(elm, scope, isShow, info, msg) {
		var p = elm.find("p.drop-info");
		p.removeClass().addClass("drop-info").addClass("text-" + info);
		scope.infoShow = isShow;
		scope.infoMsg = msg;
	}

	function dropTreeDirective($log, commonService) {
		return {
			restrict: "A",
			scope: {
				dropConfig: "=ffcDropTree"
			},
			controller: "dropTreeCtrl",
			link: function(scope, elm, attrs, controller) {
				//初始化
				scope.infoShow = false;
				scope.infoMsg = "";
				// 加监听
				dropTreeListener(elm);
				scope.$watch("dropConfig.selectedData", function(n, o) {
					if (n !== o) {
						inputViewData(scope, elm);
					}
				}, true);
				scope.$watch("dropConfig.infoType", function(n, o) {
					if (n !== o) {
						var type = scope.$parent.dropConfig.infoType,
							msg = scope.$parent.dropConfig.infoMsg;
						if (type === "info") {
							showInfoMsg(elm, scope, false, "info", msg);
						} else {
							showInfoMsg(elm, scope, true, type, msg);
						}
					}
				}, true);
			},
			transclude: true,
			template: createHtml()
		};
	}

	// 下拉组织树的数据与展示
	function inputViewData(scope, elm) {
		//var instance = scope.tree.jstree(true);
		var instance = elm.find("[js-tree]").jstree(true);
		var checkedNs = instance.get_checked(true);
		//scope.selectedData = instance.get_selected();
		var dropTreeData = "";
		//具体取值
		$.each(checkedNs, function(i, n) {
			dropTreeData += n.id + ",";
		});
		//给下拉框树取值
		scope.dropConfig.dropData = dropTreeData;
		var _rtVal = "";
		var topNs = instance.get_top_selected(true);
		//显示效果
		$.each(topNs, function(i, n) {
			var _p = instance.get_node(n);
			var children = _p.children;
			if (children.length > 0) {
				if (n.parent === "#") {
					$.each(children, function(j, k) {
						k = instance.get_node(k);
						_rtVal += k.text + ",";
					});
				} else {
					if (children.length > 0) {
						_rtVal += n.text + "(";
						$.each(children, function(j, k) {
							k = instance.get_node(k);
							_rtVal += k.text + ",";
						});
						_rtVal = _rtVal.slice(0, -1);
						_rtVal += "),";
					} else {
						_rtVal += n.text + ",";
					}
				}
			} else {
				_rtVal += _p.text + ",";
			}
		});
		_rtVal = _rtVal.slice(0, -1);
		elm.find("input").val(_rtVal);
		elm.find("input").attr({
			"title": _rtVal
		});
	}

	function dropTreeListener(elm) {
		elm.find(".dropdown-toggle").on("click", function() {
			toggleTreePanel(this);
		});
	}


	////Angular Code
	////依赖： "ngJsTree"
	var app = angular.module("dropTreeApp", ["ngJsTree"]);
	app.controller("dropTreeCtrl", ["$scope", dropTreeCtrl]);
	app.directive("ffcDropTree", ["$log", "commonService", dropTreeDirective]);
})(angular);