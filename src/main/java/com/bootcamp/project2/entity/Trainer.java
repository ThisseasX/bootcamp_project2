package com.bootcamp.project2.entity;

import com.bootcamp.project2.utils.input.interfaces.NamedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Trainer implements NamedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @EqualsAndHashCode.Exclude
    private String name;

    @Column
    @EqualsAndHashCode.Exclude
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "trainer_course",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }
}
