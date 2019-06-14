package com.example.whiteboard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="modules")
public class Module {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne()
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "module")
    private List<Lesson> lessons;

    public Module(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Module() {
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
}