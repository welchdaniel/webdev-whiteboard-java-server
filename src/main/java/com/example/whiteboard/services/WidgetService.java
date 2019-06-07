package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();

    static WidgetService myInstance = null;

    public static WidgetService getInstance() {
        if (myInstance == null){
            myInstance = new WidgetService();
        }
        return myInstance;
    }

    private WidgetService() {
        this.init();
    }

    private void init() {
        this.widgets.add(new Widget(123L, "Widget 1", "HEADING"));
        this.widgets.add(new Widget(234L, "Widget 2", "LIST"));
        this.widgets.add(new Widget(345L, "Widget 3", "PARAGRAPH"));
        this.widgets.add(new Widget(456L, "Widget 4", "IMAGE"));
    }

    public List<Widget> createWidget(Widget widget) {
        this.widgets.add(widget);
        return this.widgets;
    }

    public List<Widget> findAllWidgets() {
        return this.widgets;
    }

    public Widget findWidgetById(Long wid) {
        for(Widget w: this.widgets) {
            if(w.getId().equals(wid)) {
                return w;
            }
        }
        return null;
    }

    public Widget updateWidget(Long wid, Widget widget) {
        List<Widget> temp = new ArrayList<Widget>();
        for(Widget w: this.widgets) {
            if(w.getId().equals(wid)) {
                temp.add(widget);
            }
            else {
                temp.add(w);
            }
        }
        this.widgets = temp;
        return widget;
    }

    public void deleteWidget(Long wid) {
        List<Widget> temp = new ArrayList<Widget>();
        for(Widget w: this.widgets) {
            if(!w.getId().equals(wid)) {
                temp.add(w);
            }
        }
        this.widgets = temp;
    }
}