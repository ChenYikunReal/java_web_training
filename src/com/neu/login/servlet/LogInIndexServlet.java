package com.neu.login.servlet;

import com.neu.login.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LogInIndexServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //如果使用注释的方式，不便于去设置退出功能，所以直接跳JSP。
        response.sendRedirect("success.jsp");
//        User user = (User)session.getAttribute("user");
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.println("欢迎：" + user.getUserName() + "登录系统！<br/>");
//        out.println("你的密码是" + "*".repeat(user.getPassword().length()) + "<br/>");
//        out.println("你的电话号码是：" +user.getTelephoneNumber());
    }

}
