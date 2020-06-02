package com.neu.login.servlet;

import com.neu.login.dao.UserDao;
import com.neu.login.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        UserDao dao = new UserDaoImpl();
        try {
            dao.deleteUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("show_users.jsp");
    }

}
