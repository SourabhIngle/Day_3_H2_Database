package com.bridgelabz.springh2.exception;

//This exception handler for service layer.
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
