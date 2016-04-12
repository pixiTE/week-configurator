package com.week.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week.model.entities.Day;

public interface DayRepository extends JpaRepository<Day, Long> {

}
