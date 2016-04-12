package com.week.model.generic;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class JpaEntity implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}
