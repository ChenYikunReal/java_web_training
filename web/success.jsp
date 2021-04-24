<%@ page import="com.web.login.vo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session != null){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String username = user.getUserName();
            String password = user.getPassword();
            String telephoneNumber = user.getTelephoneNumber();
            if(username != null && !username.equals("") && password != null && !password.equals("")){
                request.setAttribute("username_value", username);
                request.setAttribute("password_value", password);
                request.setAttribute("tel_num_value", telephoneNumber == null ? "" : telephoneNumber);
            }
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>登录成功</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/vector.js"></script>
</head>
<body>
    <div id="container">
        <div id="output">
            <div class="containerT">
                <font color="#dc143c"><h1>欢迎！你登录成功</h1></font>
                <form class="form" id="entry_form" action="/web/ExitServlet" method="post">
                    <input type="text" id="username" name="username" value="<%=request.getAttribute("username_value")%>" readonly/>
                    <input type="text" id="password" name="password" value="<%=request.getAttribute("password_value")%>" readonly/>
                    <input type="text" id="tel_num" name="tel_num" value="<%=request.getAttribute("tel_num_value")%>" readonly/>
                    <input type="submit" id="exit_btn" value="退出系统"/>
                    <input type="button" id="show_vip_btn" onclick="location.href='show_vips.jsp'" value="查看VIP"/>
                    <input type="button" id="add_vip_btn" onclick="location.href='add_vips.jsp'" value="增加VIP"/>
                    <input type="button" id="show_user_btn" onclick="location.href='show_users.jsp'" value="查看用户"/>
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
