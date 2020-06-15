package com.neu.login.servlet;

import com.neu.login.dao.UserDao;
import com.neu.login.dao.UserDaoImpl;
import com.neu.login.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryByPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size = 10;
        UserDao dao = new UserDaoImpl();
        try {
            int count = dao.getTotalRecordSum();
            int total = count/size;
            if (count % size != 0) {
                total++;
            }
            dao = new UserDaoImpl();
            List<User> usersList = dao.queryByPage(page, size);
            request.setAttribute("totalPage", total);
            request.setAttribute("usersList", usersList);
            request.setAttribute("curPage", page);
            request.getRequestDispatcher("users_list.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
