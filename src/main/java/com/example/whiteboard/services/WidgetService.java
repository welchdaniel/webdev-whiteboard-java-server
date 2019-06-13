package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();

    @Autowired
    WidgetRepository repository;

    private void init() {
        Widget headingWidget1 = new Widget(123, "Widget 1", "HEADING",
                1, "Sample Heading", null, 2, null,
                null, null, null, null, null);

        Widget paragraphWidget1 = new Widget(345, "Widget 3", "PARAGRAPH",
                2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ac nisl magna. "
                +"Vestibulum laoreet leo ante, quis dapibus odio rutrum nec. Suspendisse rutrum, "
                +"nulla eu lacinia interdum, odio magna fringilla nisi, id convallis magna lectus semper lorem. "
                +"Quisque et ligula nibh. Aenean ullamcorper lacus eu sem fringilla aliquet. "
                +"Ut mattis turpis laoreet, tristique nibh sit amet, gravida metus. "
                +"Etiam dignissim tortor eget efficitur malesuada.", null,
                null, null, null, null, null, null, null);

        Widget listWidget1 = new Widget(234, "Widget 2", "LIST", 3,
                "Item 1\nItem 2\nItem 3", null, null, null, null, null,
                "ul", null, null);

        Widget imageWidget1 = new Widget(456, "Widget 4", "IMAGE",
                4, null, "https://picsum.photos/300/200", null, null,
                null, null, null, null, null);

        Widget hyperlinkWidget1 = new Widget(789, "Widget 5","HYPERLINK", 5,
                "WebDevTV Youtube Channel", "https://www.youtube.com/channel/UCCgliN1n-OaiYJbZV8gypNA",
                null, null, null, null, null, null, null);

        this.createWidget(headingWidget1);
        this.createWidget(paragraphWidget1);
        this.createWidget(listWidget1);
        this.createWidget(imageWidget1);
        this.createWidget(hyperlinkWidget1);

    }

    public List<Widget> createWidget(Widget widget) {
        repository.save(widget);
        return repository.findAllWidgets();
    }

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }

    public Widget findWidgetById(Integer wid) {
        return repository.findWidgetById(wid);
    }

    public List<Widget> updateWidget(Integer wid, Widget widget) {
        Optional<Widget> optional = repository.findById(wid);
        Widget updateWidget = optional.get();
        updateWidget.setName(widget.getName());
        updateWidget.setType(widget.getType());
        updateWidget.setOrder(widget.getOrder());
        updateWidget.setText(widget.getText());
        updateWidget.setSrc(widget.getSrc());
        updateWidget.setSize(widget.getSize());
        updateWidget.setWidth(widget.getWidth());
        updateWidget.setHeight(widget.getHeight());
        updateWidget.setCssClass(widget.getCssClass());
        updateWidget.setStyle(widget.getStyle());
        updateWidget.setValue(widget.getValue());
        updateWidget.setDataType(widget.getDataType());
        repository.save(updateWidget);
        return repository.findAllWidgets();
    }

    public List<Widget> deleteWidget(Integer wid) {
        repository.deleteById(wid);
        return repository.findAllWidgets();
    }
}