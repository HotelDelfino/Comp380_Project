package com.example.comp_380_project;

public class Manager extends Guest{

    @Override
    void menu(){
        System.out.println("1. Add a reservation ");
        System.out.println("2. Cancel a reservation ");
        System.out.println("3. View all reservations ");
        System.out.println("0. Logout ");
    }
}
