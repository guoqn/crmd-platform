/**
 * Created by FFCS-CAIWL on 2016/1/6.
 * 系统字段控制层
 */
angular.module("metaMainApp")
    .service('attrSpecService', ['commonService', function (commonService) {
        //请求前缀
        var attrSpecPre = 'meta/attrSpec/'

        var errorFn = function (rt) {
            MESSAGE_DIALOG.error(angular.toJson(rt))
        }

        //属性规格服务
        this.qryAttrSpecPageByTypeId = function (p, sf, ef) {
            commonService.call(attrSpecPre + 'page/byTypeId', p, sf, ef ? ef : errorFn)
        }
        this.addAttrSpec = function (p, sf, ef) {
            commonService.call(attrSpecPre + 'add', p, sf, ef ? ef : errorFn)
        }
        this.updateAttrSpec = function (p, sf, ef) {
            commonService.call(attrSpecPre + 'update', p, sf, ef ? ef : errorFn)
        }
        this.delAttrSpec = function (p, sf, ef) {
            commonService.call(attrSpecPre + 'del', p, sf, ef ? ef : errorFn)
        }
    }])
    .controller('attrSpecCtrl', ['$scope',
        'attrSpecService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        function ($scope, attrSpecService, optionService, commInstance, modelDateDeal) {
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
                    /*$scope.formModel = modelDateDeal.toDateStr({
                     typeId: commInstance.busiTypeSelRow.typeId
                     })*/
                    $scope.formModel = modelDateDeal.toDateStr({})
                    $scope.modalOption.title = '新增'
                    $('.attrSpecModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条属性规格记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.attrSpecModal').modal('show')
                    }
                } else if (action === 'del') {
                    $scope.modalOption.title = '删除'
                    MESSAGE_DIALOG.confirm('确定要删除？', function () {

                    }, function () {

                    })
                }
                return
            }
            //下拉选择框
            $scope.select = {
                //属性值数据类型
                attrValDataType: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 'date',
                    action: '日期型'
                }, {
                    id: 'datetime',
                    action: '日期时间型'
                }, {
                    id: 'varchar',
                    action: '字符型'
                }, {
                    id: 'number',
                    action: '数值型'
                }],
                attrLevel: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 1,
                    action: '集团规范级'
                }, {
                    id: 2,
                    action: '核心版本级'
                }, {
                    id: 3,
                    action: '省实施级'
                }],
                //属性值分类
                attrValType: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 'input',
                    action: '输入框'
                }, {
                    id: 'select',
                    action: '下拉框'
                }],
                //持久化类型 属性类型（输入T1,关联T2,选择T3,自动编码属性T4,内存属性T5）
                attrPerType: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 'T1',
                    action: '输入'
                }, {
                    id: 'T2',
                    action: '关联'
                }, {
                    id: 'T3',
                    action: '选择'
                }, {
                    id: 'T4',
                    action: '自动编码属性'
                }, {
                    id: 'T5',
                    action: '内存属性'
                }],
                procType: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 'GD',
                    action: '套餐档次'
                }, {
                    id: 'NA',
                    action: '非约'
                }, {
                    id: 'NC',
                    action: '禁止转义'
                }, {
                    id: 'NM',
                    action: '名字'
                }, {
                    id: 'OT',
                    action: '子订单行'
                }, {
                    id: 'PK',
                    action: '主键'
                }, {
                    id: 'QX',
                    action: '权限限制'
                }, {
                    id: 'RK',
                    action: '参考'
                }, {
                    id: 'RM',
                    action: '备注'
                }, {
                    id: 'ST',
                    action: '细分类型'
                }, {
                    id: 'TJ',
                    action: '营销统计'
                }],
                busiTypeItem: [{
                    id: undefined,
                    action: '请选择'
                }],
                addEffType: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 0,
                    action: '立即生效'
                }, {
                    id: 1,
                    action: '次月生效'
                }, {
                    id: 2,
                    action: '当月生效'
                }, {
                    id: 3,
                    action: '次月16日生效'
                }],
                modEffType: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 0,
                    action: '立即生效'
                }, {
                    id: 1,
                    action: '次月生效'
                }, {
                    id: 2,
                    action: '当月生效'
                }, {
                    id: 3,
                    action: '次月16日生效'
                }],
                printFormat: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 0,
                    action: '不打印'
                }, {
                    id: 1,
                    action: '打印'
                }, {
                    id: 2,
                    action: '暗码打印'
                }, {
                    id: 3,
                    action: '勾选框打印'
                }, {
                    id: 4,
                    action: '金额类型打印'
                }, {
                    id: 5,
                    action: '折扣类型打印'
                }, {
                    id: 6,
                    action: '可逆密码'
                }, {
                    id: 7,
                    action: '分钟类型打印'
                }],
                expireType: [{
                    id: undefined,
                    action: '请选择'
                }, {
                    id: 0,
                    action: '立即失效'
                }, {
                    id: 1,
                    action: '次月失效'
                }, {
                    id: 12,
                    action: '下个月15号失效'
                }, {
                    id: 2,
                    action: '当月失效'
                }, {
                    id: 3,
                    action: '完工立即失效'
                }]
            }

            $scope.add = function () {
                attrSpecService.addAttrSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        //表格刷新
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
                $('.attrSpecModal').modal('hide')
            }

            $scope.update = function () {
                attrSpecService.updateAttrSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                attrSpecService.delAttrSpec(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }

            //表格参数
            $scope.attrSpecControl = optionService.getBsTableOptions({
                toolbar: ".attrSpec-btgroup",
                queryParams: function (params) {
                    if (!commInstance.busiTypeSelRow) {
                        return false
                    }
                    var otherQry = {
                        parAttrId: 0,
                        busiTypeId: commInstance.busiTypeSelRow.busiTypeId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    attrSpecService.qryAttrSpecPageByTypeId(render.data, function (result) {
                        ffc.util.loadTableData(render, result)
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.attrSpecSelRow = modelDateDeal.toDateStr(row)
                    //刷新属性规格
                    var table = $('table[bs-table-control="attrValueControl"]')
                    if (table.length > 0) {
                        table.bootstrapTable('refresh');
                    }
                }
            })


        }])

var AttrSpecFormatter = {
    operation: function (value, row, index) {

        return ''
    }
}
