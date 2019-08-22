package com.bootcamp.project2.entity;

import com.bootcamp.project2.utils.input.interfaces.NamedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class Assignment implements NamedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @EqualsAndHashCode.Exclude
    private String name;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Course course;

    @Override
    public String toString() {
        return name;
    }
}
