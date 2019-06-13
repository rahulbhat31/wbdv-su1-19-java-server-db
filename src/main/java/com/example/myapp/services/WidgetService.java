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

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.models.repositories.WidgetRepository;


@Service
public class WidgetService {

	@Autowired
	WidgetRepository widgetRepository;

//	@PostMapping("/api/widgets")
	public Widget createWidget(@RequestBody Widget widget) {
		return widgetRepository.save(widget);
	}

//	@GetMapping("/api/widget")
	public List<Widget> getWidget()
	{
		return (List<Widget>)widgetRepository.findAll();
	}

//	@PutMapping("/api/widgets")
	public List<Widget> updateWidget()
	{
		return (List<Widget>)widgetRepository.findAll();
	}

//	@GetMapping("/api/widgets/{widgetId}")
	public Optional<Widget> findWidgetById(@PathVariable("widgetId") int wip) {
		return widgetRepository.findById(wip);
	}

//	 @PutMapping(path ="/api/widgets/{widgetId}", consumes = "application/json", produces = "application/json")
	    public Widget updateWidget(
	            @PathVariable("widgetId") long wip,
	            @RequestBody Widget widget) {
	    	return widgetRepository.save(widget);
	    }
	      
//	    @DeleteMapping("/api/widgets/{widgetId}")
	    public List<Widget> deleteWidget(@PathVariable("widgetId") int wip) {
	    	Widget temp = widgetRepository.findById(wip).get();
	    	widgetRepository.deleteById(wip);  
	    	Topic w_t = temp.getTopic();
	    	return w_t.getIncludedWidgets();
	    }
}
