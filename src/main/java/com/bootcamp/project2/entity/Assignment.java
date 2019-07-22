package com.bootcamp.project2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    private Course course;

    @Override
    public String toString() {
        return name;
    }
}
