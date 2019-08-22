package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Assignment;
import com.bootcamp.project2.entity.Course;
import com.bootcamp.project2.repository.AssignmentRepository;
import com.bootcamp.project2.repository.CourseRepository;
import com.bootcamp.project2.service.AssignmentService;
import com.bootcamp.project2.utils.input.InputPersister;
import com.bootcamp.project2.utils.iteration.IndexedList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@AllArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;
    private CourseRepository courseRepository;

    @Override
    public void printAllAssignments() {
        assignmentRepository
                .findAll()
                .forEach(System.out::println);
    }

    @Override
    public void createAssignment() {
        InputPersister.requestInputAndPersist(
                Assignment.class,
                assignmentRepository,
                assignment -> assignment.setCourse(requestCourse())
        );
    }

    private Course requestCourse() {
        IndexedList<Course> availableCourses = new IndexedList<>(courseRepository.findAll());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose the course this assignment belongs to:");
            availableCourses.forEach(entry -> System.out.printf("%s) %s%n", entry.getIndex() + 1, entry.getValue().getName()));

            try {
                return availableCourses.getList().get(Integer.parseInt(sc.next()) - 1);
            } catch (Exception e) {
                System.out.println("-- Invalid number, please type the number of the desired Course --");
            }
        }
    }
}
