package com.example.comp_380_project;

import java.util.*;
import java.io.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label userName;
    @FXML
    private Label passWord;

    private Label nameLabel;

    @FXML
    protected void handleSubmitButtonAction() {
        
        System.out.println("Logging in Boss...");
    }

    @FXML
    protected void onSignInManagerButton() {
        System.out.println("OK boss");
    }

    @FXML
    protected void onRegisterButton() {
        System.out.println("Register boss");
    }
}