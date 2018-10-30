<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="res/layui/css/layui.css">
    <link rel="stylesheet" href="res/css/global.css">
    <script src="res/layui/layui.js"></script>
</head>
<body>
<div class="header">
    <div class="main">
        <a href="index.html" style="margin-left: 30px;line-height: 65px; color: white;font-size: 18px;">作业在线批改与答疑系统</a>
        <div class="nav">

        </div>

        <div class="nav-user">
            <!-- 登入后的状态 -->

            <a class="avatar" href="index.html">
                <img src="res/images/8.jpg">
                <cite style="color: white;">教师</cite>
                <i style="color: white;">退出</i>
            </a>
            <div class="nav">
                <a href="set.html"><i class="iconfont icon-shezhi"></i>设置</a>
                <a href="login.action"><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退了</a>
            </div>
        </div>
    </div>
</div>

<div class="main fly-user-main layui-clear">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item layui-this"><a href="student.jsp"> <i
                class="layui-icon">&#xe609;</i> 首页 </a></li>
        <li class="layui-nav-item "><a href="findStudentHomework.action" target="right"> <i
                class="layui-icon">&#xe612;</i>查看作业 </a></li>
        <li class="layui-nav-item "><a href="user.html" target="right"> <i
                class="layui-icon">&#xe612;</i>上传作业</a></li>
        <!--		<li class="layui-nav-item"><a href="upload.html" target="right"> <i
            class="layui-icon">&#xe611;</i> 查看成绩 </a></li>-->
        <li class="layui-nav-item "><a href="news.html" target="right"> <i
                class="layui-icon">&#xe611;</i> 修改个人信息</a></li>
        <li class="layui-nav-item  "><a href="javascript:void(0)" onclick="updatePwd('修改密码',2)"> <i
                class="layui-icon">&#xe620;</i> 修改密码 </a></li>
        <li class="layui-nav-item "><a href="charts-1.html" target="right"> <i
                class="layui-icon">&#xe61a;</i> 站内信 </a></li>
        <!--				<li class="layui-nav-item "><a href="404.html" target="right"> <i
                            class="layui-icon">&#xe61a;</i> 404错误页面 </a></li>-->
    </ul>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="fly-panel fly-panel-user"/>
    <div class="layui-tab layui-tab-brief" lay-filter="user">

        <div class="layui-tab-content" style="padding: 20px;padding-top: 0px;">

            <iframe src="welcome.html" width="88%" style="border: none;" height="800" border="none"
                    name="right"></iframe>
        </div>
    </div>
</div>
</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="myplugs/js/plugs.js"></script>
[
<script>
    layui.use('element', function () {
        var element = layui.element();
    });
</script>
<script>

    layui.cache.page = '';
    layui.cache.user = {
        username: '游客'
        , uid: -1
        , avatar: '../res/images/avatar/00.jpg'
        , experience: 83
        , sex: '男'
    };
    layui.config({
        version: "2.0.0"
        , base: '../res/mods/'
    }).extend({
        fly: 'index'
    }).use('fly');

    //添加编辑弹出层
    function updatePwd(title, id) {
        $.jq_Panel({
            title: title,
            iframeWidth: 500,
            iframeHeight: 300,
            url: "updatePwd.html"
        });
    }
</script>
</body>
</html>