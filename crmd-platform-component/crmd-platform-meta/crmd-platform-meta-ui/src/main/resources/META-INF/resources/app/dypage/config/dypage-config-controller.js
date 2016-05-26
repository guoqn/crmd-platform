/**
 * 
 * @author LAIYONGMIN-PC
 */

$(function() {
	// 默认全部隐藏-默认事件配置显示
	$("#main > * ").hide().siblings("#main-event").show();
	// 菜单选中事件
	$("#navmenu li").click(function() {
		// 菜单却换样式
		$(this).addClass("active").siblings().removeClass('active');
		// 选中的显示，其他兄弟集隐藏
		$("#main > * ").hide().siblings("#main-" + $(this).attr("id")).show();
		// $("#main-" + $(this).attr("id")).show().siblings().hide();
	})
});

var dypageApp = angular.module("dypageApp", [ "commonApp", "dypageServiceApp", "ehDataServiceApp" ]);

var dypageCtrl = dypageApp.controller("dypageCtrl", [ "commonService", function(commonService) {

} ]);