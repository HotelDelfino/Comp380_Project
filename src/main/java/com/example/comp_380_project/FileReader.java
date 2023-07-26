package com.example.comp_380_project;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    static File usernamesFile;
    static File passwordFile;
    static ArrayList<String> userNames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    /** Constructor. Starts the Textfile **/
    FileReader(){
        verifyTextFile();
    }
    /** This reads username text file. Adds content to Array **/
    public void readUsernameFile(File file){
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
    /** This reads password text file. Adds content to Array **/
    public void readPasswordFile(File file){

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

    /** This creates a new username and password **/
    public void registerNewUser(String username, String pw){
        writeTextFile(usernamesFile, username);
        writeTextFile(passwordFile, pw);
    }

    /** This writes a new line on the text file. Does not do anything else**/
    public void writeTextFile(File file, String stuff){

        try{
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write(stuff + "\n");
            myWriter.close();
            System.out.println("File Writing Successful");
        }catch(IOException e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    /** This verifies that a text file exists. Otherwise, creates one. **/
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


        }catch(IOException e){
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

    public Path getFilePath(){
        /** Capture file path **/
        Path path = Paths.get("usernames.txt");
        // Temporary
        System.out.println(path.toAbsolutePath());
        return path.toAbsolutePath();
    }
    
    /** Checks to see if Username exists **/
    public boolean verifyUsername(String userN){
        for (int i = 0; i < userNames.size(); i++) {
            if (userN.equals(userNames.get(i))) return true;
        }
        return false;
    }

    /** Checks to see if Username is in the system and if the password matches **/
    public boolean verifyLogin(String userN, String pW){
        for (int i = 0; i < userNames.size(); i++) {
            if (userN.equals(userNames.get(i))) {
                return verifyPassWord(pW,i);
            }
        }
        return false;
    }

    public boolean verifyPassWord(String pW, int index){
        return pW.equals(passwords.get(index));
    }
}