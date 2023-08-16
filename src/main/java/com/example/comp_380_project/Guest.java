package com.example.comp_380_project;

import java.util.ArrayList;

/**
 * This class Guest handles the creation and utilities of Guest "objects" that can register by
 * creating unique usernames and passwords, and using those as parameters to log in and access the main menu.
 * Guest can modify the reservations array and verify identities with Main.
 *
 * @author Jorge Enriquez
 * Date: August 15, 2023
 * Version: 1.0*/

public class Guest {
    private String username;
    private String password;
    private String Name;
    private int guestIndex;
    private ArrayList<Integer> bookedReservations = new ArrayList<>();

    /** Constructor */
    Guest(){}

    /** Constructor that takes in a username and password and sets bookedReservations to 0
     * @param un takes in a String username
     * @param pw takes in a String password
     * */
    Guest(String un, String pw){
        this.username = un;
        this.password = pw;
        this.bookedReservations.add(0);
    }
    /** Constructor that takes in a username and password and calls initReservations
     * @param un takes in a String username
     * @param pw takes in a String password
     * @param res takes in a String reservation
     * */
    Guest(String un, String pw, String res){
        this.username = un;
        this.password = pw;
        initReservations(res);
    }

    
    /** Sets the username of the Guest
     * @param UserName gets a String
     */
    void setUsername(String UserName){
        this.username = UserName;
    }
    
    /** Sets the password of the Guest
     * @param pw gets a String
     **/
    void setPassword(String pw){
        this.password = password;
    }
    
    /** Checks if the password is correct
     * @param pw takes in a String
     * @return boolean returns true or false
     **/
    boolean isCorrectPW(String pw){
        return this.password.equals(pw);
    }
    /** Checks if any rooms are booked
     * @return boolean returns true or false
     **/
    boolean hasRooms(){ return !(bookedReservations.size() == 1 && bookedReservations.get(0) == 0); }
    /** adds any reservations passed on by FileReader.
     * @param reservations takes in a String
     **/
    void initReservations(String reservations){
        if(reservations.length() == 1) addReservation(Integer.parseInt(reservations));
        else {
            /* The following converts multi-digit integer into 2 single-digit integers. The 2 single-digit integers are used to add username to appropriate floor array */
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
    /** adds a reservation to bookedReservations array
     * @param room takes in an int
     **/
    void addReservation(int room){
        bookedReservations.add(room);
        if(bookedReservations.size() > 1 && bookedReservations.get(0)==0)
            bookedReservations.remove(0);
        printReservationsArray();
    }
    /** removes a reservation from the bookedReservations array
     * @param room takes in an int
     **/
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
    /** turns the bookedReservations array into a string
     * @return String returns a string for FileReader to use
     **/
    public String reservationsToString(){
        String allReservations = "";
        for (int i = 0; i < bookedReservations.size(); i++) {
            allReservations += bookedReservations.get(i).toString();
        }
        System.out.println(allReservations);
        return allReservations;
    }
    /** returns the size of bookedReservations array
     * @return int returns an integer
     **/
    public int amountOfReservations(){return bookedReservations.size();}
    /** returns an integer in the bookedReservations array
     * @param num takes in an integer
     * @return int returns an integer
     **/
    public int getReservation(int num){return bookedReservations.get(num);}
    /** returns the username of the Guest object
     * @return String returns a string*/
    public String getUsername(){return username;}
    /** sets the index in which Guest object resides in FileReader usernames array
     * @param index takes an int*/
    public void setGuestIndex(int index){
        this.guestIndex = index;
    }
    /** returns the index in which Guest object resides in FileReader usernames array
     * @return  int returns an int*/
    public int getGuestIndex(){
        return this.guestIndex;
    }
    /** Prints the bookedReservations array to the console */
    public void printReservationsArray(){
        for (int i = 0; i < bookedReservations.size(); i++) {
            System.out.println(bookedReservations.get(i));
        }
    }
}
