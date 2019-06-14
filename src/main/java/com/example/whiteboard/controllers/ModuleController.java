package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Lesson;
import com.example.whiteboard.models.Module;
import com.example.whiteboard.services.LessonService;
import com.example.whiteboard.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ModuleController {

    @Autowired
    ModuleService service;

    @Autowired
    LessonService lessonService;


    @PostMapping("/api/modules")
    public Module createModule(@RequestBody Module module) {
        return service.createModule(module);
    }

    @GetMapping("/api/modules")
    public List<Module> findAllModules() {
        return service.findAllModules();
    }

    @GetMapping("/api/modules/{moduleId}")
    public Module findModuleById(@PathVariable("moduleId") Integer mid) {
        return service.findModuleById(mid);
    }

    @PutMapping("/api/modules/{moduleId}")
    public List<Module> updateModule(@PathVariable("moduleId") Integer mid, @RequestBody Module module){
        return service.updateModule(mid, module);
    }

    @PutMapping("/api/modules/{moduleId}/lessons/{lessonId}")
    public void addLessonUnderModule(
            @PathVariable("moduleId") Integer moduleId,
            @PathVariable("lessonId") Integer lessonId) {
        Module module = service.findModuleById(moduleId);
        Lesson lesson = lessonService.findLessonById(lessonId);
        lesson.setModule(module);
        lessonService.updateLesson(lessonId, lesson);
    }

    @DeleteMapping("/api/modules/{moduleId}")
    public List<Module> deleteModule(@PathVariable("moduleId") Integer mid) {
        return service.deleteModule(mid);
    }
}
