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
import com.example.myapp.services.ModuleService;

@CrossOrigin("*")
@RestController
public class ModuleController {
	@Autowired
	ModuleService ms;
	
	@PostMapping("/api/modules")
	public Module createModule(@RequestBody Module module) {
		return ms.createModule(module);
	}

	@GetMapping("/api/modules")
	public List<Module> getModule()
	{
		return ms.getModule();
	}

	@PutMapping("/api/modules")
	public List<Module> updateModule()
	{
		return ms.updateModule();
	}

	@GetMapping("/api/modules/{moduleId}")
	public Optional<Module> findModuleById(@PathVariable("moduleId") int mid) {
		return ms.findModuleById(mid);
	}

	 @PutMapping(path ="/api/courses/{courseId}/modules", consumes = "application/json", produces = "application/json")
	    public List<Module> updateModule(
	            @PathVariable("courseId") int cid,
	            @RequestBody Module module) {
		 return ms.updateModule(cid, module);
	    }
	      
	    @DeleteMapping(path = "/api/courses/{courseid}/modules/{moduleId}", consumes = "application/json", produces = "application/json")
	    public List<Module> deleteModule(@PathVariable("courseid") int cid , @PathVariable("moduleId") int mid) {
	    	return ms.deleteModule(cid, mid);
	    	
	    }
	    
	    @PostMapping("/api/courses/{cid}/modules")
		public Module createModule(@PathVariable("cid") Integer id, @RequestBody Module module) {
			return ms.createModule(id, module);
		}
	    
	    
	    @GetMapping("/api/courses/{courseId}/modules")
		public List<Module> findAllModules(@PathVariable("courseId") Integer cid){
			return ms.findAllModules(cid);
		}
	    
	    @PutMapping("/api/module/{moduleId}/lesson/{lessonId}")
		public void setLesson(@PathVariable("moduleId") int moduleId, @PathVariable("lessonId") int lessonId) {
			ms.setLesson(moduleId, lessonId);
		}
		
		@GetMapping("/api/module/{moduleId}/lessons")
		public List<Lesson> findAllLessons(@PathVariable("moduleId") int moduleId){
			return ms.findAllLessons(moduleId);
		}
}
