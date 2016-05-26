



/**
 * 导航控制器
 * 
 * @author lianchao
 */
//创建导航模块
var navApp = angular.module("navApp",["navServiceApp"]);

//创建导航控制器 
navApp.controller("navCtrl", [
		"$scope",
		"commonService",
		"navService",
		function($scope, commonService, loginService) {
			var defaultData = [ {
				text : 'Parent 1',
				nodes : [ {
					text : 'Child 1',
					nodes : [ {
						text : 'Grandchild 1',
						href : '#grandchild1'
					}, {
						text : 'Grandchild 2',
						href : '#grandchild2'
					} ]
				}, {
					text : 'Child 2',
					href : '#child2'
				} ]
			}, {
				text : 'Parent 2',
				href : '#parent2'
			}, {
				text : 'Parent 3',
				href : '#parent3'
			}, {
				text : 'Parent 4',
				href : '#parent4'
			}, {
				text : 'Parent 5',
				href : '#parent5'
			} ];
			
			$('#menuTree').treeview({
				color : "#428bca",
				showBorder : false,
				data : defaultData,
				onNodeSelected:function(event, node){
					if(node.href){
						alert(node.href);
					}
				}
			});
		
		} ]);
