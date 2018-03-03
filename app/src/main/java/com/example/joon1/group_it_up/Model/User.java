package com.example.joon1.group_it_up.Model;

/**
 * Created by Minky on 2018-03-02.
 */

public class User {
    public static int uid = 0;
    private String account;
    private String password;
    private String contact;

    public User(int uid, String account, String password, String contact) {
        this.uid = uid;
        this.account = account;
        this.password = password;
        this.contact = contact;
    }

    public int getUid() {
        return uid;
    }

    public String getContact() {
        return contact;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
