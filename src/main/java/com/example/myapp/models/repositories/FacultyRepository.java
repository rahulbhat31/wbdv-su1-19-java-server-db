package com.example.myapp.models.repositories;
import org.springframework.data.repository.*;
import com.example.myapp.models.Faculty;


public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
	
}
