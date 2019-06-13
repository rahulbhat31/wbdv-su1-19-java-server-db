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
import com.example.myapp.models.repositories.LessonRepository;
import com.example.myapp.models.repositories.ModuleRepository;
import com.example.myapp.models.repositories.TopicRepository;

@Service
public class LessonService {

	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	ModuleService moduleService = new ModuleService();
	

//	@PostMapping("/api/lessons")
	public Lesson createLesson(@RequestBody Lesson lesson) {
		return lessonRepository.save(lesson);
	}

//	@GetMapping("/api/lessons")
	public List<Lesson> getLesson()
	{
		return (List<Lesson>)lessonRepository.findAll();
	}


//	@GetMapping("/api/lessons/{lessonId}")
	public Optional<Lesson> findLessonById(@PathVariable("lessonId") int lid) {
		return lessonRepository.findById(lid);
	}

//	 @PutMapping(path ="/api/lessons/{lessonId}", consumes = "application/json", produces = "application/json")
	    public Lesson updateLesson(
	            @PathVariable("lessonId") long lid,
	            @RequestBody Lesson lesson) {
	    	return lessonRepository.save(lesson);
	    }
	      
//	    @DeleteMapping("/api/lessons/{lessonId}")
	    public void deleteLesson(@PathVariable("lessonId") int lid) {
	    	Optional<Lesson> temp = lessonRepository.findById(lid);
	    	lessonRepository.deleteById(lid);    
	    }
	     
//	    @PostMapping("api/module/{mid}/lesson")
		public List<Lesson> createLesson(@PathVariable("mid") Integer id, @RequestBody Lesson lesson) {
			if(lesson.getTitle().equals("")) {
				lesson.setTitle("New Lesson");
			}
			lessonRepository.save(lesson);
			com.example.myapp.models.Module module = moduleService.findModuleById(id).get();
			if(module!=null) {
				
				moduleService.setLesson(module.getId(), lesson.getId());
				moduleService.updateModule(module.getId(),module);
				return module.getIncludedLessons();
			}
			return null;
		}
		
//		@GetMapping("/api/module/{mid}/lesson")
		public List<Lesson> findAllLessons(@PathVariable("mid") Integer id){
			return moduleService.findModuleById(id).get().getIncludedLessons();
		}
		
//		@GetMapping("/api/lesson/{lessonId}/module")
		public Module findLessonModule(@PathVariable("lessonId") int lessonId) {
			Lesson lesson = lessonRepository.findById(lessonId).get();
			return lesson.getModule();
		}
		
	    
	    
}
