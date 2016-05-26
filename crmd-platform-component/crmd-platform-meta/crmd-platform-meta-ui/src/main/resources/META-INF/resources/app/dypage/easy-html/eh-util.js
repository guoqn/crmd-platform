/**
 * 工具
 *
 * @author LAIYONGMIN-PC
 */

if (!eh) {
    var eh = {};
}
if (!eh.util) {
    eh.util = {}
}

/**
 * eg: eh.util.getDate("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * eh.util.getDate("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * eh.util.getDate"yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * eh.util.getDate("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * eh.util.getDate("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 * eh.util.getDate("yyyy-MM-dd") ==> 2016-02-24 eh.util.getDate("yyyy-MM-dd
 * HH:mm:ss") ==> 2016-02-24 14:36:08
 */

eh.util.getDate = function (fmt) {
    var date = new Date();
    var o = {
        "M+": date.getMonth() + 1, // 月份
        "d+": date.getDate(), // 日
        "h+": date.getHours() % 12 == 0 ? 12 : date.getHours() % 12, // 小时
        "H+": date.getHours(), // 小时
        "m+": date.getMinutes(), // 分
        "s+": date.getSeconds(), // 秒
        "q+": Math.floor((date.getMonth() + 3) / 3), // 季度
        "S": date.getMilliseconds()
        // 毫秒
    };
    var week = {
        "0": "/u65e5",
        "1": "/u4e00",
        "2": "/u4e8c",
        "3": "/u4e09",
        "4": "/u56db",
        "5": "/u4e94",
        "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[date.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}
eh.util.number = "";
// 数字校验
eh.util.isNumber = function (c, reg) {
    if (c && reg) {
        var t = new RegExp(reg);
        if (!t.test($(c).val())) {
            $(c).val(0);
        }
    } else {
        var reg = new RegExp("^[0-9]*$");
        if (!reg.test($(c).val())) {
            $(c).val(0);
        }
    }
}
// 获取url 参数
eh.util.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}

//获取设计界面设计树对象
eh.util.getDesignPageTree = function () {
    return $.fn.zTree.getZTreeObj("designPage");
}
//获取设计界面的样式树对象
eh.util.getDesignStyleTree = function () {
    return $.fn.zTree.getZTreeObj("designStyle");
}
//获取angular $scope
eh.util.getAngular$scope = function (id) {
    return angular.element('#' + id).scope();
}
//作用域判定
eh.util.angular$apply = function ($scope) {
    if ($scope) {
        $scope.$apply();
    }
}
//对象数
eh.util.getObjTree = function () {
    return $.fn.zTree.getZTreeObj("objComp");
}