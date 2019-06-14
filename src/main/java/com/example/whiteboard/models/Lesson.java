package com.example.whiteboard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne()
    @JsonIgnore
    private Module module;

    @OneToMany(mappedBy = "lesson", orphanRemoval=true)
    private List<Topic> topics;

    public Lesson(Integer id, String title, Module module, List<Topic> topics) {
        this.id = id;
        this.title = title;
        this.module = module;
        this.topics = topics;
    }

    public Lesson() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}