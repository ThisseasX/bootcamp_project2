package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Student;
import com.bootcamp.project2.repository.StudentRepository;
import com.bootcamp.project2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void printAllStudents() {

    }

    @Override
    public void printAllAssignmentsPerCoursePerStudent() {
        List<Student> all = studentRepository.findAll();

        all.forEach(x -> {
            System.out.printf("%s %s%n", x.getName(), x.getSurname());
            x.getCourses().forEach(y -> {
                System.out.printf("  %s%n", y.getName());
                y.getAssignments().forEach(z -> System.out.printf("    %s%n", z.getName()));
            });
        });
    }
}
