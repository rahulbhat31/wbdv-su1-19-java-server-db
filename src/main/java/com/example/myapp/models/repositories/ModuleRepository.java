package com.example.myapp.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.Faculty;
import com.example.myapp.models.Module;

public interface ModuleRepository extends CrudRepository<Module, Integer>  {

}
