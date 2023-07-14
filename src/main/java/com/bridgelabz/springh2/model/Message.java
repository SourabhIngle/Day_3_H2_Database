package com.bridgelabz.springh2.model;
//model layer for the entity.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//with the help of @Entity it will create a table in database.
// database name is = demoh2
@Entity
@Table(name = "message_data")
public class Message {

    @Id              // This annotation is showing this my primary key
    @GeneratedValue  // Auto generate ids
    private int Id;
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
