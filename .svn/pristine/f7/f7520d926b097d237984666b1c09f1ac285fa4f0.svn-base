/**
 * 登录服务
 * 
 * @author lianchao
 */
// 创建登录模块
var loginServiceApp = angular.module("loginServiceApp", [ "commonApp" ]);

// 创建登录服务
loginServiceApp.service("loginService", [ "commonService", function(commonService) {

	// 页面登录
	this.login = function(params, sback, eback) {
		commonService.call("org/loginCtrl/login", params, sback, eback);
	}

} ]);