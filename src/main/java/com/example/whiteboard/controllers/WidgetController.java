package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {
    private WidgetService widgetService = WidgetService.getInstance();

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(@RequestBody Widget widget) {
        return this.widgetService.createWidget(widget);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return this.widgetService.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Long wid) {
        return this.widgetService.findWidgetById(wid);
    }

    @PutMapping("/api/widgets/{widgetId}")
    public Widget updateWidget(@PathVariable("widgetId") Long wid, @RequestBody Widget widget){
        return this.widgetService.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public void deleteWidget(@PathVariable("widgetId") Long wid) {
        this.widgetService.deleteWidget(wid);
    }
}
