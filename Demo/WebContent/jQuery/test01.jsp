<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>

</head>
<body>
	<!-- 
	<form method="post">
		<span>学生姓名:</span><input type="text" id="stuName" name="stuName" /> <span>学生年龄:</span><input
			type="text" id="stuAge" name="stuAge" />
		<button id="submit">提交</button>
	</form>
	 -->
	<button id="submit">提交</button>
	返回结果是：
	<span id="resultSpan">xx1x</span>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#submit").click(function() {
			$.ajax({
				type : "POST",
				url : "<%=path%>/jQueryActionTest.do",
					data : {
						stuName : "zhangsan",
						stuAge : "22"
					},
					dataType : "json",
					success : function(data) {
						alert(data.length);
					}
				});
				/* $.post("../jQueryActionTest.do", {
					stuName : "zhangsan",
					stuAge : "22"
				}, function(json) {
					alert("xxx");
				}); */
			});
		});
	</script>
</body>
</html>