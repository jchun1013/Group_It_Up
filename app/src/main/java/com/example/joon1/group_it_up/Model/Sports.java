package com.example.joon1.group_it_up.Model;

/**
 * Created by sangwonyuh on 3/2/18.
 */

public enum Sports {
    SOCCER ("Soccer"),
    BASKETBALL ("Basketball"),
    BASEBALL ("Baseball"),
    TENNIS ("Tennis"),
    GOLF ("Golf"),
    FOOTBALL ("Football"),
    OTHER ("Other");

    private String sport = "";

    Sports(String aSport) {
        sport = aSport;
    }
    
    public String toString() {return this.sport;}
}
