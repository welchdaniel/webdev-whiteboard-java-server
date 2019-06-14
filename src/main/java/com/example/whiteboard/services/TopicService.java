package com.example.whiteboard.services;


import com.example.whiteboard.models.Topic;
import com.example.whiteboard.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepository repository;

    public List<Topic> createTopic(Topic topic) {
        repository.save(topic);
        return repository.findAllTopics();
    }

    public List<Topic> findAllTopics() {
        return repository.findAllTopics();
    }

    public Topic findTopicById(Integer tid) {
        return repository.findTopicById(tid);
    }

    public List<Topic> updateTopic(Integer tid, Topic topic) {
        Optional<Topic> optional = repository.findById(tid);
        Topic updateTopic = optional.get();
        updateTopic.setTitle(topic.getTitle());
        repository.save(updateTopic);
        return repository.findAllTopics();
    }

    public List<Topic> deleteTopic(Integer tid) {
        repository.deleteById(tid);
        return repository.findAllTopics();
    }
}
