package com.week.logic;

import java.util.List;

import com.week.model.entities.Day;

public interface WeekManger {

    void generateDays();

    void deleteAll();

    void updateDay(Day day);

    List<Day> findAll();

}
