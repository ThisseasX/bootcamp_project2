package com.bootcamp.project2.runner.impl;

import com.bootcamp.project2.runner.AppRunner;
import com.bootcamp.project2.service.AssignmentService;
import com.bootcamp.project2.service.CourseService;
import com.bootcamp.project2.service.StudentService;
import com.bootcamp.project2.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@AllArgsConstructor
@Component
public class AppRunnerImpl implements AppRunner {

    private StudentService studentService;
    private CourseService courseService;
    private AssignmentService assignmentService;
    private TrainerService trainerService;

    @Override
    public void printAllStudents() {
        studentService.printAllStudents();
    }

    @Override
    public void printAllTrainers() {
        trainerService.printAllTrainers();
    }

    @Override
    public void printAllAssignments() {
        assignmentService.printAllAssignments();
    }

    @Override
    public void printAllCourses() {
        courseService.printAllCourses();
    }

    @Override
    public void printAllStudentsPerCourse() {
        courseService.printAllStudentsPerCourse();
    }

    @Override
    public void printAllTrainersPerCourse() {
        courseService.printAllTrainersPerCourse();
    }

    @Override
    public void printAllAssignmentsPerCourse() {
        courseService.printAllAssignmentsPerCourse();
    }

    @Override
    public void printAllAssignmentsPerCoursePerStudent() {
        studentService.printAllAssignmentsPerCoursePerStudent();
    }

    @Override
    public void printAllStudentsWithMoreThanOneCourse() {
        studentService.printAllStudentsWithMoreThanOneCourse();
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            String action = sc.next();

            switch (action) {
                case "1":
                    printAllStudents();
                    break;
                case "2":
                    printAllTrainers();
                    break;
                case "3":
                    printAllAssignments();
                    break;
                case "4":
                    printAllCourses();
                    break;
                case "5":
                    printAllStudentsPerCourse();
                    break;
                case "6":
                    printAllTrainersPerCourse();
                    break;
                case "7":
                    printAllAssignmentsPerCourse();
                    break;
                case "8":
                    printAllAssignmentsPerCoursePerStudent();
                    break;
                case "9":
                    printAllStudentsWithMoreThanOneCourse();
                    break;
                case "exit":
                    break loop;
            }
        }
    }
}
