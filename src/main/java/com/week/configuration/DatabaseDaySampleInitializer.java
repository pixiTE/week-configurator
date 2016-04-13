package com.week.configuration;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.week.model.entities.Day;
import com.week.model.entities.DayType;
import com.week.model.repository.DayRepository;

@Configuration
public class DatabaseDaySampleInitializer {

    @Bean
    CommandLineRunner commandLineRunner(DayRepository dayRepository) {
        return String -> {
            List<Day> days = dayRepository.findAll();
            if (days.isEmpty()) {
                createDays(dayRepository);
            }
        };
    }

    private void createDays(DayRepository dayRepository) {
        Stream.of(DayType.values())
              .map(Day::new)
              .forEach(dayRepository::save);
    }

}
