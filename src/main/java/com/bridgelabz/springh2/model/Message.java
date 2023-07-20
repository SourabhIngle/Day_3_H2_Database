package com.bridgelabz.springh2.model;
//model layer for the entity.

import com.bridgelabz.springh2.dto.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

//with the help of @Entity it will create a table in database.
// database name is = demoh2
@Entity
@Table(name = "message_data")
public class Message {

    @Id              // This annotation is showing this is my primary key
    @GeneratedValue  // Auto generate ids
    private int Id;
    private String title;
    private String description;
    private LocalDate startDate;
    private String author;
    private LocalDate endDate;

    public Message() {
    }

    public Message(MessageDTO messageDTO) {
        this.updateMessage(messageDTO);
    }

    public void updateMessage(MessageDTO messageDTO){
        this.title = messageDTO.title;
        this.description = messageDTO.description;
        this.startDate = messageDTO.startDate;
        this.author = messageDTO.author;
        this.endDate = messageDTO.endDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
