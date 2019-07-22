package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.repository.CourseRepository;
import com.bootcamp.project2.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void printAllAssignmentsPerCourse() {
        courseRepository
                .findAll()
                .forEach(course -> {
                    System.out.println(course);
                    course.getAssignments()
                            .forEach(assignment -> System.out.println("  " + assignment));
                });
    }
}
