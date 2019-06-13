package com.example.myapp.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
