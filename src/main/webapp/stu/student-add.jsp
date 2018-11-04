<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--_meta 作为公共模版分离出去-->
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
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>添加学生 - 学生管理 - </title>
</head>
<body>
<article class="page-container">
    <form action="addStudent.action" method="post" class="form form-horizontal" id="form-student-add">
        <input type="hidden" name="s_id" id="s_id" value="${student.s_id}">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>学号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="" class="input-text" value="${student.s_number}" placeholder="" id="s_number"
                       name="s_number">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${student.s_pwd}" placeholder="" id="s_pwd" name="s_pwd">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" autocomplete="off" value="${student.s_name}" placeholder="姓名"
                       id="s_name"
                       name="s_name">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9">

                <select class="select" id="s_sex" name="s_sex">
                    <option value="保密" <c:if test="${student.s_sex == '保密'}">
                        selected="selected"
                    </c:if> >保密
                    </option>
                    <option value="男" <c:if test="${student.s_sex == '男'}">
                        selected="selected"
                    </c:if>>男
                    </option>
                    <option value="女"
                            <c:if test="${student.s_sex == '女'}">
                                selected="selected"
                            </c:if>>女
                    </option>
                </select>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" autocomplete="off" value="${student.s_phone}" placeholder="电话"
                       id="s_phone"
                       name="s_phone">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>专业：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" autocomplete="off" value="${student.s_major}" placeholder="专业"
                       id="s_major"
                       name="s_major">
            </div>
        </div>

        <%--<div class="row cl">--%>
            <%--<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>照片：</label>--%>
            <%--<div class="formControls col-xs-8 col-sm-9">--%>
                <%--<input type="text" class="input-text" autocomplete="off" value="${student.s_phone}" placeholder="照片"--%>
                       <%--id="s_photo"--%>
                       <%--name="s_photo">--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>班级编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <%--<input type="text" class="input-text" autocomplete="off" value="" placeholder="班级编号" id="s_cid"--%>
                <%--name="s_cid">--%>
                <select class="select" id="s_cid" name="s_cid">
                    <option value="0">班级</option>
                    <c:forEach items="${classes.data}" var="class1">
                        <option value="${class1.c_id}"
                                <c:if test="${student.s_cid == class1.c_id}">
                                    selected="selected"
                                </c:if>>${class1.c_name}
                        </option>
                    </c:forEach>
                </select>


            </div>
        </div>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="http://lib.h-ui.net/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/layer/2.1/layer.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/messages_zh.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="js/jquery-form.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-student-add").validate({
            rules: {
                s_number: {
                    required: true,
                },
                s_pwd: {
                    required: true,
                },
                s_name: {
                    required: true,
                },
                s_sex: {
                    required: true,
                },
                s_phone: {
                    required: true,
                },
                s_major: {
                    required: true,
                },
                s_photo: {
                    required: true,
                },
                s_cid: {
                    required: true,
                },
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit();
                setTimeout(function () {
                    parent.$('.a-refresh')[0].click();
                }, 3000)
                // var index = parent.layer.getFrameIndex(window.name);
                // parent.$('.btn-refresh').click();
                // parent.layer.close(index);
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>