package com.neu.login.vo;

/**
 * 系统用户类
 * 这是一个实体类
 */
public class User {

    private Integer userId;

    private String userName;

    private String password;

    private String telephoneNumber;

    private Integer isVip;

    public User() {}

    public User(Integer userId, String userName, String password, String tel, Integer isVip) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.telephoneNumber = tel;
        this.isVip = isVip;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", isVip=" + isVip +
                '}';
    }
}

