package com.example.comp_380_project;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        FileReader dataBase = new FileReader();
        PrelimMenu optionMenu = new PrelimMenu();
        JavaFXApp app = new JavaFXApp(dataBase, optionMenu, args);
        
        app.runApp();

        Scanner input = new Scanner(System.in);
        HotelRooms hotel = new HotelRooms();

        System.out.println();
        System.out.print("Welcome to Hotel Delfino!");
        while(true){
            System.out.println("\n");
            System.out.println("Please select one of these options:\n" +
                    "Reserve a room: 1\n" +
                    "Cancel a room: 2\n" +
                    "Change your reservation: 3\n" +
                    "Search for a Reservation: 4\n" +
                    "Room Info: 5\n" +
                    "Quit: 6\n");

            switch (input.nextLine()) {
                case "1":
                    Scanner input1 = new Scanner(System.in);
                    System.out.println();
                    System.out.println("Please select which type of floor you would want to stay in and the room" +
                            " number you would like to stay in:");
                    System.out.println();
                    System.out.println("Please note that each floor has ten rooms\n\n" +
                            "Small rooms: 1\n" +
                            "Larger rooms: 2\n" +
                            "Family rooms: 3\n" +
                            "Luxury rooms: 4\n" +
                            "Penthouse suite: 5\n");
                    hotel.reserveRoom(input1.nextInt(), input1.nextInt());
                    break;
                case "2":
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("I'm so sorry to hear that.\n" +
                            "Please tell me the floor and room number you reserved in:\n");
                    System.out.println("Please note that each floor has ten rooms\n\n" +
                            "Small rooms: 1\n" +
                            "Larger rooms: 2\n" +
                            "Family rooms: 3\n" +
                            "Luxury rooms: 4\n" +
                            "Penthouse suite: 5\n");
                    hotel.cancelRoom(input2.nextInt(), input2.nextInt());
                    break;
                case "3":
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Please input the floor and room number you would like to change:\n");
                    System.out.println("Please note that each floor has ten rooms\n\n" +
                            "Small rooms: 1\n" +
                            "Larger rooms: 2\n" +
                            "Family rooms: 3\n" +
                            "Luxury rooms: 4\n" +
                            "Penthouse suite: 5\n");
                    hotel.changeRoom(input3.nextInt(), input3.nextInt());

                    Scanner input4 = new Scanner(System.in);
                    System.out.print("Which room would you like to change it to?");
                    hotel.reserveRoom(input4.nextInt(), input4.nextInt());
                    break;
                case "4":
                    Scanner input5 = new Scanner(System.in);
                    System.out.println("Please input the room you would like to know the status of:\n ");
                    System.out.println("Please note that each floor has ten rooms\n\n" +
                            "Small rooms: 1\n" +
                            "Larger rooms: 2\n" +
                            "Family rooms: 3\n" +
                            "Luxury rooms: 4\n" +
                            "Penthouse suite: 5\n");
                    hotel.searchRoom(input5.nextInt(), input5.nextInt());
                    break;
                case "5":
                    Scanner input6 = new Scanner(System.in);
                    System.out.println("Which floor would you like to know more about?\n");
                    System.out.println("Small rooms: 1\n" +
                                       "Larger rooms: 2\n" +
                                       "Family rooms: 3\n" +
                                       "Luxury rooms: 4\n" +
                                       "Penthouse suite: 5\n");
                    hotel.roomInfo(input6.nextInt());
                    break;
                case "6":
                    System.out.println("Thank you for stopping by! Have a wonderful day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.println("It seems that you inputted an incorrect input, please try again!");
                    System.out.println();
            }
        }
    }
}
