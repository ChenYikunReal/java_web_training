package com.web.login.servlet;

import com.web.login.service.UserService;
import com.web.login.service.UserServiceImpl;
import com.web.login.vo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            UserService service = new UserServiceImpl();
            User user = service.login(username, password);
            if(user != null) {
                HttpSession session = request.getSession();
                user.setPassword("*".repeat(password.length()));
                session.setAttribute("user", user);
                response.sendRedirect("LogInIndexServlet");
            } else {
                request.getRequestDispatcher("/defeat.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
