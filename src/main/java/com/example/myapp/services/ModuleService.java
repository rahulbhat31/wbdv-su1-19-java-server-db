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

import com.example.myapp.models.Module;
import com.example.myapp.models.*;
import com.example.myapp.models.repositories.*;

@Service
public class ModuleService {

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	CourseService courseService = new CourseService();

	//	@PostMapping("/api/modules")
	public Module createModule(@RequestBody Module module) {
		return moduleRepository.save(module);
	}

	//	@GetMapping("/api/modules")
	public List<Module> getModule()
	{
		return (List<Module>)moduleRepository.findAll();
	}

	//	@PutMapping("/api/modules")
	public List<Module> updateModule()
	{
		return (List<Module>)moduleRepository.findAll();
	}

	//	@GetMapping("/api/modules/{moduleId}")
	public Optional<Module> findModuleById(@PathVariable("widgetId") int mid) {
		return moduleRepository.findById(mid);
	}

	//	 @PutMapping(path ="/api/courses/{courseId}/modules", consumes = "application/json", produces = "application/json")
	public List<Module> updateModule(
			@PathVariable("courseId") int cid,
			@RequestBody Module module) {
		Module mod = moduleRepository.findById(module.getId()).get();
		mod.setTitle(module.getTitle());
		Course course = courseService.findCourseById(cid);
		moduleRepository.save(mod);
		return course.getIncludedmodules();
	}

	//	    @DeleteMapping(path = "/api/courses/{courseid}/modules/{moduleId}", consumes = "application/json", produces = "application/json")
	public List<Module> deleteModule(@PathVariable("courseid") int cid , @PathVariable("moduleId") int mid) {
		Optional<Module> temp = moduleRepository.findById(mid);
		moduleRepository.deleteById(mid);
		Course c = courseService.findCourseById(cid);
		return c.getIncludedmodules();

	}

	//	    @PostMapping("/api/courses/{cid}/modules")
	public Module createModule(@PathVariable("cid") Integer id, @RequestBody Module module) {
		if(module.getTitle().equals("")) {
			module.setTitle("New Module");
		}
		moduleRepository.save(module);
		Course course = courseService.findCourseById(id);
		if(course!=null) {
			courseService.module(course.getId(), module.getId());
			courseService.updateCourse(course.getId(), course);
			return module;
		}
		return null;
	}


	//	    @GetMapping("/api/courses/{courseId}/modules")
	public List<Module> findAllModules(@PathVariable("courseId") Integer cid){
		return courseService.findCourseById(cid).getIncludedmodules();
	}

	//	    @PutMapping("/api/module/{moduleId}/lesson/{lessonId}")
	public void setLesson(@PathVariable("moduleId") int moduleId, @PathVariable("lessonId") int lessonId) {
		Module module = moduleRepository.findById(moduleId).get();
		Lesson lesson = lessonRepository.findById(lessonId).get();
		module.includedLessonfun(lesson);
		moduleRepository.save(module);
		lesson.setModule(module);
		lessonRepository.save(lesson);
	}

	//		@GetMapping("/api/module/{moduleId}/lessons")
	public List<Lesson> findAllLessons(@PathVariable("moduleId") int moduleId){
		Module m = moduleRepository.findById(moduleId).get();
		return m.getIncludedLessons();
	}


}
