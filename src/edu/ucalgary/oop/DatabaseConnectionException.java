package edu.ucalgary.oop;

public class DatabaseConnectionException extends Exception{
    public DatabaseConnectionException(){
        super("Connection to database failed");
    }
}
