package com.exampro.model;

public class User{
    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份
     */
    private Integer roleid;

    public User(String username, String password, Integer roleid) {
        this.username = username;
        this.password = password;
        this.roleid = roleid;
    }

    public User(Integer userid, String username, String password, Integer roleid) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.roleid = roleid;
    }

    public User(int parseInt, String subject) {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                '}';
    }
}