/**
 * 
 * 
 * @author LAIYONGMIN-PC
 */

var sysStyle = {};

if (!winStyle) {
	winStyle = {};
};

winStyle.treeData = [];

$(function() {
	// 初始化规格数据
	var setting = {
		// 异步请求
		async : {
			enable : true,
			autoParam : [ "styleId" ],
			url : ffc.context.contextPath + "/meta/dynamicPageCtrl/qryChildStylesById"
		},
		data : {
			key : {
				name : "styleName",
				id : "styleId"
			}
		},
		// 事件
		callback : {
			// 点击事件
			onClick : function(event, treeId, treeNode) {
				// 排除主题类的父节点
				querys = {
					styleId : treeNode.styleId,
					styleType : "table"
				}
				// 请求数据
				eh.data.callMethod("qryStylesById", querys, function(rt) {
					if (typeof (rt.object) === 'undefined') {
						$("#styleTable").bootstrapTable('removeAll');
					} else {
						$("#styleTable").bootstrapTable('load', rt.object);
					}
				});
			}
		}
	};

	// 初始化规格数据
	var winCheckSetting = {
		// 异步请求
		check : {
			enable : true,
			// 都不关联
			chkboxType : {
				"Y" : "",
				"N" : ""
			},
			chkStyle : "checkbox"
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onCheck : winStyle.onCheck
		}
	};

	// 初始请求数据
	eh.data.callMethod("qryStylesById", {
		styleType : 'theme'
	}, function(rt) {
		// 样式树初始化
		$.fn.zTree.init($("#styleTree"), setting, rt.object);
	});

	// 一次加载所有配置节点
	eh.data.callMethod("qryAllStyleTreeData", {

	}, function(rt) {
		// 样式树初始化
		$.fn.zTree.init($("#winStyle"), winCheckSetting, rt.object);
	});

});

winStyle.getWinStyle = function() {
	return $.fn.zTree.getZTreeObj("winStyle");
}

// 选中
winStyle.checkStyle = function(data) {
	// 获取样式树
	var tree = winStyle.getWinStyle();
	if (tree) {
		// 清空
		winStyle.treeData = [];
		// 取消选中
		tree.checkAllNodes(false);
		// 获取存在的样式
		if (data != null && data.length > 0) {
			for (t in data) {
				// 查询勾选节点
				var node = tree.getNodeByParam("id", parseInt(data[t].relaStyleId));
				if (node) {
					tree.checkNode(node, true, false);
					winStyle.treeData[data[t].componentId + "-" + node.id] = node.id;
				}
			}
		}
	}
}
// 勾选事件
winStyle.onCheck = function(e, treeId, treeNode) {
	// 获取样式树
	var pageTree = $.fn.zTree.getZTreeObj("pageTree");
	if (pageTree) {
		var nodes = pageTree.getSelectedNodes();
		if (nodes && nodes.length > 0) {
			var node = nodes[0];
			var styles = typeof (node.dynamicStyleDtos) === "undefined" ? node.dynamicStyleDtos = [] : node.dynamicStyleDtos;
			var checkedOld = winStyle.checkedOld(winStyle.treeData, treeNode, node);
			if (node && checkedOld === false && treeNode.checked === true) {
				// 新增样式
				var styles = (styles && styles.length > 0) ? styles : [];
				var addStyle = {
					componentId : node.componentId,// 组件
					relaStyleId : treeNode.styleId,
					styleAttrValue : treeNode.styleAttrValue,
					styleType : treeNode.styleType,
					opType : 'add'
				}
				node.dynamicStyleDtos.push(addStyle);
				pageTree.updateNode(node, false);
			} else if (node && checkedOld === false && treeNode.checked === false) {
				// 直接清除json
				if (styles && styles.length > 0) {
					for (t in styles) {
						if (styles[t].relaStyleId === treeNode.styleId) {
							node.dynamicStyleDtos.splice(t, 1);
							pageTree.updateNode(node, false);
							break;// 退出循环
						}
					}
				}
			} else if (node && checkedOld === true && treeNode.checked === false) {
				// 删除样式
				var styles = node.dynamicStyleDtos;
				if (styles && styles.length > 0) {
					for (t in styles) {
						if (styles[t].relaStyleId === treeNode.styleId) {
							node.dynamicStyleDtos[t].opType = 'del'
							pageTree.updateNode(node, false);
							break;// 退出循环
						}
					}
				}
			} else if (node && checkedOld === true && treeNode.checked === true) {
				// 恢复原状，删除状态
				if (styles && styles.length > 0) {
					for (t in styles) {
						if (styles[t].relaStyleId === treeNode.styleId) {
							delete node.dynamicStyleDtos[t].opType;
							pageTree.updateNode(node, false);
							break;// 退出循环
						}
					}
				}
			}

		}
		var roots = pageTree.getNodes();
		if (roots && roots.length > 0) {
			var root = roots[0];
			var childs = root.children;
			// 设置HTML
			$("#pageHtml").html(eh.parse.createHtml({
				object : {
					componentDto : childs[0]
				}
			}));
			// 初始化脚本
			eh.script.jsBatchActuator(eh.script.getDataCache(""));
		}
	}
}

// 原来是否是选中
winStyle.checkedOld = function(source, treeNode, node) {
	if (source) {
		if (source[node.id + "-" + treeNode.styleId] === treeNode.styleId) {
			return true;
		}
	}
	return false;
}
