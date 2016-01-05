<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<form id="from" action="#">
		用户名:<input type="text" id="username" name="username" /> <br /> 密码:<input
			type="password" id="password" name="password" /> <img
			src="img/btnlogin.png" id="btn_img"></img>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btn_img").click(function() {
				var username = $("#username").text();
				var password = $("#password").text();
				alert("用户名是:" + username);
			});
		});
	</script>
</body>
</html>