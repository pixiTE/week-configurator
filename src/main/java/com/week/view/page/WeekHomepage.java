package com.week.view.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.week.logic.WeekManger;
import com.week.model.entities.Day;
import com.week.model.entities.DayType;

public class WeekHomepage extends WebPage {

    @SpringBean
    private WeekManger weekManger;

    private Form<?> form = null;

    Label monday = null;
    CheckBox mondayVisibility = null;
    TextField<String> mondayColor = null;

    Label tuesday = null;
    CheckBox tuesdayVisibility = null;
    TextField<String> tuesdayColor = null;

    Label wednesday = null;
    CheckBox wednesdayVisibility = null;
    TextField<String> wednesdayColor = null;

    Label thursday = null;
    CheckBox thursdayVisibility = null;
    TextField<String> thursdayColor = null;

    Label friday = null;
    CheckBox fridayVisibility = null;
    TextField<String> fridayColor = null;

    Label saturday = null;
    CheckBox saturdayVisibility = null;
    TextField<String> saturdayColor = null;

    Label sunday = null;
    CheckBox sundayVisibility = null;
    TextField<String> sundayColor = null;

    @Override
    protected void onInitialize() {
        super.onInitialize();
        createPage();

    }

    private void createPage() {
        deleteDays();
        generateDays();
        createForm();
    }

    private void createForm() {

        add(new FeedbackPanel("configuration"));

        form = new Form<Void>("configForm");
        add(form);

        createGuiForEachDay();
        saveOnSubmit();
    }

    private void saveOnSubmit() {

        Button saveButton = new Button("saveButton") {

            @Override
            public void onSubmit() {
                updateInDatabase();
            }

            private void updateInDatabase() {
                for (Day day : weekManger.findAll()) {

                    if (day.getType().equals(DayType.MONDAY)) {
                        updateMonday(day);

                    } else if (day.getType().equals(DayType.TUESDAY)) {
                        updateTuesday(day);

                    } else if (day.getType().equals(DayType.WEDNESDAY)) {
                        updateWednesday(day);

                    } else if (day.getType().equals(DayType.THURSDAY)) {
                        updateThursday(day);

                    } else if (day.getType().equals(DayType.FRIDAY)) {
                        updateFriday(day);

                    } else if (day.getType().equals(DayType.SATURDAY)) {
                        updateSaturday(day);

                    } else if (day.getType().equals(DayType.SUNDAY)) {
                        updateSunday(day);
                    }
                }
            }

            private void updateSunday(Day day) {
                day.setColor(sundayColor.getValue());
                day.setVisible(Boolean.valueOf(sundayVisibility.getValue()));
                weekManger.updateDay(day);
            }

            private void updateSaturday(Day day) {
                day.setColor(saturdayColor.getValue());
                day.setVisible(Boolean.valueOf(saturdayVisibility.getValue()));
                weekManger.updateDay(day);
            }

            private void updateFriday(Day day) {
                day.setColor(fridayColor.getValue());
                day.setVisible(Boolean.valueOf(fridayVisibility.getValue()));
                weekManger.updateDay(day);
            }

            private void updateThursday(Day day) {
                day.setColor(thursdayColor.getValue());
                day.setVisible(Boolean.valueOf(thursdayVisibility.getValue()));
                weekManger.updateDay(day);
            }

            private void updateWednesday(Day day) {
                day.setColor(wednesdayColor.getValue());
                day.setVisible(Boolean.valueOf(wednesdayVisibility.getValue()));
                weekManger.updateDay(day);
            }

            private void updateTuesday(Day day) {
                day.setColor(tuesdayColor.getValue());
                day.setVisible(Boolean.valueOf(tuesdayVisibility.getValue()));
                weekManger.updateDay(day);
            }

            private void updateMonday(Day day) {
                day.setColor(mondayColor.getValue());
                day.setVisible(Boolean.valueOf(mondayVisibility.getValue()));
                weekManger.updateDay(day);
            }
        };

        form.add(saveButton);
    }

    private void createGuiForEachDay() {

        monday();
        tuesday();
        wednesday();
        thursday();
        friday();
        saturday();
        sunday();
    }

    private void sunday() {
        form.add(sunday = new Label("sunday", DayType.SUNDAY));
        form.add(sundayVisibility = new CheckBox("sundayVisibility", Model.of(false)));
        form.add(sundayColor = new TextField("sundayColor", Model.of("")));
        sundayColor.setRequired(true);
    }

    private void saturday() {
        form.add(saturday = new Label("saturday", DayType.SATURDAY));
        form.add(saturdayVisibility = new CheckBox("saturdayVisibility", Model.of(false)));
        form.add(saturdayColor = new TextField("saturdayColor", Model.of("")));
        saturdayColor.setRequired(true);
    }

    private void friday() {
        form.add(friday = new Label("friday", DayType.FRIDAY));
        form.add(fridayVisibility = new CheckBox("fridayVisibility", Model.of(false)));
        form.add(fridayColor = new TextField("fridayColor", Model.of("")));
        fridayColor.setRequired(true);
    }

    private void thursday() {
        form.add(thursday = new Label("thursday", DayType.THURSDAY));
        form.add(thursdayVisibility = new CheckBox("thursdayVisibility", Model.of(false)));
        form.add(thursdayColor = new TextField("thursdayColor", Model.of("")));
        thursdayColor.setRequired(true);
    }

    private void wednesday() {
        form.add(wednesday = new Label("wednesday", DayType.WEDNESDAY));
        form.add(wednesdayVisibility = new CheckBox("wednesdayVisibility", Model.of(false)));
        form.add(wednesdayColor = new TextField("wednesdayColor", Model.of("")));
        wednesdayColor.setRequired(true);
    }

    private void tuesday() {
        form.add(tuesday = new Label("tuesday", DayType.TUESDAY));
        form.add(tuesdayVisibility = new CheckBox("tuesdayVisibility", Model.of(false)));
        form.add(tuesdayColor = new TextField("tuesdayColor", Model.of("")));
        tuesdayColor.setRequired(true);
    }

    private void monday() {
        form.add(monday = new Label("monday", DayType.MONDAY));
        form.add(mondayVisibility = new CheckBox("mondayVisibility", Model.of(false)));
        form.add(mondayColor = new TextField("mondayColor", Model.of("")));
        mondayColor.setRequired(true);
    }

    private void deleteDays() {
        weekManger.deleteAll();

    }

    private void generateDays() {
        weekManger.generateDays();

    }

}
