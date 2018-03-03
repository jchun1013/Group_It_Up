package com.example.joon1.group_it_up.Model;

/**
 * Created by Minky on 2018-03-02.
 */

public class EventCard {
    private String title, comments;
    private int uid, contact;
    private Sports sports;
    private Gender gender;
    private Experience experience;

    public EventCard(String myTitle, String myComments, int myUid, int myContact,
                     Sports mySport, Gender myGender, Experience myExp) {
        this.title = myTitle;
        this.comments = myComments;
        this.uid = myUid;
        this.contact = myContact;
        this.sports = mySport;
        this.gender = myGender;
        this.experience = myExp;
    }

    public String getTitle() {return this.title;}
    public void setTitle(String nTitle) {this.title = nTitle;}

    public String getComments() {return this.comments;}
    public void setComments(String nComment) {this.comments = nComment;}

    public int getUid() {return this.uid;}
    public void setUid(int nUid) {this.uid = nUid;}

    public int getContact() {return this.contact;}
    public void setContact(int nContact) {this.contact = nContact;}

    public Sports getSports() {return this.sports;}
    public void setSports(Sports nSports) {this.sports = nSports;}

    public Gender gender() {return this.gender;}
    public void setGender(Gender nGender) {this.gender = nGender;}

    public Experience getExperience() {return this.experience;}
    private void setExperience(Experience nExp) {this.experience = nExp;}





}
