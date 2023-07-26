package com.example.comp_380_project;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        FileReader dataBase = new FileReader();
        //dataBase.readUsernameFile(new File(dataBase.getUserFilePath()));
        //dataBase.readPasswordFile(new File(dataBase.getPassWFilePath()));
        
        PrelimMenu optionMenu = new PrelimMenu();
        JavaFXApp app = new JavaFXApp(dataBase, optionMenu, args);
        
        app.runApp();


    }
}
