/**
 * 
 * 基本组件
 * 
 * @author LAIYONGMIN-PC
 */

if (!base) {
	var base = {};
}

$(function() {
	// 初始化基本组件
	var setting = {
		// 数据格式
		data : {
			simpleData : {
				enable : true
			}
		},
		// 异步请求
		async : {
			enable : true,
			url : "./data/base.json"
		},
		edit : {
			enable : true,
			showRemoveBtn : false,
			showRenameBtn : false,
			// 拖拽做复制操作
			drag : {
				isCopy : true,
				isMove : false,
			}
		},
		callback : {
			beforeDrag : base.beforeDrag,
			beforeDrop : base.beforeDrop,
			// 结束拖拽
			onDrop : base.targetNodeEvent
		}
	};
	// 规格树初始化
	$.fn.zTree.init($("#baseTree"), setting);
});

base.beforeDrag = function(treeId, treeNodes) {
	for (var i = 0, l = treeNodes.length; i < l; i++) {
		if (treeNodes[i].drag === false) {
			return false;
		}
	}
	return true;
}

base.beforeDrop = function(treeId, treeNodes, targetNode, moveType) {
	return targetNode ? targetNode.drop !== false : true;
}

// 移动结束
base.targetNodeEvent = function(event, treeId, treeNodes, targetNode, moveType) {
	if (targetNode) {
		var treeObj = $.fn.zTree.getZTreeObj("" + treeId);
		// 设置HTML
		$("#pageHtml").html(eh.parse.createHtml({
			object : {
				componentDto : treeObj != null ? treeObj.getNodeByParam("id", 1, null).children[0] : targetNode
			}
		}));
		// 初始化脚本
		eh.script.jsBatchActuator(eh.script.getDataCache(""));
		// 关联视图
		var $scope = angular.element('#dypage-win').scope();// jquery+angular实现
		// 默认从主数据获取页面信息---原则
		var mnode = treeNodes[0];// 移动节点集合
		if (mnode) {
			// 组件类型
			if (mnode.busAttrType) {
				$scope.compForm.componentType = parseInt(mnode.busAttrType);
			} else {
				$scope.compForm.componentType = parseInt(mnode.componentType);
			}
			// 编码
			if (mnode.busAttrCode) {
				$scope.compForm.componentCode = mnode.busAttrCode;
			} else {
				$scope.compForm.componentCode = mnode.componentCode;
			}
			// 组件名称
			if (mnode.busAttrName) {
				$scope.compForm.componentName = mnode.busAttrName;
			} else {
				$scope.compForm.componentName = mnode.componentName;
			}
			$scope.$apply();// 绑定到视图
		}
	}
}