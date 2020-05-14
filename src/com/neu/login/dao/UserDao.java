package com.neu.login.dao;

import com.neu.login.vo.User;

import java.util.List;

public interface UserDao {

    /**
     * 增加新用户
     * @param user
     * @return
     * @throws Exception
     */
    int addUser(User user) throws Exception;

    /**
     * 删除已有用户
     * @param user 已有用户
     * @return
     * @throws Exception
     */
    int deleteUser(User user) throws Exception;

    /**
     * 修改已有用户信息
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(User user) throws Exception;

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
     * @param sql SQL语句
     * @return 记录总数
     * @throws Exception
     */
    int getTotalRecordSum(String sql) throws Exception;

}

