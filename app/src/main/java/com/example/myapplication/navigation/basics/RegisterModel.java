package com.example.myapplication.navigation.basics;

public class RegisterModel {
    int id;
    String user,number,pass;
    public RegisterModel(int id,String user,String number,String pass){
        this.user=user;
        this.pass=pass;
        this.number=number;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
