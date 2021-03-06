<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <LINK rel="Bookmark" href="/favicon.ico">
    <LINK rel="Shortcut Icon" href="/favicon.ico"/>
    <link rel="stylesheet" href="bPage/b.page.bootstrap3.css" type="text/css">
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <script type="text/javascript" src="lib/PIE_IE678.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.7/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="lib/icheck/icheck.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" href="https://terryz.github.io/lib/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>答疑列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 答疑管理 <span
        class="c-gray en">&gt;</span> 答疑列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container container">
    <div class="text-c">
        <form action="findStudentByName.action" method="post">
            <input type="text" class="input-text" style="width:250px" placeholder="输入问题标题" id="s_name" name="s_name">
            <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜问题
            </button>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        <a onclick="stu_add('添加问题','addQuestionPage.action','800','500')"
           class="btn btn-primary radius">
            <i class="Hui-iconfont">&#xe600;</i>
            添加问题
        </a>
    </span>
    </div>
    <form name="myForm" id="myForm" action="batchDeleteResource.action" method="post">
        <table class="table table-border table-bordered table-bg row-fluid">
        <thead>
        <tr>
            <th scope="col" colspan="12">作业列表</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th width="25">序号</th>
            <th width="50">学生姓名</th>
            <th width="50">标题</th>
            <th width="50">问题内容</th>
            <th width="50">提问时间</th>
            <th width="50">教师</th>
            <th width="50">回答内容</th>
            <th width="50">回答时间</th>
            <th width="50">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions.data}" var="s">
            <tr class="text-c">
                <td><input type="checkbox" value="1" name=""></td>
                <td>${s.question_id}</td>
                <td>${s.s_name}</td>
                <td>${s.title}</td>
                <td>${s.content}</td>
                <td><fmt:formatDate value="${s.send_date}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                <td>${s.t_name}</td>
                <td>${s.answer_content}</td>
                <td><fmt:formatDate value="${s.answer_date}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                <td class="td-manage">
                    <a title="回答问题" href="javascript:;"
                       onclick="admin_edit('回答问题','gotoAnswerPage.action?question_id='+${s.question_id},'1','800','500')"
                       class="ml-5" style="text-decoration:none">
                        <i class="Hui-iconfont">&#xe692;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table></form>
    <input type="hidden" name="contextPath" value=<%= request.getContextPath() %>>
    <c:if test="${questions != null}">
        <input type="hidden" id="pageNumber" value="${questions.pageNumber}">
        <input type="hidden" id="pageSize" value="${questions.pageSize}">
        <input type="hidden" id="totalPage" value="${questions.totalPage}">
        <input type="hidden" id="totalRow" value="${questions.totalRow}">
    </c:if>

    <div class="row-fluid">
        <div id="page1"></div>
    </div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="bPage/b.page.min.js"></script>
<script type="text/javascript" src="jsp/question/page.js"></script>
<script type="text/javascript">
    /*
        参数解释：
        title	标题
        url		请求的url
        id		需要操作的数据id
        w		弹出层宽度（缺省调默认值）
        h		弹出层高度（缺省调默认值）
    */
    /*学生-增加*/
    function stu_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*学生-删除*/
    function admin_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

    /*学生-编辑*/
    function admin_edit(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }


    /*学生-启用*/
    function admin_start(obj, id) {
        layer.confirm('确认要启用吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……
            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6, time: 1000});
        });
    }
</script>
<script type="text/javascript" src="js/batcheDelete.js">

</script>
</body>
</html>