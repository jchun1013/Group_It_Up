package com.example.joon1.group_it_up.Model;

/**
 * Created by sangwonyuh on 3/2/18.
 */

public enum Gender {
    DEFAULT("Choose your gender"),
    MALE ("Male"),
    FEMALE ("Female");

    private String myGender = "";

    Gender(String aGender) {
        myGender = aGender;
    }

    public String toString() {return this.myGender;}


}
