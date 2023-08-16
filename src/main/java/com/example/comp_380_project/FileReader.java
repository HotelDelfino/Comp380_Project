package com.example.comp_380_project;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * FileReader
 * <p>
 * The FileReader class creates 4 textfiles that hold usernames, passwords, reservations and reviews.
 * FileReader is in charge of reading these 4 text files and holding their contents within the class.
 * FileReader is also able to modify the information within these arrays and write to the textfiles.
 * </p>
 *
 * @author Jorge Enriquez
 *  Date: Aug 15, 2023
 *  Version: 1.0*/

public class FileReader{
    private File usernamesFile;
    private File passwordFile;
    private File reservationsFile;
    private File reviewFile;
    private static HotelRooms hotel;
    private ArrayList<String> userNames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> reservations = new ArrayList<>();
    private ArrayList<String> reviews = new ArrayList<>();
    private ArrayList<Guest> registeredMembers = new ArrayList<>();
    
    /** Constructor. Starts the Textfile. ONLY CALL ONCE
     * @param hotelrooms gets the HotelRooms object */
    FileReader(HotelRooms hotelrooms){
        hotel = hotelrooms;
        verifyTextFile();
        createRegisteredGuest();
    }
    /** reads the username file and adds it to the userNames array
     * @param file gets the File necessary to run
     * @exception FileNotFoundException On file not found. */
    private void readUsernameFile(File file){
        System.out.println("Attempting to read file: " + file.getAbsolutePath());
        try{
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String st;
            while ((st = br.readLine())!= null){
                userNames.add(st);
                System.out.println(st);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }catch(IOException f){
            System.out.println("An Error has occurred");
            f.printStackTrace();
        }
    }
    /** This reads password text file. Adds content to Array
     * @param file gets the File necessary to run
     * @exception FileNotFoundException On file not found. */
    private void readPasswordFile(File file){

        try{
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String st;
            while ((st = br.readLine())!= null){
                passwords.add(st);
                System.out.println(st);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }catch(IOException f){
            System.out.println("An Error has occurred");
            f.printStackTrace();
        }
    }

    /** This reads the reservations file. Adds to HotelRooms
     * @param file gets the File necessary to run
     * @exception FileNotFoundException On file not found. */
    private void readReservationsFile(File file){

        try{
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String st;
            while ((st = br.readLine())!= null){
                reservations.add(st);
                System.out.println(st);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }catch(IOException f){
            System.out.println("An Error has occurred");
            f.printStackTrace();
        }
    }

    /** This reads the reviews files and stores it in Reviews Array
     * @param file gets the File necessary to run
     * @exception FileNotFoundException On file not found. */
    private void readReviewFile(File file){
        try{
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String st;
            while ((st = br.readLine())!= null){
                reviews.add(st);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }catch(IOException f){
            System.out.println("An Error has occurred");
            f.printStackTrace();
        }
    }

    /** Adds to Review Array and writes to review Textfile
     * @param review gets a String */
    public void addReview(String review){
        reviews.add(review);
        writeTextFile(reviewFile,review);
    }

    /** This function allows access to the reviews array
     * @return ArrayList returns array list to use */
    public ArrayList<String> getReviews(){return reviews;}

    /** This creates a new username and password
     * @param username gets a String username
     * @param pw gets a String pw */
    public void registerNewUser(String username, String pw){
        writeTextFile(usernamesFile, username);
        userNames.add(username);
        writeTextFile(passwordFile, pw);
        passwords.add(pw);
        writeTextFile(reservationsFile,"0");
        createGuest(username,pw);
    }

    /** This writes a new line on the text file. Does not do anything else
     * @param file gets a File object
     * @param stuff gets a String of stuff*/
    private void writeTextFile(File file, String stuff){

        try{
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write("\n" + stuff);
            myWriter.close();
            System.out.println("File Writing Successful");
        }catch(IOException e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
    /** Can be called by other classes without a File object. Uses File object attached to FileReader.
     * @param stuff gets a String of stuff
     * @param guestIndex gets an int*/
    public void updateReservationTextFile(String stuff, int guestIndex){
        writeReservationTextFile(reservationsFile,stuff,guestIndex);
    }
    /** This writes on the reservations text file. Uses the guest index to find where to override text
     * @param file gets a File object
     * @param stuff gets a String of stuff
     * @param guestIndex gets an int*/
    private void writeReservationTextFile(File file, String stuff, int guestIndex){

        // Checks to see if the array is more than one to avoid out of bounds exception
        if(reservations.size()>1) {
            try {
                FileWriter deleter = new FileWriter(file, false);
                deleter.write(reservations.get(0));
                deleter.close();
                System.out.println("File Wipe Successful");
                FileWriter myWriter = new FileWriter(file, true);
                for (int i = 1; i < reservations.size(); i++) {
                    if (i != guestIndex)
                        myWriter.write("\n"+reservations.get(i));
                    else myWriter.write("\n" + stuff);
                    System.out.println("File Writing Successful");
                }
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error has occurred");
                e.printStackTrace();
            }
        }else{
            try {
                FileWriter deleter = new FileWriter(file, false);
                deleter.write(reservations.get(0));
                deleter.close();
                System.out.println("File Writing Successful");

            } catch (IOException e) {
                System.out.println("An error has occurred");
                e.printStackTrace();
            }
        }
    }


    /** This verifies that a text file exists, otherwise, creates one. **/
    public void verifyTextFile(){

        try{
            File user = new File("usernames.txt");
            if(user.createNewFile()){
                System.out.println("File Successfully Created: " + user.getName());
            }else{
                System.out.println("File usernames.text already exists");
                // If file exists, then it will read it and put contents in array
                readUsernameFile(user);
            }
            //Save the file for the whole class to use
            usernamesFile = user;

            File passW = new File("passwords.txt");
            if(passW.createNewFile()){
                System.out.println("File Successfully Created: " + passW.getName());
            }else{
                System.out.println("File passwords.txt already exists");
                readPasswordFile(passW);
            }
            //Save the file for the whole class to use
            passwordFile = passW;

            File reservations = new File("reservations.txt");
            if(reservations.createNewFile()){
                System.out.println("File Successfully Created: " + reservations.getName());
            }else{
                System.out.println("File reservations.text already exists");
                // If file exists, then it will read it and put contents in array
                readReservationsFile(reservations);
            }
            //Save the file for the whole class to use
            reservationsFile = reservations;

            File reviews = new File("reviews.txt");
            if(reviews.createNewFile()) System.out.println("File Successfully Created: " + reviews.getName());
            else{
                System.out.println("File reviews.txt already exists");
                readReviewFile(reviews);
            }
            reviewFile = reviews;
        }catch(IOException e){
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

    /** Captures and returns file path for Username.txt
     * @return String returns the file path as a string
     *
     * */
    public String getUserFilePath(){
        Path path = Paths.get("usernames.txt");
        // Temporary
        System.out.println(path.toAbsolutePath());
        return path.toAbsolutePath().toString();
    }

    /** Capture password file path
     * @return String returns the file path as a string*/
    public String getPassWFilePath(){
        Path path = Paths.get("passwords.txt");
        // Temporary
        System.out.println(path.toAbsolutePath());
        return path.toAbsolutePath().toString();
    }
    
    /** Checks to see if Username exists
     * @param userN gets a String
     * @return boolean returns true or false
     *  **/
    public boolean verifyUsername(String userN){
        for (int i = 0; i < userNames.size(); i++) {
            if (userN.equals(userNames.get(i))) return true;
        }
        return false;
    }

    /** Checks to see if Username is in the system and if the password matches
     * @param userN gets a String
     * @param pW gets a String
     * @return boolean returns true or false
     *  **/
    public boolean verifyLogin(String userN, String pW){
        for (int i = 0; i < userNames.size(); i++) {
            if (userN.equals(userNames.get(i))) {
                return verifyPassWord(pW,i);
            }
        }
        return false;
    }

    /** Returns a boolean value by checking password with
     * @param pW gets a string
     * @param index gets a string
     * @return boolean returns true or false*/
    public boolean verifyPassWord(String pW, int index){
        return pW.equals(passwords.get(index));
    }
    /** This function instantiates a new guest and adds it to registeredMembers array
     * @param username gets a String
     *  @param password */
    private void createGuest(String username, String password){
        registeredMembers.add(new Guest(username,password));
    }

    /** Creates Guest Objects from textfiles. Adds reservations **/
    private void createRegisteredGuest(){
        for(int i = 0; i < userNames.size(); i++){
            registeredMembers.add(new Guest(userNames.get(i),passwords.get(i),reservations.get(i)));
            hotel.updateHotelRoomsArray(registeredMembers.get(i));
            registeredMembers.get(i).setGuestIndex(i);
        }
    }

    /** This function returns a guest object from the registedMembers array by looking through the usernames array
     * @param username get string
     *  @return Guest return Guest object*/
    public Guest getRegisteredGuest(String username){
        for (int i = 0; i < userNames.size(); i++) {
            if (userNames.get(i).equals(username)) return registeredMembers.get(i);
        }
        return null;
    }
}