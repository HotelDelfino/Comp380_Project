package com.example.comp_380_project;

import javafx.scene.control.Alert;

import java.util.Objects;
import java.util.Scanner;

/**
 * The HotelRooms class contains each floor of the hotel as String arrays, in which every index 0-9 is a room available
 * for booking. The HotelRooms class also contains methods that allow Guests to manipulate the String arrays' indices via
 * the FileReader class, which stores Guests' reservation info. These methods serve as the backend processes by which the
 * Main Menu's buttons call upon to operate.
 * @author Sergio Dieguez
 *  Date: Aug 15, 2023
 *  */

public class HotelRooms {

    Guest guest;
    private static FileReader database;
    String[] floor1 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Small rooms
    String[] floor2 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Larger rooms
    String[] floor3 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Family rooms
    String[] floor4 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Luxury rooms
    String[] floor5 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Penthouse suite


    /**This method gets the user's floor room and number room.
     * Based on the user's input of room number it will go into the specific string array and change the string inside from open to closed in the index
     * @param floor takes in an integer
     * @param roomNum takes in an integer
     */
    public void reserveRoom(int floor, int roomNum) {                               //Method gets the user's floor room and number room
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {             //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            if (floor == 1) {

                if (floor1[roomNum].equals("Open")) {                                               //This checks if the room is not closed
                        floor1[roomNum] = guest.getUsername();                                      //If it isn't, make it so the room the user choose now becomes closed
                        guest.addReservation((floor*10)+roomNum);
                        database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum + "!");      //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                    alert.showAndWait();                                                                    //different room through a pop-up box
                }
            }else if (floor == 2) {

                if (floor2[roomNum].equals("Open")) {                                  //This checks if the room is not closed
                    floor2[roomNum] = guest.getUsername();                                     //If it isn't, make it so the room the user choose now becomes closed
                    guest.addReservation((floor*10)+roomNum);
                    database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for booking room " + floor + roomNum + "!");     //Thanks the user for booking the room through a pop-up box
                    alert.showAndWait();
                } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                    alert.showAndWait();                                                                    //different room through a pop-up box
                }
            }
                if (floor == 3) {
                    if (floor3[roomNum].equals("Open")) {                                  //This checks if the room is not closed
                        floor3[roomNum] = guest.getUsername();                                     //If it isn't, make it so the room the user choose now becomes closed
                        guest.addReservation((floor*10)+roomNum);
                        database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum + "!");     //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                    } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                        alert.showAndWait();                                                                    //different room through a pop-up box
                    }
                }
                if (floor == 4) {
                    if (floor4[roomNum].equals("Open")) {                                  //This checks if the room is not closed
                        floor4[roomNum] = guest.getUsername();                                    //If it isn't, make it so the room the user choose now becomes closed
                        guest.addReservation((floor*10)+roomNum);
                        database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum + "!");     //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                    } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                        alert.showAndWait();                                                                    //different room through a pop-up box
                    }
                }
                if (floor == 5) {
                    if (floor5[roomNum].equals("Open")) {                                  //This checks if the room is not closed
                        floor5[roomNum] = guest.getUsername();                                     //If it isn't, make it so the room the user choose now becomes closed
                        guest.addReservation((floor*10)+roomNum);
                        database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum + "!");     //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                    } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                        alert.showAndWait();                                                                    //different room through a pop-up box
                    }
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!"); //If the user picks a wrong input for the rooms
                alert.showAndWait();                                                                                    //Or the floors it will give this message through
            }                                                                                                           //through a pop-up window
        }
    /**
     * @param floor
     * @param roomNum
     *
     * This method allows the user to cancel the room they booked.
     * Based on the user's input of room number it will go into the specific string array and change the string from username to open inside the index
     *
     */
    public void cancelRoom(int floor, int roomNum) {                               //Method allows the user to cancel the room they booked
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {            //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            if (floor == 1) {
                if (floor1[roomNum].equals(guest.getUsername())) {                                //This checks if the room is not open
                    floor1[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
                    guest.cancelReservation((floor*10)+roomNum);
                    database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!"); //Thanks the user for letting the hotel know
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);                                                              //If a user tries to cancel a room that is not theirs
                    alert.setContentText("Sorry but this room is not under your name. Please try again.");   //Then this message should let them know to try again
                    alert.showAndWait();
                }
            }
            if (floor == 2) {
                if (floor2[roomNum].equals(guest.getUsername())) {                                //This checks if the room is not open
                    floor2[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
                    guest.cancelReservation((floor*10)+roomNum);
                    database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!"); //Thanks the user for letting the hotel know
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);                                                              //If a user tries to cancel a room that is not theirs
                    alert.setContentText("Sorry but this room is not under your name. Please try again.");   //Then this message should let them know to try again
                    alert.showAndWait();
                }
            }
            if (floor == 3) {
                if (floor3[roomNum].equals(guest.getUsername())) {                                //This checks if the room is not open
                    floor3[roomNum] = "Open";                                                       //If not, make the closed room open to imitate a user canceling there reservation
                    guest.cancelReservation((floor*10)+roomNum);
                    database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!"); //Thanks the user for letting the hotel know
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);                                                              //If a user tries to cancel a room that is not theirs
                    alert.setContentText("Sorry but this room is not under your name. Please try again.");   //Then this message should let them know to try again
                    alert.showAndWait();
                }
            }
            if (floor == 4) {
                if (floor4[roomNum].equals(guest.getUsername())) {                                //This checks if the room is not open
                    floor4[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
                    guest.cancelReservation((floor*10)+roomNum);
                    database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!"); //Thanks the user for letting the hotel know
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);                                                              //If a user tries to cancel a room that is not theirs
                    alert.setContentText("Sorry but this room is not under your name. Please try again.");   //Then this message should let them know to try again
                    alert.showAndWait();
                }
            }
            if (floor == 5) {
                if (floor5[roomNum].equals(guest.getUsername())) {                                //This checks if the room is not open
                    floor5[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
                    guest.cancelReservation((floor*10)+roomNum);
                    database.updateReservationTextFile(guest.reservationsToString(), guest.getGuestIndex());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!"); //Thanks the user for letting the hotel know
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);                                                              //If a user tries to cancel a room that is not theirs
                    alert.setContentText("Sorry but this room is not under your name. Please try again.");   //Then this message should let them know to try again
                    alert.showAndWait();
                }
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!"); //If the user picks a wrong input for the rooms
            alert.showAndWait();                                                                                    //Or the floors it will give this message through
        }                                                                                                           //through a pop-up window
    }
    /**
     * @param initFloor
     * @param initRoom
     * @param finFloor
     * @param finRoom
     *
     * This method allows the user to change their room they reserved to another.
     * When the user selects this option it will ask for the room they reserved and use the cancelRoom method to remove their reservation.
     * Then the user will select which room they want to reserve hence why it is calling the reserveRoom method.
     *
     */
    public void editRoom(int initFloor, int initRoom, int finFloor, int finRoom) { //Method allows the user to change their room they reserved to another
        if(initFloor >= 1 && initFloor <= 5 && initRoom >= 0 && initRoom <= 9 && finFloor >= 1 && finFloor <=5 && finRoom >= 0 && finRoom <= 9) { //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            cancelRoom(initFloor, initRoom); //Cancel initial booking
            reserveRoom(finFloor, finRoom); // Reserve target room
        } else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!"); //If the user picks a wrong input for the rooms
        alert.showAndWait();                                                                                    //Or the floors it will give this message through
        }
    }
    /**
     * @param floor
     * @param roomNum
     *
     * This method detects if user picked an option from 1 to 5 for floors and 0 to 9 for each room
     * Based on the user's input of room number it will return if the room is closed or open.
     *
     */
    public void searchRoom(int floor, int roomNum){
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {         //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            if (floor == 1) {
                if (floor1[roomNum].equals("Open")) {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible.");
                    alert.showAndWait();
                }
            }
            if (floor == 2) {
                if (floor2[roomNum].equals("Open")) {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible.");
                    alert.showAndWait();
                }
            }
            if (floor == 3) {
                if (floor3[roomNum].equals("Open")) {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible.");
                    alert.showAndWait();
                }
            }
            if (floor == 4) {
                if (floor4[roomNum].equals("Open")) {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible.");
                    alert.showAndWait();
                }
            }
            if (floor == 5) {
                if (floor5[roomNum].equals("Open")) {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible.");
                    alert.showAndWait();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!"); //If the user picks a wrong input for the rooms
            alert.showAndWait();                                                                                    //Or the floors it will give this message through
        }                                                                                                           //through a pop-up window
    }
    /**
     * @param floor
     *
     * This method gives you basic information of each the rooms as a way to market the hotel.
     * If the user wants to know more information on what room they want to reserve, this returns message
     *
     */
    public void roomInfo(int floor){                            //Method gives you basic information of each the rooms as a way to market the hotel
        if (floor >= 1 && floor <= 5) {                         //The user can choose floors 1-5
            if (floor == 1) {                                                       //Goes into the description for small rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Small rooms, perfect for 1-2 people to enjoy!");
                alert.showAndWait();
            }
            if (floor == 2) {                                                       //Goes into the description for large rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Larger rooms, to fit 3-4 people nicely!");
                alert.showAndWait();
            }
            if (floor == 3) {                                                       //Goes into the description for family rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Perfect for families of 5-6 people. Baby station included!");
                alert.showAndWait();
            }
            if (floor == 4) {                                                       //Goes into the description for luxurious rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Luxurious rooms for those who love interior design.");
                alert.showAndWait();
            }
            if (floor == 5) {                                                       //Goes into the description for penthouse suites
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Spacious and luxurious penthouse suite! Fit for a king!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!");//If the user picks a wrong input for the rooms
            alert.showAndWait();                                                                                    //Or the floors it will give this message through
        }                                                                                                           //through a pop-up window
    }
    /**
     * @param stars
     *
     * This method can score their experience at the hotel.
     * If the user enters a specific amount of stars to the menu it will give a message based on what they selected
     *
     */
    public void roomReview(int stars){
        if (stars >= 1 && stars <= 5) {                                             //The user can score their experience at the hotel
            if (stars == 1) {                                                       //Gives an apologetic message for such a terrible score
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("We are so sorry that the experience was terrible, we hope your next experience here would be so much better.");
                alert.showAndWait();
            }
            if (stars == 2) {                                                       //Gives a sorrowful message for such a bad score
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("We are so sorry that the experience was bad, we hope your next experience here would be much better.");
                alert.showAndWait();
            }
            if (stars == 3) {                                                       //Gives a sad response to an average score
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("We are so sorry that the experience wasn't as good we wanted you to have.");
                alert.showAndWait();
            }
            if (stars == 4) {                                                       //Gives a happy message for a better score
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("We are happy to hear that! We hope we can get a perfect score next time!");
                alert.showAndWait();
            }
            if (stars == 5) {                                                       //Gives a thankful message for perfect score
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Thank you so much! A perfect score!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Thank you for stopping by at Hotel Delfino!");    //If the user doesn't pick anything it will give them thanks anyway
            alert.showAndWait();
        }
    }
    /** sets current logged in guest. */
    public void setGuestOnLogin(Guest guest1){this.guest = guest1;
        this.guest.printReservationsArray();}
    /** Activates when file reader instantiates. Updates all arrays with what is on reservations.txt */
    public void updateHotelRoomsArray(Guest guest){
        if(!guest.hasRooms())return;
        else{
            /** The following converts 1 double-digit integer into 2 single-digit integers. The 2 single-digit integers are used to add username to appropriate floor array */
            String room;
            int floor;
            int roomNum;
            for(int i = 0; i < guest.amountOfReservations(); i++){
                room = Integer.toString(guest.getReservation(i));
                floor = Integer.parseInt(Character.toString(room.charAt(0)));
                roomNum = Integer.parseInt(Character.toString(room.charAt(1)));
                if(floor == 1) floor1[roomNum] = guest.getUsername();
                else if(floor == 2) floor2[roomNum] = guest.getUsername();
                else if(floor == 3) floor3[roomNum] = guest.getUsername();
                else if(floor == 4) floor4[roomNum] = guest.getUsername();
                else floor5[roomNum] = guest.getUsername();
            }
        }
    }
    /** Used for bug fixing, serves no other purpose */
    public void printArray(){
        for (int i = 0; i < floor1.length; i++) {
            System.out.println(floor1[i]);
        }
    }

    public void setDatabase(FileReader db){
        database = db;
    }
}
