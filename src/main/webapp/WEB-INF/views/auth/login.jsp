<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录页面</title>
<script type="text/javascript" src="${path}/resources/extjs/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${path}/resources/extjs/jquery/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$("#identityCard").focus();
		
		$("#loginform").submit(function(){
			var options = {
				type:'post',
				dataType:'json',
				beforeSubmit:showRequest,
				success:showResponse,
				error:function(){
					alert('请求服务器失败,请检查网络!');
				}
			};
				
			$(this).ajaxSubmit(options);
			return false; 
		});
	});
	
	function showRequest(formData, jqForm, options) { 
		var form = jqForm[0];
		if (!form.identityCard.value) { 
			$('#errorMsg').html('请输入用户名!'); 
	        return false; 
	    }
		if(!form.password.value){
			$('#errorMsg').html('请输入密码!');
			return false; 
		}
		$('#errorMsg').html('请求中,请稍等....');
		return true;
	}
	
	function showResponse(responseText, statusText, xhr, $form)  { 
		var json = eval(responseText);
		if(!json.success){
			$('#errorMsg').html(json.msg);
			return;
		}
		$('#errorMsg').html('登录成功,页面跳转中.');
		location.href='${path}/home.do';
	}
</script>
</head>
<body>
	<h1>登录页面</h1>
    <div class="login">
        <form id="loginform" action="${path }/dologin.do" method="post">
            <p><label for="identityCard">用户名：</label><input type="text" id="identityCard" name="identityCard" maxlength="20"/></p>
            <p><label for="password">密　码：</label><input type="password" id="password" name="password" maxlength="20"/></p>
            <p><input type="submit" value="登录" /><span id="errorMsg" style="color: red;"></span></p>
        </form>
    </div>
</body>
</html>