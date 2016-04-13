package com.week.view.page;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.week.logic.DayService;
import com.week.model.entities.Day;

public class WeekHomepage extends WebPage {

    @SpringBean
    private DayService weekService;

    private ListModel<Day> days;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        loadDays();
        addForm();
    }

    private void loadDays() {
        days = new ListModel<>(weekService.findAll());
    }

    private void addForm() {
        Form<?> form = createForm();
        addDayElements(form);
        addSubmitButton(form);
    }

    private Form<?> createForm() {
        add(new FeedbackPanel("feedback"));
        Form<?> form = new Form<>("form");
        add(form);
        return form;
    }

    private void addDayElements(Form<?> form) {
        form.add(new ListView<Day>("day-listview", days) {

            @Override
            protected void populateItem(ListItem<Day> item) {
                addDay(item);
            }

        });
    }

    private void addDay(ListItem<Day> item) {
        IModel<Day> day = item.getModel();
        item.add(new Label("type", new PropertyModel<>(day, "type")));
        item.add(new CheckBox("visible", new PropertyModel<>(day, "visible")));
        item.add(new TextField<String>("color", new PropertyModel<>(day, "color")));
    }

    private void addSubmitButton(Form<?> form) {
        form.add(new Button("submit") {

            @Override
            public void onSubmit() {
                List<Day> updatedDays = days.getObject();
                weekService.save(updatedDays);
            }

        });
    }

}
