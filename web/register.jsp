<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/vector.js"></script>
</head>
<body>
<div id="container">
    <div id="output">
        <div class="containerT">
            <h1>用户注册</h1>
            <form action="/web/RegisterServlet" method="post">
                <table style="margin-left:10%">
                    <tr>
                        <td>用户名：</td>
                        <td><input name="username" type="text" size="20"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input name="password" type="password" size="20"></td>
                    </tr>
                    <tr>
                        <td>电话号码：</td>
                        <td><input name="tel_num" type="text" size="20"></td>
                    </tr>
                </table>
                <input type="submit" id="register_btn" value="注册">
                <input type="reset" id="reset_btn" value="重置">
                <input type="button" id="login_btn" onclick="location.href='login.jsp'" value="登录"/>
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
