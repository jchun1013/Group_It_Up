package com.example.joon1.group_it_up.Model;

/**
 * Created by Minky on 2018-03-02.
 */

public class EventCard {
    private String title, comments, contact, location;
    private int uid;
    private Sports sports;
    private Gender gender;
    private Experience experience;
    private String date;
    private RecOrComp rec;
    public static int eid;

    public EventCard() {

    }

    public EventCard(String myTitle, String myComments, int myUid, String myContact,
                     Sports mySport, Gender myGender, Experience myExp,
                      String date, RecOrComp rec, String location, int eid) {
        this.title = myTitle;
        this.comments = myComments;
        this.uid = myUid;
        this.contact = myContact;
        this.sports = mySport;
        this.gender = myGender;
        this.experience = myExp;
        this.date = date;
        this.location = location;
        this.rec = rec;
        this.eid = eid;
    }

    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public RecOrComp getRec() {
        return rec;
    }
    public void setRec(RecOrComp rec) {
        this.rec = rec;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDate() {return this.date;}
    public void setDate(String date) {this.date = date;}
    public String getTitle() {return this.title;}
    public void setTitle(String nTitle) {this.title = nTitle;}

    public String getComments() {return this.comments;}
    public void setComments(String nComment) {this.comments = nComment;}

    public int getUid() {return this.uid;}
    public void setUid(int nUid) {this.uid = nUid;}

    public String getContact() {return this.contact;}
    public void setContact(String nContact) {this.contact = nContact;}

    public Sports getSports() {return this.sports;}
    public void setSports(Sports nSports) {this.sports = nSports;}

    public Gender getGender() {return this.gender;}
    public void setGender(Gender nGender) {this.gender = nGender;}

    public Experience getExperience() {return this.experience;}
    private void setExperience(Experience nExp) {this.experience = nExp;}

    public String toString() {return this.title;}




}
