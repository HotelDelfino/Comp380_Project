package com.example.comp_380_project;

import java.util.*;

import javafx.stage.Stage;

import java.io.*;

public class Main {
    public static JavaFxApplication app;
    public static HotelRooms hotel;
    public static PrelimMenu optionMenu;
    public static FileReader dataBase;
    public static String unlocker = "none";

    public static void main(String[] args) throws Exception {
        dataBase = new FileReader();
        hotel = new HotelRooms();
        optionMenu = new PrelimMenu();
        //optionMenu.setHotel(hotel);
        optionMenu.userMenu(args);
        
        /*app = new JavaFxApplication(new FileReader(), new PrelimMenu(), new HotelRooms(), args);
        
        app.startLoginMenu();

        System.out.println(unlocker);
        if (unlocker.equals("t")) {
            optionMenu.setHotel(hotel);
            optionMenu.userMenu(args);
        }*/
    }
}
