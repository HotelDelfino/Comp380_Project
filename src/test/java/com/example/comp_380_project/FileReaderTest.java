package com.example.comp_380_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FileReaderTest {

    @Test
    public void verifyTextFile() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);

        assertEquals(true, dataBase.passwordFile != null, "datafile not existent");
    }

    @Test
    public void verifyUsername() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);

        assertEquals(true, dataBase.verifyUsername("b"), "user name does not exist");
    }

    @Test
    public void verifyLogin() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);

        assertEquals(false, dataBase.verifyLogin("b","sass"), "login correct");
    }

    @Test
    public void verifyPassWord() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);

        assertEquals(true, dataBase.verifyUsername("a"), "user does not exist");
    }

    @Test
    public void getRegisteredGuest() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);

        assertEquals(true, dataBase.getRegisteredGuest("b") != null, "password does not exist");
    }
}