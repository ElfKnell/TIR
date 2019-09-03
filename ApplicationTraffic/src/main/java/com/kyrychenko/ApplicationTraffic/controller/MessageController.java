package com.kyrychenko.ApplicationTraffic.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.kyrychenko.ApplicationTraffic.Repository.MessageRepository;
import com.kyrychenko.ApplicationTraffic.domain.Message;
import com.kyrychenko.ApplicationTraffic.domain.Views;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepository.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {

        message.setCreationDate(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDB, @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDB, "id");

        return messageRepository.save(messageFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {


        messageRepository.delete(message);
    }
}
