package com.example.comp_380_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelRoomsTest {
    private static FileReader database;

    @Test
    void reserveRoom() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);
        int floor = 3;
        int roomNum = 2;

        hotelRooms.setGuestOnLogin(dataBase.getRegisteredGuest("b"));

        hotelRooms.reserveRoom(floor, roomNum);

            // Assert
        assertEquals("b", hotelRooms.floor3[2], "Room status is not open");
    }

    @Test
    void cancelRoomTest() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);
        int floor = 3;
        int roomNum = 2;

        hotelRooms.setGuestOnLogin(dataBase.getRegisteredGuest("b"));

        //hotelRooms.reserveRoom(floor, roomNum);
        hotelRooms.cancelRoom(floor, roomNum);

        // Assert
        assertEquals("Open", hotelRooms.floor3[2], "Room status is not open");
    }


    @Test
    void editRoomTest() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);
        int floor = 3;
        int roomNum = 2;

        hotelRooms.setGuestOnLogin(dataBase.getRegisteredGuest("b"));

        hotelRooms.reserveRoom(floor, roomNum);
        hotelRooms.editRoom(floor, roomNum, 3, 3);

        // Assert
        assertEquals("b", hotelRooms.floor3[3], "Room did not change");
    }

    @Test void setDatabase() {
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);

        // Assert
        assertEquals(true, dataBase != null, "Room is not open");
    }

    @Test
    void printArray(){
        HotelRooms hotelRooms = new HotelRooms();
        FileReader dataBase = new FileReader(hotelRooms);
        hotelRooms.setDatabase(dataBase);

        assertEquals(true, hotelRooms.floor1 != null, "Room is not open");
    }
}
