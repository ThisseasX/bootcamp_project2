package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Course;
import com.bootcamp.project2.entity.Trainer;
import com.bootcamp.project2.repository.CourseRepository;
import com.bootcamp.project2.repository.TrainerRepository;
import com.bootcamp.project2.service.TrainerService;
import com.bootcamp.project2.utils.input.InputUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;
    private CourseRepository courseRepository;

    @Override
    public void printAllTrainers() {
        trainerRepository
                .findAll()
                .forEach(System.out::println);
    }

    @Override
    public void createTrainer() {
        InputUtils.requestInputAndPersist(
                Trainer.class,
                trainerRepository
        );
    }

    @Override
    @Transactional
    public void addTrainerToCourse() {
        Trainer selectedTrainer = InputUtils.requestEntityChoice(
                trainerRepository,
                "Please select a trainer to add to a course:"
        );

        Course selectedCourse = InputUtils.requestEntityChoice(
                courseRepository,
                "Please select a course that the trainer will teach:"
        );

        int previousSize = selectedTrainer.getCourses().size();
        selectedTrainer.getCourses().add(selectedCourse);

        if (previousSize == selectedTrainer.getCourses().size()) {
            System.out.printf("-- Trainer: [%s] is already teaching: [%s] --%n", selectedTrainer, selectedCourse);
        } else {
            trainerRepository.save(selectedTrainer);
            System.out.printf("-- Trainer: [%s] was successfully saved with new Course: [%s] --%n", selectedTrainer, selectedCourse);
        }
    }
}
