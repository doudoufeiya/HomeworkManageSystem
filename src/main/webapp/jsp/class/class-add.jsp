<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

    <title>新建班级 - 班级管理 </title>
</head>
<body>
<article class="page-container">
    <form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>班级名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="c_name" name="c_name"
                       datatype="*4-16" nullmsg="班级名称不能为空">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">勾选学生：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <dl class="permission-list">
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="" name="user-Character-0-0" id="user-Character-0-0">
                                    全部</label>
                            </dt>
                            <dd>
                                <label class="">
                                    <input type="checkbox" value="" name="user-Character-0-0-0"
                                           id="user-Character-0-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="" name="user-Character-0-0-0"
                                           id="user-Character-0-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="" name="user-Character-0-0-0"
                                           id="user-Character-0-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="" name="user-Character-0-0-0"
                                           id="user-Character-0-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="" name="user-Character-0-0-0"
                                           id="user-Character-0-0-4">
                                    审核</label>
                                <label class="c-orange">
                                    <input type="checkbox" value="" name="user-Character-0-0-0"
                                           id="user-Character-0-0-6">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-7">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-8">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-9">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-10">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-11">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-12">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-13">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-14">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-15">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-16">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-17">是是 </label><label class="c-orange">
                                <input type="checkbox" value="" name="user-Character-0-0-0"
                                       id="user-Character-0-0-18">是是 </label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button type="submit" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i
                        class="icon-ok"></i> 确定
                </button>
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script>

<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $(function () {
        $(".permission-list dt input:checkbox").click(function () {
            $(this).closest("dl").find("dd input:checkbox").prop("checked", $(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function () {
            var l = $(this).parent().parent().find("input:checked").length;
            var l2 = $(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if ($(this).prop("checked")) {
                $(this).closest("dl").find("dt input:checkbox").prop("checked", true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked", true);
            }
            else {
                if (l == 0) {
                    $(this).closest("dl").find("dt input:checkbox").prop("checked", false);
                }
                if (l2 == 0) {
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked", false);
                }
            }
        });

        $("#form-admin-role-add").validate({
            rules: {
                roleName: {
                    required: true,
                },
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>