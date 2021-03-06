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
    <title>作业列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 作业管理 <span
        class="c-gray en">&gt;</span> 作业列表 <a class="a-refresh btn btn-success radius r"
                                              style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container container">
    <div class="text-c">
        <form action="findWorks.action" method="post">
            <input type="text" class="input-text" style="width:250px" value="${tw_name}" placeholder="输入作业名称"
                   id="tw_name" name="tw_name">
            <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜作业
            </button>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        <a href="javascript:;" onclick="submitForm()" class="btn btn-danger radius">
            <i class="Hui-iconfont">&#xe6e2;</i>
            批量删除
        </a>
        <a onclick="stu_add('发布作业','addWorkPage.action','800','500')"
           class="btn btn-primary radius">
            <i class="Hui-iconfont">&#xe600;</i>
            发布作业
        </a>
    </span>
    </div>
    <form name="myForm" id="myForm" action="batchDeleteWork.action" method="post">
        <table class="table table-border table-bordered table-bg row-fluid">
            <thead>
            <tr>
                <th scope="col" colspan="11">作业列表</th>
            </tr>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="100">序号</th>
                <th width="50">作业名</th>
                <th width="50">创建时间</th>
                <th width="50">截止时间</th>
                <th width="50">文件名</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${works.data}" var="s">
                <tr class="text-c">
                    <td><input type="checkbox" value="${s.tw_id}" name="muticheck-${s.tw_id}" onclick="toChkSon(this);">
                    </td>
                    <td>${s.tw_id}</td>
                    <td>${s.tw_name}</td>
                    <td><fmt:formatDate value="${s.tw_addTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${s.tw_deadLine}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                    <td><a href="${s.tw_file_path}">${s.tw_file_name}</a></td>
                    <td class="td-manage">
                        <a title="编辑" href="javascript:;"
                           onclick="admin_edit('编辑','addWorkPage.action?tw_id='+ ${s.tw_id},'1','800','500')"
                           class="ml-5" style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6df;</i>
                        </a>
                        <a title="删除"
                           href="/deleteWork.action?s_id=${s.tw_id}"
                           class="ml-5"
                           style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6e2;</i>
                        </a>
                        <a title="查看作业情况"
                           class="ml-5"
                           onclick="stu_add('查看作业情况','viewWorkPage.action','800','500')"
                           style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6cd;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
    <input type="hidden" name="contextPath" value=<%= request.getContextPath() %>>
    <c:if test="${works != null}">
        <input type="hidden" id="pageNumber" value="${works.pageNumber}">
        <input type="hidden" id="pageSize" value="${works.pageSize}">
        <input type="hidden" id="totalPage" value="${works.totalPage}">
        <input type="hidden" id="totalRow" value="${works.totalRow}">
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
<script type="text/javascript" src="jsp/work/page.js"></script>
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