package com.example.joon1.group_it_up.Model;

/**
 * Created by Minky on 2018-03-02.
 */

public class User {
    private static int uid;
    private String account;
    private String password;
    private int contact;

    public User(int uid, String account, String password, int contact) {
        this.uid = uid++;
        this.account = account;
        this.password = password;
        this.contact = contact;
    }

    public int getUid() {
        return uid;
    }

    public int getContact() {
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

    public void setContact(int contact) {
        this.contact = contact;
    }
}
