package com.mrgao.enty;

public class UserBean {
    int id;
    String username;
    String password;
    double account;

    public UserBean() {
    }

    public UserBean(String username, String password, double account) {
        this.username = username;
        this.password = password;
        this.account = account;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
