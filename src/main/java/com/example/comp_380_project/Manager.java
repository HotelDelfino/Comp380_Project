package com.example.comp_380_project;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Manager extends Guest {
    ArrayList<String> reviews;

    Manager() {
        reviews = new ArrayList<>();
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    void menu(){
        System.out.println("1. Add a reservation ");
        System.out.println("2. Cancel a reservation ");
        System.out.println("3. View all reservations ");
        System.out.println("0. Logout ");
    }
}
