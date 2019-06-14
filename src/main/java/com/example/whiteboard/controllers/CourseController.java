package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Course;
import com.example.whiteboard.models.Module;
import com.example.whiteboard.services.CourseService;
import com.example.whiteboard.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    CourseService service;

    @Autowired
    ModuleService moduleService;


    @PostMapping("/api/courses")
    public List<Course> createCourse(@RequestBody Course course) {
        return service.createCourse(course);
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return service.findAllCourses();
    }

    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById(@PathVariable("courseId") Integer cid) {
        return service.findCourseById(cid);
    }

    @PutMapping("/api/courses/{courseId}")
    public List<Course> updateCourse(@PathVariable("courseId") Integer cid, @RequestBody Course course){
        return service.updateCourse(cid, course);
    }

    @PutMapping("/api/courses/{courseId}/modules/{moduleId}")
    public void addModuleUnderCourse(
            @PathVariable("courseId") Integer courseId,
            @PathVariable("moduleId") Integer moduleId) {
        Course course = service.findCourseById(courseId);
        Module module = moduleService.findModuleById(moduleId);
        module.setCourse(course);
        moduleService.updateModule(moduleId, module);
    }

    @DeleteMapping("/api/courses/{courseId}")
    public List<Course> deleteCourse(@PathVariable("courseId") Integer cid) {
        return service.deleteCourse(cid);
    }
}
