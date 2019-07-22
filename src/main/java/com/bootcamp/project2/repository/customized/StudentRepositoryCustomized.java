package com.bootcamp.project2.repository.customized;

import com.bootcamp.project2.entity.Student;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface StudentRepositoryCustomized {
    List<Student> findAllStudentsWithMoreThanOneCourse();
}
