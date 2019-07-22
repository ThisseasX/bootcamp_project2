package com.bootcamp.project2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Assignment> assignments;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @ManyToMany(mappedBy = "courses")
    private List<Trainer> trainers;

    @Override
    public String toString() {
        return name;
    }
}
