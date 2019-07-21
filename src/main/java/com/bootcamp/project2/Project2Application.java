package com.bootcamp.project2;

import com.bootcamp.project2.entity.Student;
import com.bootcamp.project2.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class Project2Application implements CommandLineRunner {

    private StudentService studentService;

    public Project2Application(StudentService repo) {
        this.studentService = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Project2Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        studentService.printAllAssignmentsPerCoursePerStudent();
    }
}