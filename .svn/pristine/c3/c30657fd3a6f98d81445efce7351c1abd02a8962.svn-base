var sysConfigButtonServiceApp = angular.module("sysConfigButtonServiceApp",
		[ "commonApp" ]);

sysConfigButtonServiceApp.service("sysConfigButtonService", [
		"commonService",
		function(commonService) {
			this.qrySysConfigButton = function (params,sback,eback) {
				commonService.call("meta/sysConfigQuery/qrySysConfigList",params,sback,eback);
			}
			
		} ]);