package com.web.login.service;

import com.web.login.dao.UserDao;
import com.web.login.dao.UserDaoImpl;
import com.web.login.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(String username, String password) throws Exception{
        User user = null;
        String sql = "select * from user_login where username='" + username+ "' and password='" + password + "'";
        List<User> list = dao.getPageByQuery(sql);
        if(list != null && !list.isEmpty()){
            user = list.get(0);
        }
        return user;
    }

    @Override
    public boolean register(String username, String password, String telephone) throws Exception {
        if (username.length() == 0 || username.length() > 20 || password.length() == 0 || password.length() > 20 ||
                telephone.length() > 15 || !telephone.matches("\\d+")) {
            return false;
        }
        return dao.addUser(username, password, telephone);
    }

}
