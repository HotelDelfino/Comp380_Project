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


public class JavaFXApplication extends Application implements EventHandler<ActionEvent> {
    Button button1;

    @Override
    public void start(Stage initialWindow) throws IOException { // Launches the application
        // FXMLLoader fxmlLoader = new FXMLLoader(JavaFXApplication.class.getResource("hello-view.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        // initialStage.setScene(scene);

        
        StackPane layout = new StackPane(); // Creats a stack layout for GUI elements
        Scene scene = new Scene(layout, 500, 500); // Size of a visual displayed window
        button1 = new Button();

        layout.getChildren().add(button1);
        button1.setText("Click");
        button1.setOnAction(e -> System.out.println("a"));

        initialWindow.setTitle("Hotel");
        initialWindow.setScene(scene);
        initialWindow.show();
    }

    public static void main(String[] args) {
        // This starts the GUI 
        launch();
    }
}