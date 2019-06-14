package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

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