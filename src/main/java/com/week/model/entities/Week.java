package com.week.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.week.model.generic.JpaEntity;

@Entity
public class Week extends JpaEntity {

	@OneToMany
	private List<Day> days = new ArrayList<Day>();


	
	
}
