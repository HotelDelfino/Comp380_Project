package com.example.comp_380_project;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.awt.*;
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

public class PrelimMenu extends Application implements Cloneable {
    Stage window;
    Scene scene;
    Button reserve, search, cancel, review, edit, info, close; //buttons for each method
    HotelRooms hotel = new HotelRooms();
    //HotelRooms hotel;
    //FileReader database = new FileReader();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
   /*  public void setHotel(HotelRooms hotel) {
        this.hotel = hotel;
    }*/

    /*public void userMenu(String[] args) {
        launch(args); // launches window
    }*/

    @Override 
    public void start(Stage mainMenu) throws Exception {
        //Main.hotel;
        window = mainMenu;
        mainMenu.setTitle("Hotel Delfino: Main Menu"); // unnamed hotel
        Label welcome = new Label("Welcome to Hotel Delfino!");
        GridPane.setConstraints(welcome, 1,0);

        reserve = new Button("Reserve a Room"); // reserve button
        search = new Button("Search for a Room"); // search button
        cancel = new Button("Cancel Reservation"); // cancel button
        review = new Button("Review Reservation"); // review button
        edit = new Button("Edit Reservation"); // edit button
        info = new Button("Room Info"); // info button
        close = new Button("Close");

        reserve.setOnAction(e -> reserveRoom());
        search.setOnAction(e -> searchRoom());
        cancel.setOnAction(e -> cancelRoom());
        review.setOnAction(e -> reviewRoom());
        edit.setOnAction(e -> editRoom());
        info.setOnAction(e -> infoRoom());
        close.setOnAction(e -> window.close());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid.setVgap(50); //vertical space for each "unit"
        grid.setHgap(50); //horizontal space for each "unit"

        grid.getChildren().addAll(welcome, reserve, search, cancel, review, edit, info, close); // from here to line 51, adding buttons to grid.

        welcome.setStyle("-fx-font-size:23");
        reserve.setStyle("-fx-font-size:20"); // increasing button/font size
        search.setStyle("-fx-font-size:20");
        cancel.setStyle("-fx-font-size:20");
        review.setStyle("-fx-font-size:20");
        edit.setStyle("-fx-font-size:20");
        info.setStyle("-fx-font-size:20");
        close.setStyle("-fx-font-size:20");

        grid.setAlignment(Pos.CENTER);
        GridPane.setConstraints(reserve,0 , 1); // from here to line 58, placing buttons
        GridPane.setConstraints(search, 2, 1);
        GridPane.setConstraints(cancel, 0, 2);
        GridPane.setConstraints(review, 2, 2);
        GridPane.setConstraints(edit, 0, 3);
        GridPane.setConstraints(info, 2, 3);
        GridPane.setConstraints(close, 2, 4);

        Scene menu = new Scene(grid, 800, 600);
        scene = menu;
        mainMenu.setScene(menu);
        mainMenu.show();
    }


    private void reserveRoom() {
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid2.setVgap(50); //vertical space for each "unit"
        grid2.setHgap(50); //horizontal space for each "unit"
        //grid2.setGridLinesVisible(true);
        grid2.setAlignment(Pos.CENTER);

        Label reservation = new Label("Reservation");
        GridPane.setConstraints(reservation, 0,0);
        reservation.setStyle("-fx-font-size:20");

        Label floorSelect = new Label("Select your desired floor!");
        GridPane.setConstraints(floorSelect,0,1);
        floorSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> floors = new ChoiceBox<Integer>(); //dropdown menu for floor selection
        floors.getItems().addAll(1, 2, 3, 4, 5); // 5 floors available to select
        floors.setValue(1);
        GridPane.setConstraints(floors, 1,1);
        floors.setStyle("fx-font-size:15");

        Label roomSelect = new Label("Select your desired room!");
        GridPane.setConstraints(roomSelect, 0, 2);
        roomSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> rooms = new ChoiceBox<Integer>(); //dropdown menu for room selection
        rooms.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        rooms.setValue(0);
        GridPane.setConstraints(rooms,1,2);
        rooms.setStyle("fx-font-size:15");


        Button goBack = new Button("Return to Main Menu");
        goBack.setStyle("-fx-font-size:15");
        goBack.setOnAction(e -> window.setScene(scene));
        GridPane.setConstraints(goBack, 0, 3);

        Button confirm = new Button("Confirm Room Selection");
        confirm.setStyle("-fx-font-size:15");
        confirm.setOnAction(e -> hotel.reserveRoom(floors.getValue(), rooms.getValue())); // bars
        GridPane.setConstraints(confirm, 2,3);

        grid2.getChildren().addAll(reservation, floorSelect, floors, roomSelect, rooms, confirm, goBack);

        Scene resRoom = new Scene(grid2, 550, 300);
        window.setScene(resRoom);
        window.show();
    }

    private void searchRoom() {
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

    private void cancelRoom() {
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

    private void infoRoom() {
        Scanner input6 = new Scanner(System.in);
        System.out.println("Which floor would you like to know more about?\n");
        System.out.println("Small rooms: 1\n" +
                            "Larger rooms: 2\n" +
                            "Family rooms: 3\n" +
                            "Luxury rooms: 4\n" +
                            "Penthouse suite: 5\n");
        hotel.roomInfo(input6.nextInt());
    }

    private void reviewRoom() {

    }

    private void editRoom() {
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