/**
 * Created by qn_guo on 2016/1/6.
 */
var clearCacheApp = angular.module("clearCacheApp", ["configMainServiceApp"]);

// controller
clearCacheApp.controller("clearCacheCtrl", ["$scope", "configMainService", "commonService", "$compile",
    function ($scope, configMainService, commonService, $compile) {
		$scope.qryInfo= {};
        //根据路径清除缓存
        $scope.clearCacheByPath = function () {
            if (undefined == $scope.cachePath || $scope.cachePath == "") {
                MESSAGE_DIALOG.warning("路径不能为空！");
                return;
            }
            $scope.qryInfo ={}
            $scope.qryInfo.cachePath = $scope.cachePath;
            MESSAGE_DIALOG.confirm("确认清除此路径的缓存？", function () {
                configMainService.clearCacheByPathData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("根据路径清缓存节点成功！");
                    } else {
                        MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                	MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        //清除所有缓存
        $scope.clearAllCache = function () {
            MESSAGE_DIALOG.confirm("确认清除所有的缓存？", function () {
            	$scope.qryInfo ={}
            	$scope.qryInfo.cachePath ="not null";
                configMainService.clearAllCacheData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("清缓存成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };

        //清除路径下的子节点
        $scope.clearChildByPath = function () {
            if (undefined == $scope.cachePath || $scope.cachePath == "") {
                MESSAGE_DIALOG.warning("路径不能为空！");
                return;
            }
            $scope.qryInfo ={}
            $scope.qryInfo.cachePath = $scope.cachePath;
            MESSAGE_DIALOG.confirm("清除路径下的子节点缓存？", function () {
                configMainService.clearChildByPathData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("根据路径清缓存节点成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        //根据路径清除开关缓存
        $scope.clearSwitchByPath = function () {
            if (undefined == $scope.switchPath || $scope.switchPath == "") {
                MESSAGE_DIALOG.warning("路径不能为空！");
                return;
            }
            $scope.qryInfo ={}
            $scope.qryInfo.switchPath = $scope.switchPath;
            MESSAGE_DIALOG.confirm("确认清除此路径的缓存？", function () {
                configMainService.clearSwitchByPathData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("根据路径清缓存节点成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        //清除路径下的子节点
        $scope.clearSwiChildByPath = function () {
            if (undefined == $scope.switchPath || $scope.switchPath == "") {
                MESSAGE_DIALOG.warning("路径不能为空！");
                return;
            }
            $scope.qryInfo ={}
            $scope.qryInfo.switchPath = $scope.switchPath;
            MESSAGE_DIALOG.confirm("清除路径下的子节点缓存？", function () {
                configMainService.clearChildByPathData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("根据路径清缓存节点成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        //清除所有开关缓存
        $scope.clearAllSwitch = function () {
            MESSAGE_DIALOG.confirm("确认清除所有的缓存？", function () {
            	$scope.qryInfo ={}
                $scope.qryInfo.switchPath ="not null";
                configMainService.clearAllSwitchData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("清除所有开关缓存成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        //根据路径清除抽样
        $scope.clearSamplingByPath = function () {
            if (undefined == $scope.samplingPath || $scope.samplingPath == "") {
                MESSAGE_DIALOG.warning("路径不能为空！");
                return;
            }
            $scope.qryInfo ={}
            $scope.qryInfo.samplingPath = $scope.samplingPath;
            MESSAGE_DIALOG.confirm("确认清除此路径的缓存？", function () {
                configMainService.clearSamplingByPathData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("根据路径清缓存成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        //清除路径下的子节点
        $scope.clearSChildByPath = function () {
            if (undefined == $scope.samplingPath || $scope.samplingPath == "") {
                MESSAGE_DIALOG.warning("路径不能为空！");
                return;
            }
            $scope.qryInfo ={}
            $scope.qryInfo.samplingPath = $scope.samplingPath;
            MESSAGE_DIALOG.confirm("确认清除此路径下的子节点缓存？", function () {
                configMainService.clearChildByPathData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("根据路径清缓存成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        //清除所有抽样缓存
        $scope.clearAllSampling = function () {
            MESSAGE_DIALOG.confirm("确认清除所有抽样缓存？", function () {
            	$scope.qryInfo ={}
                $scope.qryInfo.samplingPath ="not null";
                configMainService.clearAllSamplingData($scope.qryInfo, function (result) {
                    if (result.result != undefined && result.result == true) {
                        MESSAGE_DIALOG.alert("清所有抽样缓存成功！");
                    } else {
                    	MESSAGE_DIALOG.error("清缓存失败！" + result.msgTitle);
                    }
                }, function () {
                    MESSAGE_DIALOG.error("清缓存失败！");
                });
            });
        };
        $scope.qryInfo ={}
        $scope.cachePath = "",$scope.switchPath = "",$scope.samplingPath = "";
        
    }]);