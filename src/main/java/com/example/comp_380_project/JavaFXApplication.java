package com.example.comp_380_project;

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

import javafx.fxml.FXMLLoader;

public class JavaFXApplication extends Application { // implements EventHandler<ActionEvent> 
    Button button1, loginButton, button3;
    Scene scene1, scene2;
    StackPane layout1, layout2;

    void firstScene() { 
        StackPane l1;
        
    }

    @Override
    public void start(Stage initialWindow) throws IOException { // Launches the application
        // FXMLLoader fxmlLoader = new FXMLLoader(JavaFXApplication.class.getResource("hello-view.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        // initialStage.setScene(scene);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setVgap(10); // Spacing of the individual cells in the grid
        grid.setHgap(12);

        Label userName = new Label("Username:");
        GridPane.setConstraints(userName, 0, 0); // Cell position 'column, row'
        TextField rightBox1 = new TextField();
        rightBox1.setPromptText("Username"); // Username Input
        GridPane.setConstraints(rightBox1, 1, 0);

        Label userPassword = new Label("Password:");
        GridPane.setConstraints(userPassword, 0, 1);
        TextField rightBox2 = new TextField();
        rightBox2.setPromptText("Password"); // Password Input
        GridPane.setConstraints(rightBox2, 1, 1);

        loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(userName, rightBox1, userPassword, rightBox2, loginButton);
        
        scene1 = new Scene(grid, 800, 600);
        initialWindow.setTitle("Hotel Login");
        initialWindow.setScene(scene1);
        initialWindow.show();
        /*
        layout1 = new StackPane(); // Creates a stack layout for GUI elements
        layout2 = new StackPane(); 
        scene1 = new Scene(layout1, 500, 500); // Size of a visual displayed window
        scene2 = new Scene(layout2, 500, 500);
        button1 = new Button();
        loginButton = new Button("Guest Login");
        button3 = new Button();
        
        
        layout1.getChildren().addAll(button1, button3);
        layout2.getChildren().addAll(button3);

        button1.setText("Manager Login");
        button1.setOnAction(event -> firstScene());
        button1.setOnAction(event -> initialWindow.setScene(scene2));

        button3.setText("Guest Login");
        button2.setOnAction(event -> initialWindow.setScene(scene1));
        */
    }

    public static void main(String[] args) {
        // This starts the GUI 
        launch();
    }
}