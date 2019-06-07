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
        this.widgets.add(new Widget(123L, "Widget 1", "HEADING",
                1, "Sample Heading", null, 2, null,
                null, null, null, null, null));
        this.widgets.add(new Widget(345L, "Widget 3", "PARAGRAPH",
                2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ac nisl magna. "
                +"Vestibulum laoreet leo ante, quis dapibus odio rutrum nec. Suspendisse rutrum, "
                +"nulla eu lacinia interdum, odio magna fringilla nisi, id convallis magna lectus semper lorem. "
                +"Quisque et ligula nibh. Aenean ullamcorper lacus eu sem fringilla aliquet. "
                +"Ut mattis turpis laoreet, tristique nibh sit amet, gravida metus. "
                +"Etiam dignissim tortor eget efficitur malesuada.", null,
                null, null, null, null, null, null, null));
        this.widgets.add(new Widget(234L, "Widget 2", "LIST", 3,
                "Item 1\nItem 2\nItem 3", null, null, null, null, null,
                "ul", null, null));
        this.widgets.add(new Widget(456L, "Widget 4", "IMAGE",
                4, null, "https://picsum.photos/300/200", null, null,
                null, null, null, null, null));
        this.widgets.add(new Widget(789L, "Widget 5","HYPERLINK", 5,
                "WebDevTV Youtube Channel", "https://www.youtube.com/channel/UCCgliN1n-OaiYJbZV8gypNA",
                null, null, null, null, null, null, null));
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

    public List<Widget> updateWidget(Long wid, Widget widget) {
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
        return widgets;
    }

    public List<Widget> deleteWidget(Long wid) {
        List<Widget> temp = new ArrayList<Widget>();
        for(Widget w: this.widgets) {
            if(!w.getId().equals(wid)) {
                temp.add(w);
            }
        }
        this.widgets = temp;
        return widgets;
    }
}