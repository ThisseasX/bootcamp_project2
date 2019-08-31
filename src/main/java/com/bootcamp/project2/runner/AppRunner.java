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
            new Action("Show all students", () -> studentService.printAllStudents()),
            new Action("Show all trainers", () -> trainerService.printAllTrainers()),
            new Action("Show all assignments", () -> assignmentService.printAllAssignments()),
            new Action("Show all courses", () -> courseService.printAllCourses()),
            new Action("Show all students per course", () -> courseService.printAllStudentsPerCourse()),
            new Action("Show all trainers per course", () -> courseService.printAllTrainersPerCourse()),
            new Action("Show all assignments per course", () -> courseService.printAllAssignmentsPerCourse()),
            new Action("Show all assignments per course per student", () -> studentService.printAllAssignmentsPerCoursePerStudent()),
            new Action("Show all students with more than one course", () -> studentService.printAllStudentsWithMoreThanOneCourse()),
            new Action("Create a new course", () -> courseService.createCourse()),
            new Action("Create a new assignment", () -> assignmentService.createAssignment()),
            new Action("Create a new student", () -> studentService.createStudent()),
            new Action("Create a new trainer", () -> trainerService.createTrainer()),
            new Action("Add a student to a course", () -> studentService.addStudentToCourse()),
            new Action("Add a trainer to a course", () -> trainerService.addTrainerToCourse())
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

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("-- Invalid action --");
            }
        }
    }
}
