<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() +":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
//去后台验证相应的操作
$.ajax({
url : "",
data : {

},
type : "",
dataType : "json",
success : function (data) {

}
})

$(".time").datetimepicker({
minView: "month",
language:  'zh-CN',
format: 'yyyy-mm-dd',
autoclose: true,
todayBtn: true,
pickerPosition: "bottom-left"
});


//创建时间，当前系统时间
String createTime = DateTimeUtil.getSysTime();
//创建人，当前登录用户
String createBy = ((User)request.getSession().getAttribute("user")).getName();
</body>
</html>
