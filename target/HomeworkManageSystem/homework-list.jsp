<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>作业信息</title>
    <link rel="stylesheet" href="res/css/amazeui.min.css"/>
    <link rel="stylesheet" href="res/css/admin.css"/>

</head>
<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">学生作业</strong>
            <small></small>
        </div>
    </div>

    <hr>

    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" placeholder="请输入学生名">
                <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
            </div>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <form class="am-form">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th class="table-check"><input type="checkbox"></th>
                        <th class="table-id">ID</th>
                        <th class="table-title">作业名称</th>
                        <th class="table-type">学生学号</th>
                        <th class="table-author am-hide-sm-only">文件名</th>
                        <th class="table-date am-hide-sm-only">上传时间</th>
                        <th>分数</th>
                        <th class="table-set">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${homeworks}" var="h">
                        <tr>
                            <td><input type="checkbox" value="1" name=""></td>
                            <td>${h.sw_sid}</td>
                            <td>${h.sw_name}</td>
                            <td>${h.s_number}</td>
                            <td><a href="${h.sw_file_path}">${h.sw_file_name}</a></td>
                            <td><fmt:formatDate value="${h.sw_addTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                            <td class="am-hide-sm-only">${h.sw_grade}</td>
                            <td>
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                            <%--<button class="am-btn am-btn-default am-btn-xs am-text-secondary"--%>
                                            <%--onclick="stu_add('批改作业','goReadHomeworkPage.action?sworkId='+${h.sw_sid},'800','500')">--%>
                                            <%--<span class="am-icon-pencil-square-o">--%>

                                            <%--</span>--%>
                                            <%--评分--%>
                                            <%--</button>--%>
                                        <a onclick="stu_add('批改作业','goReadHomeworkPage.action?sworkId='+${h.sw_id},'800','500')"
                                           class="btn btn-primary radius">
                                            <i class="Hui-iconfont">&#xe647;</i>
                                            评分
                                        </a>
                                            <%--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"--%>
                                            <%--onclick="redirect://filedown.action"><span--%>
                                            <%--class="am-icon-trash-o"></span> 下载--%>
                                            <%--</button>--%>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="am-cf">
                    共 15 条记录
                    <div class="am-fr">
                        <ul class="am-pagination">
                            <li class="am-disabled">
                                <a href="#">«</a>
                            </li>
                            <li class="am-active">
                                <a href="#">1</a>
                            </li>
                            <li>
                                <a href="#">2</a>
                            </li>
                            <li>
                                <a href="#">3</a>
                            </li>
                            <li>
                                <a href="#">4</a>
                            </li>
                            <li>
                                <a href="#">5</a>
                            </li>
                            <li>
                                <a href="#">»</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <hr>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
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
        debugger
        layer_show(title, url, w, h);
    }
</script>
</html>