package com.example.comp_380_project;
// THIS IS A PRELIMINARY MENU, NOT FINAL PRODUCT NOR PROGRAMMED TO FUNCTION
import java.util.*;
import java.io.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.transform.Scale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

// 6 methods so far: Search for a room type (Single bed - Family rooms), Reserve, Cancel Reservation, Review Reservation
// Change Reservation, Room Info (Whoever's taking this room/For how long; this is hotel staff exclusive)

public class prelimMenu extends Application {

    Button reserve, search, cancel, review, edit, info; //buttons for each method

    public static void main(String[] args) {
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
}