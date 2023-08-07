package com.example.comp_380_project;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Guest {
    private String username;
    private String password;
    private String Name;
    private ArrayList<Integer> bookedReservations = new ArrayList<>();

    Guest(){}
    Guest(String un, String pw){
        this.username = un;
        this.password = pw;
        this.bookedReservations.add(0);
    }
    Guest(String un, String pw, String res){
        this.username = un;
        this.password = pw;
        this.bookedReservations.add(parseInt(res));
    }

    void setUsername(String UserName){
        this.username = UserName;
    }
    void setPassword(String pw){
        this.password = password;
    }
    boolean isCorrectPW(String pw){
        return this.password.equals(pw);
    }
    /** Checks if any rooms are booked **/
    void hasRooms(){

    }
    void addReservation(int room){
        bookedReservations.add(room);
    }
    void cancelReservation(int room){
        for(int i = 0; i< bookedReservations.size();i++) {
            if (bookedReservations.get(i) == room) {
                bookedReservations.remove(i);
            }else {
                System.out.println("No reservation at " + room + " exists.");
            }
        }
    }
    // Need HotelRooms Finished
    void modifyReservations(int room){}

}
