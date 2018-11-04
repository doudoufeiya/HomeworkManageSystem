<%@page import="cn.kewen.hms.pojo.Admin"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

</head>
<body>

<!-- contact-form -->	
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>欢迎登录</h1>
		<div class="alert-close"> </div> 			
	</div>
		<form action="${pageContext.request.contextPath}/admin/login" method="post">
			<font color="red">${idErr}${pwdErr}</font>
			<li>
				<input type="text" class="text" placeholder="用户账号" name="a_id"><a href="#" class=" icon user"></a>
			</li>
				<div class="clear"> </div>
			<li>
				<input type="password" value="Password" onfocus="this.value = '';" 
				onblur="if (this.value == '') {this.value = 'Password';}"
				name="a_pwd"> <a href="#" class="icon lock"></a>
			</li>
			<div class="clear"> </div>	
			<div><a href="regist.jsp">还没账号，去注册</a></div>
			<div class="submit">
				<input type="submit" value="Login">
				<input type="reset"  value="Reset" >
						  <div class="clear">  </div>	
			</div>	
		</form>
		</div>					
	</div>
	</div>
	<div class="clear"> </div>
<!--- footer --->
<div class="footer">
	<p>Copyright &copy; 2014.</p>
</div>

</body>
</html>