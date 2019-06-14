package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ImageWidgetController {

    @Autowired
    WidgetService service;


    @PostMapping("/api/image/widget")
    public List<Widget> createWidget(@RequestBody Widget widget) {
        return service.createWidget(widget);
    }

    @GetMapping("/api/image/widget")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/image/widget/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
        return service.findWidgetById(wid);
    }

    @PutMapping("/api/image/widget/{widgetId}")
    public List<Widget> updateWidget(@PathVariable("widgetId") Integer wid, @RequestBody Widget widget){
        return service.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/image/widget/{widgetId}")
    public List<Widget> deleteWidget(@PathVariable("widgetId") Integer wid) {
        return service.deleteWidget(wid);
    }
}
