package com.neu.login.service;

import com.neu.login.vo.User;

public interface UserService {
    User login(String username, String password) throws Exception;
}
