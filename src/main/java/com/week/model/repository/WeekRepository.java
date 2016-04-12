package com.week.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week.model.entities.Week;

public interface WeekRepository extends  JpaRepository<Week, Long> {

}
