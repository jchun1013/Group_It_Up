package com.example.joon1.group_it_up.Model;

/**
 * Created by sangwonyuh on 3/2/18.
 */

public enum RecOrComp {
    RECRUIT ("Recruit"),
    COMPETITION ("Competition");

    private String choice;

    RecOrComp(String myChoice) {
        choice = myChoice;
    }

    public String toString() {return this.choice;}
}
