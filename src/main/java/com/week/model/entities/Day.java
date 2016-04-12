package com.week.model.entities;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.week.model.generic.JpaEntity;

@Entity
public class Day extends JpaEntity {

	@Enumerated(EnumType.STRING)
	private DayType type; 
	
	private boolean visible;
	
	private String color;

	public DayType getType() {
		return type;
	}

	public void setType(DayType type) {
		this.type = type;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Day [type=" + type + ", visible=" + visible + ", color=" + color + "]";
	}
	
	
	
	
}
