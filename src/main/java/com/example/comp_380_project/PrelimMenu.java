package com.example.comp_380_project;
// THIS IS A PRELIMINARY MENU, NOT FINAL PRODUCT NOR PROGRAMMED TO FUNCTION
import javafx.stage.Stage;

import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

// 6 methods so far: Search for a room type (Single bed - Family rooms), Reserve, Cancel Reservation, Review Reservation
// Change Reservation, Room Info (Whoever's taking this room/For how long; this is hotel staff exclusive)

public class PrelimMenu extends Application {

    Button reserve, search, cancel, review, edit, info; //buttons for each method
    private HotelRooms hotel;
     

    public void setHotel(HotelRooms hotel) {
        this.hotel = hotel;
    }

    public void userMenu(String[] args) {
        launch(args); // launches window
    }

    @Override 
    public void start(Stage mainMenu) throws Exception {
        mainMenu.setTitle("Hotel Name: Main Menu"); // unnamed hotel
        Label welcome = new Label("Welcome to Hotel Name!");
        GridPane.setConstraints(welcome, 7,4);

        reserve = new Button("Reserve a Room"); // reserve button
        search = new Button("Search for a Room"); // search button
        cancel = new Button("Cancel Reservation"); // cancel button
        review = new Button("Review Reservation"); // review button
        edit = new Button("Edit Reservation"); // edit button
        info = new Button("Room Info"); // info button

        reserve.setOnAction(e -> reserveRoom());
        search.setOnAction(e -> searchRoom());
        cancel.setOnAction(e -> cancelRoom());
        review.setOnAction(e -> reviewRoom());
        edit.setOnAction(e -> editRoom());
        info.setOnAction(e -> infoRoom());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid.setVgap(10); //vertical space for each "unit"
        grid.setHgap(10); //horizontal space for each "unit"

        grid.getChildren().addAll(welcome, reserve, search, cancel, review, edit, info); // from here to line 51, adding buttons to grid.

        welcome.setStyle("-fx-font-size:25");
        reserve.setStyle("-fx-font-size:20"); // increasing button/font size
        search.setStyle("-fx-font-size:20");
        cancel.setStyle("-fx-font-size:20");
        review.setStyle("-fx-font-size:20");
        edit.setStyle("-fx-font-size:20");
        info.setStyle("-fx-font-size:20");

        GridPane.setConstraints(reserve, 6, 12); // from here to line 58, placing buttons
        GridPane.setConstraints(search, 8, 12);
        GridPane.setConstraints(cancel, 6, 20);
        GridPane.setConstraints(review, 8, 20);
        GridPane.setConstraints(edit, 6, 28);
        GridPane.setConstraints(info, 8, 28);

        Scene menu = new Scene(grid, 800, 600);
        mainMenu.setScene(menu);
        mainMenu.show();
    }


    private void reserveRoom() { // Adrian
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
    }

    private void searchRoom() { // Sergio
        Scanner input5 = new Scanner(System.in);
        System.out.println("Please input the room you would like to know the status of:\n ");
        System.out.println("Please note that each floor has ten rooms\n\n" +
                "Small rooms: 1\n" +
                "Larger rooms: 2\n" +
                "Family rooms: 3\n" +
                "Luxury rooms: 4\n" +
                "Penthouse suite: 5\n");
        hotel.searchRoom(input5.nextInt(), input5.nextInt());
    }

    private void cancelRoom() { // Adrian
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
    }

    private void infoRoom() { // Angel
        Scanner input6 = new Scanner(System.in);
        System.out.println("Which floor would you like to know more about?\n");
        System.out.println("Small rooms: 1\n" +
                            "Larger rooms: 2\n" +
                            "Family rooms: 3\n" +
                            "Luxury rooms: 4\n" +
                            "Penthouse suite: 5\n");
        hotel.roomInfo(input6.nextInt());
    }

    private void reviewRoom() {// Angel

    }

    private void editRoom() { // Sergio
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
    }

}