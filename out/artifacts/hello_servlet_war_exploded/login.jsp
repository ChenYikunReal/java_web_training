<%--
  Created by IntelliJ IDEA.
  User: yk
  Date: 2020/3/20
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>登录系统</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/vector.js"></script>
</head>
<body>
    <div id="container">
	    <div id="output">
		    <div class="containerT">
			    <h1>用户登录</h1>
			    <form class="form" id="entry_form" action="/web/LogInServlet" method="post">
				    <input type="text" placeholder="用户名" name="username"/>
				    <input type="password" placeholder="密码" name="password"/>
                    <input type="submit" id="login_btn" value="登录"/>
                    <input type="reset" id="reset_btn" value="重置"/>
                    <input type="button" id="register_btn" onclick="location.href='register.jsp'" value="注册"/>
			    </form>
		    </div>
	    </div>
    </div>
    <script type="text/javascript">
        $(function(){
            Victor("container", "output");   //登录背景函数
            $("#entry_name").focus();
            $(document).keydown(function(event){
               if(event.keyCode==13){
                   $("#entry_btn").click();
               }
           });
        });
    </script>
</body>
</html>