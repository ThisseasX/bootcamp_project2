package com.bootcamp.project2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private List<Course> courses;
}
