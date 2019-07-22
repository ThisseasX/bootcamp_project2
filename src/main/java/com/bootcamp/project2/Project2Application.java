package com.bootcamp.project2;

import com.bootcamp.project2.runner.impl.AppRunnerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Project2Application {

    public static void main(String[] args) {
        SpringApplication.run(AppRunnerImpl.class, args);
    }
}