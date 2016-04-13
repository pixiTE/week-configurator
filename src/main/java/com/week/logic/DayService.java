package com.week.logic;

import java.util.List;

import com.week.model.entities.Day;

public interface DayService {

    void save(Day day);

    void save(List<Day> days);

    List<Day> findAll();

}
