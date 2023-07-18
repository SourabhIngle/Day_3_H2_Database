package com.bridgelabz.springh2.dto;
// DTO => transfer the data between the controller layer and the service layer


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class MessageDTO {
    // NotNull for int, NotEmpty and NotBlank for String , NotBlank for collection data type also .

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]+(\\s[A-Za-z]+)?$",message = "Title mismatich")
    @NotEmpty(message = "Title Cannot be Empty")
    public String title;
    public String description;
    public LocalDate startDate;
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]+(\\s[A-Za-z]+)?$",message = "First letter should be capital and At least three character")
    public String author;
    public LocalDate endDate;
}
