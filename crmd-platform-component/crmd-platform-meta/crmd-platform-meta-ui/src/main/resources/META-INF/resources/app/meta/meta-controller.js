/**
 * Meta控制层
 */
angular.module('metaMainApp')
    .controller('metaMainCtrl', [
        '$scope',
        'metaRequestService',
        'optionService',
        function ($scope, metaRequestService, optionService) {
            //初始化

            $scope.metaMain = {
                projectName: '元数据配置',
                sidebarItems: [{
                    code: 'sys',
                    name: '系统表'
                }, {
                    code: 'domain',
                    name: '主题域'
                }, {
                    code: 'busiType',
                    name: '业务大类'
                }, {
                    code: 'busiObj',
                    name: '业务对象'
                }],
                selectSidebarItem: {},
                itemSelect: function (item, ev) {
                    $scope.metaMain.selectSidebarItem = item
                    $(ev.target).parent().addClass("active").siblings().removeClass('active')
                }
            }

            $scope.statusCdItems = [{
                action: '请选择...',
                id: undefined
            }, {
                action: '有效状态',
                id: '1000'
            }, {
                action: '无效状态',
                id: '1100'
            }, {
                action: '失效状态',
                id: '1200'
            }]
            //管理等级
            $scope.manageGrade = [{
                action: '请选择...',
                id: undefined
            }, {
                id: 10,
                action: '集团级'
            }, {
                id: 11,
                action: '省级'
            }]
            //C3地区
            $scope.areaIdItems = [{
                action: '请选择...',
                id: undefined
            }]
            //C4地区
            $scope.regionCdItems = [{
                action: '请选择...',
                id: undefined
            }]
            //是否
            $scope.isOrNotItems = [{
                id: undefined,
                action: '请选择...'
            }, {
                id: 1,
                action: '是'
            }, {
                id: '0',
                action: '否'
            }]

        }
    ])
