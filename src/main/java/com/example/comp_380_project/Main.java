package com.example.comp_380_project;

public class Main {


    public static void main(String[] args) {
        PrelimMenu optionMenu = new PrelimMenu();
        JavaFXApp app = new JavaFXApp(optionMenu, args);

        app.runApp();
    }
}
