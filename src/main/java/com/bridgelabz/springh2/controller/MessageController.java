package com.bridgelabz.springh2.controller;

import com.bridgelabz.springh2.model.Message;
import com.bridgelabz.springh2.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @PostMapping("/add")
    public Message addMessage(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    @GetMapping("/getAll")
    public List<Message> getAllMessage() {
        return messageRepo.findAll();
    }


    // we can use @RequestParam also = @GetMapping("/getbyid")
    // local-8089/getById?id=1
    @GetMapping("/getbyid/{id}")
    public Optional<Message> getById(@PathVariable int id) {  // Optional is a class
        return messageRepo.findById(id);
    }


    // for set data => @RequestBody Message message
    @PutMapping("/update/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {
        Optional<Message> messageData = messageRepo.findById(id);
        if (messageData.isPresent()) {
            messageData.get().setMessage(message.getMessage());     //set the new data
            return messageRepo.save(messageData.get());             //save new data in database
        }
        return null;
    }


    // we can use @RequestParam also = @GetMapping("/deleteByid")
    // local-8089/deleteById?id=1
    @DeleteMapping("/delete/{id}")
    public Message deleteMessage(@PathVariable int id) {
        Optional<Message> messageData = messageRepo.findById(id);
        if (messageData.isPresent()) {
            messageRepo.deleteById(id);
            return messageData.get();
        }
        return null; // or throw an exception if desired
    }

}
