/**
 * Created by FFCS-CAIWL on 2016/1/6.
 */
angular.module("metaMainApp")
    .service('attrValueService', [
        'commonService',
        function (commonService) {
            var attrValuePre = 'meta/attrValue/'
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //属性值规格
            this.qryAttrValuePageByAttrId = function (p, sf, ef) {
                commonService.call(attrValuePre + 'page/byAttrId', p, sf, ef ? ef : errorFn)
            }
            this.addAttrValue = function (p, sf, ef) {
                commonService.call(attrValuePre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateAttrValue = function (p, sf, ef) {
                commonService.call(attrValuePre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delAttrValue = function (p, sf, ef) {
                commonService.call(attrValuePre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('attrValueCtrl', ['$scope',
        'attrValueService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, attrValueService, optionService, commInstance, modelDateDeal) {
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
                    $('.attrValueModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条属性规格记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.attrValueModal').modal('show')
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
                attrValueService.addAttrValue(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                attrValueService.updateAttrValue(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                attrValueService.delAttrValue(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.attrValueControl = optionService.getBsTableOptions({
                toolbar: ".attrValue-btgroup",
                queryParams: function (params) {
                    if (!commInstance.attrSpecSelRow) {
                        return false
                    }
                    var otherQry = {
                        parentValueId: 0,
                        attrId: commInstance.attrSpecSelRow.attrId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    attrValueService.qryAttrValuePageByAttrId(render.data, function (result) {
                        ffc.util.loadTableData(render, result)
                    });
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.attrValuelSelRow = modelDateDeal.toDateStr(row)
                }
            })

            //传播事件
            $scope.$on('refreshTable', function () {

            })
        }])
var AttrValueFormatter = {
    operation: function (value, row, index) {

    }
}
