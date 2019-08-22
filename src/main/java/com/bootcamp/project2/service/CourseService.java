package com.bootcamp.project2.service;

import com.bootcamp.project2.entity.Course;

public interface CourseService {
    void printAllCourses();

    void printAllStudentsPerCourse();

    void printAllTrainersPerCourse();

    void printAllAssignmentsPerCourse();

    void createCourse();
}
