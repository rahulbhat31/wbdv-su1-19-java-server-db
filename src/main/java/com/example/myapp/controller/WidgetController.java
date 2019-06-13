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

import com.example.myapp.models.Widget;
import com.example.myapp.services.WidgetService;

@CrossOrigin("*")
@RestController
public class WidgetController {
	
	@Autowired
	WidgetService ws = new WidgetService();
	
	@PostMapping("/api/widgets")
	public Widget createWidget(@RequestBody Widget widget) {
		return ws.createWidget(widget);
	}

	@GetMapping("/api/widget")
	public List<Widget> getWidget()
	{
		return ws.getWidget();
	}

	@PutMapping("/api/widgets")
	public List<Widget> updateWidget()
	{
		return ws.updateWidget();
	}

	@GetMapping("/api/widgets/{widgetId}")
	public Optional<Widget> findWidgetById(@PathVariable("widgetId") int wip) {
		return ws.findWidgetById(wip);
	}

	 @PutMapping(path ="/api/widgets/{widgetId}", consumes = "application/json", produces = "application/json")
	    public Widget updateWidget(
	            @PathVariable("widgetId") long wip,
	            @RequestBody Widget widget) {
	    	return ws.updateWidget(wip, widget);
	    }
	      
	    @DeleteMapping("/api/widgets/{widgetId}")
	    public List<Widget> deleteWidget(@PathVariable("widgetId") int wip) {
	    	return ws.deleteWidget(wip);
	    }
}
