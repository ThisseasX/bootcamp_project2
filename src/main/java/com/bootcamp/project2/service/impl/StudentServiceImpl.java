package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Course;
import com.bootcamp.project2.entity.Student;
import com.bootcamp.project2.repository.CourseRepository;
import com.bootcamp.project2.repository.StudentRepository;
import com.bootcamp.project2.service.StudentService;
import com.bootcamp.project2.utils.input.InputUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

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
        InputUtils.requestInputAndPersist(
                Student.class,
                studentRepository
        );
    }

    @Override
    @Transactional
    public void addStudentToCourse() {
        Student selectedStudent = InputUtils.requestEntityChoice(
                studentRepository,
                "Please select a student to add to a course:"
        );

        Course selectedCourse = InputUtils.requestEntityChoice(
                courseRepository,
                "Please select a course that the student will attend:"
        );

        int previousSize = selectedStudent.getCourses().size();
        selectedStudent.getCourses().add(selectedCourse);

        if (previousSize == selectedStudent.getCourses().size()) {
            System.out.printf("-- Student: [%s] is already attending: [%s] --%n", selectedStudent, selectedCourse);
        } else {
            studentRepository.save(selectedStudent);
            System.out.printf("-- Student: [%s] was successfully saved with new Course: [%s] --%n", selectedStudent, selectedCourse);
        }
    }
}
