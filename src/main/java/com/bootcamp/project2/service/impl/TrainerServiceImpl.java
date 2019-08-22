package com.bootcamp.project2.service.impl;

import com.bootcamp.project2.entity.Trainer;
import com.bootcamp.project2.repository.TrainerRepository;
import com.bootcamp.project2.service.TrainerService;
import com.bootcamp.project2.utils.input.InputPersister;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;

    @Override
    public void printAllTrainers() {
        trainerRepository
                .findAll()
                .forEach(System.out::println);
    }

    @Override
    public void createTrainer() {
        InputPersister.requestInputAndPersist(
                Trainer.class,
                trainerRepository
        );
    }
}
