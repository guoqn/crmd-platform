/**
 * config service app
 */

// module
var configMainServiceApp = angular.module("configMainServiceApp", [ "commonApp" ]);
// service
configMainServiceApp.service("configMainService", [ "commonService", function(commonService) {
	//qry SysConfig
	this.qrySysConfigData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/qrySysConfigList",params,sback,eback);
	}
	//save SysConfig
	this.saveSysConfig = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/saveSysConfig",params,sback,eback);
	}
	//del SysConfig
	this.delSysConfig = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/delSysConfig",params,sback,eback);
	}
	//clear cache by path
	this.clearCacheByPathData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/clearCacheByPath",params,sback,eback);
	}
	//clear all cache
	this.clearAllCacheData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/clearAllCache",params,sback,eback);
	}
	//clear switch by path
	this.clearSwitchByPathData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/clearCacheByPath",params,sback,eback);
	}

	//clear all switch
	this.clearAllSwitchData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/clearAllCache",params,sback,eback);
	}
	//clear sampling by path
	this.clearSamplingByPathData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/clearCacheByPath",params,sback,eback);
	}
	//clear all sampling
	this.clearAllSamplingData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/clearAllCache",params,sback,eback);
	}
	//clear child by path
	this.clearChildByPathData = function (params,sback,eback) {
		commonService.call("meta/sysConfigQuery/clearChildCache",params,sback,eback);
	}
} ]);
