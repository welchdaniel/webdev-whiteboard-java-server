package com.example.whiteboard.services;

import com.example.whiteboard.models.Lesson;
import com.example.whiteboard.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    LessonRepository repository;

    public Lesson createLesson(Lesson lesson) {
        return repository.save(lesson);
    }

    public List<Lesson> findAllLessons() {
        return repository.findAllLessons();
    }

    public Lesson findLessonById(Integer lid) {
        return repository.findLessonById(lid);
    }

    public List<Lesson> updateLesson(Integer lid, Lesson lesson) {
        Optional<Lesson> optional = repository.findById(lid);
        Lesson updateLesson = optional.get();
        updateLesson.setTitle(lesson.getTitle());
        updateLesson.setModule(lesson.getModule());
        repository.save(updateLesson);
        return repository.findAllLessons();
    }

    public List<Lesson> deleteLesson(Integer lid) {
        repository.deleteById(lid);
        return repository.findAllLessons();
    }
}
