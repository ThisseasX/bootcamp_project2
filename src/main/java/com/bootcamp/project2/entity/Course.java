package com.bootcamp.project2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "course")
    private Set<Assignment> assignments;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @ManyToMany(mappedBy = "courses")
    private Set<Trainer> trainers;

    @Override
    public String toString() {
        return name;
    }
}
