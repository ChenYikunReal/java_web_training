package com.neu.login.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ExitServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute("user", null);
        session.setAttribute("username_value", null);
        session.setAttribute("password_value", null);
        session.setAttribute("tel_num_value", null);
        //session.removeAttribute("user");
        //session.removeAttribute("username_value");
        //session.removeAttribute("password_value");
        //session.removeAttribute("tel_num_value");
        response.setHeader("refresh","0;URL=login.jsp");
    }

}
