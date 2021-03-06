package com.bootcamp.project2.repository;

import com.bootcamp.project2.entity.Student;
import com.bootcamp.project2.repository.customized.StudentRepositoryCustomized;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustomized {
}
