package com.bridgelabz.springh2.dto;

public class ResponseDTO {
    public String message; //message for user
    public Object data;    //get data here after successfully adding in postman

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
