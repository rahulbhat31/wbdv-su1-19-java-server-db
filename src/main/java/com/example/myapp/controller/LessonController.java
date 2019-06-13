package com.example.myapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.services.LessonService;


@CrossOrigin("*")
@RestController
public class LessonController {
	@Autowired
	LessonService ls;
	
	@PostMapping("/api/lessons")
	public Lesson createLesson(@RequestBody Lesson lesson) {
		return ls.createLesson(lesson);
	}

	@GetMapping("/api/lessons")
	public List<Lesson> getLesson()
	{
		return ls.getLesson();
	}


	@GetMapping("/api/lessons/{lessonId}")
	public Optional<Lesson> findLessonById(@PathVariable("lessonId") int lid) {
		return ls.findLessonById(lid);
	}
	
	 @PutMapping(path ="/api/lessons/{lessonId}", consumes = "application/json", produces = "application/json")
	    public Lesson updateLesson(
	            @PathVariable("lessonId") long lid,
	            @RequestBody Lesson lesson) {
	    	return ls.updateLesson(lid, lesson);
	    }
	      
	    @DeleteMapping("/api/lessons/{lessonId}")
	    public void deleteLesson(@PathVariable("lessonId") int lid) {
	    	ls.deleteLesson(lid);    
	    }
	  
	    @PostMapping("api/module/{mid}/lesson")
		public Lesson createLesson(@PathVariable("mid") Integer id, @RequestBody Lesson lesson) {
			return ls.createLesson(id, lesson);
		}
		
		@GetMapping("/api/module/{mid}/lesson")
		public List<Lesson> findAllLessons(@PathVariable("mid") Integer id){
			return ls.findAllLessons(id);
		}
		
		@GetMapping("/api/lesson/{lessonId}/module")
		public Module findLessonModule(@PathVariable("lessonId") int lessonId) {
			return ls.findLessonModule(lessonId);
		}
}
