package com.bootcamp.project2.repository.customized;

import com.bootcamp.project2.entity.Student;

import java.util.List;

public interface StudentRepositoryCustomized {
    List<Student> findAllStudentsWithMoreThanOneCourse();
}
