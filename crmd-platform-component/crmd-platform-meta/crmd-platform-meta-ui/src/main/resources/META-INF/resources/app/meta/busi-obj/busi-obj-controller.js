/**
 * Created by FFCS-CAIWL on 2016/1/6.
 */
angular.module("metaMainApp")
    .service('busiObjService', [
        'commonService',
        function (commonService) {
            var busiObjPre = 'meta/busiObj/'
            var errorFn = function (rt) {
                MESSAGE_DIALOG.error(angular.toJson(rt))
            }
            //业务对象
            this.qryBusiObjPageByTypeId = function (p, sf, ef) {
                commonService.call(busiObjPre + 'page/byTypeId', p, sf, ef ? ef : errorFn)
            }
            this.addBusiObj = function (p, sf, ef) {
                commonService.call(busiObjPre + 'add', p, sf, ef ? ef : errorFn)
            }
            this.updateBusiObj = function (p, sf, ef) {
                commonService.call(busiObjPre + 'update', p, sf, ef ? ef : errorFn)
            }
            this.delBusiObj = function (p, sf, ef) {
                commonService.call(busiObjPre + 'del', p, sf, ef ? ef : errorFn)
            }
        }])
    .controller('busiObjCtrl', ['$scope',
        'busiObjService',
        'optionService',
        'commInstance',
        'modelDateDeal',
        'metaRequestService',
        function ($scope, busiObjService, optionService, commInstance, modelDateDeal, metaRequestService) {
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
                    $('.busiObjModal').modal('show')
                } else if (action === 'update') {
                    if ($.isEmptyObject($scope.formModel)) {
                        MESSAGE_DIALOG.warning('请选中一条业务对象记录')
                    } else {
                        $scope.modalOption.title = '编辑'
                        $('.busiObjModal').modal('show')
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
                busiDomainItems: [{
                    id: undefined,
                    action: '请选择...'
                }],
                busiTypeItems: [{
                    id: undefined,
                    action: '请选择...'
                }],
                sysTabItems: [{
                    id: undefined,
                    action: '请选择...'
                }],
                applyRegionIdItems: [{
                    id: undefined,
                    action: '请选择...'
                }]
            }
            //查询现存主题域
            metaRequestService.getSysDomainService().qryDomainPage({}, function (rt) {
                if (rt.result) {
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
                //查询现存业务大类
                metaRequestService.getBusiTypeService()
                    .qryBusiTypePageByDomainId({
                        domainId: $scope.busiDomainId
                    }, function (rt) {
                        if(rt.result){
                            $.each(rt.pageInfo.list, function(index, obj){
                                $scope.select.busiTypeItems.push({
                                    id: obj.busiTypeId,
                                    action: obj.busiTypeName
                                })
                            })
                        }
                    })
            }
            $scope.busiTypeId = undefined
            $scope.qryBusiType = function () {
                $('table[bs-table-control="busiObjControl"]').bootstrapTable('refresh')
            }


            $scope.add = function () {
                busiObjService.addBusiObj(modelDateDeal.toDateLong($scope.formModel), function (rt) {
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
                busiObjService.updateBusiObj(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('保存成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            $scope.del = function () {
                busiObjService.delBusiObj(modelDateDeal.toDateLong($scope.formModel), function (rt) {
                    if (rt.result) {
                        MESSAGE_DIALOG.warning('删除成功')
                    } else {
                        MESSAGE_DIALOG.error(rt.detailMsg)
                    }
                })
            }
            //表格参数
            $scope.busiObjControl = optionService.getBsTableOptions({
                toolbar: ".busiObj-btgroup",
                queryParams: function (params) {
                    if (!$scope.busiTypeId) {
                        return false
                    }
                    var otherQry = {
                        busiTypeId: $scope.busiTypeId
                    }
                    return $.extend({}, params, otherQry)
                },
                ajax: function (render) {
                    busiObjService.qryBusiObjPageByTypeId(render.data, function (result) {
                        ffc.util.loadTableData(render, result);
                    })
                },
                onClickRow: function (row, $elm) {
                    $scope.formModel = commInstance.busiObjSelRow = modelDateDeal.toDateStr(row)
                    //刷新
                    var table = $('table[bs-table-control="busiObjAttrControl"]')
                    if (table.length > 0) {
                        table.bootstrapTable('refresh');
                    }
                    var table1 = $('table[bs-table-control="specRelAControl"]')
                    if (table1.length > 0) {
                        table1.bootstrapTable('refresh');
                    }
                    var table2 = $('table[bs-table-control="specRelZControl"]')
                    if (table2.length > 0) {
                        table2.bootstrapTable('refresh');
                    }
                }
            })
            /*var table = $("#busiObjTreeTable");
             var data = [
             {
             name: 'Some Folder',
             type: 'folder',
             size: '',
             children: [
             {
             name: 'some file.pdf',
             type: 'file',
             size: '500KB'
             },
             {
             name: 'another_file.doc',
             type: 'file',
             size: '344KB'
             }
             ]
             }
             ];

             $scope.dynamic_params = new ngTreetableParams({
             getNodes: function(parent) {
             return parent ? parent.children : data;
             },
             getTemplate: function(node) {
             return 'tree_node';
             },
             options: {
             onNodeExpand: function() {
             console.log('A node was expanded!');
             }
             }
             });*/


        }])
var BusiObjFormatter = {
    operation: function (value, row, index) {

    }
}
