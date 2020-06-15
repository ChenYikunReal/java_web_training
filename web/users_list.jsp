<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.neu.login.vo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>用户列表分页显示</title>
</head>

<body>
    <table border="1">
        <tr>
            <td>序列号</td>
            <td>用户ID</td>
            <td>用户名</td>
            <td>联系方式</td>
            <td>VIP</td>
            <td>删除用户</td>
        </tr>
        <c:forEach items="${requestScope.usersList}" var="u" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${u.userId}</td>
            <td>${u.userName}</td>
            <td>${u.telephoneNumber}</td>
            <td>${u.isVip}</td>
            <td><a href="DeleteUserServlet?id="${u.userId}"">删除用户</a></td>
        </tr>
        </c:forEach>
    </table>
    <a href="QueryByPageServlet?page=1">首页</a>
    <c:if test="${requestScope.curPage!=1}">
        <a href="QueryByPageServlet?page=${requestScope.curPage-1}">上一页</a>
    </c:if>
    <c:if test="${requestScope.curPage!=requestScope.totalPage}">
        <a href="QueryByPageServlet?page=${requestScope.curPage+1}">下一页</a>
    </c:if>
    <a href="QueryByPageServlet?page=${requestScope.totalPage}">末页</a>
</body>

</html>
