package com.web.login.service;

import com.web.login.vo.User;

public interface UserService {

    /**
     * 用户登录功能
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    User login(String username, String password) throws Exception;

    /**
     * 用户登录功能
     * @param username
     * @param password
     * @param telephone
     * @return
     * @throws Exception
     */
    boolean register(String username, String password, String telephone) throws Exception;

}
