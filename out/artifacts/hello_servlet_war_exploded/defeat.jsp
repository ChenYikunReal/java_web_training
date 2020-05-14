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
    <title>登录失败</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/vector.js"></script>
</head>
<body>
    <div id="container">
        <div id="output">
            <div class="containerT">
                <form class="form" id="entry_form" action="/web/LogInServlet" method="post">
                    <label><font color="#dc143c">用户名或密码错误 登录失败</font></label>
                    <input type="button" id="back_btn" onclick="location.href='login.jsp'" value="返回"/>
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
