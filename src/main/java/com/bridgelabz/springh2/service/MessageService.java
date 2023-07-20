package com.bridgelabz.springh2.service;


import com.bridgelabz.springh2.dto.MessageDTO;
import com.bridgelabz.springh2.exception.CustomException;
import com.bridgelabz.springh2.model.Message;
import com.bridgelabz.springh2.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public Message addMessage(MessageDTO messageDTO) {
        Message messageData = new Message(messageDTO);
        return messageRepo.save(messageData);
    }

    public Message getById(int id) {
//        return messageRepo.findById(id);
        return messageRepo.findById(id).orElseThrow(() -> new CustomException("Message with id: " + id + " Not Present"));
    }

    public Message updateMessage(int id, MessageDTO messageDTO) {
        Message messageData = getById(id);
        if (messageData != null) {
            messageData.updateMessage(messageDTO);
            return messageRepo.save(messageData);
        }
        return null;
    }

    public boolean deleteMessageById(int id){
        if (messageRepo.existsById(id)){
            messageRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
