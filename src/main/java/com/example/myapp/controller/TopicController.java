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

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.services.TopicService;

@CrossOrigin("*")
@RestController
public class TopicController {
	@Autowired
	TopicService ts = new TopicService();
	
	@PostMapping("/api/topics")
	public Topic createTopic(@RequestBody Topic topic) {
		return ts.createTopic(topic);
	}

	@GetMapping("/api/topic")
	public List<Topic> getTopic()
	{
		return ts.getTopic();
	}

	@PutMapping("/api/topics")
	public List<Topic> updateTopic()
	{
		return ts.updateTopic();
	}

	@GetMapping("/api/topics/{topicId}")
	public Optional<Topic> findTopicById(@PathVariable("topicId") int tip) {
		return ts.findTopicById(tip);
	}

	 @PutMapping(path ="/api/topics/{topicId}", consumes = "application/json", produces = "application/json")
	    public Topic updateTopic(
	            @PathVariable("topicId") int tip,
	            @RequestBody Topic topic) {
	    	return ts.updateTopic(tip, topic);
	    }
	      
	    @DeleteMapping("/api/topics/{topicId}")
	    public void deleteTopic(@PathVariable("topicId") int tip) {
	    	ts.deleteTopic(tip);   
	    }
	    
	    @PostMapping("/api/topic/{tid}/widget")
	    public List<Widget> authoredCourse(@PathVariable("tid") int tid, 
	    			@RequestBody Widget widget) {
	    	
	    	return ts.authoredCourse(tid, widget);
	    }

	    @GetMapping("/api/topic/{tid}/widgets")
	    public List<Widget> findAllWidgets(@PathVariable("tid") int tid){
	    return ts.findAllWidgets(tid);
	    }
	    
	    
	    
	    @PostMapping("/api/lesson/{lid}/topic")
		public Topic createTopic(@PathVariable("lid") Integer id, @RequestBody Topic topic) {
			return ts.createTopic(id, topic);
			
		}
		
	    
	    @PutMapping("/api/topic/{topicId}/widget")
		public void widgets(@PathVariable("topicId") int topicId, @RequestBody Widget newWidget) {
			ts.widgets(topicId, newWidget);
		}
	    
	    @PutMapping("/api/topic/{topicId}/all/widgets")
		public List<Widget> widgets(@PathVariable("topicId") int topicId, @RequestBody List<Widget> newWidgets) {
			return ts.widgets(topicId, newWidgets);
		}		
	    
	    
	    
//		@GetMapping("/api/lesson/{lid}/topic")
//		public Iterable<Topic> findAllTopics(@PathVariable("lid") Integer id){
//			return lessonService.findLessonById(id).get().getIncludedTopics();
//		}
//		
		@PutMapping("/api/lesson/{lessonId}/topic/{topicId}")
		public void topicForLesson(@PathVariable("lessonId") int lessonId, @PathVariable("topicId") int topicId) {
			ts.topicForLesson(lessonId, topicId);
		}
		
		@GetMapping("/api/lesson/{lessonId}/topics")
		public Iterable<Topic> getAllTopics(@PathVariable("lessonId") int lessonId){
			return ts.getAllTopics(lessonId);
		}
		
		
}
