/**
 * 登录控制器
 * 
 * @author lianchao
 */
// 获取登录模块
var loginApp = angular.module("loginApp", [ "loginServiceApp" ]);

// 创建登录控制器
loginApp.controller("loginCtrl", [
		"$scope",
		"commonService",
		"loginService",
		function($scope, commonService, loginService) {
			$scope.userName = "张三";
			$scope.userPassword = "123456";
			$scope.isRememberMe = false;
			$scope.login = function() {
				alert($scope.userName + "," + $scope.userPassword + ","
						+ $scope.isRememberMe);
			}
		} ]);