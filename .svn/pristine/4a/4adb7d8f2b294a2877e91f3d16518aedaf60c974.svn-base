/**
 * Created by FFCS-CAIWL on 2016/1/6.
 * 系统表控制层
 */
angular.module('metaMainApp')
    .service('sysTabService', [
        'commonService',
        function (commonService) {
            var sysTabPre = 'meta/sysTable/';
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //系统表
            this.qrySysTabs = function (p, sf, ef) {
                commonService.call(sysTabPre + 'page', p, sf, ef ? ef : errorFn)
            }
            this.getSysTab = function (p, sf, ef) {
                commonService.call(sysTabPre + 'getSysTable', p, sf, ef ? ef : errorFn)
            }
            this.addSysTab = function (p, sf, ef) {
                commonService.call(sysTabPre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateSysTab = function (p, sf, ef) {
                commonService.call(sysTabPre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delSysTab = function (p, sf, ef) {
                commonService.call(sysTabPre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('sysTabCtrl', [
        '$scope',
        'sysTabService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, sysTabService, optionService, commInstance, modelDateDeal) {
            //form数据
            $scope.formModel = {}

            //新增or编辑or删除
            $scope.modalOption = {
                title: undefined,
                state: undefined
            }
            //toolBar的按钮功能
            $scope.changeState = function (action) {
                $scope.modalOption.state = action
                if (action === 'add') {
                    $scope.formModel = modelDateDeal.toDateStr({})
                    $scope.modalOption.title = '新增'
                    $('.sysTabModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条系统表记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.sysTabModal').modal('show')
                    }
                } else if (action === 'del') {
                    $scope.modalOption.title = '删除'
                    MESSAGE_DIALOG.confirm('确定要删除？', function () {

                    }, function () {

                    })
                }
                return
            }
            //下拉选择
            $scope.select = {
                busyType: [{
                    id: undefined,
                    action: '请选择'
                },{
                    id: '0',
                    action: '横表'
                },{
                    id: '1',
                    action: '纵表'
                }]
            }
            $scope.add = function () {
                sysTabService.addSysTab(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        if (rt.result) {
                            //表格刷新
                        } else {
                            MESSAGE_DIALOG.error(rt.detailMsg)
                        }
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.update = function () {
                sysTabService.updateSysTab(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                sysTabService.delSysTab(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.sysTableControl = optionService.getBsTableOptions({
                toolbar: ".sysTab-btgroup",
                queryParams: function (params) {
                    var otherQry = {}
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    sysTabService.qrySysTabs(render.data, function (result) {
                        ffc.util.loadTableData(render, result)
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.tabSelRow = modelDateDeal.toDateStr(row);
                    //刷新
                    var table = $('table[bs-table-control="sysColumnControl"]')
                    if (table.length > 0) {
                        table.bootstrapTable('refresh');
                    }
                    var table1 = $('table[bs-table-control="tabObjRelControl"]')
                    if (table1.length > 0) {
                        table1.bootstrapTable('refresh')
                    }
                }
            })

        }])
/**
 * 表字段格式化转变
 * @returns {string}
 */
var SysTabFormatter = {
    operation: function (value, row, index) {
        return "<a href='javascript:;'>详情</a><a href='javascript:;'>查看表字段</a>"
    }
}
