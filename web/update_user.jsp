<%@ page import="com.web.login.vo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
    <form class="form" id="entry_form" action="/web/UpdateUserServlet" method="post">
        <input type="text" name="id" readonly value="<%=request.getParameter("id")%>"/>
        <input type="text" name="name" value="<%=request.getParameter("name")%>"/>
        <input type="text" name="telephone" value="<%=request.getParameter("telephone")%>"/>
        <input type="submit" id="update_user_btn" value="修改"/>
    </form>
</body>
</html>
