package com.example.comp_380_project;

import java.util.*;
import java.io.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.transform.Scale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



import javafx.fxml.FXMLLoader;


public class JavaFXApplication extends Application { // implements EventHandler<ActionEvent> 
    Button button1, button2;
    Scene scene1, scene2;
    StackPane layout1, layout2;

    @Override
    public void start(Stage initialWindow) throws IOException { // Launches the application
        // FXMLLoader fxmlLoader = new FXMLLoader(JavaFXApplication.class.getResource("hello-view.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        // initialStage.setScene(scene);

        layout1 = new StackPane(); // Creats a stack layout for GUI elements
        layout2 = new StackPane(); 
        scene1 = new Scene(layout1, 500, 500); // Size of a visual displayed window
        scene2 = new Scene(layout2, 500, 500);
        button1 = new Button();
        button2 = new Button();
        
        layout1.getChildren().addAll(button1);
        layout2.getChildren().addAll(button2);

        button1.setText("Manager Login");
        button1.setOnAction(event -> initialWindow.setScene(scene2));

        button2.setText("Guest Login");
        button2.setOnAction(event -> initialWindow.setScene(scene1));

        initialWindow.setTitle("Hotel");
        initialWindow.setScene(scene1);
        initialWindow.show();
    }

    public static void main(String[] args) {
        // This starts the GUI 
        launch();
    }
}