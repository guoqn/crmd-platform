/**
 * Created by FFCS-CAIWL on 2016/1/6.
 */
angular.module("metaMainApp")
    .service('sysDomainService', [
        'commonService',
        function (commonService) {
            var sysDomainPre = 'meta/sysDomain/'
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //主题域
            this.qryDomainPage = function (p, sf, ef) {
                commonService.call(sysDomainPre + 'page', p, sf, ef ? ef : errorFn)
            }
            this.addDomain = function (p, sf, ef) {
                commonService.call(sysDomainPre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateDomain = function (p, sf, ef) {
                commonService.call(sysDomainPre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delDomain = function (p, sf, ef) {
                commonService.call(sysDomainPre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('sysDomainCtrl', ['$scope',
        'sysDomainService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, sysDomainService, optionService, commInstance, modelDateDeal) {
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
                    $('.doMainModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条表字段记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.doMainModal').modal('show')
                    }
                } else if (action === 'del') {
                    $scope.modalOption.title = '删除'
                    MESSAGE_DIALOG.confirm('确定要删除？', function () {

                    }, function () {

                    })
                }
                return
            }
            $scope.add = function () {
                sysDomainService.addDomain(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                sysDomainService.updateDomain(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                sysDomainService.delDomain(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.domainControl = optionService.getBsTableOptions({
                toolbar: ".domain-btgroup",
                queryParams: function (params) {
                    var other = {
                    }
                    return $.extend({}, params, other)
                },
                ajax: function (render) {
                    sysDomainService.qryDomainPage(render.data, function (result) {
                        ffc.util.loadTableData(render, result)
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.doMainSelRow = modelDateDeal.toDateStr(row)
                    //刷新
                    var table = $('table[bs-table-control="busiTypeControl"]')
                    if (table.length > 0) {
                        table.bootstrapTable('refresh')
                    }
                }
            })
        }])
var SysDomainFormatter = {
    operation: function (value, row, index) {
        return "<a href='javascript:;'>详情</a><a href='javascript:;'>查看表字段</a>"
    }
}
