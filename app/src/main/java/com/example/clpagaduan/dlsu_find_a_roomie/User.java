package com.example.clpagaduan.dlsu_find_a_roomie;

public class User {
    String userID;
    String lname;
    String fname;
    String gen;
    String email;

    public User(){

    }

    public User(String userID, String lname, String fname, String gen, String email) {
        this.userID = userID;
        this.lname = lname;
        this.fname = fname;
        this.gen = gen;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
