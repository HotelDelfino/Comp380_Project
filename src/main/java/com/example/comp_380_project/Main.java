package com.example.comp_380_project;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        FileReader dataBase = new FileReader();
        HotelRooms hotel = new HotelRooms();
        PrelimMenu optionMenu = new PrelimMenu();
        JavaFXApp app = new JavaFXApp(dataBase, optionMenu, args);
        
        optionMenu.setHotel(hotel);
        
        app.runApp();
    }
}
