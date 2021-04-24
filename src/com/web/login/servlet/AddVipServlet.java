package com.web.login.servlet;

import com.web.login.dao.UserDao;
import com.web.login.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddVipServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao dao = new UserDaoImpl();
        try {
            dao.addVip(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("add_vips.jsp");
    }

}
