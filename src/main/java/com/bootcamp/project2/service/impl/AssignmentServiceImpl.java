package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Assignment;
import com.bootcamp.project2.entity.Course;
import com.bootcamp.project2.repository.AssignmentRepository;
import com.bootcamp.project2.repository.CourseRepository;
import com.bootcamp.project2.service.AssignmentService;
import com.bootcamp.project2.utils.input.InputUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

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
        Supplier<Course> courseSupplier = () -> InputUtils.requestEntityChoice(
                courseRepository,
                "Please choose the course this assignment belongs to:"
        );

        InputUtils.requestInputAndPersist(
                Assignment.class,
                assignmentRepository,
                assignment -> assignment.setCourse(courseSupplier.get())
        );
    }
}
