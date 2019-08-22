package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Course;
import com.bootcamp.project2.repository.CourseRepository;
import com.bootcamp.project2.service.CourseService;
import com.bootcamp.project2.utils.input.InputUtils;
import com.bootcamp.project2.utils.iteration.IndexedList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Override
    public void printAllCourses() {
        courseRepository
                .findAll()
                .forEach(System.out::println);
    }

    @Override
    @Transactional
    public void printAllStudentsPerCourse() {
        courseRepository
                .findAll()
                .forEach(course -> {
                    System.out.println(course);
                    course.getStudents()
                            .forEach(student -> System.out.println("  " + student));
                });
    }

    @Override
    @Transactional
    public void printAllTrainersPerCourse() {
        courseRepository
                .findAll()
                .forEach(course -> {
                    System.out.println(course);
                    course.getTrainers()
                            .forEach(trainer -> System.out.println("  " + trainer));
                });
    }

    @Override
    @Transactional
    public void printAllAssignmentsPerCourse() {
        courseRepository
                .findAll()
                .forEach(course -> {
                    System.out.println(course);
                    course.getAssignments()
                            .forEach(assignment -> System.out.println("  " + assignment));
                });
    }

    @Override
    public void createCourse() {
        InputUtils.requestInputAndPersist(
                Course.class,
                courseRepository
        );
    }
}
