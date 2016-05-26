/**
 * Created by FFCS-CAIWL on 2016/1/6.
 * 系统表控制层
 */
angular.module('metaMainApp')
    .service('relSpecService', [
        'commonService',
        function (commonService) {
            var tabObjRelPre = 'meta/relSpec/';
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //查询表关联下的业务对象
            this.qryPageByAObjId = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'page/byAObjId', p, sf, ef ? ef : errorFn)
            }
            this.qryPageByZObjId = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'page/byZObjId', p, sf, ef ? ef : errorFn)
            }

            this.addRelSpec = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateRelSpec = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delRelSpec = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('relSpecACtrl', [
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
                    $('.specRelAModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条业务对象记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.specRelAModal').modal('show')
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
            $scope.specRelAControl = optionService.getBsTableOptions({
                toolbar: ".specRelA-btgroup",
                queryParams: function (params) {
                    if(!commInstance.busiObjSelRow){
                        return false
                    }
                    var otherQry = {
                        //relType: 'busi_obj'
                        busiObjId: commInstance.busiObjSelRow.busiObjId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    relSpecService.qryPageByZObjId(render.data, function (result) {
                        ffc.util.loadTableData(render, result);
                    });
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.relSpecSelARow = modelDateDeal.toDateStr(row)
                    var table = $('table[bs-table-control="relSpecAttrAControl"]')
                    if (table.length > 0) {
                        table.bootstrapTable('refresh');
                    }
                }
            })

        }])

var RelSpecAFormatter = {
    operation: function (value, row, index) {
        return "<a href='javascript:;'>详情</a><a href='javascript:;'>查看表字段</a>"
    }
}
