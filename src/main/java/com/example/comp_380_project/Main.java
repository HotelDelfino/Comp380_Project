package com.example.comp_380_project;

import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.LinearGradient;


/**
 * This class Main is our driver class for out javaFx Front end
 * It allows the user to interact with visual attributes to select hotel options.4
 * @author Jorge
 * @author Angel
 * @author Sergio
 * @author Adrian
 */
public class Main extends Application {
    Stage window;
    Scene scene, loginScene, guestScene;
    Button reserve, search, cancel, review, edit, info, close;
    private HotelRooms hotelRooms;
    private FileReader dataBase;
    private Manager manager;
    ListView<String> listReviews;


    /**
     * This is the main method which calls login which calls launch
     * @param args Anything that gets set before main is called
     * @throws Exception Throws an exception if something happens throughout the program
     */
    public static void main(String[] args) throws Exception {
        Main main = new Main();
  
        main.login(args);
    }

    /**
     * This method launches the javaFX application
     * @param args Anything that gets set before main is called
     */
    public void login(String[] args) {
        launch(args); // launches window
    }


    /**
     * This method starts the javaFX application which creates a new window with a new scene.
     * It displays 3 buttons which the user can click to login as guest, manager, or register a user.
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        hotelRooms = new HotelRooms();
        dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);
        manager = new Manager();


        VBox root = new VBox(40);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));

        Font buttonFont = Font.font("Arial", 32);

        Button guestButton = new Button("Guest Login");
        Button managerButton = new Button("Manager Login");
        Button registerButton = new Button("Register User");

        guestButton.setFont(buttonFont);
        managerButton.setFont(buttonFont);
        registerButton.setFont(buttonFont);

        registerButton.setOnAction(event -> registerUser() );

        managerButton.setOnAction(event -> {
            managerLogin(primaryStage);
        });

        guestButton.setOnAction(event -> {
            guestLogin(primaryStage);
        });

        root.getChildren().addAll(registerButton, managerButton, guestButton);
        root.setBackground(Background.EMPTY);
        loginScene = new Scene(root, 780, 600);
        loginScene.setFill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                                    //cycling
                new Stop(0, Color.web("#191970")),                 //colors
                new Stop(1, Color.web("#87CEEB")))
        );

        window.setTitle("Welcome Hotel Delfino!");
        window.setWidth(780);
        //window.setWidth(Screen.getPrimary().getVisualBounds().getWidth() * 1.0);
        window.setHeight(600);
        //window.setHeight(Screen.getPrimary().getVisualBounds().getHeight() * 1.0);
        window.setScene(loginScene);
        window.show();
    }


    /**
     * This opens up a dialog so a guest could log in if they are registered in the system
     * @param primaryStage
     * @return returns from the function if no username was provided
     */
    private void guestLogin(Stage primaryStage) {
        TextInputDialog dialog1 = new TextInputDialog();
        dialog1.setTitle("Login As Guest");
        dialog1.setHeaderText(null);
        dialog1.setContentText("Enter User Name:");
        String u = dialog1.showAndWait().orElse(null);

        TextInputDialog dialog2 = new TextInputDialog();
        
        if (u == null)
            return;
        
        while (true) {
            if (!dataBase.verifyUsername(u)) {
                dialog1.setTitle("Wrong User Name");
                dialog1.setHeaderText(null);
                dialog1.setContentText("Enter User Name:");
                u = dialog1.showAndWait().orElse(null);
            }
            else {
                dialog2.setTitle("Password");
                dialog2.setHeaderText(null);
                dialog2.setContentText("Enter Password:");
                String p = dialog2.showAndWait().orElse(null);

                if (!dataBase.verifyLogin(u,p)) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Wrong Password");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong password entered.");
                    alert.showAndWait();
                }
                else {
                    try {
                        hotelRooms.setGuestOnLogin(dataBase.getRegisteredGuest(u));
                        menu(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            } 
        }   
    }

    /**
     * Allows a user to login as a manager which has a set password and username.
     * @param primaryStage the stage gets passed to menu if the user successfully logs in, if successful, the user
     * gets to login with menu options
     */
    private void managerLogin(Stage primaryStage) {
        TextInputDialog dialog1 = new TextInputDialog();
        dialog1.setTitle("Login As Manager");
        dialog1.setHeaderText(null);
        dialog1.setContentText("Enter User Name:");
        String u = dialog1.showAndWait().orElse(null);

        TextInputDialog dialog2 = new TextInputDialog();
        
        if (u == null)
            return;

        while (u != null) {
            if (!u.equals("m")) {
                dialog1.setTitle("Wrong User Name");
                dialog1.setHeaderText(null);
                dialog1.setContentText("Enter User Name:");
                u = dialog1.showAndWait().orElse(null);
            } else {
                dialog2.setTitle("Password");
                dialog2.setHeaderText(null);
                dialog2.setContentText("Enter Password:");
                String p = dialog2.showAndWait().orElse(null);

                if (!p.equals("p")) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Wrong Password");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong password entered.");
                    alert.showAndWait();
                } else {
                    try {
                        menu(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    /**
     * This method registers a user and handles duplicate usernames.
     * Allows a user to enter a username and a password
     * @return returns from the function if no username was provided
     * @throws throws an exception
     */
    private void registerUser() {
        TextInputDialog dialog1 = new TextInputDialog();
        dialog1.setTitle("Register");
        dialog1.setHeaderText(null);
        dialog1.setContentText("Choose Username:");
        String u = dialog1.showAndWait().orElse(null);

        if (u == null)
            return;
        
        while (true) {
            if (dataBase.verifyUsername(u)) {
                TextInputDialog dialog3 = new TextInputDialog();
                dialog3.setTitle("User Name Taken Choose Something Else");
                dialog3.setHeaderText(null);
                u = dialog3.showAndWait().orElse(null);
            }
            else {
                TextInputDialog dialog2 = new TextInputDialog();
                dialog2.setTitle("Register");
                dialog2.setHeaderText(null);
                dialog2.setContentText("Choose Password:");
                String p = dialog2.showAndWait().orElse(null);
                dataBase.registerNewUser(u, p);
                break;
            }
        }
    }



//////////-----------------------------------Main Menu-----------------------------------------------------------------


    /**
     * This method handles the menu options
     *
     * @param mainMenu The stage for the main menu
     * @throws Exception If something goes wrong
     */
    public void menu(Stage mainMenu) throws Exception {
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

        /**
         * Calls reserveRoom on SetOnAction when the button is pressed
         */
        reserve.setOnAction(e -> reserveRoom());
        /**
         * Calls searchRoom on SetOnAction when the button is pressed
         */
        search.setOnAction(e -> searchRoom());
        /**
         * Calls cancelReservation on SetOnAction when the button is pressed
         */
        cancel.setOnAction(e -> cancelReservation());
        /**
         * Calls reviewRoom on SetOnAction when the button is pressed
         */
        review.setOnAction(e -> reviewRoom());
        /**
         * Calls editRoom on SetOnAction when the button is pressed
         */
        edit.setOnAction(e -> editRoom());
        /**
         * Calls infoRoom on SetOnAction when the button is pressed
         */
        info.setOnAction(e -> infoRoom());
        close.setOnAction(e -> window.close());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid.setVgap(30); //vertical space for each "unit"
        grid.setHgap(20); //horizontal space for each "unit"

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

        grid.setBackground(Background.EMPTY);
        Scene menu = new Scene(grid,780,600);
        scene = menu;
        scene.setFill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                                    //cycling
                new Stop(0, Color.web("#191970")),                 //colors
                new Stop(1, Color.web("#87CEEB")))
        );
        mainMenu.setScene(menu);
        mainMenu.show();
    }


    /**
     * This method handles the reserve room button's functionality
     */
    private void reserveRoom() {
        GridPane grid2 = new GridPane(); // initializes a new grid layout for reserve room submenu
        grid2.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid2.setVgap(50); //vertical space for each "unit"
        grid2.setHgap(50); //horizontal space for each "unit"
        //grid2.setGridLinesVisible(true);
        grid2.setAlignment(Pos.CENTER);

        Label reservation = new Label("Reservation");
        GridPane.setConstraints(reservation, 0,0); // grid coordinates for reservation label
        reservation.setStyle("-fx-font-size:20");

        Label floorSelect = new Label("Select your desired floor!");
        GridPane.setConstraints(floorSelect,0,1); // grid coordinates for floor selection label
        floorSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> floors = new ChoiceBox<>(); // dropdown menu for floor selection
        floors.getItems().addAll(1, 2, 3, 4, 5); // 5 floors available to select
        floors.setValue(1); // first floor selected by default
        GridPane.setConstraints(floors, 1,1); // grid coordinates for floor selection choice box
        floors.setStyle("fx-font-size:15");

        Label roomSelect = new Label("Select your desired room!");
        GridPane.setConstraints(roomSelect, 0, 2); // grid coordinates for room selection
        roomSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> rooms = new ChoiceBox<>(); //dropdown menu for room selection
        rooms.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9); // 9 available rooms to choose from within a floor
        rooms.setValue(0); // room 0 selected by default (i.e. floor 1 room 0 is room 10; F2 R7 is room 27)
        GridPane.setConstraints(rooms,1,2);
        rooms.setStyle("fx-font-size:15");


        Button goBack = new Button("Return to Main Menu");
        goBack.setStyle("-fx-font-size:15");
        goBack.setOnAction(e -> window.setScene(scene)); // goBack button changes scene back to original main menu
        GridPane.setConstraints(goBack, 0, 3); // grid coordinates for goBack button

        Button confirm = new Button("Confirm Room Selection");
        confirm.setStyle("-fx-font-size:15");
        confirm.setOnAction(e -> hotelRooms.reserveRoom(floors.getValue(), rooms.getValue())); // confirm button takes choice box selections and uses them as parameters to call reserveRoom method
        GridPane.setConstraints(confirm, 2,3); // grid coordinates for confirm button

        grid2.getChildren().addAll(reservation, floorSelect, floors, roomSelect, rooms, confirm, goBack); // adds all buttons and labels onto scene

        Scene resRoom = new Scene(grid2, 550, 300); // new scene for reservation sub menu
        window.setScene(resRoom); // set scene upon clicking "reserve a room" button in main menu
        window.show(); // show scene
    }

    private void cancelReservation() {
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid2.setVgap(50); //vertical space for each "unit"
        grid2.setHgap(50); //horizontal space for each "unit"
        //grid2.setGridLinesVisible(true);
        grid2.setAlignment(Pos.CENTER);

        Label reservation = new Label("Cancel Reservation");
        GridPane.setConstraints(reservation, 0,0); // grid coordinates for cancel reservation label
        reservation.setStyle("-fx-font-size:20");

        Label floorSelect = new Label("Select your desired floor!");
        GridPane.setConstraints(floorSelect,0,1);  // grid coordinates for floor selection label
        floorSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> floors = new ChoiceBox<>(); // dropdown menu for floor selection
        floors.getItems().addAll(1, 2, 3, 4, 5); // 5 floors available to select
        floors.setValue(1); // first floor by default
        GridPane.setConstraints(floors, 1,1); // coordinates for floor selection choice box
        floors.setStyle("fx-font-size:15");

        Label roomSelect = new Label("Select your desired room!");
        GridPane.setConstraints(roomSelect, 0, 2); // grid coordinates for room select label
        roomSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> rooms = new ChoiceBox<>(); //dropdown menu for room selection
        rooms.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9); // 0-9 rooms to select
        rooms.setValue(0); // room 0 selected by default
        GridPane.setConstraints(rooms,1,2); // grid coordinates for room selection choice box
        rooms.setStyle("fx-font-size:15");


        Button goBack = new Button("Return to Main Menu");
        goBack.setStyle("-fx-font-size:15");
        goBack.setOnAction(e -> window.setScene(scene)); // go back button returns to original main menu scene
        GridPane.setConstraints(goBack, 0, 3); // grid coordinates for goBack button

        Button confirm = new Button("Confirm Room Selection");
        confirm.setStyle("-fx-font-size:15");
        confirm.setOnAction(e -> hotelRooms.cancelRoom(floors.getValue(), rooms.getValue())); // confirm button uses choice box inputs as parameters for cancelRoom method
        GridPane.setConstraints(confirm, 2,3); // grid coordinates for confirm button

        grid2.getChildren().addAll(reservation, floorSelect, floors, roomSelect, rooms, confirm, goBack); // add all buttons and labels to scene

        Scene cancelRoom = new Scene(grid2, 550, 300); // initializes cancel room grid layout
        window.setScene(cancelRoom); // sets window scene to cancel room submenu 
        window.show();
    }
    private void searchRoom() {
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid2.setVgap(50); //vertical space for each "unit"
        grid2.setHgap(50); //horizontal space for each "unit"
        //grid2.setGridLinesVisible(true);
        grid2.setAlignment(Pos.CENTER);

        Label reservation = new Label("Search for a Room");
        GridPane.setConstraints(reservation, 0,0);
        reservation.setStyle("-fx-font-size:20");

        Label floorSelect = new Label("Select your desired floor!");
        GridPane.setConstraints(floorSelect,0,1);
        floorSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> floors = new ChoiceBox<>(); //dropdown menu for floor selection
        floors.getItems().addAll(1, 2, 3, 4, 5); // 5 floors available to select
        floors.setValue(1);
        GridPane.setConstraints(floors, 1,1);
        floors.setStyle("fx-font-size:15");

        Label roomSelect = new Label("Select your desired room!");
        GridPane.setConstraints(roomSelect, 0, 2);
        roomSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> rooms = new ChoiceBox<>(); //dropdown menu for room selection
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
        confirm.setOnAction(e -> hotelRooms.searchRoom(floors.getValue(), rooms.getValue()));
        GridPane.setConstraints(confirm, 2,3);

        grid2.getChildren().addAll(reservation, floorSelect, floors, roomSelect, rooms, confirm, goBack);

        Scene resRoom = new Scene(grid2, 550, 300);
        window.setScene(resRoom);
        window.show();
    }

    private void infoRoom() {
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid2.setVgap(50); //vertical space for each "unit"
        grid2.setHgap(50); //horizontal space for each "unit"
        //grid2.setGridLinesVisible(true);
        grid2.setAlignment(Pos.CENTER);

        Label reservation = new Label("Room Information");
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

        Button goBack = new Button("Return to Main Menu");
        goBack.setStyle("-fx-font-size:15");
        goBack.setOnAction(e -> window.setScene(scene));
        GridPane.setConstraints(goBack, 0, 3);

        Button confirm = new Button("Confirm Floor Selection");
        confirm.setStyle("-fx-font-size:15");
        confirm.setOnAction(e -> hotelRooms.roomInfo(floors.getValue()));
        GridPane.setConstraints(confirm, 2,3);

        grid2.getChildren().addAll(reservation, floorSelect, floors, confirm, goBack);

        Scene resRoom = new Scene(grid2, 550, 300);
        window.setScene(resRoom);
        window.show();
    }

    /**
     * Allows the user to select the amount of stars they want to give the hotel and a text box to share their feelings
     * of their experience
     */
    private void reviewRoom() {
        GridPane gridStars = new GridPane();
        gridStars.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        gridStars.setVgap(50); //vertical space for each "unit"
        gridStars.setHgap(50); //horizontal space for each "unit"
        //gridStars.setGridLinesVisible(true);
        gridStars.setAlignment(Pos.CENTER);

        Label reservation = new Label("Thank you for taking the time to review your time here at Hotel Delfino!" +
                "\n\nBelow you can score our hotel from a 5 to 1 scale. (5 Excellent - 1 Poor)" +
                "\nIf you have time please leave your thoughts and experience here at Hotel Delfino! (Optional)");
        GridPane.setConstraints(reservation, 0,0);
        reservation.setStyle("-fx-font-size:20");

        Label starsSelect = new Label("Please select the amount of stars you would like to give:");
        GridPane.setConstraints(starsSelect,0,1);
        starsSelect.setStyle("-fx-font-size:15");


        ChoiceBox<Integer> stars = new ChoiceBox<Integer>(); //dropdown menu for how many stars the user wants to give
        stars.getItems().addAll(5,4,3,2,1); // 5 stars available to select
        stars.setValue(5);
        GridPane.setConstraints(stars, 1,1);
        stars.setStyle("fx-font-size:15");

        TextArea reviewArea = new TextArea();
        gridStars.add(reviewArea, 0,2);

        Button goBack = new Button("Return to Main Menu");
        goBack.setStyle("-fx-font-size:15");
        goBack.setOnAction(e -> window.setScene(scene));
        GridPane.setConstraints(goBack, 0, 3);

        Button confirm = new Button("Confirm");
        confirm.setStyle("-fx-font-size:15");
        confirm.setOnAction(e -> hotelRooms.roomReview(stars.getValue()));
        GridPane.setConstraints(confirm, 2,3);

        gridStars.getChildren().addAll(reservation, starsSelect, stars, confirm, goBack);

        Scene resRoom = new Scene(gridStars, 550, 300);
        window.setScene(resRoom);
        window.show();

        /**
        Button fiveStarButton = new Button("5 stars");
        Button fourStarButton = new Button("4 stars");
        Button threeStarButton = new Button("3 stars");
        Button twoStarButton = new Button("2 stars");
        Button oneStarButton = new Button("1 stars");

        grid.add(oneStarButton,9,1);
        grid.add(twoStarButton,8,1);
        grid.add(threeStarButton,7,1);
        grid.add(fourStarButton,6,1);
        grid.add(fiveStarButton,5,1);
*/

        /**
        grid.add(reviewLabel, 7,0);
        grid.add(reviewArea, 7,2);
        grid.add(cancelButton, 7,3);
        grid.add(submitButton, 7,4);
*/
        /**
        fiveStarButton.setOnAction(e -> {
            ListView<String> listReviews = new ListView<>();
            listReviews.getItems().addAll("Thank you so much! If it is possible could you leave your experience here. (Optional)");

            Button cancel = new Button("Done");

            GridPane g = new GridPane();
            g.getChildren().addAll(listReviews, cancel);

            cancel.setOnAction(newE ->  {
                window.setScene(scene);
            });

            Scene thisScene = new Scene(g, 800, 800);

            manager.addReview(reviewArea.getText());
            window.setScene(thisScene);
        });

        fourStarButton.setOnAction(e -> {
            ListView<String> listReviews = new ListView<>();
            listReviews.getItems().addAll("Thank you so much! If it is possible could you leave your experience here. (Optional)");

            Button cancel = new Button("Done");

            GridPane g = new GridPane();
            g.getChildren().addAll(listReviews, cancel);

            cancel.setOnAction(newE ->  {
                window.setScene(scene);
            });

            Scene thisScene = new Scene(g, 800, 800);

            manager.addReview(reviewArea.getText());
            window.setScene(thisScene);
        });

        threeStarButton.setOnAction(e -> {
            ListView<String> listReviews = new ListView<>();
            listReviews.getItems().addAll("Thank you so much! If it is possible could you leave your experience here. (Optional)");

            Button cancel = new Button("Done");

            GridPane g = new GridPane();
            g.getChildren().addAll(listReviews, cancel);

            cancel.setOnAction(newE ->  {
                window.setScene(scene);
            });

            Scene thisScene = new Scene(g, 800, 800);

            manager.addReview(reviewArea.getText());
            window.setScene(thisScene);
        });

        twoStarButton.setOnAction(e -> {
            ListView<String> listReviews = new ListView<>();
            listReviews.getItems().addAll("Thank you so much! If it is possible could you leave your experience here. (Optional)");

            Button cancel = new Button("Done");

            GridPane g = new GridPane();
            g.getChildren().addAll(listReviews, cancel);

            cancel.setOnAction(newE ->  {
                window.setScene(scene);
            });

            Scene thisScene = new Scene(g, 800, 800);
            manager.addReview(reviewArea.getText());
            window.setScene(scene);

        });

        oneStarButton.setOnAction(e -> {
            ListView<String> listReviews = new ListView<>();
            listReviews.getItems().addAll("Thank you so much! We are happy you had a great time!");

            Button cancel = new Button("Done");

            GridPane g = new GridPane();
            g.getChildren().addAll(listReviews, cancel);

            cancel.setOnAction(newE ->  {
                window.setScene(scene);
            });

            Scene thisScene = new Scene(g, 800, 800);

            manager.addReview(reviewArea.getText());
            window.setScene(thisScene);
        });

*/

/**
        submitButton.setOnAction(e -> {
            manager.addReview(reviewArea.getText());
            window.setScene(scene);

        });

        cancelButton.setOnAction(e -> {
            /*ListView<String> listReviews = new ListView<>();
            listReviews.getItems().addAll(manager.getReviews());
    
            VBox vBox = new VBox(20);
            vBox.getChildren().add(listReviews);
    
            Scene thisScene = new Scene(vBox, 800, 800);
            window.setScene(thisScene);
            window.show();//
            window.setScene(scene);
        });
        */
/**
        reviewScene = new Scene(grid, 700,700);
        window.setScene(reviewScene);
        window.show();
   */ }

    private void editRoom() {
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid2.setVgap(50); //vertical space for each "unit"
        grid2.setHgap(50); //horizontal space for each "unit"
        //grid2.setGridLinesVisible(true);
        grid2.setAlignment(Pos.CENTER);
        grid2.setGridLinesVisible(true);

        Label reservation = new Label("Edit Reservation");
        GridPane.setConstraints(reservation, 0,0);
        reservation.setStyle("-fx-font-size:20");

        Label currRoom = new Label("What room are you currently booked on?");
        GridPane.setConstraints(currRoom,0,1);
        currRoom.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> initFloor = new ChoiceBox<>(); //dropdown menu for floor selection
        initFloor.getItems().addAll(1, 2, 3, 4, 5); // 5 floors available to select
        initFloor.setValue(1);
        GridPane.setConstraints(initFloor, 1,1);
        initFloor.setStyle("fx-font-size:15");

        ChoiceBox<Integer> initRoom = new ChoiceBox<>(); //dropdown menu for floor selection
        initRoom.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9); // 5 floors available to select
        initRoom.setValue(0);
        GridPane.setConstraints(initRoom, 2,1);
        initRoom.setStyle("fx-font-size:15");

        Label roomSelect = new Label("What room would you like to change to?");
        GridPane.setConstraints(roomSelect, 0, 2);
        roomSelect.setStyle("-fx-font-size:15");

        ChoiceBox<Integer> finFloor = new ChoiceBox<>(); //dropdown menu for room selection
        finFloor.getItems().addAll(1, 2, 3, 4, 5);
        finFloor.setValue(1);
        GridPane.setConstraints(finFloor,1,2);
        finFloor.setStyle("fx-font-size:15");

        ChoiceBox<Integer> finRoom = new ChoiceBox<>(); //dropdown menu for room selection
        finRoom.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        finRoom.setValue(0);
        GridPane.setConstraints(finRoom,2,2);
        finRoom.setStyle("fx-font-size:15");

        Button goBack = new Button("Return to Main Menu");
        goBack.setStyle("-fx-font-size:15");
        goBack.setOnAction(e -> window.setScene(scene));
        GridPane.setConstraints(goBack, 0, 3);

        Button confirm = new Button("Confirm Room Selection");
        confirm.setStyle("-fx-font-size:15");
        confirm.setOnAction(e -> hotelRooms.editRoom(initFloor.getValue(), initRoom.getValue(), finFloor.getValue(), finRoom.getValue())); // bars :(
        GridPane.setConstraints(confirm, 2,3);

        grid2.getChildren().addAll(reservation, currRoom, initRoom, initFloor, roomSelect, finRoom, finFloor, confirm, goBack);

        Scene editRoom = new Scene(grid2, 550, 300);
        window.setScene(editRoom);
        window.show();
        /*Scanner input3 = new Scanner(System.in);
        System.out.println("Please input the floor and room number you would like to change:\n");
        System.out.println("Please note that each floor has ten rooms\n\n" +
                "Small rooms: 1\n" +
                "Larger rooms: 2\n" +
                "Family rooms: 3\n" +
                "Luxury rooms: 4\n" +
                "Penthouse suite: 5\n");
        hotelRooms.changeRoom(input3.nextInt(), input3.nextInt());

        Scanner input4 = new Scanner(System.in);
        System.out.print("Which room would you like to change it to?");
        hotelRooms.reserveRoom(input4.nextInt(), input4.nextInt());
        */
    }

/*---------------------------------Manager Menu-----------------------------------------------------------------------*/
    /*
    public void managerMenu(Stage managerMenu){
        window = managerMenu;
        managerMenu.setTitle("Hotel Delfino: Main Menu"); // unnamed hotel
        Label welcome = new Label("Hotel Delfino - Manager Edition");
        GridPane.setConstraints(welcome, 1,0);

        reserve = new Button("Reserve a Room"); // reserve button
        search = new Button("Search for a Room"); // search button
        cancel = new Button("Cancel Reservation"); // cancel button
        review = new Button("Review Reservation"); // review button
        edit = new Button("Edit Reservation"); // edit button
        info = new Button("Room Info"); // info button
        close = new Button("Close");

        /*
         * Calls reserveRoom on SetOnAction when the button is pressed
         */
        // reserve.setOnAction(e -> reserveRoom());

        /*
         * Calls searchRoom on SetOnAction when the button is pressed
         */
        // search.setOnAction(e -> searchRoom());
        /*
         * Calls cancelReservation on SetOnAction when the button is pressed
         */
        // cancel.setOnAction(e -> cancelReservation());
        /*
         * Calls reviewRoom on SetOnAction when the button is pressed
         */
        // review.setOnAction(e -> reviewRoom());
        /*
         * Calls editRoom on SetOnAction when the button is pressed
         */
        // edit.setOnAction(e -> editRoom());
        /*
         * Calls infoRoom on SetOnAction when the button is pressed
         */
         /*
        info.setOnAction(e -> infoRoom());
        close.setOnAction(e -> window.close());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); // reserved spacing between window borders and buttons
        grid.setVgap(30); //vertical space for each "unit"
        grid.setHgap(20); //horizontal space for each "unit"

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

        grid.setBackground(Background.EMPTY);
        Scene menu = new Scene(grid,780,600);
        scene = menu;
        scene.setFill(new LinearGradient(
                0, 0, 1, 1, true,                                  //sizing
                CycleMethod.NO_CYCLE,                              //cycling
                new Stop(0, Color.web("#191970")),                 //colors
                new Stop(1, Color.web("#87CEEB")))
        );
        managerMenu.setScene(menu);
        managerMenu.show();
    }
    */

}