package com.example.comp_380_project;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Guest {
    private String username;
    private String password;
    private String Name;
    private int guestIndex;
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
        initReservations(res);
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
    boolean hasRooms(){ return !(bookedReservations.size() == 1 && bookedReservations.get(0) == 0); }
    void initReservations(String reservations){
        if(reservations.length() == 1) addReservation(Integer.parseInt(reservations));
        else {
            /** The following converts multi-digit integer into 2 single-digit integers. The 2 single-digit integers are used to add username to appropriate floor array */
            int room;
            int firstDigit;
            int secondDigit;
            for (int i = 0; i < reservations.length(); i++) {
                firstDigit = (reservations.charAt(i)-48)*10;
                secondDigit = reservations.charAt(i+1)-48;
                room = firstDigit + secondDigit;
                addReservation(room);
                i++;
            }
        }
    }
    void addReservation(int room){
        bookedReservations.add(room);
        if(bookedReservations.size() > 1 && bookedReservations.get(0)==0)
            bookedReservations.remove(0);
    }
    void cancelReservation(int room){
        for(int i = 0; i< bookedReservations.size();i++) {
            if (bookedReservations.get(i) == room) {
                bookedReservations.remove(i);
            }else {
                System.out.println("No reservation at " + room + " exists.");
            }
        }
        if(bookedReservations.isEmpty()) bookedReservations.add(0);
    }
    public String reservationsToString(){
        String allReservations = "";
        for (int i = 0; i < bookedReservations.size(); i++) {
            allReservations += bookedReservations.get(i).toString();
        }
        System.out.println(allReservations);
        return allReservations;
    }
    void modifyReservations(int room){}
    public int amountOfReservations(){return bookedReservations.size();}
    public int getReservation(int num){return bookedReservations.get(num);}
    public String getUsername(){return username;}
    public void setGuestIndex(int index){
        this.guestIndex = index;
    }
    public int getGuestIndex(){
        return this.guestIndex;
    }
    public void printReservationsArray(){
        for (int i = 0; i < bookedReservations.size(); i++) {
            System.out.println(bookedReservations.get(i));
        }
    }
}
