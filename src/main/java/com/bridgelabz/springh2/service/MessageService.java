package com.bridgelabz.springh2.service;


import com.bridgelabz.springh2.dto.MessageDTO;
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

    public Optional<Message> getById(int id) {
        return messageRepo.findById(id);
    }

    public Message updateMessage(int id, MessageDTO messageDTO) {
        Optional<Message> messageData = getById(id);
        if (messageData.isPresent()) {
            messageData.get().updateMessage(messageDTO);
            return messageRepo.save(messageData.get());
        }
        return null;
    }
}
