<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
	</head>
	<body>
		<h3>${prod.price }</h3>
		<form id="inputForm" action="${pageContext.request.contextPath}/prod/insert" method="post">
		    
		    price： <input type="text" name="price"/><br />
		    <input type="submit" value="提交">
		
		</form>
	</body>
</html>