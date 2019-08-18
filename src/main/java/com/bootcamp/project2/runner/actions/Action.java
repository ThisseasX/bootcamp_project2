package com.bootcamp.project2.runner.actions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Action {

    private String description;
    private Runnable action;

    public void run() {
        System.out.printf("-- %s --%n", description);
        action.run();
    }
}
