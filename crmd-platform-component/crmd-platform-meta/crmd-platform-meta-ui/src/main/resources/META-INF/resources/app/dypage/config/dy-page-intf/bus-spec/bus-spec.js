/**
 * 
 * 事件配置（规格、等）
 * 
 * 请定义type='';自行扩展
 * 
 * {id : 11, pId : 1, name : "实物规格"},根据实际情况修改格式 ；ZTREE,支持多种数据格式加载；
 * 
 * @author LAIYONGMIN-PC
 * 
 */

$(function() {
	// 初始化树参数
	var setting = null;
	// 区分类型
	var type = eh.util.getUrlParam("type");
	// 根据集体需求修改树加载情况
	if (type) {
		if (type === "default") {
			$("#divTitle").html("规格");
			// 初始化规格数据
			setting = {
				// 数据格式
				data : {
					simpleData : {
						enable : true
					}
				},
				// 异步请求
				async : {
					enable : true,
					url : "./data/ggtree.json"// 数据请求地址
				},
				callback : {
					onClick : dypageEvent.onSelectSpecNode
				// 这个接口不需要改
				}
			};
			// 实物业务对象
		} else if (type === "mktObj") {
			$("#divTitle").html("业务对象");
		}
	}
	// 规格树初始化
	$.fn.zTree.init($("#specTree"), setting);

});