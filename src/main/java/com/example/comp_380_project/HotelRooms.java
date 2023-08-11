package com.example.comp_380_project;

import javafx.scene.control.Alert;

import java.util.Objects;
import java.util.Scanner;


public class HotelRooms {
    String[] floor1 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Small rooms
    String[] floor2 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Larger rooms
    String[] floor3 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Family rooms
    String[] floor4 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Luxury rooms
    String[] floor5 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Penthouse suite


    public void reserveRoom(int floor, int roomNum) {
        if (floor >= 1 && floor <= 5 && roomNum >= 0 && roomNum <= 9) {
            if (floor == 1) {
                if (floor1[roomNum] != "Closed") {
                    floor1[roomNum] = "Closed";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for booking room " + roomNum + "on floor 1!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is already book! Please try another room.");
                    alert.showAndWait();
                }
            }
            if (floor == 2) {
                if (floor2[roomNum] != "Closed") {
                    floor2[roomNum] = "Closed";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for booking room " + roomNum + "on floor 2!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is already book! Please try another room.");
                    alert.showAndWait();
                }
            }
            if (floor == 3) {
                if (floor3[roomNum] != "Closed") {
                    floor3[roomNum] = "Closed";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for booking room " + roomNum + "on floor 3!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is already book! Please try another room.");
                    alert.showAndWait();
                }
            }
            if (floor == 4) {
                if (floor4[roomNum] != "Closed") {
                    floor4[roomNum] = "Closed";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for booking room " + roomNum + "on floor 4!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is already book! Please try another room.");
                    alert.showAndWait();
                }
            }
            if (floor == 5) {
                if (floor5[roomNum] != "Closed") {
                    floor5[roomNum] = "Closed";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for booking room " + roomNum + "on floor 5!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is already book! Please try another room.");
                    alert.showAndWait();
                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!");
            alert.showAndWait();
        }
    }

    public void cancelRoom(int floor, int roomNum) {
        if (floor >= 1 && floor <= 5 && roomNum >= 1 && roomNum <= 10) {
            if (floor == 1) {
                if (floor1[roomNum - 1] != "Open") {
                    floor1[roomNum - 1] = "Open";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is not under you name. Please try again.");
                    alert.showAndWait();
                }
            }
            if (floor == 2) {
                if (floor2[roomNum - 1] != "Open") {
                    floor2[roomNum - 1] = "Open";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is not under you name. Please try again.");
                    alert.showAndWait();
                }
            }
            if (floor == 3) {
                if (floor3[roomNum - 1] != "Open") {
                    floor3[roomNum - 1] = "Open";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is not under you name. Please try again.");
                    alert.showAndWait();
                }
            }
            if (floor == 4) {
                if (floor4[roomNum - 1] != "Open") {
                    floor4[roomNum - 1] = "Open";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is not under you name. Please try again.");
                    alert.showAndWait();
                }
            }
            if (floor == 5) {
                if (floor5[roomNum - 1] != "Open") {
                    floor5[roomNum - 1] = "Open";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry but this room is not under you name. Please try again.");
                    alert.showAndWait();
                }
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!");
            alert.showAndWait();
        }
    }

    public void changeRoom(int floor, int roomNum){
        if (floor >= 1 && floor <= 5 && roomNum >= 1 && roomNum <= 10) {
            cancelRoom(floor, roomNum);
            reserveRoom(floor, roomNum);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!");
            alert.showAndWait();
        }
    }

    public void searchRoom(int floor, int roomNum){
        if (floor >= 1 && floor <= 5 && roomNum >= 1 && roomNum <= 10) {
            if (floor == 1) {
                if (floor1[roomNum - 1] != "Closed") {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + roomNum + " on floor 1 is open!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Room " + roomNum + " on floor 1 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 2) {
                if (floor2[roomNum - 1] != "Closed") {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + roomNum + " on floor 2 is open!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText( "This room " + roomNum + " on floor 2 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 3) {
                if (floor3[roomNum - 1] != "Closed") {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + roomNum + " on floor 3 is open!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText( "This room " + roomNum + " on floor 3 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 4) {
                if (floor4[roomNum - 1] != "Closed") {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + roomNum + " on floor 4 is open!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText( "This room " + roomNum + " on floor 4 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
            if (floor == 5) {
                if (floor5[roomNum - 1] != "Closed") {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("The room " + roomNum + " on floor 5 is open!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("This room " + roomNum + " on floor 5 has already been taken by someone else! Please look for" +
                            " another room if possible. If none available, please choose another floor for possible availability!");
                    alert.showAndWait();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!");
            alert.showAndWait();
        }
    }

    public void roomInfo(int floor){
        if (floor >= 1 && floor <= 5) {
            if (floor == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Floor 1 have our finest small rooms, perfect for 1-2 people to enjoy!");
                alert.showAndWait();
            }
            if (floor == 2) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("For those with a group of 3-4 people, our second floor has the right open space for you!");
                alert.showAndWait();
            }
            if (floor == 3) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Having a big family trip? Well on floor 3 we have just the room for you!\n" +
                        "Perfect for families of 5-6 people. Baby station included!");
                alert.showAndWait();
            }
            if (floor == 4) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Our rooms not good enough for your standards? Don't worry we got something for you as well!\n" +
                        "On the fourth floor we have some luxurious rooms for those who love interior design.");
                alert.showAndWait();
            }
            if (floor == 5) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Can't stand the closed spaces of a normal hotel room? \n" + "On the top floor awaits your spacious and luxurious penthouse suite! Fit for a king!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You inputted a wrong number for either floor or room number. Please try again!");
            alert.showAndWait();
        }
    }
}
