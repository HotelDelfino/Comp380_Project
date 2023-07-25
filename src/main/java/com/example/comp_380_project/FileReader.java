package com.example.comp_380_project;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    /** This reads text file. Does not do anything else **/
    public void readTextFile(File file){

        try{
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String st;
            while ((st = br.readLine())!= null){
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

    /** This writes a new line on the text file. Does not do anything else**/
    public void writeTextFile(File file, String username){

        try{
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write(username + "\n");
            myWriter.close();
            System.out.println("File Writing Successful");
        }catch(IOException e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    /** This verifies that a text file exists. Otherwise, creates one. **/
    public void verifyUserNameTextFile(){

        try{
            File obj = new File("usernames.txt");
            if(obj.createNewFile()){
                System.out.println("File Successfully Created: " + obj.getName());
            }else{
                System.out.println("File already exists");
            }
            /** //Example
            String username = "Jose";
            writeTextFile(obj, username);
            readTextFile(obj);
             **/
        }catch(IOException e){
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

    /** This verifies that a text file exists. Otherwise, creates one. **/
    public void verifyPasswordTextFile(){

        try{
            File obj = new File("passwords.txt");
            if(obj.createNewFile()){
                System.out.println("File Successfully Created: " + obj.getName());
            }else{
                System.out.println("File already exists");
            }
            /** //Example
            String password = "password";
            writeTextFile(obj, password);
            readTextFile(obj);
             **/
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
}
