package com.example.comp_380_project;

import java.util.ArrayList;


public class Manager extends Guest {
    ArrayList<String> reviews;

    Manager() {
        reviews = new ArrayList<>();
    }

    
    /** 
     * @param review
     */
    public void addReview(String review) {
        reviews.add(review);
    }

    
    /** 
     * @return ArrayList<String>
     */
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
