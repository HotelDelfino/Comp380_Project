package com.example.comp_380_project;

import javafx.scene.control.Alert;

import java.util.Objects;
import java.util.Scanner;


public class HotelRooms {

    Guest guest;
    String[] floor1 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Small rooms
    String[] floor2 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Larger rooms
    String[] floor3 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Family rooms
    String[] floor4 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Luxury rooms
    String[] floor5 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Penthouse suite


    public void reserveRoom(int floor, int roomNum) {                               //Method gets the user's floor room and number room
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {             //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            if (floor == 1) {

                if (floor1[roomNum] != "Closed") {                                  //This checks if the room is not closed
                    floor1[roomNum] = "Closed";                                     //If it isn't, make it so the room the user choose now becomes closed

                    if (floor1[roomNum].equals("Open")) {
                        floor1[roomNum] = guest.getUsername();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum);     //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                    } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                        alert.showAndWait();                                                                    //different room through a pop-up box
                    }
                }
                if (floor == 2) {
                    if (floor2[roomNum] != "Closed") {                                  //This checks if the room is not closed
                        floor2[roomNum] = "Closed";                                     //If it isn't, make it so the room the user choose now becomes closed
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum);     //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                    } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                        alert.showAndWait();                                                                    //different room through a pop-up box
                    }
                }
                if (floor == 3) {
                    if (floor3[roomNum] != "Closed") {                                  //This checks if the room is not closed
                        floor3[roomNum] = "Closed";                                     //If it isn't, make it so the room the user choose now becomes closed
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum);     //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                    } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                        alert.showAndWait();                                                                    //different room through a pop-up box
                    }
                }
                if (floor == 4) {
                    if (floor4[roomNum] != "Closed") {                                  //This checks if the room is not closed
                        floor4[roomNum] = "Closed";                                     //If it isn't, make it so the room the user choose now becomes closed
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum);     //Thanks the user for booking the room through a pop-up box
                        alert.showAndWait();
                    } else {                                                            //If room is closed, it will not allow the user to continue booking the room
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Sorry but this room is already booked! Please try another room.");  //It will give this message to the user to try again with a
                        alert.showAndWait();                                                                    //different room through a pop-up box
                    }
                }
                if (floor == 5) {
                    if (floor5[roomNum] != "Closed") {                                  //This checks if the room is not closed
                        floor5[roomNum] = "Closed";                                     //If it isn't, make it so the room the user choose now becomes closed
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Thank you for booking room " + floor + roomNum);     //Thanks the user for booking the room through a pop-up box
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
    }

    public void cancelRoom(int floor, int roomNum) {                               //Method allows the user to cancel the room they booked
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {            //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            if (floor == 1) {
                if (floor1[roomNum] != "Open") {                                //This checks if the room is not open
                    floor1[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
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
                if (floor2[roomNum] != "Open") {                                //This checks if the room is not open
                    floor2[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
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
                if (floor3[roomNum] != "Open") {                                //This checks if the room is not open
                    floor3[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
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
                if (floor4[roomNum] != "Open") {                                //This checks if the room is not open
                    floor4[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
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
                if (floor5[roomNum] != "Open") {                                //This checks if the room is not open
                    floor5[roomNum] = "Open";                                   //If not, make the closed room open to imitate a user canceling there reservation
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

    public void changeRoom(int floor, int roomNum){                             //Method allows the user to change their room they reserved to another
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {         //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            cancelRoom(floor, roomNum);                                         //Calls the cancelRoom and reserveRoom Methods to simulate the user changing their
            reserveRoom(floor, roomNum);                                        //room to a different room
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!"); //If the user picks a wrong input for the rooms
            alert.showAndWait();                                                                                    //Or the floors it will give this message through
        }                                                                                                           //through a pop-up window
    }

    public void searchRoom(int floor, int roomNum){
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {         //Detects if user picked an option from  1 to 5 for floors and 0 to 9 for each room
            if (floor == 1) {
                if (floor1[roomNum] != "Closed") {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 2) {
                if (floor2[roomNum] != "Closed") {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 3) {
                if (floor3[roomNum] != "Closed") {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 4) {
                if (floor4[roomNum] != "Closed") {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 5) {
                if (floor5[roomNum] != "Closed") {                              //If room is not closed the room status is open
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + floor + roomNum + " is open!");
                    alert.showAndWait();
                } else {                                                    //If room is closed, a message is returned saying that the user needs to try another room
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + floor + roomNum + " has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
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

    public void roomInfo(int floor){                            //Method gives you basic information of each the rooms as a way to market the hotel
        if (floor >= 1 && floor <= 5) {                         //The user can choose floors 1-5
            if (floor == 1) {                                                       //Goes into the description for small rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Floor 1 have our finest small rooms, perfect for 1-2 people to enjoy!");
                alert.showAndWait();
            }
            if (floor == 2) {                                                       //Goes into the description for large rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("For those with a group of 3-4 people, our second floor has the right open space for you!");
                alert.showAndWait();
            }
            if (floor == 3) {                                                       //Goes into the description for family rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Having a big family trip? Well on floor 3 we have just the room for you!\n" +
                        "Perfect for families of 5-6 people. Baby station included!");
                alert.showAndWait();
            }
            if (floor == 4) {                                                       //Goes into the description for luxurious rooms
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Our rooms not good enough for your standards? Don't worry we got something for you as well!\n" +
                        "On the fourth floor we have some luxurious rooms for those who love interior design.");
                alert.showAndWait();
            }
            if (floor == 5) {                                                       //Goes into the description for penthouse suites
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Can't stand the closed spaces of a normal hotel room? \n" + "On the top floor awaits your spacious and luxurious penthouse suite! Fit for a king!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!");//If the user picks a wrong input for the rooms
            alert.showAndWait();                                                                                    //Or the floors it will give this message through
        }                                                                                                           //through a pop-up window
    }
    public void setGuestOnLogin(Guest guest1){
        this.guest = guest1;
    }
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
    public void printArray(){
        for (int i = 0; i < floor1.length; i++) {
            System.out.println(floor1[i]);
        }
    }
}
