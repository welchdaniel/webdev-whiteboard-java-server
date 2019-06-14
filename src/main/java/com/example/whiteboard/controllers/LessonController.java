package com.example.whiteboard.controllers;


import com.example.whiteboard.models.Lesson;
import com.example.whiteboard.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LessonController {

    @Autowired
    LessonService service;


    @PostMapping("/api/lessons")
    public List<Lesson> createLesson(@RequestBody Lesson lesson) {
        return service.createLesson(lesson);
    }

    @GetMapping("/api/lessons")
    public List<Lesson> findAllLessons() {
        return service.findAllLessons();
    }

    @GetMapping("/api/lessons/{lessonId}")
    public Lesson findLessonById(@PathVariable("lessonId") Integer lid) {
        return service.findLessonById(lid);
    }

    @PutMapping("/api/lessons/{lessonId}")
    public List<Lesson> updateLesson(@PathVariable("lessonId") Integer lid, @RequestBody Lesson lesson){
        return service.updateLesson(lid, lesson);
    }

    @DeleteMapping("/api/lessons/{lessonId}")
    public List<Lesson> deleteLesson(@PathVariable("lessonId") Integer lid) {
        return service.deleteLesson(lid);
    }
}
