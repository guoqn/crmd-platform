/**
 * 脚本统一执行
 * 
 * @author LAIYONGMIN-PC
 */
// 脚本统一执行
if (!eh) {
	var eh = {};
}
if (!eh.script) {
	eh.script = {};
}
// JS 缓存
var dataCache = {};

eh.script.getDataCache = function(key) {
	if (key in dataCache) {
		return dataCache[key]
	} else {
		return dataCache;
	}
}
// 设置JS缓存
eh.script.setDataCache = function(key, value) {
	dataCache[key] = value;
}
// 清理JS缓存
eh.script.removeDataCache = function(key) {
	if (key in dataCache) {
		delete dataCache[key]
	}
}
// 脚本执行器，无返回值
eh.script.jsActuator = function(js) {
	if (js) {
		try {
			// 函数
			if ($.isFunction(js)) {
				js();
			} else {
				// 脚本字符串
				eval(js + "");
			}
		} catch (e) {
			// console.log(e);
		}
	}
}
// 清理缓存
eh.script.clearDataCache = function() {
	dataCache = {};
}
// 批量执行，无返回值
eh.script.jsBatchActuator = function(data) {
	if (data) {
		// 循环执行
		for ( var d in data) {
			eh.script.jsActuator(data[d]);
		}
	}
}
