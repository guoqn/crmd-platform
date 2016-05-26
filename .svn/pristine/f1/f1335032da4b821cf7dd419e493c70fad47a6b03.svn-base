/**
 * 动态配置界面
 *
 * Created by LAIYONGMIN on 2016/4/21.
 */
//命名空间
if (!design) {
    var design = {};
}
//模块
var easyDesignApp = angular.module("easyDesignApp", ["ehDataServiceApp"]);
//控制
easyDesignApp.controller("easyDesignCtrl", ["$scope", "ehDataService", "$timeout", function ($scope, ehDataService, $timeout) {
    // 组件表单对象
    $scope.compForm = {};
    // 模版下拉
    $scope.templSel = {};
    // 组件类型
    $scope.comType = {
        typeData: [{
            id: -1,
            action: '请选择'
        }, {
            id: 0,
            action: '表单（form）'
        }, {
            id: 3,
            action: '层（div）'
        }, {
            id: 4,
            action: '标签（label）'
        }, {
            id: 1,
            action: '输入框'
        }, {
            id: 2,
            action: '下拉框'
        }, {
            id: 5,
            action: '日期输入框'
        }, {
            id: 14,
            action: '数字输入框'
        }, {
            id: 8,
            action: '多选框'
        }, {
            id: 9,
            action: '单选框'
        }, {
            id: 10,
            action: '多行文本输入框'
        }, {
            id: 11,
            action: '按钮'
        }, {
            id: 200,
            action: '虚拟组件（模版使用）'
        }, {
            id: 201,
            action: '构件组件'
        }]
    };
    //初始
    $scope.compForm.componentType = -1;
    $scope.compForm.groupCode = "-1";
    // 加载模版数据
    eh.data.callMethod("qryTplListsByType", {
        templateType: 'wtpl'
    }, function (rt) {
        //初始化
        var option = {};
        option.templateName = "请选择";
        option.templateCode = "-1";
        var options = new Array(1);
        options[0] = option;
        //合并
        $scope.groupCode = $.merge(options, rt.object);
    });
    //更新界面树节点信息
    $scope.updateDesignTree = function () {
        var pageTree = eh.util.getDesignPageTree();
        var selNodes = pageTree.getSelectedNodes();
        if (selNodes != null && selNodes.length > 0) {
            // 当前选中的节点
            var node = selNodes[0];
            node.componentType = $scope.compForm.componentType;
            node.name = $scope.compForm.componentName;
            node.componentName = $scope.compForm.componentName;
            node.componentNo = $scope.compForm.componentNo;
            node.componentExp = $scope.compForm.componentExp;
            node.componentTip = "";
            // 构件不同步
            if ($scope.compForm.componentType != "201") {
                node.groupCode = ffc.util.isEmpty($scope.compForm.groupCode) ? "-1" : $scope.compForm.groupCode;
                //设置模版
                if (!ffc.util.isEmpty(node.groupCode)) {
                    ehDataService.getTpl(node.groupCode, function (rt) {
                        node.tpl = rt.object;
                        $timeout(function () {
                            design.updateNode(node, pageTree);
                        }, 0)
                    })
                } else {
                    design.updateNode(node, pageTree);
                }
            } else {
                design.updateNode(node, pageTree);
            }
        } else {
            MESSAGE_DIALOG.warning("请选择要更新的节点!");
        }
    }
    //提交
    $scope.submitDesignWin = function () {
        var $form = eh.util.getAngular$scope("designCompForm");
        // 界面树
        var pageTree = eh.util.getDesignPageTree();
        if (!pageTree.getNodes()[0].children) {
            MESSAGE_DIALOG.warning("没有可保存的信息!");
            return;
        }
        var tempChilds = new Array(pageTree.getNodes()[0].children.length);
        // 要对其进行深度拷贝，防止改变当前对象影响原来对象的变更。
        $.extend(true, tempChilds, pageTree.getNodes()[0].children);
        // 清除后台不对应的属性
        design.recurseDel(tempChilds);
        design.recurseDel(design.delCompents);
        if (ffc.util.isEmpty($form.type) || ffc.util.isEmpty($form.id)) {
            MESSAGE_DIALOG.warning("保存信息不完整,(type/id为空)!");
            return;
        }
        MESSAGE_DIALOG.loading();
        ehDataService.saveDesignWindow($form.type, $form.id, tempChilds, design.delCompents, function (rt) {
            MESSAGE_DIALOG.alert('保存成功');
            design.initDesignPage();
        });
    }
    //重置
    $scope.reSetDesignTree = function () {
        design.initDesignPage();
    }

}]);

// 递归设置参数
design.recurseDel = function (datas) {
    if (datas && datas.length > 0) {
        for (d in datas) {
            var data = datas[d];
            if (data) {
                design.deleteAttr(data);
                // 不进行模版提交，没有意义
                if (data.tpl) {
                    delete data.tpl;
                }
                if (data.children && data.children.length > 0) {
                    design.recurseDel(data.children);
                }
            }
        }
    }
}
// 提交的时候，controller接受端对象，属性不一致，会报错。
design.deleteAttr = function (data) {
    // 删除属性
    delete data.check_Child_State;
    delete data.check_Focus;
    delete data.checked;
    delete data.checkedOld;
    delete data.chkDisabled;
    delete data.editNameFlag;
    delete data.halfCheck;
    delete data.isAjaxing;
    delete data.isFirstNode;
    delete data.isHover;
    delete data.isLastNode;
    delete data.isParent;
    delete data.nocheck;
    delete data.open;
    delete data.pId;
    delete data.parentTId;
    delete data.tId;
    delete data.zAsync;
    delete data.level;
}

design.updateNode = function (node, pageTree) {
    if (node.componentId != -1) {
        node.opType = "edit";
    }
    pageTree.updateNode(node, false);

    var roots = pageTree.getNodes();
    if (roots && roots.length > 0) {
        var root = roots[0];
        //本地数据界面渲染
        if (typeof(root.children) != 'undefined') {
            $("#pageHtml").winByLocal(root.children[0]);
        }
    }
}

//是否可以移动拷贝
design.isCanDrap = function (treeId, treeNodes, targetNode, moveType) {
//本身，不允许移动拷贝
    if ("baseComp" === treeId || "partComp" == treeId) {
        return false;
    }
};

//布局组件树,配置参数
design.baseCompSetting = {
    // 数据格式
    data: {
        simpleData: {
            enable: true
        }
    },
    // 异步请求
    async: {
        enable: true,
        url: "../data/base-comp.json"
    },
    edit: {
        enable: true,
        showRemoveBtn: false,
        showRenameBtn: false,
        // 拖拽做复制操作
        drag: {
            isCopy: true,
            isMove: false
        }
    },
    callback: {
        beforeDrop: design.isCanDrap
    }

};

//构件树
design.partSetting = {
    // 数据格式
    data: {
        key: {
            name: "componentName",
            id: "componentId"
        }
    },
    // 异步请求
    async: {
        enable: true,
        url: ffc.context.contextPath + "/meta/dynamicPageCtrl/qryParts"
    },
    edit: {
        enable: true,
        showRemoveBtn: false,
        showRenameBtn: false,
        // 拖拽做复制操作
        drag: {
            isCopy: true,
            isMove: false
        }
    },
    callback: {
        beforeDrop: design.isCanDrap
    }
}

//自定义操作
design.selfDomOp = function (treeId, treeNode) {
// 跟节点隐藏删除动作
    if (treeNode.id === 1) {
        $("#" + treeId + "_" + treeNode.id + "_remove").hide();
    }
}
//节点不允许移动为根节点
design.noMoveToRootNode = function (treeId, treeNodes, targetNode, moveType) {
    // 不允许，移动为根节点
    if (targetNode === null) {
        return false;
    }
}
//根节点不允许移动
design.rootNodeNoMove = function (treeId, treeNodes) {
    // 根节点不允许移动
    if (treeNodes) {
        var node = treeNodes[0];
        if (node.id === 1) {
            return false;
        }
    }
}

//界面树点击事件
design.onClickNode = function (event, treeId, treeNode) {
    var $scope = eh.util.getAngular$scope("designCompForm");// jquery+angular实现
    // 设置组件表单式
    $scope.compForm.componentExp = treeNode.componentExp;
    // 组件类型
    if (treeNode.busAttrType) {
        $scope.compForm.componentType = parseInt(treeNode.busAttrType);
    } else {
        $scope.compForm.componentType = parseInt(treeNode.componentType);
    }
    // 编码
    if (treeNode.busAttrCode) {
        $scope.compForm.componentCode = treeNode.busAttrCode;
    } else {
        $scope.compForm.componentCode = treeNode.componentCode;
    }
    // 组件名称
    if (treeNode.busAttrName) {
        $scope.compForm.componentName = treeNode.busAttrName;
    } else {
        $scope.compForm.componentName = treeNode.componentName;
    }
    $scope.compForm.groupCode = ffc.util.isEmpty(treeNode.groupCode) ? "-1" : treeNode.groupCode;
    eh.util.angular$apply($scope);
    design.checkedStyle(treeNode.dynamicStyleDtos);// 勾选样式
}
design.delCompents = [];
//删除操作
design.removeNode = function (event, treeId, treeNode) {

    var pageTree = eh.util.getDesignPageTree();
    var nodes = pageTree.getNodes();
    if (nodes && nodes.length > 0) {
        var root = nodes[0];
        $("#pageHtml").winByLocal(root.children[0]);
    }
    // 暂存删除节点信息
    if (treeNode.componentId != -1) {
        // 没有实际的组件Id，则不缓存
        design.delCompents.push(treeNode);
    }

}

design.changeNode = function (event, treeId, treeNodes, targetNode, moveType) {
    // 目标节点
    if (targetNode === null) {
        return false;
    }
    var pageTree = eh.util.getDesignPageTree();
    var nodes = pageTree.getNodes();
    // 更新移动目标节点
    if (treeNodes) {
        var selNode = treeNodes[0];
        if (selNode.componentId != -1) {
            selNode.opType = 'edit';
        }
        selNode.pComponentId = targetNode.componentId;
        pageTree.updateNode(selNode, false);
    }

    if (nodes && nodes.length > 0) {
        var root = nodes[0];
        $("#pageHtml").winByLocal(root.children[0]);
    }
}

//界面树
design.designSetting = {
    // 数据格式
    data: {
        simpleData: {
            enable: true
        }
    },
    edit: {
        enable: true,
        showRenameBtn: false
    },
    callback: {
        //单击事件
        onClick: design.onClickNode,
        // 移动结束前
        beforeDrop: design.noMoveToRootNode,
        //移动之前
        beforeDrag: design.rootNodeNoMove,
        // 删除节点动作
        onRemove: design.removeNode,
        //移动结束
        onDrop: design.changeNode
    },
    view: {
        addHoverDom: design.selfDomOp
    }
}

//设计界面根节点
design.designRootNode = [
    {
        id: 1,
        pId: 0,
        drag: false,
        name: "HTML"
    }
]
//记录当前选中的样式
design.styleNodes = [];

//校验

design.onCheck = function (e, treeId, treeNode) {
    // 获取样式树
    var pageTree = eh.util.getDesignPageTree();
    if (pageTree) {
        var nodes = pageTree.getSelectedNodes();
        if (nodes && nodes.length > 0) {
            var node = nodes[0];
            var styles = typeof (node.dynamicStyleDtos) === "undefined" ? node.dynamicStyleDtos = [] : node.dynamicStyleDtos;
            var checkedOld = design.checkedOld(design.styleNodes, treeNode, node);
            if (node && checkedOld === false && treeNode.checked === true) {
                // 新增样式
                var styles = (styles && styles.length > 0) ? styles : [];
                var addStyle = {
                    componentId: node.componentId,// 组件
                    relaStyleId: treeNode.styleId,
                    styleAttr: treeNode.styleAttr,//
                    styleAttrValue: treeNode.styleAttrValue,
                    styleType: treeNode.styleType,
                    opType: 'add'
                }
                node.dynamicStyleDtos.push(addStyle);
                pageTree.updateNode(node, false);
            } else if (node && checkedOld === false && treeNode.checked === false) {
                // 直接清除json
                if (styles && styles.length > 0) {
                    for (t in styles) {
                        if (styles[t].relaStyleId === treeNode.styleId) {
                            node.dynamicStyleDtos.splice(t, 1);
                            pageTree.updateNode(node, false);
                            break;// 退出循环
                        }
                    }
                }
            } else if (node && checkedOld === true && treeNode.checked === false) {
                // 删除样式
                var styles = node.dynamicStyleDtos;
                if (styles && styles.length > 0) {
                    for (t in styles) {
                        if (styles[t].relaStyleId === treeNode.styleId) {
                            node.dynamicStyleDtos[t].opType = 'del'
                            pageTree.updateNode(node, false);
                            break;// 退出循环
                        }
                    }
                }
            } else if (node && checkedOld === true && treeNode.checked === true) {
                // 恢复原状，删除状态
                if (styles && styles.length > 0) {
                    for (t in styles) {
                        if (styles[t].relaStyleId === treeNode.styleId) {
                            delete node.dynamicStyleDtos[t].opType;
                            pageTree.updateNode(node, false);
                            break;// 退出循环
                        }
                    }
                }
            }

        }
        var roots = pageTree.getNodes();
        if (roots && roots.length > 0) {
            var root = roots[0];
            //本地数据界面渲染
            if (typeof(root.children) != 'undefined') {
                $("#pageHtml").winByLocal(root.children[0]);
            }
        }
    }
}

//选中
design.checkedStyle = function (styles) {
    // 获取样式树
    var tree = eh.util.getDesignStyleTree();
    if (tree) {
        // 清空
        design.styleNodes = [];
        // 取消选中
        tree.checkAllNodes(false);
        // 获取存在的样式
        if (styles != null && styles.length > 0) {
            for (var t in styles) {
                // 查询勾选节点
                var node = tree.getNodeByParam("id", parseInt(styles[t].relaStyleId));
                if (node) {
                    tree.checkNode(node, true, false);
                    design.styleNodes[styles[t].componentId + "-" + node.id] = node.id;
                }
            }
        }
    }
}


// 原来是否是选中
design.checkedOld = function (source, treeNode, node) {
    if (source) {
        if (source[node.id + "-" + treeNode.styleId] === treeNode.styleId) {
            return true;
        }
    }
    return false;
}
//设计界面样式

design.styleSetting = {
    check: {
        enable: true,
        // 都不关联
        chkboxType: {
            "Y": "",
            "N": ""
        },
        chkStyle: "checkbox"
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        onCheck: design.onCheck
    }
}
//获取配置数据加载...
design.initDesignPage = function () {
    var $scope = eh.util.getAngular$scope("designCompForm");
    var id = eh.util.getUrlParam("id");
    var type = eh.util.getUrlParam("type");
    //存在的时候
    if (!ffc.util.isEmpty("type")) {
        $scope.id = id;
        $scope.type = type;
        design.loadDesignData(id, type);
    }

}
//加载
design.loadDesignData = function (id, type) {
    var ehDataServiceApp = angular.injector(["ehDataServiceApp", "ng"]);
    ehDataServiceApp.invoke(['ehDataService', function (ehDataService) {
        MESSAGE_DIALOG.loading();
        ehDataService.getDesignWindow(type, id, function (rt) {
            if (rt.result) {
                MESSAGE_DIALOG.close();
                var pageTree = eh.util.getDesignPageTree();
                var nodes = pageTree.getNodes();
                if (nodes.length > 0) {
                    // 清除当前所有孩子节点
                    pageTree.removeChildNodes(nodes[0]);
                    if (rt.object && rt.object.componentDto) {
                        pageTree.addNodes(nodes[0], rt.object.componentDto);
                        pageTree.expandAll(true);
                        $("#pageHtml").winByLocal(rt.object.componentDto);
                    } else {
                        pageTree.removeChildNodes(nodes[0]);
                        $("#pageHtml").html("");
                    }
                }
            } else {
                MESSAGE_DIALOG.error(rt.detailMsg);
            }
        });
    }]);
}

$(function () {
    //布局初始化
    $.fn.zTree.init($("#baseComp"), design.baseCompSetting);
    //构件
    $.fn.zTree.init($("#partComp"), design.partSetting);
    //界面树
    $.fn.zTree.init($("#designPage"), design.designSetting, design.designRootNode);
    //样式
    // 一次加载所有配置节点
    eh.data.callMethod("qryAllStyleTreeData", {
        //参数
    }, function (rt) {
        // 样式树初始化
        $.fn.zTree.init($("#designStyle"), design.styleSetting, rt.object);
    });
    //界面数据初始化
    design.initDesignPage();
});
