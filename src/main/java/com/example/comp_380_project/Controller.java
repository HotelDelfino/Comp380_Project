package com.example.comp_380_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label guestText;
    @FXML
    private Label managerText;

    @FXML
    protected void onGuestButtonClick() { guestText.setText("Logging in as Guest..."); }
    @FXML
    protected void onManagerButtonClick() { managerText.setText("Logging in as Manager"); }
}