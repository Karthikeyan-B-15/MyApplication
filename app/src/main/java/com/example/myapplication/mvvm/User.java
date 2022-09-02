package com.example.myapplication.mvvm;

public class User {
    String fname,lname;
    public User(String fname,String lname){
        this.fname=fname;
        this.lname=lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
