package com.example.whiteboard.repositories;

import com.example.whiteboard.models.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {

    @Query("select lesson from Lesson lesson")
    public List<Lesson> findAllLessons();

    @Query("select lesson from Lesson lesson where lesson.id=:lid")
    public Lesson findLessonById(@Param("lid") Integer id);
}
