package com.web.login.servlet;

import com.web.login.service.UserService;
import com.web.login.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String telephone = request.getParameter("tel_num");
        try {
            UserService service = new UserServiceImpl();
            if (service.register(username, password, telephone)) {
                PrintWriter out = response.getWriter();
                String a = "<body onLoad=\"checkForm()\"><script language=\"JavaScript\" type=\"text/JavaScript\">function checkForm(){"+
                        "alert(\"恭喜，注册成功！\");return true;}</script>";
                out.print(a);
                out.close();
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            } else {
                PrintWriter out = response.getWriter();
                String a = "<body onLoad=\"checkForm()\"><script language=\"JavaScript\" type=\"text/JavaScript\">function checkForm(){"+
                        "alert(\"注册失败！\n用户名不得超过20个字符\n密码不得超过20个字符\n电话号码不得超过15位数字\");return true;}</script>";
                out.print(a);
                out.close();
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
