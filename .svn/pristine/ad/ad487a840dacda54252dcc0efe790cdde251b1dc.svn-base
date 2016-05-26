/**
 * 
 */

if (!part) {
	var part = {};
}

$(function() {
	// 初始化基本组件
	var setting = {
		// 数据格式
		data : {
			key : {
				name : "componentName",
				id : "componentId"
			}
		},
		// 异步请求
		async : {
			enable : true,
			url : ffc.context.contextPath + "/meta/dynamicPageCtrl/qryParts"
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
		/*
		 * beforeDrag : base.beforeDrag, beforeDrop : base.beforeDrop, // 结束拖拽
		 * onDrop : base.targetNodeEvent
		 */
		}
	};
	// 规格树初始化
	$.fn.zTree.init($("#partTree"), setting);
});