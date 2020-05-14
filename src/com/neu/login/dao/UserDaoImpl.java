package com.neu.login.dao;

import com.neu.login.util.MySQLConnector;
import com.neu.login.vo.User;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl() {
        connection = MySQLConnector.getConnection();
    }

    @Override
    public boolean addUser(String username, String password, String telephone) throws Exception {
        int count = 0;
        String sql = "insert into user_login (username, password, telephone)values(?,?,?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, telephone);
            count = preparedStatement.executeUpdate();
            if (count >= 1) {
                return true;
            } else {
                System.err.println("没有添加任何用户!");
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
            e.printStackTrace();
            throw new Exception("添加用户失败");
        } finally {
            MySQLConnector.closeConnection(null, preparedStatement, connection);
        }
        return false;
    }

    @Override
    public int deleteUser(User user) throws Exception{
        int count = 0;
        String sql = "delete from user_login where user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUserId());
            count = preparedStatement.executeUpdate();
            if (count >= 1) {
                System.out.println("删除用户成功!");
            } else {
                System.out.println("没有删除任何用户!");
            }
        } catch (SQLException e) {
            System.out.println("建立通道失败");
            e.printStackTrace();
            throw new Exception("删除用户失败");
        } finally {
            MySQLConnector.closeConnection(null, preparedStatement, connection);
        }
        return count;
    }

    @Override
    public int updateUser(User user) throws Exception{
        int count;
        String sql = "update user_login set username=?, password=? where user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getUserId());
            count = preparedStatement.executeUpdate();
            if (count >= 1) {
                System.out.println("修改用户成功!");
            } else {
                System.out.println("没有修改任何用户!");
            }
        } catch (SQLException e) {
            System.out.println("建立通道失败");
            e.printStackTrace();
            throw new Exception("修改用户失败");
        } finally {
            MySQLConnector.closeConnection(null, preparedStatement, connection);
        }
        return count;
    }

    @Override
    public User getUserById(Integer userId) throws Exception{
        User user = new User();
        String sql = "select * from user_login where user_id=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("建立通道失败");
            e.printStackTrace();
            throw new Exception("查询单个用户失败");
        } finally {
            MySQLConnector.closeConnection(resultSet, preparedStatement, connection);
        }
        return user;
    }

    @Override
    public List<User> getPageByQuery(String sql) throws Exception {
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        User user;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setTelephoneNumber(resultSet.getString("telephone"));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("建立通道失败!");
            e.printStackTrace();
        } finally {
            MySQLConnector.closeConnection(resultSet, statement, connection);
        }
        return list;
    }

    @Override
    public int getTotalRecordSum(String sql) throws Exception{
        int totalRecordSum = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                totalRecordSum = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("建立通道失败");
            e.printStackTrace();
            throw new Exception("查询用户数量失败");
        } finally {
            MySQLConnector.closeConnection(resultSet, preparedStatement, connection);
        }
        return totalRecordSum;
    }

}

