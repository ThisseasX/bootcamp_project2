package com.bootcamp.project2.runner;

import org.springframework.boot.CommandLineRunner;

public interface AppRunner extends CommandLineRunner {
    void printAllStudents();

    void printAllTrainers();

    void printAllAssignments();

    void printAllCourses();

    void printAllStudentsPerCourse();

    void printAllTrainersPerCourse();

    void printAllAssignmentsPerCourse();

    void printAllAssignmentsPerCoursePerStudent();

    void printAllStudentsWithMoreThanOneCourse();
}
