package com.example.joon1.group_it_up.Model;

/**
 * Created by sangwonyuh on 3/2/18.
 */

public enum Experience {
    BEGINNER ("Beginner"),
    AMATEUR ("Amateur"),
    INTERMEDIATE ("Intermediate"),
    SEMIPRO ("Semi-Pro"),
    PROFESSIONAL ("Professional");

    private String exp;

    Experience(String myExp) {
        exp = myExp;
    }

    public String toString() {return this.exp;}




}
