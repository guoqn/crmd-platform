/**
 * Created by FFCS-CAIWL on 2015/12/8.
 */
(function (angular) {
    'use strict'

    /**
     * 指令
     * @param $timeout
     * @returns {{restrict: string, scope: {config: string}, controller: string, link: dir.link, transclude: boolean, template: string}}
     */
    function ngPopoverDir($timeout) {
        var dir = {
            restrict: 'A',
            scope: {
                /**
                 * config中的参数
                 * @param selector: 选择器
                 * @param target: popover内容对象
                 * @param title: 标题
                 * @param status: 状态操作  [init, ok, err]
                 * @param initFunc: 初始化
                 * @param callb: 回调函数
                 * @param version: 版本号
                 */
                config: '=ngPopover'
            },
            controller: 'popoverCtrl',
            link: function (scope, elm, attrs, crtl) {
                //监听模型
                scope.$watch('config.status', function (newV, oldV) {
                    //if (typeof newV === 'string') {
                    if (newV == 'reset')
                        return
                    if (newV == 'init') {
                        init(scope, elm, attrs)
                    } else {
                        redraw(newV, scope, elm)
                    }
                    //重置
                    scope.config.status = 'reset'
                }, true)
            },
            transclude: true,
            template: createHtml()
        }
        return dir
    }

    /**
     * 指令模版
     * @returns {string}
     */
    function createHtml() {
        return "<div class='diyPopover popover' role='tooltip'>" +
            "<div class ='arrow'></div>" +
            "<h3 class='popover-title'></h3>" +
            "<div class='popover-content' ng-transclude></div>" +
            "<div class='popover-info'></div>" +
            "</div>"
    }

    /**
     * 初始化
     * @param scope
     * @param elm
     * @param attrs
     */
    function init(scope, elm, attrs) {
        //对选择器进行
        var obj = $(scope.config.selector)
        createPopObj(obj, scope, elm)
        //加监听
        addPopObjEvents(scope, elm)
        scope.version = scope.config.version
    }

    /**
     * 执行前处理
     * @param source
     * @param elm
     * @param scope
     */
    function beforeHandler(source, elm, scope) {
        elm.removeClass('fade in top bottom left right')
        elm.find('div.diyPopover').css({
            'display': 'block',
            'max-width': 'none'
        })
        //标题处理
        var _title = scope.config.title ? scope.config.title : source.text()
        elm.find('.popover-title').text(_title)
        //内容
        elm.find('.popover-content').hide()
        //提示信息
        elm.find('.popover-info').text(scope.config.msg ? scope.config.msg : scope.msgInfo).show()
        executePosition(source, elm, scope)
    }

    /**
     * 重新渲染
     * @param newV
     * @param oldV
     * @param scope
     * @param elm
     */
    function redraw(newV, scope, elm) {
        //执行对象的版本要一致
        if (!scope.actor) return
        if (newV == 'ok') {
            elm.find('.popover-content').show()
            elm.find('.popover-info').hide()
            executePosition(scope.actor, elm, scope)
        } else if (newV === 'err') {
            elm.find('.popover-content').hide()
            elm.find('.popover-info').text(scope.config.errMsg ? scope.config.errMsg : scope.errMsg).show()
            executePosition(scope.actor, elm, scope)
        }
    }

    function createPopObj(obj, scope, elm) {
        var t1, t2
        if (obj.length > 1) {
            //obj = obj.slice()
            for (t1 = 0, t2 = obj.length; t1 < t2; t1++) {
                createPopObj($(obj[t1]), scope, elm)
            }
        } else {
            //attr、data处理
            obj.attr({'diy-popover': 'popover'})
            return true
        }
    }


    /**
     * 添加需要弹出的对象事件
     * @param scope
     * @param elm
     */
    function addPopObjEvents(scope, elm) {
        removePopoverListener(scope, elm)
        var selectors = $(scope.config.selector)
        var _target = $(scope.config.target)
        if (selectors && _target && selectors.length >= 0 && _target.length == 1) {
            selectors.on('click.' + scope.config.target, function (e) {
                e.stopPropagation()
                selectors.removeClass('popover-active')
                scope.actor = $(this).addClass('popover-active');
                beforeHandler($(this), elm, scope)
                popoverHandler($(this), elm, scope)
            })
            $(document).on('click.' + scope.config.target, function (event) {
                var clickObj = $(event.target)
                if ((elm.prop('outerHTML').indexOf(clickObj.prop('outerHTML'))) == -1) {
                    elm.find('div.diyPopover').hide()
                    selectors.removeClass('popover-active')
                }
            })
        }
    }

    /**
     * 移除事件
     * @param scope
     * @param elm
     */
    function removePopoverListener(scope, elm) {
        var _sels = $(scope.config.selector)
        _sels.off('click.divPop')
        $(document).off('click.divPop')
    }

    function popoverHandler(obj, elm, scope) {
        var $tip = elm.find('div.diyPopover')
        //2、执行函数并更新模型
        scope.$apply(function () {
            scope.config.executeHandler(obj, $tip)
        })
    }

    /**
     * 位置属性的处理
     * @param obj
     * @param elm
     * @param scope
     */
    function executePosition(obj, elm, scope) {
        var $tip = elm.find('div.diyPopover')
        var placement = typeof scope.placement == 'function' ?
            scope.placement.call(this, obj, $tip) :
            scope.placement
        var autoToken = /\s?auto?\s?/i
        var autoPlace = autoToken.test(placement)
        if (autoPlace) placement = placement.replace(autoToken, '') || 'top'
        $tip.css({top: -10000, left: -10000, display: 'block'}).addClass(placement)

        var pos = getPosition(obj)
        var actualWidth = $tip[0].offsetWidth
        var actualHeight = $tip[0].offsetHeight

        if (autoPlace) {
            var orgPlacement = placement
            var viewportDim = getPosition($('body'))
            placement = placement == 'bottom' && pos.bottom + actualHeight > viewportDim.bottom ? 'top' :
                placement == 'top' && pos.top - actualHeight < viewportDim.top ? 'bottom' :
                    placement == 'right' && pos.right + actualWidth > viewportDim.width ? 'left' :
                        placement == 'left' && pos.left - actualWidth < viewportDim.left ? 'right' :
                            placement
            $tip.removeClass(orgPlacement).addClass(placement)
        }
        var calculatedOffset = getCalculatedOffset(placement, pos, actualWidth, actualHeight)
        applyPlacement(calculatedOffset, placement, obj, $tip)
    }

    /**
     * 使用位置
     * @param offset
     * @param placement
     * @param obj
     * @param target
     */
    function applyPlacement(offset, placement, obj, target) {
        var $tip = target
        var width = $tip[0].offsetWidth
        var height = $tip[0].offsetHeight

        // manually read margins because getBoundingClientRect includes difference
        var marginTop = parseInt($tip.css('margin-top'), 10)
        var marginLeft = parseInt($tip.css('margin-left'), 10)

        // we must check for NaN for ie 8/9
        if (isNaN(marginTop))  marginTop = 0
        if (isNaN(marginLeft)) marginLeft = 0

        offset.top += marginTop
        offset.left += marginLeft

        // $.fn.offset doesn't round pixel values
        // so we use setOffset directly with our own function B-0
        $.offset.setOffset($tip[0], $.extend({
            using: function (props) {
                $tip.css({
                    top: Math.round(props.top),
                    left: Math.round(props.left)
                })
            }
        }, offset), 0)

        $tip.addClass('in')

        // check to see if placing tip in new offset caused the tip to resize itself
        var actualWidth = $tip[0].offsetWidth
        var actualHeight = $tip[0].offsetHeight

        if (placement == 'top' && actualHeight != height) {
            offset.top = offset.top + height - actualHeight
        }

        var delta = getViewportAdjustedDelta(placement, offset, actualWidth, actualHeight)

        if (delta.left) offset.left += delta.left
        else offset.top += delta.top

        var isVertical = /top|bottom/.test(placement)
        var arrowDelta = isVertical ? delta.left * 2 - width + actualWidth : delta.top * 2 - height + actualHeight
        var arrowOffsetPosition = isVertical ? 'offsetWidth' : 'offsetHeight'

        $tip.offset(offset)
        replaceArrow($tip, offset, arrowDelta, $tip[0][arrowOffsetPosition], isVertical)
    }

    /**
     * 指向箭头的位置更新
     * @param tip
     * @param delta
     * @param dimension
     * @param isVertical
     */
    function replaceArrow(tip, offset, delta, dimension, isVertical) {
        tip.find('div.arrow')
            .css(isVertical ? 'left' : 'top', 50 * (1 - delta / dimension) + '%')
            .css(isVertical ? 'top' : 'left', '')
    }

    /**
     * 展示窗口调整
     * @param placement
     * @param pos
     * @param actualWidth
     * @param actualHeight
     * @returns {{top: number, left: number}}
     */
    function getViewportAdjustedDelta(placement, pos, actualWidth, actualHeight) {
        var delta = {top: 0, left: 0}
        var $viewport = $('body')
        if (!$viewport) return delta

        var viewportPadding = 0
        var viewportDimensions = getPosition($viewport)

        if (/right|left/.test(placement)) {
            var topEdgeOffset = pos.top - viewportPadding - viewportDimensions.scroll
            var bottomEdgeOffset = pos.top + viewportPadding - viewportDimensions.scroll + actualHeight
            if (topEdgeOffset < viewportDimensions.top) { // top overflow
                delta.top = viewportDimensions.top - topEdgeOffset
            } else if (bottomEdgeOffset > viewportDimensions.top + viewportDimensions.height) { // bottom overflow
                delta.top = viewportDimensions.top + viewportDimensions.height - bottomEdgeOffset
            }
        } else {
            var leftEdgeOffset = pos.left - viewportPadding
            var rightEdgeOffset = pos.left + viewportPadding + actualWidth
            if (leftEdgeOffset < viewportDimensions.left) { // left overflow
                delta.left = viewportDimensions.left - leftEdgeOffset
            } else if (rightEdgeOffset > viewportDimensions.right) { // right overflow
                delta.left = viewportDimensions.left + viewportDimensions.width - rightEdgeOffset
            }
        }
        return delta
    }

    /**
     * 对到对象的位置属性
     * @param $element
     * @returns {void|*}
     */
    function getPosition($element) {
        var el = $element[0]
        var isBody = el.tagName == 'BODY'

        var elRect = el.getBoundingClientRect()
        if (elRect.width == null) {
            // width and height are missing in IE8, so compute them manually see https://github.com/twbs/bootstrap/issues/14093
            elRect = $.extend({}, elRect, {width: elRect.right - elRect.left, height: elRect.bottom - elRect.top})
        }
        var elOffset = isBody ? {top: 0, left: 0} : $element.offset()
        var scroll = {scroll: isBody ? document.documentElement.scrollTop || document.body.scrollTop : $element.scrollTop()}
        var outerDims = isBody ? {width: $(window).width(), height: $(window).height()} : null
        var _position = $.extend({}, elRect, scroll, outerDims, elOffset)
        return _position
    }

    /**
     * 计算坐标
     * @param placement
     * @param pos
     * @param actualWidth
     * @param actualHeight
     * @returns {*}
     */
    function getCalculatedOffset(placement, pos, actualWidth, actualHeight) {
        return placement == 'bottom' ? {top: pos.top + pos.height, left: pos.left + pos.width / 2 - actualWidth / 2} :
            placement == 'top' ? {top: pos.top - actualHeight, left: pos.left + pos.width / 2 - actualWidth / 2} :
                placement == 'left' ? {top: pos.top + pos.height / 2 - actualHeight / 2, left: pos.left - actualWidth} :
                    /* placement == 'right' */ {
                    top: pos.top + pos.height / 2 - actualHeight / 2,
                    left: pos.left + pos.width
                }
    }

    /**
     * 指令控制层
     * @param $scope
     */
    function popoverCtrl($scope) {
        $scope.config.version = $scope.config.version ? $scope.config.version : 1
        $scope.msgInfo = $scope.config.msg ? $scope.config.msg : '正在加载数据......,请稍等....'
        $scope.errMsg = $scope.config.errMsg ? $scope.config.errMsg : '查询出错了!'
        $scope.placement = $scope.config.placement ? $scope.config.placement : 'top'
    }

    var app = angular.module('ngPopover', [])
    app.controller('popoverCtrl', ['$scope', popoverCtrl])
    app.directive('ngPopover', ['$timeout', ngPopoverDir])

})(angular)
