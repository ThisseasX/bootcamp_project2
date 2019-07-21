package com.bootcamp.project2.repository;

import com.bootcamp.project2.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
