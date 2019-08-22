package com.bootcamp.project2.runner;

import com.bootcamp.project2.runner.actions.Action;
import com.bootcamp.project2.service.AssignmentService;
import com.bootcamp.project2.service.CourseService;
import com.bootcamp.project2.service.StudentService;
import com.bootcamp.project2.service.TrainerService;
import com.bootcamp.project2.utils.iteration.IndexedList;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@AllArgsConstructor
@Component
public class AppRunner implements CommandLineRunner {

    private StudentService studentService;
    private CourseService courseService;
    private AssignmentService assignmentService;
    private TrainerService trainerService;

    private final IndexedList<Action> actionList = new IndexedList<>(Arrays.asList(
            new Action("Show all students", this::printAllStudents),
            new Action("Show all trainers", this::printAllTrainers),
            new Action("Show all assignments", this::printAllAssignments),
            new Action("Show all courses", this::printAllCourses),
            new Action("Show all students per course", this::printAllStudentsPerCourse),
            new Action("Show all trainers per course", this::printAllTrainersPerCourse),
            new Action("Show all assignments per course", this::printAllAssignmentsPerCourse),
            new Action("Show all assignments per course per student", this::printAllAssignmentsPerCoursePerStudent),
            new Action("Show all students with more than one course", this::printAllStudentsWithMoreThanOneCourse),
            new Action("Create a new Assignment", this::createAssignment),
            new Action("Create a new Course", this::createCourse),
            new Action("Create a new Student", this::createStudent),
            new Action("Create a new Trainer", this::createTrainer)
    ));

    private void printIntro() {
        System.out.println("-- Available actions --");
        printActions();
        System.out.println("-- Please choose an action by typing the desired number --");
        System.out.println("-- or type 'exit' to stop --");
    }

    private void printActions() {
        actionList.forEach(entry -> System.out.printf("%s) %s%n",
                entry.getIndex() + 1, entry.getValue().getDescription()));
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printIntro();

            String input = sc.next();
            if (input.equals("exit")) {
                System.out.println("Goodbye!");
                return;
            }

            try {
                actionList
                        .getList()
                        .get(Integer.parseInt(input) - 1)
                        .run();

                System.out.println("Press any key to continue...");

                sc.nextLine();
                sc.nextLine();

            } catch (Exception e) {
                System.out.println("-- Invalid action --");
            }
        }
    }

    private void printAllStudents() {
        studentService.printAllStudents();
    }

    private void printAllTrainers() {
        trainerService.printAllTrainers();
    }

    private void printAllAssignments() {
        assignmentService.printAllAssignments();
    }

    private void printAllCourses() {
        courseService.printAllCourses();
    }

    private void printAllStudentsPerCourse() {
        courseService.printAllStudentsPerCourse();
    }

    private void printAllTrainersPerCourse() {
        courseService.printAllTrainersPerCourse();
    }

    private void printAllAssignmentsPerCourse() {
        courseService.printAllAssignmentsPerCourse();
    }

    private void printAllAssignmentsPerCoursePerStudent() {
        studentService.printAllAssignmentsPerCoursePerStudent();
    }

    private void printAllStudentsWithMoreThanOneCourse() {
        studentService.printAllStudentsWithMoreThanOneCourse();
    }

    private void createAssignment() {
        assignmentService.createAssignment();
    }

    private void createCourse() {
        courseService.createCourse();
    }

    private void createStudent() {
        studentService.createStudent();
    }

    private void createTrainer() {
        trainerService.createTrainer();
    }
}
