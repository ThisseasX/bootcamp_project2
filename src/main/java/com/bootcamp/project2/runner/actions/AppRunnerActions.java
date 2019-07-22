package com.bootcamp.project2.runner.actions;

public enum AppRunnerActions {

    PRINT_ALL_STUDENTS("1", "List all students"),
    PRINT_ALL_TRAINERS("2", "List all trainers"),
    PRINT_ALL_ASSIGNMENTS("3", "List all assignments"),
    PRINT_ALL_COURSES("4", "List all courses"),
    PRINT_ALL_STUDENTS_PER_COURSE("5", "List all students per course"),
    PRINT_ALL_TRAINERS_PER_COURSE("6", "List all trainers per course"),
    PRINT_ALL_ASSIGNMENTS_PER_COURSE("7", "List all assignments per course"),
    PRINT_ALL_ASSIGNMENTS_PER_COURSE_PER_STUDENT("8", "List all assignments per course per student"),
    PRINT_ALL_STUDENTS_WITH_MORE_THAN_ONE_COURSE("9", "List all students with more than one course");

    private String key;
    private String description;

    AppRunnerActions(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String key() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
