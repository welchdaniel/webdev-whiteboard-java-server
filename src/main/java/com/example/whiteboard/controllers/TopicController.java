package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TopicController {

    @Autowired
    TopicService service;


    @PostMapping("/api/topics")
    public List<Topic> createTopic(@RequestBody Topic topic) {
        return service.createTopic(topic);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return service.findAllTopics();
    }

    @GetMapping("/api/topics/{topicId}")
    public Topic findTopicById(@PathVariable("topicId") Integer tid) {
        return service.findTopicById(tid);
    }

    @PutMapping("/api/topics/{topicId}")
    public List<Topic> updateTopic(@PathVariable("topicId") Integer tid, @RequestBody Topic topic){
        return service.updateTopic(tid, topic);
    }

    @DeleteMapping("/api/topics/{topicId}")
    public List<Topic> deleteTopic(@PathVariable("topicId") Integer tid) {
        return service.deleteTopic(tid);
    }
}
