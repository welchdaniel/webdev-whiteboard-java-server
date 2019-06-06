package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetService {
    static List<Widget> widgets = new ArrayList<Widget>();
    static {
        widgets.add(new Widget(123, "Widget 1", "HEADING"));
        widgets.add(new Widget(234, "Widget 2", "LIST"));
        widgets.add(new Widget(345, "Widget 3", "PARAGRAPH"));
        widgets.add(new Widget(456, "Widget 4", "IMAGE"));
    }

    List<Widget> createWidget(Widget widget) {
        widgets.add(widget);
        return widgets;
    }

    List<Widget> findAllWidgets() {
        return widgets;
    }

    Widget findWidgetById(Integer wid) {
        for(Widget w: widgets) {
            if(w.getId().equals(wid)) {
                return w;
            }
        }
        return null;
    }

    Widget updateWidget(Integer wid, Widget widget) {
        List<Widget> temp = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getId().equals(wid)) {
                temp.add(widget);
            }
            else {
                temp.add(w);
            }
        }
        widgets = temp;
        return widget;
    }

    void deleteWidget(Integer wid) {
        List<Widget> temp = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(!w.getId().equals(wid)) {
                temp.add(w);
            }
        }
        widgets = temp;
    }
}