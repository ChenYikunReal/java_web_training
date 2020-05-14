package com.neu.login.service;

import com.neu.login.dao.UserDao;
import com.neu.login.dao.UserDaoImpl;
import com.neu.login.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao dao = new UserDaoImpl();

    public User login(String username, String password) throws Exception{
        User user = null;
        String sql = "select * from user_login where username='" + username+ "' and password='" + password + "'";
        List<User> list = dao.getPageByQuery(sql);
        if(list != null && !list.isEmpty()){
            user = list.get(0);
        }
        return user;
    }

}
