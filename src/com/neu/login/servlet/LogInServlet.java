package com.neu.login.servlet;

import com.neu.login.service.UserService;
import com.neu.login.service.UserServiceImpl;
import com.neu.login.vo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            UserService service = new UserServiceImpl();
            User user = service.login(username, password);
            if(user != null){
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            }
            else {
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
