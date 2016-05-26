/**
 * 
 * 对象规格组件
 * 
 * 格式： {id : 102, pId : 11, componentId:-1, componentType:1,
 * componentName:"文本输入框", componentCode:'', componentTip:'请输入', name : "文本输入框",
 * busAttrId:2, busAttrType:0, busAttrCode:'44', busAttrName:''}
 * ZTREE,支持多种数据格式加载；
 * 
 * @author LAIYONGMIN-PC
 */

if (!bo) {
	var bo = {};
}

$(function() {
	var boSetting = {};
	// 区分类型
	var type = eh.util.getUrlParam("type");
	if (type === "default") {
		boSetting = {
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
		}
	} else if (type === "") {
		boSetting = {

		}
	}
	$.fn.zTree.init($("#boTree"), boSetting);

});
