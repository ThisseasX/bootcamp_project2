package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.repository.AssignmentRepository;
import com.bootcamp.project2.service.AssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;

    @Override
    public void printAllAssignments() {
        assignmentRepository
                .findAll()
                .forEach(System.out::println);
    }
}
