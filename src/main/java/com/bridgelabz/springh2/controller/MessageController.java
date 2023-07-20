package com.bridgelabz.springh2.controller;

import com.bridgelabz.springh2.dto.MessageDTO;
import com.bridgelabz.springh2.dto.ResponseDTO;
import com.bridgelabz.springh2.model.Message;
import com.bridgelabz.springh2.repository.MessageRepo;
import com.bridgelabz.springh2.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addMessage(@Valid @RequestBody MessageDTO messageDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Data Add Successfully", messageService.addMessage(messageDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Message> getAllMessage() {
        return messageRepo.findAll();
    }


    // we can use @RequestParam also = @GetMapping("/getbyid")id
    // local-8089/getById?id=1
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id) {  // Optional is a class
        ResponseDTO responseDTO = new ResponseDTO("Data Fetched Successfully", messageService.getById(id));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


    // for set data => @RequestBody Message message
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateMessage(@PathVariable int id, @Valid @RequestBody MessageDTO messageDTO) {
        Message message = messageService.updateMessage(id, messageDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Updated Successfully", message);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMessageById(@PathVariable int id) {
        boolean deleted = messageService.deleteMessageById(id);
        if (deleted) {
            return ResponseEntity.ok("Data with Id " + id + " deleted successfully");
        }

        return ResponseEntity.ok("Data Id " + id + " Not Found");
    }
}
