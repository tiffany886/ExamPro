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
    private Integer role;

    public User(Integer userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public User(Integer userid, String username, String password, Integer role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, Integer role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    private static final long serialVersionUID = 1L;

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", userid=" + userid +
                ", username=" + username +
                ", password=" + password +
                ", role=" + role +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}