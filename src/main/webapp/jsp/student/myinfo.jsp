<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>修改个人资料</title>
    <style type="text/css">
        .con4 {
            width: 300px;
            height: auto;
            overflow: hidden;
            /*margin: 20px auto;*/
            color: #FFFFFF;
        }

        .con4 .btn {
            width: 40%;
            height: 40px;
            line-height: 40px;
            background: #d8b49c;
            display: block;
            font-size: 16px;
            border-radius: 5px;
            margin-left: 90px;
        }

        .upload {
            float: left;
            position: relative;
        }

        .upload_pic {
            display: block;
            width: 100%;
            height: 40px;
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
            border-radius: 5px;
        }

        #cvs {
            border: 1px solid #000;
            margin: 20px 0 20px 50px;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form action="editStudentInfo.action" method="post" class="form form-horizontal" enctype="multipart/form-data"
          id="form-student-work-add">
        <input type="text" style="display: none;" class="input-text" value="${workId}" placeholder="" id="workId"
               name="workId">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">上传头像：</label>
            <div class="con4">
                <canvas id="cvs" width="200" height="200"></canvas>
                <span class="btn upload">上传头像<input type="file" name="file" class="upload_pic" id="upload"/></span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${studentInfo.s_name}" placeholder="" id="s_name"
                       name="s_name">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" value="${studentInfo.s_pwd}" placeholder="" id="s_pwd"
                       name="s_pwd">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">

                <select class="select" id="s_sex" name="s_sex">
                    <option value="保密" <c:if test="${studentInfo.s_sex == '保密'}">
                        selected="selected"
                    </c:if> >保密
                    </option>
                    <option value="男" <c:if test="${studentInfo.s_sex == '男'}">
                        selected="selected"
                    </c:if>>男
                    </option>
                    <option value="女"
                            <c:if test="${studentInfo.s_sex == '女'}">
                                selected="selected"
                            </c:if>>女
                    </option>
                </select>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>专业：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${studentInfo.s_major}" placeholder="" id="s_major"
                       name="s_major">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${studentInfo.s_phone}" placeholder="" id="s_phone"
                       name="s_phone">
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
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="js/jquery-form.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $(function () {
        $(".permission-list dt input:checkbox").click(function () {
            $(this).closest("dl").find("dd input:checkbox").prop("checked", $(this).prop("checked"));
        });
        $(".student-list dd input:checkbox").click(function () {
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

        $("#form-student-work-add").validate({
            rules: {
                roleName: {
                    required: true,
                },
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                debugger
                $(form).ajaxSubmit();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                return false
            }
        });
    });
</script>
<script>
    //获取上传按钮
    var input1 = document.getElementById("upload");
    if (typeof FileReader === 'undefined') {
        //result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
        input1.setAttribute('disabled', 'disabled');
    } else {
        input1.addEventListener('change', readFile, false);
    }

    function readFile() {
        var file = this.files[0]; //获取上传文件列表中第一个文件
        if (!/image\/\w+/.test(file.type)) {
            //图片文件的type值为image/png或image/jpg
            alert("文件必须为图片！");
            return false;
        }
        // console.log(file);
        var reader = new FileReader(); //实例一个文件对象
        reader.readAsDataURL(file); //把上传的文件转换成url
        //当文件读取成功便可以调取上传的接口
        reader.onload = function (e) {
            // console.log(this.result);//文件路径
            // console.log(e.target.result);//文件路径
            /*var data = e.target.result.split(',');
    var tp = (file.type == 'image/png')? 'png': 'jpg';
    var imgUrl = data[1];//图片的url，去掉(data:image/png;base64,)
    //需要上传到服务器的在这里可以进行ajax请求
    // console.log(imgUrl);
    // 创建一个 Image 对象
    var image = new Image();
    // 创建一个 Image 对象
    // image.src = imgUrl;
    image.src = e.target.result;
    image.onload = function(){
        document.body.appendChild(image);
    }*/
            var image = new Image();
            // 设置src属性
            image.src = e.target.result;
            var max = 200;
            // 绑定load事件处理器，加载完成后执行，避免同步问题
            image.onload = function () {
                // 获取 canvas DOM 对象
                var canvas = document.getElementById("cvs");
                // 如果高度超标 宽度等比例缩放 *=
                /*if(image.height > max) {
            image.width *= max / image.height;
            image.height = max;
        } */
                // 获取 canvas的 2d 环境对象,
                var ctx = canvas.getContext("2d");
                // canvas清屏
                ctx.clearRect(0, 0, canvas.width, canvas.height);
                // 重置canvas宽高
                /*canvas.width = image.width;
        canvas.height = image.height;
        if (canvas.width>max) {canvas.width = max;}*/
                // 将图像绘制到canvas上
                // ctx.drawImage(image, 0, 0, image.width, image.height);
                ctx.drawImage(image, 0, 0, 200, 200);
                // 注意，此时image没有加入到dom之中
            };
        }
    };
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>