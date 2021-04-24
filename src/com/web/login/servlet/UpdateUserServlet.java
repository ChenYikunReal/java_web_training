package com.web.login.servlet;

import com.web.login.dao.UserDao;
import com.web.login.dao.UserDaoImpl;
import com.web.login.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserDao dao = new UserDaoImpl();
        try {
            dao.updateUser(request.getParameter("id"), request.getParameter("name"), request.getParameter("telephone"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("show_users.jsp");
    }

}
