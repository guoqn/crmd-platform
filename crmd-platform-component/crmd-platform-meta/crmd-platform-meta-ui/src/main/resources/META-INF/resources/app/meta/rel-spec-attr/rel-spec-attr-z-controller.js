/**
 * Created by FFCS-CAIWL on 2016/1/6.
 * 系统表控制层
 */
angular.module('metaMainApp')
    .controller('relSpecAttrCtrlZ', [
        '$scope',
        'relSpecAttrService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, relSpecAttrService, optionService, commInstance, modelDateDeal) {
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
                    $('.relSpecAttrZModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条系统表记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.relSpecAttrZModal').modal('show')
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
                relSpecAttrService.addRelSpecAttr(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                relSpecAttrService.updateRelSpecAttr(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                relSpecAttrService.delRelSpecAttr(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.relSpecAttrZControl = optionService.getBsTableOptions({
                toolbar: ".relSpecAttrZ-btgroup",
                queryParams: function (params) {
                    if (!commInstance.relSpecSelZRow) {
                        return false
                    }
                    var otherQry = {
                        relSpecId: commInstance.relSpecSelZRow.relSpecId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    relSpecAttrService.qryByRelSpecId(render.data, function (result) {
                        ffc.util.loadTableData(render, result);
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.relSpecAttrZSelRow = modelDateDeal.toDateStr(row)
                }
            })

        }])
/**
 * 表字段格式化转变
 * @returns {string}
 */
var relSpecAttrZFormatter = {
    operation: function (value, row, index) {
        return "<a href='javascript:;'>详情</a><a href='javascript:;'>查看表字段</a>"
    }
}
