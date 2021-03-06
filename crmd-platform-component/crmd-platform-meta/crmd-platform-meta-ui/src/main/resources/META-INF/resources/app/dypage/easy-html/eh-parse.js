/**
 * JSON2HTML
 *
 * HMTL解析器
 *
 * @author LAIYONGMIN-PC
 */

// HMTL解析器
if (!eh) {
    var eh = {};
}
if (!eh.parse) {
    eh.parse = {};
}

// 组件取值类型
eh.parse.compType = {};
eh.parse.compType["1"] = "input";
eh.parse.compType["2"] = "select";
eh.parse.compType["5"] = "dateinput";
eh.parse.compType["8"] = "checkbox";
eh.parse.compType["9"] = "radio";
eh.parse.compType["10"] = "textarea";
eh.parse.compType["14"] = "numberinput";
// 返回对象
eh.parse.compValue = {};

// 获取结果集
eh.parse.createHtml = function (result) {
    // 获取根组件
    return eh.parse.parse2HTML(eh.parse.getRootComp(result));
}

// 获取根组件-结果集
eh.parse.getRootComp = function (result) {
    if (result && result.object) {
        // 获取更组件
        return result.object.componentDto;
    }
}

// 递归解析 每个组件对象
eh.parse.parse2HTML = function (cdata) {
    var html = "";
    if (cdata) {
        // 模版
        if (cdata.groupCode && cdata.componentType != '201') {
            if (cdata.tpl && typeof (cdata.tpl) != 'undefined') {
                var tpl = cdata.tpl.componentDto;
                // 替换为模版
                if (tpl && tpl.children && tpl.children.length > 0) {
                    // 替换为模版
                    var tTpl = {};
                    $.extend(tTpl, tpl);
                    var tData = {};
                    $.extend(tData, cdata);
                    // 清除模版
                    delete tData.tpl;
                    delete tData.groupCode;
                    html += eh.parse.createCompHtml(eh.parse.tplHtml(tTpl, tData));
                } else {
                    // 样式模版
                    if (tpl.componentType === '200') {
                        eh.parse.tplStyle(tpl, cdata);
                    }
                    html += eh.parse.createCompHtml(cdata);
                }
            }
            /*
             * else { html += eh.parse.createCompHtml(cdata); }
             */
        } else if (cdata.groupCode && cdata.componentType === '201') {
            if (cdata.part && typeof (cdata.part) != 'undefined') {
                var part = cdata.part.componentDto;
                html += eh.parse.createCompHtml(part);
            }
        } else {
            html += eh.parse.createCompHtml(cdata);
        }
        /*
         * // 是否存在模版 if (cdata.tpl && typeof (cdata.tpl) != 'undefined') { var
         * tpl = cdata.tpl.componentDto; // 替换为模版 if (tpl && tpl.children &&
         * tpl.children.length > 0) { // 替换为模版 var tTpl = {}; $.extend(tTpl,
         * tpl); var tData = {}; $.extend(tData, cdata); // 清除模版 delete
         * tData.tpl; html += eh.parse.createCompHtml(eh.parse.tplHtml(tTpl,
         * tData)); } else { // 样式模版 if (tpl.componentType === '200') {
         * eh.parse.tplStyle(tpl, cdata); } html +=
         * eh.parse.createCompHtml(cdata); } } else { html +=
         * eh.parse.createCompHtml(cdata); }
         */
    }
    return html;
}
// 解析模版html
eh.parse.tplHtml = function (tTpl, tData) {
    // 组件名称
    if (tData.busAttrName) {
        tTpl.componentName = tData.busAttrName;
    } else {
        tTpl.componentName = tData.componentName;
    }
    // 编码
    if (tData.busAttrCode) {
        tTpl.busAttrCode = tData.busAttrCode;
    } else {
        tTpl.busAttrCode = tData.componentCode;
    }
    $.each(tTpl.children, function (i, v) {
        if (v.componentType === '200') {
            $.extend(true, v, tData);
        } else {
            // 递归查找
            eh.parse.tplHtml(v, tData);
        }
        if (tData.busAttrCode) {
            v.busAttrCode = tData.busAttrCode;
        } else {
            v.busAttrCode = tData.componentCode;
        }
        // 组件名称
        if (tData.busAttrName) {
            v.componentName = tData.busAttrName;
        } else {
            v.componentName = tData.componentName;
        }
    });
    return tTpl;
}
// 解析模版样式
eh.parse.tplStyle = function (tpl, cdata) {
    // 默认复制样式-模版替换，不再次进行持久化操作
    $.each(tpl.dynamicStyleDtos, function (i, v) {
        // 模版拷贝-来源
        v.opType = 'tpl';
        if (cdata && cdata.dynamicStyleDtos && cdata.dynamicStyleDtos.length > 0) {
            $.each(cdata.dynamicStyleDtos, function (i, cv) {
                // 新增不存在的模版样式
                if (v.relaStyleId != cv.relaStyleId) {
                    cdata.dynamicStyleDtos.push(v);
                }
            });
        } else {
            // 本身不配置样式，则直接新增
            if ("undefined" === typeof(cdata.dynamicStyleDtos)) {
                cdata.dynamicStyleDtos = [];
            }
            cdata.dynamicStyleDtos.push(v);
        }
    })
}

// 创建每个组件HTML片段
eh.parse.createCompHtml = function (cdata) {
    var html = "";
    var cType = parseInt(cdata.componentType);
    // 创建每个组件
    switch (cType) {
        case 0:
            html = eh.parse.createForm(cdata);
            break;
        case 1:
            html = eh.parse.createInput(cdata);
            break;
        case 2:
            html = eh.parse.createSelect(cdata);
            break;
        case 3:
            html = eh.parse.createDiv(cdata);
            break;
        case 4:
            html = eh.parse.createLabel(cdata);
            break;
        case 5:
            html = eh.parse.createDateInput(cdata);
            break;
        case 6:
            html = eh.parse.createPassword(cdata);
            break;
        case 7:
            html = eh.parse.createSpan(cdata);
            break;
        case 8:
            html = eh.parse.createCheckbox(cdata);
            break;
        case 9:
            html = eh.parse.createRadiobox(cdata);
            break;
        case 10:
            html = eh.parse.createTextarea(cdata);
            break;
        case 11:
            html = eh.parse.createButton(cdata);
            break;
        case 12:
            html = eh.parse.createUl(cdata);
            break;
        case 13:
            html = eh.parse.createLi(cdata);
            break;
        case 14:
            html = eh.parse.createNumberInput(cdata);
            break;
        default:
            break;
    }
    return html;
}

// 创建每个主键STYLE样式
eh.parse.createStyle = function (c) {
    var style = eh.style.parseConfStyle(c.dynamicStyleDtos);
    return typeof (style) == 'undefined' ? '' : style;
}

// form 表单 (布局节点)
eh.parse.createForm = function (c) {
    var html = '<form ' + eh.parse.createStyle(c) + ' >';
    var cc = c.children;
    if (cc != null && cc.length > 0) {
        for (t in cc) {
            html += eh.parse.parse2HTML(cc[t]);
        }
    }
    html += '</form>';
    return html;
}

// div 层(布局节点)
eh.parse.createDiv = function (c) {
    var html = '<div ' + eh.parse.createStyle(c) + ' >';
    var cc = c.children;
    if (cc != null && cc.length > 0) {
        for (t in cc) {
            html += eh.parse.parse2HTML(cc[t]);
        }
    }
    html += '</div>';
    return html;
}
// tag id->code
eh.parse.createTagId = function (c) {
    return c.busAttrCode;
}

// input 输入框
eh.parse.createInput = function (c) {
    var html = '';
    var tip = typeof (c.componentTip) === 'undefined' ? "" : c.componentTip;
    html += '<input ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" type="text"  placeholder="' + tip + '"/>';
    return html;
}
// label
eh.parse.createLabel = function (c) {
    var html = '';
    html += '<label ' + eh.parse.createStyle(c) + ' for="' + eh.parse.createTagId(c) + '">';
    var cc = c.children;
    if (cc != null && cc.length > 0) {
        html += '' + c.componentName + ':</label>';
        var cc = c.children;
        if (cc != null && cc.length > 0) {
            for (t in cc) {
                html += eh.parse.parse2HTML(cc[t]);
            }
        }
    } else {
        html += c.componentName + '</label>';
    }
    return html;
}
// input type='password' 密码框
eh.parse.createPassword = function (c) {
    var html = '';
    html += '<input ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" type="password" "/>';
    return html;
}
// span 标签
eh.parse.createSpan = function (c) {
    var html = '';
    html += '<span ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" >' + c.componentName + '</span>';
    return html;
}
// 多选 checkbox
eh.parse.createCheckbox = function (c) {
    var html = '';
    html += '<input type="checkbox" ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" value="1">  ' + c.componentName + '';
    return html;
}
// 单选 radiobox
eh.parse.createRadiobox = function (c) {
    var html = "";
    /*
     * var html = ''; html += '<input type="radio" name="' + c.busAttrCode + '" ' +
     * eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '"
     * value="1"> ' + c.componentName + '';
     */
    // 多个单选
    var attrValues = c.attrValueDtos;
    if (attrValues && attrValues.length > 0) {
        for (var a = 0; a < attrValues.length; a++) {
            var atv = attrValues[a];
            html += '<input name="' + c.busAttrCode + '" ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" value="'
                + atv.attrValue + '">' + atv.attrValueName + '</input>';
        }
    }
    return html;
}
// 多行文本输入框 textarea
eh.parse.createTextarea = function (c) {
    var html = '';
    html += '<textarea ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" rows="' + c.componentRows + '" clos="' + c.componentClos
        + '" placeholder="' + c.componentName + '"/>';
    return html;
}
// 下拉框 select
eh.parse.createSelect = function (c) {
    var html = '';
    html += ' <select ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '">';
    // 下拉值
    var attrValues = c.attrValueDtos;
    if (attrValues && attrValues.length > 0) {
        html += '<option id="option_0_0" value="" selected="selected">请选择</option>';
        for (var a = 0; a < attrValues.length; a++) {
            var atv = attrValues[a];
            html += '<option id="option_' + eh.parse.createTagId(c) + '_' + atv.attrValueId + '" value="' + atv.attrValue + '">' + atv.attrValueName
                + '</option>'
        }
    }
    html += '</select>'
    return html;
}
// 时间输入框
eh.parse.createDateInput = function (c) {
    // html
    var html = '<input ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" placeholder="' + c.componentName + '" type="text" />';
    // 初始脚本
    eh.script.setDataCache(eh.parse.createTagId(c), function () {
        $("#" + eh.parse.createTagId(c)).datetimepicker({
            // 格式化
            format: typeof (c.componentExp) === "undefined" ? "yyyy-MM-dd" : c.componentExp,
            // 图片
            dateIcon: 'glyphicon glyphicon-calendar'
        });
    })
    return html;
}
// 按钮
eh.parse.createButton = function (c) {
    var html = '<button type="button" ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '">' + c.componentName + '</button>'
    return html;
}
// ui
eh.parse.createUl = function (c) {
    var html = '<ul ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '">';
    var cc = c.children;
    if (cc != null && cc.length > 0) {
        for (t in cc) {
            html += eh.parse.parse2HTML(cc[t]);
        }
    }
    html += '</ul>'
    return html;
}
// li
eh.parse.createLi = function (c) {
    var html = '<li ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '">' + c.componentName + '</li>'
    return html;
}
// 数字输入
eh.parse.createNumberInput = function (c) {
    var html = '';
    var tip = typeof (c.componentTip) === 'undefined' ? "" : c.componentTip;
    html += '<input ' + eh.parse.createStyle(c) + ' id="' + eh.parse.createTagId(c) + '" type="text" value="0"  placeholder="' + tip
        + '" onblur="eh.util.isNumber(this,' + (typeof (c.componentExp) === 'undefined' ? "''" : '' + c.componentExp + '') + ')"/>';
    return html;
}
// :::::::::::::::::::::::::::::::::数据获取::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
// 获取界面值对象
eh.parse.getHtmlValue = function (result) {
    eh.parse.vResult = [];
    var root = eh.parse.getRootComp(result);
    //校验
    eh.parse.validate(root.children);
    //验证结果
    if (eh.parse.vResult && eh.parse.vResult.length > 0) {
        MESSAGE_DIALOG.warning("请把必填数据补充完整!");
        return;
    }
    return eh.parse.recursionGetComp(root.children);
}
// 递归组件
eh.parse.recursionGetComp = function (datas) {
    for (var i in datas) {
        var d = datas[i];
        if (d.componentType in eh.parse.compType) {
            eh.parse.compValue[d.busAttrCode] = eh.parse.getCompValue(d);
        }
        var cc = d.children;
        if (cc != null && cc.length > 0) {
            eh.parse.recursionGetComp(cc);
        }
    }
    return eh.parse.compValue;
}
//校验结果
eh.parse.vResult = [];

// 获取每个组件值
eh.parse.getCompValue = function (cdata) {
    var value = null;
    var cType = parseInt(cdata.componentType);
    switch (cType) {
        case 1:
            value = eh.parse.getInputValue(cdata);
            break;
        case 2:
            value = eh.parse.getSelectValue(cdata);
            break;
        case 5:
            value = eh.parse.getDateInputValue(cdata);
            break;
        case 8:
            value = eh.parse.getCheckboxValue(cdata);
            break;
        case 9:
            value = eh.parse.getRadioValue(cdata);
            break;
        case 10:
            value = eh.parse.getTextareaValue(cdata);
            break;
        case 14:
            value = eh.parse.getNumberInputValue(cdata);
            break;
        default:
            break;
    }
    return value;
}
//校验
eh.parse.validate = function (datas) {
    for (var i in datas) {
        var d = datas[i];
        if (d.componentType in eh.parse.compType) {
            var value = eh.parse.getCompValue(d);
            if ((d.attrSpecDto && "0" === d.attrSpecDto.isNullable) && (ffc.util.isEmpty(value) || "-1" === value)) {
                eh.parse.vResult.push(false);
                $("#" + eh.parse.createTagId(d)).addClass("error");
            } else {
                $("#" + eh.parse.createTagId(d)).removeClass("error");
            }
        }
        var cc = d.children;
        if (cc != null && cc.length > 0) {
            eh.parse.validate(cc);
        }
    }
}

// 获取输入框
eh.parse.getInputValue = function (c) {
    return $("#" + eh.parse.createTagId(c)).val();
}
// 下拉框值
eh.parse.getSelectValue = function (c) {
    return $("#" + eh.parse.createTagId(c)).val();
}
// 日期
eh.parse.getDateInputValue = function (c) {
    return $("#" + eh.parse.createTagId(c)).val();
}

// 获取radio单选$('input:radio[name="xxx"]:checked').val();
eh.parse.getRadioValue = function (c) {
    return $('input:radio[name="' + c.busAttrCode + '"]:checked').val();
}

// 获取checkBox多选框
eh.parse.getCheckboxValue = function (c) {
    // 目前配置，支持配置一个多选宽
    $("input[id='" + c.busAttrCode + "']:checkbox").each(function () {
        // 有选中则为true
        // TODO;如果要返回选中的值，则需改造
        if ($(this).attr("checked")) {
            return true;
        }
    });
    return false;
}
// 多行文本框
eh.parse.getTextareaValue = function (c) {
    return $("#" + eh.parse.createTagId(c)).val();
}

// 获取数字输入框
eh.parse.getNumberInputValue = function (c) {
    return $("#" + eh.parse.createTagId(c)).val();
}

// :::::::::::::::::::::::::::::::::数据获取::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

// :::::::::::::::::::::::::::::::::数据设置::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

// 获取界面值对象
/**
 * {key:value}
 *
 * @param orig
 *            源数据对象
 */
eh.parse.setHtmlValue = function (result, orig) {
    var root = eh.parse.getRootComp(result);
    return eh.parse.recursionSetComp(root.children, orig);
}

// 清空界面对象值
eh.parse.clearHtmlValue = function (result) {
    var root = eh.parse.getRootComp(result);
    return eh.parse.recursionClearComp(root.children);
}

// 递归组件
eh.parse.recursionClearComp = function (datas) {
    for (i in datas) {
        var d = datas[i];
        if (d.componentType in eh.parse.compType) {
            // if (orig) {
            // for (key in orig) {
            // 设置为空
            eh.parse.setCompValue(d, "");
            // }
            // }
        }
        var cc = d.children;
        if (cc != null && cc.length > 0) {
            eh.parse.recursionClearComp(cc);
        }
    }
}
// 递归组件
eh.parse.recursionSetComp = function (datas, orig) {
    for (i in datas) {
        var d = datas[i];
        if (d.componentType in eh.parse.compType) {
            if (orig) {
                for (key in orig) {
                    // 不存在属性值，设置为空
                    if (d.busAttrCode === key) {
                        eh.parse.setCompValue(d, typeof (orig[key]) === 'undefiend' ? "" : orig[key]);
                    }
                }
            }
        }
        var cc = d.children;
        if (cc != null && cc.length > 0) {
            eh.parse.recursionSetComp(cc, orig);
        }
    }
}

// ::::::::::::::::::::::::::::::::::数据设置:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
// 设置每个组件值
eh.parse.setCompValue = function (cdata, value) {
    var cType = parseInt(cdata.componentType);
    switch (cType) {
        case 1:
            eh.parse.setInputValue(cdata, value);
            break;
        case 2:
            eh.parse.setSelectValue(cdata, value);
            break;
        case 5:
            eh.parse.setDateInputValue(cdata, value);
            break;
        case 8:
            value = eh.parse.setCheckboxValue(cdata, value);
            break;
        case 9:
            value = eh.parse.setRadioValue(cdata, value);
            break;
        case 10:
            value = eh.parse.setTextareaValue(cdata, value);
            break;
        case 14:
            value = eh.parse.setNumberInputValue(cdata, value);
            break;
        default:
            break;
    }
}

// 设置input
eh.parse.setInputValue = function (c, value) {
    $("#" + eh.parse.createTagId(c)).val(value);
}
// 设置下拉
eh.parse.setSelectValue = function (c, value) {
    $("#" + eh.parse.createTagId(c)).val(value);
}
// 设置日期输入框
eh.parse.setDateInputValue = function (c, value) {
    $("#" + eh.parse.createTagId(c)).val(value);
}
// 设置日期输入框
eh.parse.setTextareaValue = function (c, value) {
    $("#" + eh.parse.createTagId(c)).val(value);
}
// 设置日期输入框
eh.parse.setNumberInputValue = function (c, value) {
    $("#" + eh.parse.createTagId(c)).val(value);
}
// 单选 $("input[type=‘radio’][name=sex][value=‘1’]").attr("checked",true);
eh.parse.setRadioValue = function (c, value) {
    if (value) {
        $("input[type='radio'][name='" + c.busAttrCode + "'][value='" + value + "']").attr("checked", true);
    } else {
        $("input[type='radio'][name='" + c.busAttrCode + "']").removeAttr('checked');
    }
}
// 多选
eh.parse.setCheckboxValue = function (c, value) {
    if (value) {
        $("[id='" + c.busAttrCode + "']").attr("checked", true);// 选中
    } else {
        $("[id='" + c.busAttrCode + "']").attr("checked", false);// 不选中
    }
}