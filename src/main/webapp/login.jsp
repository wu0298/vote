<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
		<link rel="stylesheet" href="css/login.css" />	
		<script type="text/javascript" src="js/jquery-1.x.js" ></script>
		<script>
			function check(){
				if(username.value==""||username.value==null||password.value==""||password.value==null){
					alert("用户名或密码不能为空！")
					return false
				}

				var name=document.getElementById("username").value;
				var pwd=document.getElementById("password").value;
				$.post("${pageContext.request.contextPath}/userLogin",{"username":name,"password":pwd},function(data){
					if (data.code  == 200){
						window.location.href='${pageContext.request.contextPath}/admin/index.jsp'
					}else{
						var msg=document.getElementById("msg");
						msg.innerHTML=data.msg;
						msg.value=data.msg;
					}
				});
			}
		</script>
	</head>
	<body>
		<div class="main">
			<div class="top">
				<img src="img/logo.gif" />
			</div>
			<div class="mid">
				<div class="mid01">
					<img src="img/voteBanner.jpg"/>
				</div>
				<div class="mid02">
					<p class="p1">青软实训</p>
					<p class="p2">网上调查系统...</p>
				</div>
				<div class="mid03">
					<div class="head">
						用户登录 &nbsp;  <img src="img/arrow_down.gif" /> <span id="msg" style="color: red"></span>
					</div>
					<div class="line1"></div>
					<form>
						<table>
							<tr>
								<td>用户名：</td>
								<td><input type="text" name="username" id="username"/></td>
							</tr>
							<tr>
								<td>密码：</td>
								<td><input type="password" name="password" id="password" /></td>
							</tr>
							<tr>
								<td></td>
								<td>
									
									<input id="btn" name="btn" onclick="check()" type="button" value="   登录" style="width:77px; height:32px;border:0;background:url(img/button_login.gif);"  />
									
									<a href="admin/reg.jsp">新用户注册</a>
								</td>
							</tr>
						</table>
					</form>
				</div>
				
			</div>
			<div class="line2"></div>
			<div class="end">
				青软实训 &copy; 版权所有
			</div>
		</div>
	</body>
</html>
