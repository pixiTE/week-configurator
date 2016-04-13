package com.week.model.util;

import com.week.model.entities.Day;
import com.week.model.entities.DayType;

public class DaysBuilder {

    private Day day;

    public DaysBuilder() {
        day = new Day();
        day.setColor("");
        day.setVisible(false);
    }

    public DaysBuilder setType(DayType dayType) {
        day.setType(dayType);
        return this;
    }

    public Day build() {
        return day;
    }
}
