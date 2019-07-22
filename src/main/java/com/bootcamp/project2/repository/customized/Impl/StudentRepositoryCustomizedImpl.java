package com.bootcamp.project2.repository.customized.Impl;


import com.bootcamp.project2.entity.Student;
import com.bootcamp.project2.repository.customized.StudentRepositoryCustomized;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepositoryCustomizedImpl implements StudentRepositoryCustomized {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Student> findAllStudentsWithMoreThanOneCourse() {
        return em.createQuery("" +
                "SELECT s " +
                "FROM Student s " +
                "GROUP BY s " +
                "HAVING s.courses.size > 1", Student.class)
                .getResultList();
    }
}
