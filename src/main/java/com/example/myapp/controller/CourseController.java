package com.example.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Course;
import com.example.myapp.models.Module;


import com.example.myapp.services.CourseService;


@CrossOrigin("*")
@RestController
public class CourseController {
	
	@Autowired
	CourseService cs ;
	

	@PostMapping("/api/courses")
	public List<Course> createCours(@RequestBody Course newCourse) {
		return cs.createCours(newCourse);
	}

	@GetMapping("/api/courses")
	public List<Course> getCourse()
	{
		return cs.getCourse();
	}

	@PutMapping("/api/courses")
	public List<Course> updateCourse()
	{
		return cs.updateCourse();
	}

	@GetMapping("/api/course/{courseId}")
	public Course findCourseById(@PathVariable("courseId") int cid) {
		return cs.findCourseById(cid);
	}

	 @PutMapping(path ="/api/courses/{courseId}", consumes = "application/json", produces = "application/json")
	    public Course updateWidget(
	            @PathVariable("courseId") long cid,
	            @RequestBody Course course) {
		 return cs.updateWidget(cid, course);
	     }
	      
	    @DeleteMapping("/api/courses/{courseId}")
	    public List<Course> deleteCourse(@PathVariable("courseId") int cid) {	    	
	    	return cs.deleteCourse(cid);
	    }


	    @PutMapping("/api/course/{courseId}/module/{moduleId}")
		public void module(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId) {
	    	cs.module(courseId, moduleId);			
		}
	    
	    @GetMapping("/api/course/{courseId}/modules")
		public Iterable<Module> findCourseModules(@PathVariable("courseId") int courseId){
			return cs.findCourseModules(courseId);
		}

	    
	    @PutMapping("/api/courses/{courseId}")
		public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course newCourse) {
			return cs.updateCourse(courseId, newCourse);
		}


}
