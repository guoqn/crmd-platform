/**
 * 
 * 通用JS模块
 * 
 * 描述:
 * </p>
 * 1:ffc.context 上下文变量;
 * </p>
 * 2:ffc.util 全局工具类;
 * </p>
 * 3:ffc.comp;
 * </p>
 * 4:angularJS 封装工具类;
 * </p>
 * 
 */

registNS = function(fullNS, isIgnorSelf) {
	// 命名空间合法性校验依据
	var reg = /^[_$a-z]+[_$a-z0-9]*/i;

	// 将命名空间切成N部分, 比如ffc.util等
	var nsArray = fullNS.split('.');
	var sEval = "";
	var sNS = "";
	var n = isIgnorSelf ? nsArray.length - 1 : nsArray.length;
	for (var i = 0; i < n; i++) {
		// 命名空间合法性校验
		if (!reg.test(nsArray[i])) {
			throw new Error("Invalid namespace:" + nsArray[i] + "");
			return;
		}
		if (i != 0)
			sNS += ".";
		sNS += nsArray[i];
		// 依次创建构造命名空间对象（假如不存在的话）的语句
		sEval += "if(typeof(" + sNS + ")=='undefined') " + sNS
				+ "=new Object();else " + sNS + ";";
	}
	// 生成命名空间
	if (sEval != "") {
		return eval(sEval);
	}
	return {};
}

// 注册命名空间

registNS("ffc.context");
registNS("ffc.util");
registNS("ffc.comp");
registNS("ffc.arrayUtil");

// 全局变量
ffc.context.path = path;
ffc.context.contextPath = contextPath;
ffc.context.reqMetaUrl = "/metadata";
ffc.context.reqSugUrl = "/suggestion";
ffc.context.errorTip = "不存在的返回结果！";
ffc.context.timeoutTip = "网络连接已断开！";
//// 获取配置调用目标CRM2域
//$.ajax({
//	url : contextPath + "/pub/getAppConfDefValue?confCd=crm2_url",
//	async : false,
//	success : function(data) {
//		ffc.context.crm2 = data;
//	}
//});// 域
ffc.context.crm2URL = ffc.context.crm2 + "/mod_ds/ds_invoke_index.zul";// 具体访问地址
// antularJS封装
var commonApp = angular.module("commonApp", []);

commonApp.service("commonService", function($http) {
	var _this = this;
	/**
	 * 统一HTTP参数
	 */

	var http = function(method, url, param) {
		if (method == 'POST') {
			return $http({
				method : method,
				url : ffc.context.contextPath + "/" + url,
				data : param
			// ,
			// headers : {
			// 'Content-Type' : 'application/x-www-form-urlencoded'
			// }
			})
		} else {
			return $http({
				method : method,
				url : ffc.context.contextPath + "/" + url,
				params : param
			})
		}
	}
	/**
	 * 统一同步的syncHttp参数
	 */
	var syncHttp = function(method, url, param) {
		return $.ajax({
			method : method,
			async : false,
			url : ffc.context.contextPath + "/" + url,
			data : param
		});
	}

	/**
	 * 获取绝对路径
	 */
	this.getContextPath = function() {
		return contextPath;
	}
	/**
	 * 获取项目名称
	 */
	this.getPath = function() {
		/*
		 * path = path + ""; if (path) { if (path.indexOf("/") >= 0) { return
		 * path.substring(path.indexOf("/")+1); } }
		 */
		return path;
	}

	/**
	 * 通用angularJS HTTP请求
	 * 
	 * @param url
	 * @param method
	 * @param param
	 * @param sucCallback
	 * @param errCallBack
	 */
	this.call = function(url, param, sucCallback, errCallBack) {
		return http("POST", url, param).success(
				function(data, status, headers, config) {
					if (angular.isFunction(sucCallback)) {
						if (data.result == false
								&& undefined != data.exceptions
								&& data.exceptions.length > 0) {
							MESSAGE_DIALOG.warning("【" + data.retCode + "】 "
									+ "业务异常：" + data.msgTitle);
						} else {
							sucCallback(data);
						}

					}
				}).error(function(data, status, headers, config) {
			// 失败处理
			if (angular.isFunction(errCallBack)) {
				errCallBack(data);
			}
		});
	};

	/**
	 * by get 请求
	 * 
	 * @param url
	 * @param param
	 * @param sucCallback
	 * @param errCallBack
	 */
	this.callByGet = function(url, param, sucCallback, errCallBack) {
		return http("GET", url, param).success(
				function(data, status, headers, config) {
					if (angular.isFunction(sucCallback)) {
						sucCallback(data);
					}
				}).error(function(data, status, headers, config) {
			// 失败处理
			if (angular.isFunction(errCallBack)) {
				errCallBack(data);
			}
		});
	};

	/**
	 * 同步的 HTTP请求
	 * 
	 * @param url
	 * @param param
	 */
	this.syncCall = function(url, param) {
		var result = {
			data : "error"
		}
		syncHttp("POST", url, param).success(function(data, textStatus, jqXHR) {
			result.data = data;
		}).fail(function(XMLHttpRequest, textStatus, errorThrown) {

		});
		return result.data;
	};

	/**
	 * by get 同步请求
	 * 
	 * @param url
	 * @param param
	 */
	this.syncCallByGet = function(url, param) {
		var result = {
			data : "error"
		}
		syncHttp("GET", url, param).success(function(data, textStatus, jqXHR) {
			result.data = data;
		}).fail(function(XMLHttpRequest, textStatus, errorThrown) {

		});
		return result.data;
	};

	/**
	 * data To Table Rows 格式转换
	 * 
	 * @param data
	 */
	this.cov2TableRows = function(data) {
		var covData = {
			rows : data.list,
			total : data.total
		}
		return covData;
	};

	// form初始化
	this.initFrom = function($scopmeta, backfun) {
		var urlParam = "";
		$("[data-metadata]").each(
				function(i, d) {
					if (i == 0) {
						urlParam = urlParam + "?metadatas="
								+ ($(this).data("metadata"));
					} else {
						urlParam = urlParam + "," + ($(this).data("metadata"));
					}
				});
		// 存在下拉情况
		if (urlParam != "") {
			_this.call(ffc.context.reqMetaUrl + urlParam, {}, function(data) {
				// 请求成功
				// 初始数据绑定
				$scopmeta.metadatas = data;
				// 回调函数
				if (angular.isFunction(backfun)) {
					backfun();
				}
			}, function(data) {
				// 失败处理
			});
		} else if (angular.isFunction(backfun)) {
			// 没有下拉组件回调
			backfun();
		}
	};
	// 跨域系统调用函数
	// URL目标域系统访问地址
	// PARAMS,解析地址
	// 方案描述：创建相同域的IFRAME,通过加装页面进而执行脚本
	this.invoke = function(url, params) {
		if (ffc.util.isAvailable(url)) {
			if (!ffc.util.isEmpty(url) && ffc.util.isCrm2()) {
				if (typeof (exec_obj) === 'undefined') {
					exec_obj = document.createElement('iframe');
					exec_obj.name = 'exe_frame';
					exec_obj.src = url + '#' + params;
					exec_obj.style.display = 'none';
					document.body.appendChild(exec_obj);
				} else {
					exec_obj.src = url + '?' + Math.random() + "#" + params;
				}
			}
		} else {
			MESSAGE_DIALOG.warning("请求访问服务器失败!(地址:" + ffc.context.crm2
					+ "，请检查)");
		}
	};
})

// 全局工具

/**
 * 日期格式化
 * 
 * @param date
 * @param fmt
 */
ffc.util.formatter = function(date, fmt) {
	// 日期格式化
	var o = {
		"M+" : date.getMonth() + 1, // month
		"d+" : date.getDate(), // day
		"h+" : date.getHours(), // hour
		"m+" : date.getMinutes(), // minute
		"s+" : date.getSeconds(), // second
		"q+" : Math.floor((date.getMonth() + 3) / 3), // quarter
		"S" : date.getMilliseconds()
	// millisecond
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
/**
 * bootstrap table formatter 格式化
 * 
 * @param value
 *            new Date()对象;
 * @param row
 * @param index
 */
ffc.util.tableDateFormatter = function(value, row, index) {
	if (value) {
		return ffc.util.formatter(new Date(value), "yyyy-MM-dd hh:mm:ss");
	}
	return "";
}
// 获取table pageSize
ffc.util.getTablePageSize = function($jq) {
	return $jq.bootstrapTable('getOptions').pageSize;
}
// 获取table pageNumber
ffc.util.getTablePageNumber = function($jq) {
	return $jq.bootstrapTable('getOptions').pageNumber;
}

/**
 * 获取Page MATADATAS 绑定
 * 
 * @param $scope
 * 
 */
ffc.util.getPageMetas = function($scope) {
	return $scope.initData = {
		metadatas : {}
	}
}
// bootstrap-table bind reqUrl data2
ffc.util.loadTableData = function(render, result) {
	if (result && result.result && undefined != result.pageInfo
			&& undefined != result.pageInfo.list) {
		render.success({
			total : result.pageInfo.total + "",
			rows : result.pageInfo.list
		});
	} else {
		render.success({
			total : "0",
			rows : []
		});
	}
	render.complete();
}
// bootstrap-table bind pageEvent
ffc.util.bindTablePageEvent = function($jq, param, fun) {
	if ($jq) {
		// 释放监听table分页点击事件
		$jq.unbind("page-change.bs.table");
		// 监听table分页点击事件
		$jq.on('page-change.bs.table', function(e, size, number) {
			// 分页信息
			param.pageNumber = number;
			param.pageSize = size;
			fun(param)
		});
	}
}
// bootstrap-table bind sortEvent
ffc.util.bindTableSortEvent = function($jq, param, fun) {
	if ($jq) {
		// 释放监听table分页点击事件
		$jq.unbind("sort.bs.table");
		// 监听table分页点击事件
		$jq.on('sort.bs.table', function(e, name, order) {
			// 刷新到第一页
			$jq.bootstrapTable('refreshOptions', {
				pageNumber : 1
			});
			// 排序信息
			param.pageNumber = ffc.util.getTablePageNumber($jq);
			param.pageSize = ffc.util.getTablePageSize($jq);
			param.sortName = name;
			param.sortOrder = order;
			fun(param);
		});
	}
}
// 判断空
ffc.util.isEmpty = function(val) {
	if ((val == null || typeof (val) == "undefined")
			|| (typeof (val) == "string" && val == "" && val != "undefined")) {
		return true;
	} else {
		return false;
	}
}
// 超过长度，截取并填充...
ffc.util.interceptString = function(val, len) {
	if (val.length > len) {
		return val.substring(0, len) + "...";
	} else {
		return val;
	}
}
// tab切换触发angular事件
ffc.util.tabsShownTriggerNg = function(suf) {
	var suf_ = "_ngtabclick";
	if (!ffc.util.isEmpty(suf)) {
		suf_ = suf;
	}
	$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
		// 获取已激活的标签页的名称
		var activeTab = $(e.target).attr("href");
		$(activeTab + suf_).click();
	});
}
// 触发激活状态tab页的angular事件
ffc.util.tabsActiveTriggerNg = function(tabsHref, suf) {
	var suf_ = "_ngtabclick";
	if (!ffc.util.isEmpty(suf)) {
		suf_ = suf;
	}
	$.each(tabsHref, function(i, d) {
		if ($("a[href='" + d + "']").parent().hasClass("active")) {
			// console.info(d + suf_);
			$(d + suf_).click();
			return false;
		}
	});
}
/**
 * 获取Page MATADATAS 绑定
 * 
 * @param $scope
 * 
 */
ffc.util.setPageResult = function($scope, errorValue, render, result) {
	if (!$scope.errorTips) {
		$scope.errorTips = {};
	}
	if (render) {
		if (result.result) {
			$scope.errorTips[errorValue] = null;
			ffc.util.loadTableData(render, result);
		} else {
			$scope.errorTips[errorValue] = ffc.util.isEmpty(result.msgTitle[0]) ? ffc.context.errorTip
					: result.msgTitle[0];
		}
	} else {
		$scope.errorTips[errorValue] = ffc.context.timeoutTip;
	}
}
// 获取url参数
ffc.util.getQueryString = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

// 字符串替换
ffc.util.sprintf = function(str) {
	var args = arguments, flag = true, i = 1;

	str = str.replace(/%s/g, function() {
		var arg = args[i++];

		if (typeof arg === 'undefined') {
			flag = false;
			return '';
		}
		return arg;
	});
	return flag ? str : '';
};

// 数组元素位置调换
ffc.arrayUtil.swapItems = function(arr, index1, index2) {
	arr[index1] = arr.splice(index2, 1, arr[index1])[0];
	return arr;
};

// 数组元素上移
ffc.arrayUtil.upRecord = function(arr, index) {
	if (index == 0) {
		return;
	}
	ffc.arrayUtil.swapItems(arr, index, index - 1);
};

// 数组元素下移
ffc.arrayUtil.downRecord = function(arr, index) {
	if (index >= arr.length - 1) {
		return;
	}
	ffc.arrayUtil.swapItems(arr, index, index + 1);
};
// 数组元素删除
ffc.arrayUtil.removeRecord = function(arr, index) {
	if (index > arr.length - 1) {
		return;
	}
	arr.splice(index, 1);
};
// prefix,以什么开始
ffc.util.startsWith = function(s, prefix) {
	if (!ffc.util.isEmpty(prefix)) {
		var preLength = prefix.length;
		if (preLength > 0) {
			var sStarts = s.substr(0, preLength);
			if (prefix === sStarts) {
				return true;
			}
		}
	}
	return false;
};

// 身份证校验
ffc.util.identityCodeValid = function(code) {
	var city = {
		11 : "北京",
		12 : "天津",
		13 : "河北",
		14 : "山西",
		15 : "内蒙古",
		21 : "辽宁",
		22 : "吉林",
		23 : "黑龙江 ",
		31 : "上海",
		32 : "江苏",
		33 : "浙江",
		34 : "安徽",
		35 : "福建",
		36 : "江西",
		37 : "山东",
		41 : "河南",
		42 : "湖北 ",
		43 : "湖南",
		44 : "广东",
		45 : "广西",
		46 : "海南",
		50 : "重庆",
		51 : "四川",
		52 : "贵州",
		53 : "云南",
		54 : "西藏 ",
		61 : "陕西",
		62 : "甘肃",
		63 : "青海",
		64 : "宁夏",
		65 : "新疆",
		71 : "台湾",
		81 : "香港",
		82 : "澳门",
		91 : "国外 "
	};
	var tip = "";
	var pass = true;

	if (!code || !/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(code)) {
		tip = "身份证号格式错误";
		pass = false;
	}

	else if (!city[code.substr(0, 2)]) {
		tip = "地址编码错误";
		pass = false;
	} else {
		// 18位身份证需要验证最后一位校验位
		if (code.length == 18) {
			code = code.split('');
			// ∑(ai×Wi)(mod 11)
			// 加权因子
			var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
			// 校验位
			var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
			var sum = 0;
			var ai = 0;
			var wi = 0;
			for (var i = 0; i < 17; i++) {
				ai = code[i];
				wi = factor[i];
				sum += ai * wi;
			}
			var last = parity[sum % 11];
			if (parity[sum % 11] != code[17]) {
				tip = "校验位错误";
				pass = false;
			}
		}
	}
	return pass;
}
// http://localhost:8080/web/index.jsp?param1=1&param2=2;
// 获取?或者{index}后面的参数串
ffc.util.getHrefParam = function(href, index) {
	if (!ffc.util.isEmpty(href)) {
		if (href.indexOf(index) > 0) {
			return href.split(index).length > 0 ? href.split(index)[1] : "";
		}
	}
}
// 获取 param1=1&param2=2格式值
ffc.util.getHrefValue = function(param, index) {
	if (!ffc.util.isEmpty(param)) {
		var params = param.split("&");
		for (var i = 0; i < params.length; i++) {
			var t = params[i].split("=");
			if (index == t[0] && t.length > 1) {
				return t[1];
			}
		}
	}
	return "";
}
// 去除左右空格
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

// 校验 href 是否有效
ffc.util.isAvailable = function(href) {
	var bool = false;
	if (!ffc.util.isEmpty(href)) {
		$.ajax({
			url : "",
			type : 'jsonp',// 解决跨域,采用此类类型
			async : false,
			complete : function(response) {
				if (response.status == 200) {
					bool = true;
				}
			}
		});
	}
	return bool;
}
// 是否crm2中加载
ffc.util.isCrm2 = function() {
	var bool = false;
	// 检测界面是否提供参数，获取crm2登录信息
	var localUrl = window.location.href;
	if (!ffc.util.isEmpty(localUrl)) {
		var params = ffc.util.getHrefParam(localUrl, "?");
		// 自主加载数据
		if ("1" === ffc.util.getHrefValue(params, "auto")) {
			// crm2 中加载
			bool = true;
		}
		return bool;
	}
}