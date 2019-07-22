package com.bootcamp.project2.runner;

import com.bootcamp.project2.service.AssignmentService;
import com.bootcamp.project2.service.CourseService;
import com.bootcamp.project2.service.StudentService;
import com.bootcamp.project2.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@AllArgsConstructor
@Component
public class AppRunner implements CommandLineRunner {

    private StudentService studentService;
    private CourseService courseService;
    private AssignmentService assignmentService;
    private TrainerService trainerService;

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            String action = sc.next();

            switch (action) {
                case "1":
                    studentService.printAllStudents();
                    break;
                case "2":
                    trainerService.printAllTrainers();
                    break;
                case "3":
                    assignmentService.printAllAssignments();
                    break;
                case "4":
                    courseService.printAllCourses();
                    break;
                case "5":
                    courseService.printAllStudentsPerCourse();
                    break;
                case "6":
                    courseService.printAllTrainersPerCourse();
                    break;
                case "7":
                    courseService.printAllAssignmentsPerCourse();
                    break;
                case "8":
                    studentService.printAllAssignmentsPerCoursePerStudent();
                    break;
                case "9":
                    studentService.printAllStudentsWithMoreThanOneCourse();
                    break;
                case "exit":
                    break loop;
            }
        }
    }
}
