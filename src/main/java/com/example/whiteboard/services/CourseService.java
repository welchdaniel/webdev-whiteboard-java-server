package com.example.whiteboard.services;

import com.example.whiteboard.models.Course;
import com.example.whiteboard.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public List<Course> createCourse(Course course) {
        repository.save(course);
        return repository.findAllCourses();
    }

    public List<Course> findAllCourses() {
        return repository.findAllCourses();
    }

    public Course findCourseById(Integer cid) {
        return repository.findCourseById(cid);
    }

    public List<Course> updateCourse(Integer cid, Course course) {
        Optional<Course> optional = repository.findById(cid);
        Course updateCourse = optional.get();
        updateCourse.setTitle(course.getTitle());
        repository.save(updateCourse);
        return repository.findAllCourses();
    }

    public List<Course> deleteCourse(Integer cid) {
        repository.deleteById(cid);
        return repository.findAllCourses();
    }
}
