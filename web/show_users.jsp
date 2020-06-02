<%--
  Created by IntelliJ IDEA.
  User: yk
  Date: 2020/6/2
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.neu.login.vo.User" %>
<%@ page import="com.neu.login.dao.UserDao" %>
<%@ page import="com.neu.login.dao.UserDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>UserName</td>
            <td>Password</td>
            <td>TelephoneNumber</td>
            <td>删除用户</td>
            <td>修改用户</td>
        </tr>
        <%
            UserDao dao = new UserDaoImpl();
            List<User> userList = dao.getPageByQuery("select * from user_login");
            for (User u : userList) {
        %>
        <tr>
            <td><%=u.getUserId()%></td>
            <td><%=u.getUserName()%></td>
            <td><%="*".repeat(u.getPassword().length())%></td>
            <td><%=u.getTelephoneNumber()%></td>
            <td><a href="DeleteUserServlet?id=<%=u.getUserId()%>">删除用户</a></td>
            <td><a href="update_user.jsp?id=<%=u.getUserId()%>&name=<%=u.getUserName()%>
                &telephone=<%=u.getTelephoneNumber()%>">修改用户</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <input type="button" id="return_btn" onclick="location.href='success.jsp'" value="返回"/>
</body>
</html>

