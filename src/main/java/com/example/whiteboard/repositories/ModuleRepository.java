package com.example.whiteboard.repositories;


import com.example.whiteboard.models.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {

    @Query("select module from Module module")
    public List<Module> findAllModules();

    @Query("select module from Module module where module.id=:mid")
    public Module findModuleById(@Param("mid") Integer id);
}
