
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

        grid.getChildren().add(reserve);
        grid.getChildren().add(search);
        grid.getChildren().add(cancel);
        grid.getChildren().add(review);
        grid.getChildren().add(edit);
        grid.getChildren().add(info);

        GridPane.setConstraints(reserve, 10, 5);
        GridPane.setConstraints(search, 25, 5);
        GridPane.setConstraints(cancel, 10, 15);
        GridPane.setConstraints(review, 25, 15);
        GridPane.setConstraints(edit, 10, 25);
        GridPane.setConstraints(info, 25, 25);

        Scene menu = new Scene(grid, 640, 480);
        mainMenu.setScene(menu);
        mainMenu.show();
    }
}