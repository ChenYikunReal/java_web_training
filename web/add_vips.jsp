<%@ page import="java.util.List" %>
<%@ page import="com.web.login.vo.User" %>
<%@ page import="com.web.login.dao.UserDao" %>
<%@ page import="com.web.login.dao.UserDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VIP列表</title>
</head>
<body>

<table border="1">
    <tr>
        <td>ID</td>
        <td>UserName</td>
        <td>Password</td>
        <td>TelephoneNumber</td>
    </tr>

<%
    UserDao dao = new UserDaoImpl();
    List<User> userList = dao.getPageByQuery("select * from user_login where vip=0");
    for (User u : userList) {
%>
        <tr>
            <td><%=u.getUserId()%></td>
            <td><%=u.getUserName()%></td>
            <td><%="*".repeat(u.getPassword().length())%></td>
            <td><%=u.getTelephoneNumber()%></td>
            <td><a href="AddVipServlet?id=<%=Integer.toString(u.getUserId())%>">添加VIP</a></td>
        </tr>
<%
    }
%>
</table>

</body>
</html>
