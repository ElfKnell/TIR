package com.kyrychenko.ApplicationTraffic.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.kyrychenko.ApplicationTraffic.Repository.MessageRepository;
import com.kyrychenko.ApplicationTraffic.domain.Message;
import com.kyrychenko.ApplicationTraffic.domain.Views;
import com.kyrychenko.ApplicationTraffic.dto.EventType;
import com.kyrychenko.ApplicationTraffic.dto.ObjectType;
import com.kyrychenko.ApplicationTraffic.util.WsSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageRepository messageRepository;
    private final BiConsumer<EventType, Message> wsSender;

    @Autowired
    public MessageController(MessageRepository messageRepository, WsSender wsSender) {
        this.messageRepository = messageRepository;
        this.wsSender = wsSender.getSender(ObjectType.MESSAGE, Views.IdName.class);
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
        Message updateMessage = messageRepository.save(message);

        wsSender.accept(EventType.CREATE, updateMessage);

        return updateMessage;
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDB, @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDB, "id");

        Message updatedMessage = messageRepository.save(messageFromDB);

        wsSender.accept(EventType.UPDATE, updatedMessage);
        return updatedMessage;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {


        messageRepository.delete(message);
        wsSender.accept(EventType.REMOVE, message);
    }

    //@MessageMapping("/changeMessage")
    //@SendTo("/topic/activity")
    //public Message change(Message message) {
    //    return messageRepository.save(message);
    //}
}
