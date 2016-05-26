/**
 * Created by FFCS-CAIWL on 2016/1/6.
 * 系统表控制层
 */
angular.module('metaMainApp')
    .service('tabObjRelService', [
        'commonService',
        function (commonService) {
            var tabObjRelPre = 'meta/objTabRel/';
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //查询表关联下的业务对象
            this.qryPageByTabId = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'page/byTabId', p, sf, ef ? ef : errorFn)
            }

            this.addTabObjRel = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateTabObjRel = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delTabObjRel = function (p, sf, ef) {
                commonService.call(tabObjRelPre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('tabObjRelCtrl', [
        '$scope',
        'tabObjRelService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, tabObjRelService, optionService, commInstance, modelDateDeal) {
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
                    $('.tabObjRelModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条业务对象记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.tabObjRelModal').modal('show')
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
                tabObjRelService.addTabObjRel(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                tabObjRelService.updateTabObjRel(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                tabObjRelService.delTabObjRel(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.tabObjRelControl = optionService.getBsTableOptions({
                toolbar: ".tabObjRel-btgroup",
                queryParams: function (params) {
                    if (!commInstance.tabSelRow) {
                        return false
                    }
                    var otherQry = {
                        objType: 'busi_obj',
                        tabId: commInstance.tabSelRow.tabId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    tabObjRelService.qryPageByTabId(render.data, function (result) {
                        ffc.util.loadTableData(render, result);
                    });
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.tabObjRelRow = modelDateDeal.toDateStr(row)

                }
            })

        }])
/**
 * 表字段格式化转变
 * @returns {string}
 */
var tabObjRelFormatter = {
    operation: function (value, row, index) {
        return "<a href='javascript:;'>详情</a><a href='javascript:;'>查看表字段</a>"
    }
}
