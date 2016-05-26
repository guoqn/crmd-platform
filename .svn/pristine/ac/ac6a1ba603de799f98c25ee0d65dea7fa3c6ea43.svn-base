/**
 * Created by FFCS-CAIWL on 2016/1/6.
 */
angular.module("metaMainApp")
    .service('busiTypeService', [
        'commonService',
        function (commonService) {
            var busiTypePre = 'meta/busiType/'
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //业务大类
            this.qryBusiTypePageByDomainId = function (p, sf, ef) {
                commonService.call(busiTypePre + 'page/byDomainId', p, sf, ef ? ef : errorFn)
            }
            this.addBusiType = function (p, sf, ef) {
                commonService.call(busiTypePre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateBusiType = function (p, sf, ef) {
                commonService.call(busiTypePre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delBusiType = function (p, sf, ef) {
                commonService.call(busiTypePre + 'del', p, sf, ef ? ef : errorFn)
            }

        }])
    .controller('busiTypeCtrl', ['$scope',
        'busiTypeService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        'metaRequestService',
        function ($scope, busiTypeService, optionService, commInstance, modelDateDeal, metaRequestService) {
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
                    $('.busiTypeModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条业务大类记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.busiTypeModal').modal('show')
                    }
                } else if (action === 'del') {
                    $scope.modalOption.title = '删除'
                    MESSAGE_DIALOG.confirm('确定要删除？', function () {

                    }, function () {

                    })
                }
                return
            }
            // select框
            $scope.select = {
                //删除等级
                deleteLogLevelItems: [{
                    id: undefined,
                    action: '请选择...'
                }, {
                    id: 0,
                    action: '否'
                }, {
                    id: 1,
                    action: '是'
                }],
                //变更等级
                changeLogLevelItems: [{
                    id: undefined,
                    action: '请选择...'
                }, {
                    id: 0,
                    action: '否'
                }, {
                    id: 1,
                    action: '是'
                }],
                //域
                busiDomainItems: [{
                    id: undefined,
                    action: '请先选择主题域'
                }]
            }

            //查询现存主题域
            metaRequestService.getSysDomainService().qryDomainPage({}, function (rt) {
                if (rt.result) {
                    $scope.select.busiDomainItems.length = 1
                    $.each(rt.pageInfo.list, function (index, obj) {
                        $scope.select.busiDomainItems.push({
                            id: obj.domainId,
                            action: obj.domainName
                        })
                    })
                }
            })
            //选择主题下拉框值
            $scope.busiDomainId = undefined
            $scope.qrySysDomain = function () {
                $('table[bs-table-control="busiTypeControl"]').bootstrapTable('refresh')
            }

            $scope.add = function () {
                busiTypeService.addBusiType(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                busiTypeService.updateBusiType(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                busiTypeService.delBusiType(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }

            $scope.busiTypeControl = optionService.getBsTableOptions({
                toolbar: '.type-btgroup',
                queryParams: function (params) {
                    if (!$scope.busiDomainId) {
                        return false
                    }
                    var otherQry = {
                        domainId: $scope.busiDomainId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    busiTypeService.qryBusiTypePageByDomainId(render.data, function (result) {
                        ffc.util.loadTableData(render, result)
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.busiTypeSelRow = modelDateDeal.toDateStr(row)
                    //刷新
                    var table1 = $('table[bs-table-control="busiObjControl"]')
                    if (table1.length > 0) {
                        table1.bootstrapTable('refresh')
                    }
                    var table2 = $('table[bs-table-control="attrSpecControl"]')
                    if (table2.length > 0) {
                        table2.bootstrapTable('refresh')
                    }
                }
            })
        }])
var BusiTypeFormatter = {
    operation: function (value, row, index) {

    }
}
