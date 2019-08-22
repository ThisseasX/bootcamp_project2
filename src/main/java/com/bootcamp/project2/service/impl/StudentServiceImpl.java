package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Student;
import com.bootcamp.project2.repository.StudentRepository;
import com.bootcamp.project2.service.StudentService;
import com.bootcamp.project2.utils.input.InputPersister;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public void printAllStudents() {
        studentRepository
                .findAll()
                .forEach(System.out::println);
    }

    @Override
    @Transactional
    public void printAllAssignmentsPerCoursePerStudent() {
        studentRepository
                .findAll()
                .forEach(student -> {
                    System.out.println(student);
                    student.getCourses()
                            .forEach(course -> {
                                System.out.println("  " + course);
                                course.getAssignments()
                                        .forEach(assignment -> System.out.println("    " + assignment));
                            });
                });
    }

    @Override
    public void printAllStudentsWithMoreThanOneCourse() {
        studentRepository
                .findAllStudentsWithMoreThanOneCourse()
                .forEach(System.out::println);
    }

    @Override
    public void createStudent() {
        InputPersister.requestInputAndPersist(
                Student.class,
                studentRepository
        );
    }
}
