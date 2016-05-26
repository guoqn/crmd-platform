/**
 * 对jstree进行ng封装
 *
 * @author caiwl
 *
 */
(function (angular) {
    'use strict'
        // javascript code
        function jsTreeCtrl(scope) {

        }

        function manageEvents(scope, elm, attrs) {
            if (attrs.treeEvents) {
                var evMap = attrs.treeEvents.split(';')
                for (var i = 0; i < evMap.length; i++) {
                    if (evMap[i].length > 0) {
                        // plugins could have events with suffixes other
                        // than '.jstree'
                        var evt = evMap[i].split(':')[0]
                        if (evt.indexOf('.') < 0) {
                            evt = evt + '.jstree'
                        }
                        var cb = evMap[i].split(':')[1]
                        scope.tree.on(evt, scope.$parent.$eval(cb))
                    }
                }
            }
        }

        // 默认事件
        function initEvents($timeout, scope, elm, attrs) {
            // 树事件
            scope.tree.on('changed.jstree', function (oEv, p) {
                $timeout(function () {
                    scope.selectedData = p.selected
                }, 0)
            })
        }

        function jsTreeDirective($log, $timeout) {
            var treeDir = {
                restrict: 'A',
                controller: 'jsTreeCtrl',
                //require: '?^ffcDropTree',
                scope: {
                    status: '=',
                    treeData: '=', //数据
                    treeConfig: '=jsTree', //配置
                    plugins: '=', //jstree插件
                    treeTypes: '=',
                    selectedData: '=', //选中节点值数组
                    tree: '=',
                    service: '=',  // 请求服务方法
                    serviceType: '=',
                    params: '=' // 请求参数    {}  function(node){ return {}}
                },
                link: function (scope, elm, attrs, ctrl) {
                    //## default config
                    var config = {
                        core: {
                            multiple: false,
                            animation: false,
                            error: function (error) {
                                $log.error('生成树错误:' + angular.toJson(error))
                            },
                            check_callback: true,
                            worker: false,
                            'themes': {
                                'icons': false
                            }
                        },
                        types: {},
                        plugins: []
                    }

                    /**
                     * 可使用方式如：data-multiple,multiple
                     */
                    $.extend(config, scope.treeConfig)
                    var settingCore = $.extend(true, {}, {
                        multiple: attrs.multiple === 'true' ? true : false,
                        animation: attrs.animation === 'true' ? true : false,
                    }, elm.data())
                    // 修改
                    $.extend(config.core, settingCore)

                    if (config.core.multiple) {
                        config.plugins.push('checkbox')
                    }
                    //scope.$eval(attrs.treeTypes)
                    if (scope.treeTypes) {
                        if (typeof scope.treeTypes === 'string') {
                            config.types = {
                                'default': {
                                    icon: scope.treeTypes
                                }
                            }
                        } else if (typeof scope.treeTypes === 'object') {
                            config.types = scope.treeTypes
                        }
                        config.plugins.push('types')
                    }
                    // 扩展jstree插件
                    config.plugins.concat(config.plugins, scope.plugins)
                    /* 1、
                     * ajax example  异步记载树
                     * scope.url : string/function
                     * scope.param: function
                     * 2、
                     * function example 方法调用给treeData
                     * scope.service: function
                     * scope.params: function
                     * 3、
                     * 给静态数据treeData，切记节点的状态loaded=true，都为加载完成的。
                     *
                     * */
                    if (angular.isString(scope.service)) { //传递url
                        //url一定是ajax
                        scope.serviceType = 'ajax'
                        config.core.data = {
                            url: scope.service
                        }
                        if (angular.isFunction(scope.params)) {
                            config.core.data = {
                                'data': scope.params
                            }
                        } else {
                            config.core.data = { // 默认参数传递
                                'data': function (node) {
                                    return node.id !== '#' ? {
                                        'id': node.id
                                    } : {}
                                }
                            }
                        }
                        config.core.data.success = function (data) {
                            if (!scope.treeData) {
                                scope.treeData = []
                            }
                            scope.treeData = scope.treeData.concat(data);
                        }
                    } else if (angular.isFunction(scope.service)) { //自定义服务请求
                        scope.serviceType = 'ajax'
                        config.core.data = function (obj, callback) {
                            var queryParam = angular.isFunction(scope.params) ? scope.params(obj) : obj
                            scope.service(queryParam, function (data) {
                                if (!scope.treeData) {
                                    scope.treeData = []
                                }
                                scope.treeData = scope.treeData.concat(data);
                                callback.call(this, data)
                            })
                        }
                    } else { //静态，传递treeData即可，切记节点的状态loaded=true，都为加载完成的。
                        config.core.data = function (obj, callback) {
                            callback.call(this, scope.treeData)
                        }
                    }

                    //初始化
                    scope.init = function () {
                        elm.jstree(config)
                        scope.tree = elm
                        initEvents($timeout, scope, elm, attrs)
                        manageEvents(scope, elm, attrs)
                        //默认选中值
                        if (scope.selectedData && scope.selectedData.length > 0) {
                            var instans = scope.tree.jstree(true)
                            instans.select_node(scope.selectedData, false)
                        }
                    }
                    //销毁
                    scope.destroy = function () {
                        if(!scope.tree){
                            return
                        }
                        elm.jstree('destroy', true)
                        scope.tree = null
                    }
                    //初始化
                    if ((scope.serviceType === 'ajax') || (scope.treeData && scope.length>0)) {
                        scope.init()
                    }

                    scope.$watch('status', function (newV) {
                        if (newV == '')
                            return
                        if (newV == 'reload') {
                            scope.destroy(elm)
                            scope.init(scope, elm, attrs, config)
                        }
                        scope.status = ''
                    }, true)
                    // 监听-数据模型变化

                    scope.$watch('treeData', function (newV, oldV) {
                        //异步请求无需重构树
                        if (scope.serviceType === 'ajax') {
                            return
                        }
                        if (oldV !== newV && oldV != null) {
                            scope.destroy(elm)
                            scope.treeData = newV
                            scope.init(scope, elm, attrs, config)
                        }
                    }, true)
                    // 监听-配置修改
                    /*scope.$watch('treeConfig', function(n, o) {
                     if (o !== n) {
                     scope.destroy(elm)
                     scope.init(scope, elm, attrs, config)
                     /*if(scope.$parent.$parent){
                     scope.$parent.$parent.treeConfig = n
                     }
                     }
                     }, true)*/
                    // 监听-选中节点
                    scope.$watch('selectedData', function (n, o) {
                        if (o !== n) {
                            //其他操作请参照jstree的API
                            var tree = scope.tree.jstree(true)
                            tree.select_node(n, false, false)
                        }
                    }, true)
                }
            }
            return treeDir
        }

    // other function

    // angularjs code
    var app = angular.module('ngJsTree', []);
    app.controller("jsTreeCtrl", ["$scope", jsTreeCtrl]);
    app.directive("jsTree", ["$log", "$timeout", jsTreeDirective]);
})(angular);
