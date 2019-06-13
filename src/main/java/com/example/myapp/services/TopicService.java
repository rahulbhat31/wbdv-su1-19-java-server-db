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

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.models.repositories.*;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	LessonService lessonService = new LessonService();
	
	

//	@PostMapping("/api/topics")
	public Topic createTopic(@RequestBody Topic topic) {
		return topicRepository.save(topic);
	}

//	@GetMapping("/api/topic")
	public List<Topic> getTopic()
	{
		return (List<Topic>)topicRepository.findAll();
	}

//	@PutMapping("/api/topics")
	public List<Topic> updateTopic()
	{
		return (List<Topic>)topicRepository.findAll();
	}

//	@GetMapping("/api/topics/{topicId}")
	public Optional<Topic> findTopicById(@PathVariable("topicId") int tip) {
		return topicRepository.findById(tip);
	}

//	 @PutMapping(path ="/api/topics/{topicId}", consumes = "application/json", produces = "application/json")
	    public Topic updateTopic(
	            @PathVariable("topicId") int tip,
	            @RequestBody Topic topic) {
	    	return topicRepository.save(topic);
	    }
	      
//	    @DeleteMapping("/api/topics/{topicId}")
	    public void deleteTopic(@PathVariable("topicId") int tip) {
	    	Optional<Topic> temp = topicRepository.findById(tip);
	    	topicRepository.deleteById(tip);    
	    }
	    
//	    @PostMapping("/api/topic/{tid}/widget")
	    public List<Widget> authoredCourse(@PathVariable("tid") int tid, 
	    			@RequestBody Widget widget) {
	    	
	    	Topic topic = topicRepository.findById(tid).orElse(null);
	    	widget.setOrder(topic.getIncludedWidgets().size());
	    	widget.setTopic(topic);
	    	widgetRepository.save(widget);
	    		    	
	    	return topic.getIncludedWidgets();
	    }

//	    @GetMapping("/api/topic/{tid}/widgets")
	    public List<Widget> findAllWidgets(@PathVariable("tid") int tid){
	    Topic topic = topicRepository.findById(tid).orElse(null);
   	 	return topic.getIncludedWidgets();
	    }
	    
	    
	    
//	    @PostMapping("/api/lesson/{lid}/topic")
		public Topic createTopic(@PathVariable("lid") Integer id, @RequestBody Topic topic) {
			if(topic.getTitle().equals("")) {
				topic.setTitle("New Topic");
			}
			Topic t = topicRepository.save(topic);
			Lesson lesson = lessonService.findLessonById(id).get();
			if(lesson!=null) {
				this.topicForLesson(lesson.getId(), topic.getId());
				lessonService.updateLesson(lesson.getId(),lesson);
				return t;
			}
			return null;
			
		}
		
	    
//	    @PutMapping("/api/topic/{topicId}/widget")
		public void widgets(@PathVariable("topicId") int topicId, @RequestBody Widget newWidget) {
			Topic topic = topicRepository.findById(topicId).get();
			newWidget.setTopic(topic);
			
			widgetRepository.save(newWidget);
		}
	    
//	    @PutMapping("/api/topic/{topicId}/all/widgets")
		public List<Widget> widgets(@PathVariable("topicId") int topicId, @RequestBody List<Widget> newWidgets) {
			Topic topic = topicRepository.findById(topicId).get();
			for(Widget w : newWidgets){
				w.setTopic(topic);
			
				widgetRepository.save(w);
				
			}
			
			return newWidgets;
		}		
	
//		@PutMapping("/api/lesson/{lessonId}/topic/{topicId}")
		public void topicForLesson(@PathVariable("lessonId") int lessonId, @PathVariable("topicId") int topicId) {
			Lesson lesson = lessonRepository.findById(lessonId).get();
			Topic topic = topicRepository.findById(topicId).get();
			lesson.includedTopicfun(topic);
			lessonRepository.save(lesson);
			topic.setLesson(lesson);
			topicRepository.save(topic);
		}
		
//		@GetMapping("/api/lesson/{lessonId}/topics")
		public Iterable<Topic> getAllTopics(@PathVariable("lessonId") int lessonId){
			Lesson lesson = lessonRepository.findById(lessonId).get();
			return lesson.getIncludedTopics();
		}
		    
}
