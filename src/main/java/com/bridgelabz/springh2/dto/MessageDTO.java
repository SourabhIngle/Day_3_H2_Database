package com.bridgelabz.springh2.dto;
// DTO => transfer the data between the controller layer and the service layer


import java.time.LocalDate;

public class MessageDTO {
    public String title;
    public String description;
    public LocalDate startDate;
    public String author;
    public LocalDate endDate;
}
