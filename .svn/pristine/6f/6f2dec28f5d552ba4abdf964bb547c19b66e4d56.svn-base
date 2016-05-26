/**
 * Created by FFCS-CAIWL on 2016/1/6.
 */
angular.module("metaMainApp")
    .service('busiObjAttrValueService', [
        'commonService',
        function (commonService) {
            var busiObjAttrValuePre = 'meta/busiObjAttrValue/'
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //业务对象属性值规格
            this.qryBusiAttrValuePageByBusiObjAttrId = function (p, sf, ef) {
                commonService.call(busiObjAttrValuePre + 'page/byBusiObjAttrId', p, sf, ef ? ef : errorFn)
            }
            this.addBusiAttrValue = function (p, sf, ef) {
                commonService.call(busiObjAttrValuePre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateBusiAttrValue = function (p, sf, ef) {
                commonService.call(busiObjAttrValuePre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delBusiAttrValue = function (p, sf, ef) {
                commonService.call(busiObjAttrValuePre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('busiObjAttrValueCtrl', ['$scope',
        'busiObjAttrValueService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, busiObjAttrValueService, optionService, commInstance, modelDateDeal) {
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
                    $('.busiObjAttrValueModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条业务对象属性规格值记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.busiObjAttrValueModal').modal('show')
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
                busiObjAttrValueService.addBusiAttrValue(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                busiObjAttrValueService.updateBusiAttrValue(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                busiObjAttrValueService.delBusiAttrValue(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.busiObjAttrValueControl = optionService.getBsTableOptions({
                toolbar: ".busiObjAttrValue-btgroup",
                queryParams: function (params) {
                    if (!commInstance.busiObjAttrSelRow) {
                        return false
                    }
                    var otherQry = {
                        busiObjAttrId: commInstance.busiObjAttrSelRow.busiObjAttrId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    busiObjAttrValueService.qryBusiAttrValuePageByBusiObjAttrId(render.data, function (result) {
                        ffc.util.loadTableData(render, result);
                    });
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.busiObjAttrValueSelRow = modelDateDeal.toDateStr(row)
                }
            })
        }])
var BusiObjAttrValueFormatter = {
    operation: function (value, row, index) {

    }
}
