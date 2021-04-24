package com.web.login.dao;

import com.web.login.vo.User;

import java.util.List;

public interface UserDao {

    /**
     * 注册新用户
     * @param username 用户提交的合法用户名
     * @param password 用户提交的合法密码
     * @param telephone 用户提交的合法电话号码
     * @return
     * @throws Exception
     */
    boolean addUser(String username, String password, String telephone) throws Exception;

    /**
     * 删除已有用户
     * @param user 已有用户
     * @return
     * @throws Exception
     */
    int deleteUser(User user) throws Exception;

    int deleteUserById(String id) throws Exception;

    /**
     * 修改已有用户信息
     * @return
     * @throws Exception
     */
    int updateUser(String id, String name, String telephone) throws Exception;

    int addVip(String id) throws Exception;

    /**
     * 根据ID查User
     * @param userId
     * @return
     * @throws Exception
     */
    User getUserById(Integer userId) throws Exception;

    /**
     * 使用SQL语句查询用户集合
     * @param sql
     * @return
     * @throws Exception
     */
    List<User> getPageByQuery(String sql) throws Exception;

    /**
     * 根据SQL语句查询记录总数
     * @return 记录总数
     * @throws Exception
     */
    int getTotalRecordSum() throws Exception;

    List<User> queryByPage(int page, int size) throws Exception;

}

