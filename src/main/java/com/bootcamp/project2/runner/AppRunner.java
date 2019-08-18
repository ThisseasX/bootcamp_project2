package com.bootcamp.project2.runner;

import com.bootcamp.project2.runner.actions.Action;
import com.bootcamp.project2.service.AssignmentService;
import com.bootcamp.project2.service.CourseService;
import com.bootcamp.project2.service.StudentService;
import com.bootcamp.project2.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Scanner;

@AllArgsConstructor
@Component
public class AppRunner implements CommandLineRunner {

    private StudentService studentService;
    private CourseService courseService;
    private AssignmentService assignmentService;
    private TrainerService trainerService;

    private Map<String, Action> actionMap;

    @PostConstruct
    private void init() {
        actionMap.put("1", new Action("Show all students", this::printAllStudents));
        actionMap.put("2", new Action("Show all trainers", this::printAllTrainers));
        actionMap.put("3", new Action("Show all assignments", this::printAllAssignments));
        actionMap.put("4", new Action("Show all courses", this::printAllCourses));
        actionMap.put("5", new Action("Show all students per course", this::printAllStudentsPerCourse));
        actionMap.put("6", new Action("Show all trainers per course", this::printAllTrainersPerCourse));
        actionMap.put("7", new Action("Show all assignments per course", this::printAllAssignmentsPerCourse));
        actionMap.put("8", new Action("Show all assignments per course per student", this::printAllAssignmentsPerCoursePerStudent));
        actionMap.put("9", new Action("Show all students with more than one course", this::printAllStudentsWithMoreThanOneCourse));
    }

    public void printActions() {
        actionMap.forEach((key, value) -> System.out.printf("%s) %s%n", key, value.getDescription()));
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-- Available actions --");
            printActions();
            System.out.println("-- Please choose an action by typing the desired number --");
            Action action = actionMap.get(sc.next());
            if (action != null) {
                action.run();
                System.out.println("Press any key to continue...");
                sc.nextLine();
                sc.nextLine();
            } else {
                break;
            }
        }
    }

    public void printAllStudents() {
        studentService.printAllStudents();
    }

    public void printAllTrainers() {
        trainerService.printAllTrainers();
    }

    public void printAllAssignments() {
        assignmentService.printAllAssignments();
    }

    public void printAllCourses() {
        courseService.printAllCourses();
    }

    public void printAllStudentsPerCourse() {
        courseService.printAllStudentsPerCourse();
    }

    public void printAllTrainersPerCourse() {
        courseService.printAllTrainersPerCourse();
    }

    public void printAllAssignmentsPerCourse() {
        courseService.printAllAssignmentsPerCourse();
    }

    public void printAllAssignmentsPerCoursePerStudent() {
        studentService.printAllAssignmentsPerCoursePerStudent();
    }

    public void printAllStudentsWithMoreThanOneCourse() {
        studentService.printAllStudentsWithMoreThanOneCourse();
    }
}
