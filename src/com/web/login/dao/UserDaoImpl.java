package com.web.login.dao;

import com.web.login.util.MySQLConnector;
import com.web.login.vo.User;

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
        String sql = "insert into user_login (username, password, telephone, vip)values(?,?,?,0);";
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
    public int deleteUserById(String id) throws Exception{
        int count = 0;
        String sql = "delete from user_login where user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
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
    public int updateUser(String id, String name, String telephone) throws Exception{
        int count;
        String sql = "update user_login set username=?, telephone=? where user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, telephone);
            preparedStatement.setString(3, id);
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
    public int addVip(String id) throws Exception{
        int count;
        String sql = "update user_login set vip=1 where user_id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            count = preparedStatement.executeUpdate();
            if (count >= 1) {
                System.out.println("修改用户成功!");
            } else {
                System.out.println("没有修改任何用户!");
            }
        } catch (SQLException e) {
            System.out.println("建立通道失败");
            e.printStackTrace();
            throw new Exception("新增VIP失败");
        } finally {
            MySQLConnector.closeConnection(null, preparedStatement, connection);
        }
        return count;
    }

    @Override
    public User getUserById(Integer userId) throws Exception{
        User user = null;
        String sql = "select * from user_login where user_id=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getInt(5));
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
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getInt(5));
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
    public int getTotalRecordSum() throws Exception{
        int totalRecordSum = 0;
        String sql = "select count(*) from user_login";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                totalRecordSum = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("建立通道失败");
            e.printStackTrace();
            throw new Exception("查询用户数量失败");
        } finally {
            MySQLConnector.closeConnection(resultSet, statement, connection);
        }
        return totalRecordSum;
    }

    @Override
    public List<User> queryByPage(int page, int size) throws Exception {
        List<User> list = new ArrayList<>();
        User user;
        String sql = "select * from user_login limit ?,?";
//        System.out.println(page);
//        System.out.println((page-1)*size+1);
//        System.out.println(size);
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (page-1)*size);
            statement.setInt(2, size);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getInt(5));
                list.add(user);
            }
        } catch (SQLException e) {
            System.err.println("分页查询失败");
            e.printStackTrace();
        } finally {
            MySQLConnector.closeConnection(resultSet, statement, connection);
        }
        return list;
    }

}

