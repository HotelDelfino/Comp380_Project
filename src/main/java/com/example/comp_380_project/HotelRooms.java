package com.example.comp_380_project;

import java.util.Objects;
import java.util.Scanner;

public class HotelRooms {

    String[] floor1 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Small rooms
    String[] floor2 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Larger rooms
    String[] floor3 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Family rooms
    String[] floor4 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Luxury rooms
    String[] floor5 = {"Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open", "Open"}; //Penthouse suite


    public void reserveRoom(int floor, int roomNum) {
        if (floor >= 1 && floor <= 5 && roomNum >= 1 && roomNum <= 10) {
            if (floor == 1) {
                if (floor1[roomNum - 1] != "Closed") {
                    floor1[roomNum - 1] = "Closed";
                    System.out.println();
                    System.out.println("Thank you for booking room " + roomNum + " on floor 1!");
                } else {
                    System.out.println("Sorry but this room is already book! Please try another room.");
                }
            }
            if (floor == 2) {
                if (floor2[roomNum - 1] != "Closed") {
                    floor2[roomNum - 1] = "Closed";
                    System.out.println();
                    System.out.println("Thank you for booking room " + roomNum + " on floor 2!");
                } else {
                    System.out.println("Sorry but this room is already book! Please try another room.");
                }
            }
            if (floor == 3) {
                if (floor3[roomNum - 1] != "Closed") {
                    floor3[roomNum - 1] = "Closed";
                    System.out.println();
                    System.out.println("Thank you for booking room " + roomNum + " on floor 3!");
                } else {
                    System.out.println("Sorry but this room is already book! Please try another room.");
                }
            }
            if (floor == 4) {
                if (floor4[roomNum - 1] != "Closed") {
                    floor4[roomNum - 1] = "Closed";
                    System.out.println();
                    System.out.println("Thank you for booking room " + roomNum + " on floor 4!");
                } else {
                    System.out.println("Sorry but this room is already book! Please try another room.");
                }
            }
            if (floor == 5) {
                if (floor5[roomNum - 1] != "Closed") {
                    floor5[roomNum - 1] = "Closed";
                    System.out.println();
                    System.out.println("Thank you for booking room " + roomNum + " on floor 5!");
                } else {
                    System.out.println("Sorry but this room is already book! Please try another room.");
                }
            }

        } else {
            System.out.println();
            System.out.println("You inputted a wrong number for either floor or room number. Please try again!");
        }
    }

    public void cancelRoom(int floor, int roomNum) {
        if (floor >= 1 && floor <= 5 && roomNum >= 1 && roomNum <= 10) {
            if (floor == 1) {
                if (floor1[roomNum - 1] != "Open") {
                    floor1[roomNum - 1] = "Open";
                    System.out.println();
                    System.out.println("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                } else {
                    System.out.println("Sorry but this room is not under you name. Please try again.");
                }
            }
            if (floor == 2) {
                if (floor2[roomNum - 1] != "Open") {
                    floor2[roomNum - 1] = "Open";
                    System.out.println();
                    System.out.println("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                } else {
                    System.out.println("Sorry but this room is not under you name. Please try again.");
                }
            }
            if (floor == 3) {
                if (floor3[roomNum - 1] != "Open") {
                    floor3[roomNum - 1] = "Open";
                    System.out.println();
                    System.out.println("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                } else {
                    System.out.println("Sorry but this room is not under you name. Please try again.");
                }
            }
            if (floor == 4) {
                if (floor4[roomNum - 1] != "Open") {
                    floor4[roomNum - 1] = "Open";
                    System.out.println();
                    System.out.println("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                } else {
                    System.out.println("Sorry but this room is not under you name. Please try again.");
                }
            }
            if (floor == 5) {
                if (floor5[roomNum - 1] != "Open") {
                    floor5[roomNum - 1] = "Open";
                    System.out.println();
                    System.out.println("Thank you for letting us know! Your refund should be given to you in 48 hours!");
                } else {
                    System.out.println("Sorry but this room is not under you name. Please try again.");
                }
            }
        }else {
            System.out.println("You inputted a wrong number for either floor or room number. Please try again!");
        }
    }

    public void changeRoom(int floor, int roomNum){
        if (floor >= 1 && floor <= 5 && roomNum >= 1 && roomNum <= 10) {
            cancelRoom(floor, roomNum);
            reserveRoom(floor, roomNum);
        } else {
            System.out.println("You inputted a wrong number for either floor or room number. Please try again!");
        }
    }

    public void searchRoom(int floor, int roomNum){
        if (floor >= 1 && floor <= 5 && roomNum >= 1 && roomNum <= 10) {
            if (floor == 1) {
                if (floor1[roomNum - 1] != "Closed") {
                    System.out.println("The room " + roomNum + " on floor 1 is open!");
                } else {
                    System.out.println("Room " + roomNum + " on floor 1 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                }
            }
            if (floor == 2) {
                if (floor2[roomNum - 1] != "Closed") {
                    System.out.println("The room " + roomNum + " on floor 2 is open!");
                } else {
                    System.out.println("This room " + roomNum + " on floor 2 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                }
            }
            if (floor == 3) {
                if (floor3[roomNum - 1] != "Closed") {
                    System.out.println("The room " + roomNum + " on floor 3 is open!");
                } else {
                    System.out.println("This room " + roomNum + " on floor 3 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                }
            }
            if (floor == 4) {
                if (floor4[roomNum - 1] != "Closed") {
                    System.out.println("The room " + roomNum + " on floor 4 is open!");
                } else {
                    System.out.println("This room " + roomNum + " on floor 4 has already been taken by someone else!\n" +
                            "Please look for another room if possible. If none available, please choose another floor for possible availability!");
                }
            }
            if (floor == 5) {
                if (floor5[roomNum - 1] != "Closed") {
                    System.out.println("The room " + roomNum + " on floor 5 is open!");
                } else {
                    System.out.println("This room " + roomNum + " on floor 5 has already been taken by someone else! Please look for" +
                            " another room if possible. If none available, please choose another floor for possible availability!");
                }
            }
        } else {
            System.out.println("You inputted a wrong number for either floor or room number. Please try again!");
        }
    }

    public void roomInfo(int floor){
        if (floor >= 1 && floor <= 5) {
            if (floor == 1) {
                System.out.println("Floor 1 have our finest small rooms, perfect for 1-2 people to enjoy!");
            }
            if (floor == 2) {
                System.out.println("For those with a group of 3-4 people, our second floor has the right open space for you!");
            }
            if (floor == 3) {
                System.out.println("Having a big family trip? Well on floor 3 we have just the room for you!\n" +
                        "Perfect for families of 5-6 people. Baby station included!");
            }
            if (floor == 4) {
                System.out.println("Our rooms not good enough for your standards? Don't worry we got something for you as well!\n" +
                        "On the fourth floor we have some luxurious rooms for those who love interior design.");
            }
            if (floor == 5) {
                System.out.println("Can't stand the closed spaces of a normal hotel room? \n" +
                        "On the top floor awaits your spacious and luxurious penthouse suite! Fit for a king!");
            }
        } else {
            System.out.println("You inputted a wrong number for either floor or room number. Please try again!");
        }
    }
}
