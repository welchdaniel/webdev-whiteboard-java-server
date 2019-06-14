package com.example.whiteboard.repositories;

import com.example.whiteboard.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("select topic from Topic topic")
    public List<Topic> findAllTopics();

    @Query("select topic from Topic topic where topic.id=:tid")
    public Topic findTopicById(@Param("tid") Integer id);
}
