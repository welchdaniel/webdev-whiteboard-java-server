package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WidgetController {
    static WidgetService widgetService = WidgetService.getInstance();

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(@RequestBody Widget widget) {
        return widgetService.createWidget(widget);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
        return widgetService.findWidgetById(wid);
    }

    @PutMapping("/api/widgets/{widgetId}")
    public Widget updateWidget(@PathVariable("widgetId") Integer wid, @RequestBody Widget widget){
        return widgetService.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public void deleteWidget(@PathVariable("widgetId") Integer wid) {
        widgetService.deleteWidget(wid);
    }
}
