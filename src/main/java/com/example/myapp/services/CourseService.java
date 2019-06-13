package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.*;
import com.example.myapp.models.repositories.CourseRepository;
import com.example.myapp.models.repositories.*;



@Service
public class CourseService {
	
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	UserRepository userRepository;
	

	

//	@PostMapping("/api/courses")
	public List<Course> createCours(@RequestBody Course newCourse) {
		if(newCourse.getName().equals("")) {
			newCourse.setName("New Course");
		}
				
		Course course = courseRepository.save(newCourse);
		
		return (List<Course>) courseRepository.findAll();
	}

//	@GetMapping("/api/courses")
	public List<Course> getCourse()
	{
		return (List<Course>)courseRepository.findAll();
	}

//	@PutMapping("/api/courses")
	public List<Course> updateCourse()
	{
		return (List<Course>)courseRepository.findAll();
	}

//	@GetMapping("/api/course/{courseId}")
	public Course findCourseById(@PathVariable("courseId") int cid) {
		return courseRepository.findById(cid).get();
	}

//	 @PutMapping(path ="/api/courses/{courseId}", consumes = "application/json", produces = "application/json")
	    public Course updateWidget(
	            @PathVariable("courseId") long cid,
	            @RequestBody Course course) {
	    	return courseRepository.save(course);
	    }
	      
//	    @DeleteMapping("/api/courses/{courseId}")
	    public List<Course> deleteCourse(@PathVariable("courseId") int cid) {
	    	Optional<Course> temp = courseRepository.findById(cid);
	    	courseRepository.deleteById(cid);
	    	
	    	return (List<Course>) courseRepository.findAll();
	    }


//	    @PutMapping("/api/course/{courseId}/module/{moduleId}")
		public void module(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId) {
			Course course = courseRepository.findById(courseId).get();
			Module module = moduleRepository.findById(moduleId).get();
			module.setCourse(course);
			moduleRepository.save(module);
			course.includedModulesfun(module);
			courseRepository.save(course);
			
		}
	    
//	    @GetMapping("/api/course/{courseId}/modules")
		public Iterable<Module> findCourseModules(@PathVariable("courseId") int courseId){
			Course course = courseRepository.findById(courseId).get();
			return course.getIncludedmodules();
		}

	    
//	    @PutMapping("/api/courses/{courseId}")
		public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course newCourse) {
			Course course = this.findCourseById(courseId);
			if(course!=null) {
				course.setName(newCourse.getName());
				courseRepository.save(course);
				return course;
			}
			return null;
		}


}
