/**
 * Created by FFCS-CAIWL on 2016/1/6.
 * 系统表控制层
 */
angular.module('metaMainApp')
    .controller('relSpecZCtrl', [
        '$scope',
        'relSpecService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, relSpecService, optionService, commInstance, modelDateDeal) {
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
                    $('.specRelZModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条业务对象记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.specRelZModal').modal('show')
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
                relSpecService.addRelSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                relSpecService.updateRelSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                relSpecService.delRelSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.specRelZControl = optionService.getBsTableOptions({
                toolbar: ".specRelZ-btgroup",
                queryParams: function (params) {
                    if (!commInstance.busiObjSelRow) {
                        return false
                    }
                    var otherQry = {
                        //relType: 'busi_obj'
                        busiObjId: commInstance.busiObjSelRow.busiObjId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    relSpecService.qryPageByAObjId(render.data, function (result) {
                        ffc.util.loadTableData(render, result);
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.relSpecSelZRow = modelDateDeal.toDateStr(row)
                    var table = $('table[bs-table-control="relSpecAttrZControl"]')
                    if (table.length > 0) {
                        table.bootstrapTable('refresh')
                    }
                }
            })

        }])

var relSpecZFormatter = {
    operation: function (value, row, index) {
        return "<a href='javascript:;'>详情</a><a href='javascript:;'>查看表字段</a>"
    }
}
