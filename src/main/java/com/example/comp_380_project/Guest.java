package com.example.comp_380_project;

public class Guest {
    private String username;
    private String password;
    private String Name;

    void setUsername(String UserName){
        this.username = UserName;
    }
    void setPassword(String pw){
        this.password = password;
    }
    boolean isCorrectPW(String pw){
        return this.password == pw;
    }
    void menu(){
        System.out.println("1. Reserve a room ");
        System.out.println("2. Cancel a reservation ");
        System.out.println("3. View reservations ");
        System.out.println("0. Logout ");
    }

}
