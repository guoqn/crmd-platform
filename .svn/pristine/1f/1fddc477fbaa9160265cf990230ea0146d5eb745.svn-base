/**
 * Created by FFCS-CAIWL on 2015/12/30.
 * commonApp: 公共模块控件 common.js
 * bsTable：表格控件 bootstrap-table-angular.js
 */
angular.module('metaMainApp', ['commonApp', 'bsTable'])
    //初始化，可存放如全局事件监听
    .run(function (metaRequestService, dateFormatterStr) {
        //日期时间选择器
        $(function () {
            $('.date').datetimepicker({
                format: dateFormatterStr,
                dateIcon: 'glyphicon glyphicon-calendar'
            })
        })

    })
    //日期格式化字符串
    .constant('dateFormatterStr', 'yyyy/MM/dd hh:mm:ss') //IE支持“/”，不支持“-”
    //公共请求服务
    .service('metaRequestService', [
        'commonService', 'attrSpecService', 'attrValueService',
        'busiObjService', 'busiObjAttrService', 'busiObjAttrValueService',
        'sysTabService', 'busiTypeService', 'sysColumnService', 'sysDomainService',
        function (commonService, attrSpecService, attrValueService, busiObjService, busiObjAttrService, busiObjAttrValueService,
                  sysTabService, busiTypeService, sysColumnService, sysDomainService) {
            //属性规格服务
            this.getAttrSpecService = function () {
                return attrSpecService
            }
            //属性值服务
            this.getAttrValueService = function () {
                return attrValueService
            }
            //业务对象服务
            this.getBusiObjService = function () {
                return busiObjService
            }
            //业务对象属性规格服务
            this.getBusiObjAttrService = function () {
                return busiObjAttrService
            }
            //业务对象属性规格值服务
            this.getBusiObjAttrValueService = function () {
                return busiObjAttrValueService
            }
            //系统表服务
            this.getSysTabService = function () {
                return sysTabService
            }
            //系统大类服务
            this.getBusiTypeService = function () {
                return busiTypeService
            }
            //主题域服务
            this.getSysDomainService = function () {
                return sysDomainService
            }
        }])
    //公共组件配置参数
    .service('optionService', function () {
        //默认bsTable表格参数
        this.getBsTableOptions = function (extOpts) {
            var _default = {
                toolbar: undefined,
                /**
                 * @param params 可用值
                 * limit: 10
                 * offset: 0
                 * order: "asc"
                 * search: undefined
                 * sort: undefined
                 * @returns {*}
                 */
                queryParams: function (params) {
                    return params;
                },
                ajax: undefined,
                height: 300,
                sidePagination: "server",
                cache: false,
                striped: true,
                pagination: true,
                pageSize: 10,
                pageList: [5, 10, 25, 50, 100, 200],
                queryParamsType: '',
                search: true,
                showColumns: true,
                showRefresh: true,
                paginationDetailHAlign: "left",
                clickToSelect: false,
                showToggle: false,
                maintainSelected: true
            }
            return {
                options: $.extend({}, _default, extOpts)
            }
        }
        //自定义popover
        this.getPopOption = function (extOpts) {
            var _default = {
                selector: undefined,
                target: undefined,
                status: '',
                title: '',
                placement: "auto",
                executeHandler: function (obj, target) {
                    //自定义
                }
            }
            return $.extend({}, _default)
        };
        //ng-jsTree参数
        this.getJsTreeOption = function (extOpts) {
            var _dropConfig = {
                treeData: null,
                treeConfig: {
                    version: 1,
                },
                instance: null,
                infoType: null,
                infoMsg: "",
                treeTypes: {
                    'default': {
                        icon: "glyphicon glyphicon-flash"
                    },
                    star: {
                        icon: "glyphicon glyphicon-star"
                    },
                    cloud: {
                        icon: "glyphicon glyphicon-cloud"
                    }
                },
                dropData: "",
                treeEvents: {}
            };
            return $.extend({}, _dropConfig, extOpts);
        }

        /*//toolBar的按钮功能
         this.changeStateOpt = function (option) {
         if (option.action === 'add') {
         option.formModal = {}
         option.title = '新增'
         $(options.modal).modal('show')
         //回调函数
         } else if (option.action === 'update') {
         if ($.isEmptyObject(option.formModal)) {
         MESSAGE_DIALOG.warning('请选中一条记录')
         } else {
         option.title = '编辑'
         $(options.modal).modal('show')
         //回调函数
         }
         } else if (option.action === 'del') {
         option.title = '删除'
         MESSAGE_DIALOG.confirm('确定要删除？', function () {
         //回调函数
         }, function () {
         //回调函数
         })
         }
         return
         }*/
    })
    //公共属性 供控制层之间传递
    .factory('commInstance', function () {
        //这里记录说明
        return {}
    })
    .factory('modelDateDeal', function (dateFormatterStr) {
        //公共字段
        var comAttrs = ['statusDate', 'createDate', 'updateDate', 'dtimestamp', 'recUpdateDate']
        //对象中属于日期的属性-毫秒转换成字符串
        var attrsToDateStr = function (obj, extAttrs, b) {
            var now = new Date()
            $.each(comAttrs, function (i, attr) {
                obj[attr] ? (obj[attr] = longToDateStr(obj[attr])) : b ? (obj[attr] = longToDateStr(now.getTime())) : ''
            })
            if (extAttrs) {
                $.each(extAttrs, function (i, extAttr) {
                    obj[extAttr] ? (obj[extAttr] = longToDateStr(obj[extAttr])) : b ? (obj[extAttr] = longToDateStr(now.getTime())) : ''
                })
            }
        }

        //对象中属于日期的属性-字符串转换成毫秒
        var attrsToDateLong = function (obj, extAttrs, b) {
            var now = new Date()
            $.each(comAttrs, function (i, attr) {
                obj[attr] ? (obj[attr] = strToDate(obj[attr])) : b ? (obj[attr] = longToDateStr(now.getTime())) : ''
            })
            if (extAttrs) {
                $.each(extAttrs, function (i, attr) {
                    obj[attr] ? (obj[attr] = strToDate(obj[attr])) : b ? (obj[attr] = longToDateStr(now.getTime())) : ''
                })
            }
        }

        var longToDateStr = function (longDate) {
            if (longDate)
                return ffc.util.formatter(new Date(longDate), dateFormatterStr)
        }
        var strToDate = function (str) {
            return Date.parse(str)
        }
        return {
            /**
             * 毫秒日期转换成字符串
             * @param obj
             * @param extAttrs
             * @param b 默认不开
             * @returns 新对象
             */
            toDateStr: function (obj, extAttrs, b) {
                var tmp = $.extend(obj ? obj : {}, obj)
                attrsToDateStr(tmp, extAttrs, b)
                return tmp
            },
            /**
             * 字符串日期转换成毫秒
             * @param obj
             * @param extAttrs
             * @param b
             * @returns 新对象
             */
            toDateLong: function (obj, extAttrs, b) {
                var tmp = $.extend({}, obj)
                attrsToDateLong(tmp, extAttrs, b)
                return tmp
            }
        }
    })
