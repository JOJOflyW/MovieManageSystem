<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I'm Movie 管理员入口</title>
</head>
  <link href="css/manage.css" rel="stylesheet" type="text/css">
  <link href="css/hide.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>
    <script src="js/jquery.timers.js" type="text/javascript"></script>
    <script src="js/popup2.js" type="text/javascript"></script>
<body>
	<div id="templatemo_top_wrapper">
		<div id="templatemo_top">
        	<ul id="social_box">
				<li><a href="javascript:void(0);" id="signin">管理员登录</a></li>
        	</ul>
    	</div>
	</div>
	<div id="hidden">
		<div id="templatemo_header_wrapper">
    		<div id="templatemo_header">
        		<div id="site_title">
            	<h1><a href="index.jsp"><img alt="logo" src="images/logo.png" width="250" height="60"><span>I'm Movie Theater后台管理</span></a></h1>
        		</div> <!-- end of site_title -->
    		</div>
		</div> <!-- end of templatemo_header -->
	</div>
	<div id="signin_wrap" class="popup_wrap" >
    	<p>管理员登录</p>
   		<form action="managelogin.do" id="signin_form" method="post" >
        	<label class="label" for="signin_username">管理员用户名：</label>
        	<input class="input" type="text" id="signin_username" name="managername" value="" maxlength="50">
        	<span class="message" style="display: none;">请输入一个有效的用户名！</span>
        	<label class="label" for="signin_password">管理员密码：</label>
        	<input class="input" type="password" id="signin_password" name="password" value="" maxlength="50">
        	<input class="submit" id="btn_signin" type="button" value="登 录">
   		</form>
    	<a class="close" id="signin_close" href="javascript:void(0);" title="关闭窗口"></a>
	</div>
	<div id="black_overlay" ></div>
</body>
</html>