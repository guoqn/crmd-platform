/**
 * Created by FFCS-CAIWL on 2016/1/6.
 */
angular.module("metaMainApp")
    .service('busiObjAttrService', [
        'commonService',
        function (commonService) {
            var busiObjAttrPre = 'meta/busiObjAttr/'
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //业务对象属性规格
            this.qryBusiAttrSpecPageByObjId = function (p, sf, ef) {
                commonService.call(busiObjAttrPre + 'page/byObjId', p, sf, ef ? ef : errorFn)
            }
            this.addBusiAttrSpec = function (p, sf, ef) {
                commonService.call(busiObjAttrPre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateBusiAttrSpec = function (p, sf, ef) {
                commonService.call(busiObjAttrPre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delBusiAttrSpec = function (p, sf, ef) {
                commonService.call(busiObjAttrPre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('busiObjAttrCtrl', ['$scope',
        'busiObjAttrService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, busiObjAttrService, optionService, commInstance, modelDateDeal) {
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
                    $('.busiObjAttrModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条业务对象属性规格记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.busiObjAttrModal').modal('show')
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
                busiObjAttrService.addBusiAttrSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                busiObjAttrService.updateBusiAttrSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                busiObjAttrService.delBusiAttrSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.busiObjAttrControl = optionService.getBsTableOptions({
                toolbar: ".busiObjAttr-btgroup",
                queryParams: function (params) {
                    if (!commInstance.busiObjSelRow) {
                        return false
                    }
                    var otherQry = {
                        busiObjId:commInstance.busiObjSelRow.busiObjId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {

                    busiObjAttrService.qryBusiAttrSpecPageByObjId(render.data, function (result) {
                        ffc.util.loadTableData(render, result);
                    });
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.busiObjAttrSelRow = modelDateDeal.toDateStr(row)
                    //刷新
                    var table = $('table[bs-table-control="busiObjAttrValueControl"]')
                    if (table.length > 0) {
                        table.bootstrapTable('refresh');
                    }
                }
            })
        }])
var BusiObjAttrFormatter = {
    operation: function (value, row, index) {

    }
}
