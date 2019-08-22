package com.bootcamp.project2.entity;

import com.bootcamp.project2.utils.input.interfaces.NamedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course implements NamedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @EqualsAndHashCode.Exclude
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
