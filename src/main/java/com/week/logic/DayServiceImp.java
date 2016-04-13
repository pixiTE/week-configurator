package com.week.logic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week.model.entities.Day;
import com.week.model.repository.DayRepository;

@Service
public class DayServiceImp implements DayService {

    @Autowired
    private DayRepository dayRepository;

    @Override
    public List<Day> findAll() {
        return dayRepository.findAll()
                            .stream()
                            .sorted((e1, e2) -> e1.getType()
                                                  .compareTo(e2.getType()))
                            .collect(Collectors.toList());
    }

    @Override
    public void save(Day day) {
        dayRepository.save(day);
    }

    @Override
    public void save(List<Day> days) {
        dayRepository.save(days);
    }

}
