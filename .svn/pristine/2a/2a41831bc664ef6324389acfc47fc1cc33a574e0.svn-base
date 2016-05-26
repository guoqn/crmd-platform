/**
 * Created by FFCS-CAIWL on 2016/1/6.
 * 系统字段控制层
 */
angular.module("metaMainApp")
    .service('sysColumnService', [
        'commonService',
        function (commonService) {
            var sysColPre = 'meta/sysColumn/'
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //表字段
            this.qryColPageByTabId = function (p, sf, ef) {
                commonService.call(sysColPre + 'page/byTabId', p, sf, ef ? ef : errorFn)
            }
            this.qryColListByTabId = function (p, sf, ef) {
                commonService.call(sysColPre + 'list/byTabId', p, sf, ef ? ef : errorFn)
            }
            this.addCol = function (p, sf, ef) {
                commonService.call(sysColPre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateCol = function (p, sf, ef) {
                commonService.call(sysColPre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delCol = function (p, sf, ef) {
                commonService.call(sysColPre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('sysColumnCtrl', ['$scope',
        'sysColumnService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, sysColumnService, optionService, commInstance, modelDateDeal) {
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
                    $scope.formModel = modelDateDeal.toDateStr({
                        tabId: commInstance.tabSelRow.tabId
                    })
                    $scope.modalOption.title = '新增'
                    $('.sysColModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条表字段记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.sysColModal').modal('show')
                    }
                } else if (action === 'del') {
                    $scope.modalOption.title = '删除'
                    MESSAGE_DIALOG.confirm('确定要删除？', function () {

                    }, function () {

                    })
                }
                return
            }
            //下拉框
            $scope.select ={
                colType: [{
                    id: undefined,
                    action: '请选择'
                },{
                    id: 'varchar',
                    action: '字符串'
                },{
                    id: 'number',
                    action: '整型'
                },{
                    id: 'datetime',
                    action: '日期'
                }]
            }
            $scope.add = function () {
                sysColumnService.addCol(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                sysColumnService.updateCol(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                sysColumnService.delCol(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.sysColumnControl = optionService.getBsTableOptions({
                toolbar: '.sysColumn-btgroup',
                queryParams: function (params) {
                    if (!commInstance.tabSelRow) {
                        return false
                    }
                    var otherQry = {
                        tabId: commInstance.tabSelRow.tabId
                    };
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    sysColumnService.qryColPageByTabId(render.data, function (result) {
                        ffc.util.loadTableData(render, result)
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.sysColSelRow = modelDateDeal.toDateStr(row)
                }
            });
        }])
var SysColumnFormatter = {
    operation: function (value, row, index) {
        return "<a href='javascript:;'>详情</a>"
    }
}
