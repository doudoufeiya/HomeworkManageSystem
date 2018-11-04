<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
function login(){
	var role = $('#wrap input[name="role"]:checked').val();
	var id= $('input[name="id"]').val();
	var pwd = $('input[name="pwd"]').val();
	var url="";
	if(role==1){ 
		window.location = "studentlogin.action?s_id="+id+"&s_pwd="+pwd;	 
	}else if(role==2){
		window.location = "teacherlogin.action?t_id="+id+"&t_pwd="+pwd;
	}else if(role==3){
		window.location = "adminlogin.action?a_id="+id+"&a_pwd="+pwd;
	}
} 
</script>
</head>

<body class="login">

<div class="login_m">
	<div class="login_logo"><font size="5px">作业在线批改与答疑系统</font></div>
	<div class="login_boder">
	 <p align="center"><font color="red">${idErr}${pwdErr}</font></p>
		<div class="login_padding">
			<h2>账号</h2>
			<label>
				<input type="text" name="id" id="username" class="txt_input txt_input2" onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}" value="Your name">
			</label>
			<h2>密码</h2>
			<label>
				<input type="password" name="pwd" id="userpwd" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="******">
			</label>
			   <div id="wrap">
        <input type="radio" name="role" value="1" checked="checked">学生
        <input type="radio" name="role" value="2">教师
        <input type="radio" name="role" value="3">管理员
      </div>
		
			<div class="rem_sub">

				<label>
					<input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;" onclick="login()">
				</label>
			</div>
		</div>
	</div><!--login_boder end-->
</div><!--login_m end-->

<br />
<br />

<p align="center">Copyright sunny by HomeworkManageSystem</p>

</body>
</html>