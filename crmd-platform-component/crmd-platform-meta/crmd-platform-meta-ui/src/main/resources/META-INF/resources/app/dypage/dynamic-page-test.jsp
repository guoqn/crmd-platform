<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.ffcs.crmd.platform.control.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>动态界面</title>
    <style type="text/css">

        .error {
            border: 1px solid red
        }
    </style>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-body">
        <div id="div"></div>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-body">
        <div id="div2"></div>
    </div>
</div>

<div>

    <button id="ddd">保存</button>
</div>

<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>

<!-- 压缩版-->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/dypage/easy-html/min/easy-html-min.js?<%=JspUtil.version()%>"></script>

<script type="text/javascript">
    $(function () {
        //直接通过winCode;
        $("#div").win({
            param: 'WIN-3001',
            success: function (data) {
                //设值
                //事件绑定
                $("#44").click(function () {
                    console.log(eh.parse.getHtmlValue(data));
                });
            }
        });
        var temp = {};
        //通过配置的事件
        $("#div2").winByEvent({
            param: {
                busSpec: 116,
                busService: 0,
                busRegion: 0
            },
            success: function (data) {
                eh.parse.setHtmlValue(data, {
                    RecCode: "123",
                    259100000020190: "1"
                });
                temp = data;
                //eh.parse.clearHtmlValue(data);
                //设值
                /* $("#259100000020190").initSelect({
                 url : "meta/dynamicPageCtrl/getTestList",
                 param : {},
                 success : function() {

                 }
                 }); */

                $("#ddd").click(function () {
                    console.log(eh.parse.getHtmlValue(temp));
                })
            }
        });

        eh.data.callMethod("queryPageInfoEvents", {
            busSpec: 122
        }, function (data) {
            // console.log(data);
        })

    });
</script>
</body>
</html>