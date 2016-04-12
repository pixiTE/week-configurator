package com.week.logic;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week.model.entities.Day;
import com.week.model.entities.DayType;
import com.week.model.repository.DayRepository;
import com.week.model.util.Days;

@Service
public class WeekManagerImp implements WeekManger {

    @Autowired
    private DayRepository dayRepository;

    @Override
    @PostConstruct
    public void generateDays() {
        Stream.of(DayType.values()).map(this::createDays).forEach(dayRepository::save);
    }

    private Day createDays(DayType dayType) {
        switch (dayType) {
        case MONDAY:
            return monday();
        case TUESDAY:
            return tuesday();
        case WEDNESDAY:
            return wednesday();
        case THURSDAY:
            return thursday();
        case FRIDAY:
            return friday();
        case SATURDAY:
            return saturday();
        case SUNDAY:
            return sunday();
        default:
            throw new IllegalStateException("Unknown Day: " + dayType);

        }
    }

    private Day sunday() {
        return Days.builder().setType(DayType.SUNDAY).build();
    }

    private Day saturday() {
        return Days.builder().setType(DayType.SATURDAY).build();
    }

    private Day friday() {
        return Days.builder().setType(DayType.FRIDAY).build();
    }

    private Day thursday() {
        return Days.builder().setType(DayType.THURSDAY).build();
    }

    private Day wednesday() {
        return Days.builder().setType(DayType.WEDNESDAY).build();

    }

    private Day tuesday() {
        return Days.builder().setType(DayType.TUESDAY).build();

    }

    private Day monday() {
        return Days.builder().setType(DayType.MONDAY).build();

    }

    @Override
    public List<Day> findAll() {
        return dayRepository.findAll();
    }

    @Override
    public void deleteAll() {
        dayRepository.deleteAll();
    }

    @Override
    public void updateDay(Day day) {
        dayRepository.save(day);
    }

}
