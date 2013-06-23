<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1> 
	Hello world!   
</h1>

<P>  The time on the server is  </P>
<form action="login.do" method="post">
用户名：<input type="text" name="userLoginName"/><br/>
密码：<input type="password" name="password"/>
<input type="submit" value="登录">
</form>
</body>
</html>
