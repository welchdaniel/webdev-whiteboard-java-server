package com.example.whiteboard.services;

import com.example.whiteboard.models.Module;
import com.example.whiteboard.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository repository;

    public Module createModule(Module module) {
        return repository.save(module);
    }

    public List<Module> findAllModules() {
        return repository.findAllModules();
    }

    public Module findModuleById(Integer mid) {
        return repository.findModuleById(mid);
    }

    public List<Module> updateModule(Integer mid, Module module) {
        Optional<Module> optional = repository.findById(mid);
        Module updateModule = optional.get();
        updateModule.setTitle(module.getTitle());
        updateModule.setCourse(module.getCourse());
        repository.save(updateModule);
        return repository.findAllModules();
    }

    public List<Module> deleteModule(Integer mid) {
        repository.deleteById(mid);
        return repository.findAllModules();
    }
}
