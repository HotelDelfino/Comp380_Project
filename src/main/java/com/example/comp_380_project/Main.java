package com.example.comp_380_project;

import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
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


public class Main extends Application {
    Stage window;
    Scene scene, loginScene, guestScene;
    Button reserve, search, cancel, review, edit, info, close;
    private HotelRooms hotelRooms;
    private FileReader dataBase;
    private Manager manager;
    ListView<String> listReviews;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
  
        main.login(args);
    }

    public void login(String[] args) {
        launch(args); // launches window
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        hotelRooms = new HotelRooms();
        dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);
        manager = new Manager();


        VBox root = new VBox(40);
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
        loginScene = new Scene(root, 600, 400);

        window.setTitle("Welcome To Hotel");
        window.setWidth(Screen.getPrimary().getVisualBounds().getWidth() * 1.0);
        window.setHeight(Screen.getPrimary().getVisualBounds().getHeight() * 1.0);
        window.setScene(loginScene);
        window.show();
    }


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

    private void managerLogin(Stage primaryStage) {
        TextInputDialog dialog1 = new TextInputDialog();
        dialog1.setTitle("Login As Manager");
        dialog1.setHeaderText(null);
        dialog1.setContentText("Enter User Name:");
        String u = dialog1.showAndWait().orElse(null);

        TextInputDialog dialog2 = new TextInputDialog();
        
        if (u == null)
            return;
        
        while (true) {
            if (!u.equals("m")) {
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

                if (!p.equals("p")) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Wrong Password");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong password entered.");
                    alert.showAndWait();
                }
                else {
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
        if(hotelRooms == null) System.out.println("Hotel is null");
        confirm.setOnAction(e -> hotelRooms.reserveRoom(floors.getValue(), rooms.getValue())); // bars :(
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
        hotelRooms.searchRoom(input5.nextInt(), input5.nextInt());
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
        hotelRooms.cancelRoom(input2.nextInt(), input2.nextInt());
    }

    private void infoRoom() {
        Scanner input6 = new Scanner(System.in);
        System.out.println("Which floor would you like to know more about?\n");
        System.out.println("Small rooms: 1\n" +
                            "Larger rooms: 2\n" +
                            "Family rooms: 3\n" +
                            "Luxury rooms: 4\n" +
                            "Penthouse suite: 5\n");
        hotelRooms.roomInfo(input6.nextInt());
    }

    private void reviewRoom() { 
        Scene reviewScene;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);

        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        Label reviewLabel = new Label("Type Review:");
        TextArea reviewArea = new TextArea();

        grid.add(reviewLabel, 0,0);
        grid.add(reviewArea, 1,0);
        grid.add(cancelButton, 2,1);
        grid.add(submitButton, 2,2);

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
            window.show();*/
            window.setScene(scene);
        });
        

        reviewScene = new Scene(grid, 700,700);
        window.setScene(reviewScene);
        window.show();
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
        hotelRooms.changeRoom(input3.nextInt(), input3.nextInt());

        Scanner input4 = new Scanner(System.in);
        System.out.print("Which room would you like to change it to?");
        hotelRooms.reserveRoom(input4.nextInt(), input4.nextInt());
    }

}