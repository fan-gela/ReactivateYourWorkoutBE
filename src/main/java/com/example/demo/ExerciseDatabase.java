package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ExerciseDatabase {
    private ExerciseList allExercises;

    @PostConstruct
    public void init() {
        allExercises = new ExerciseList();

        allExercises.getExerciseList().add(
                new Exercise(
                        1,
                        "Russian Twist",
                        "The Russian twist is an exercise that works the obliques and core by twisting your torso from side to side while holding a weight in your hands."
                )
        );
        allExercises.getExerciseList().add(
                new Exercise(
                        2,
                        "Russian Twist",
                        "The Russian twist is an exercise that works the obliques and core by twisting your torso from side to side while holding a weight in your hands."
                )
        );
        allExercises.getExerciseList().add(
                new Exercise(
                        3,
                        "Russian Twist",
                        "The Russian twist is an exercise that works the obliques and core by twisting your torso from side to side while holding a weight in your hands."
                )
        );
    }

    public ExerciseList getAllExercises() {
        return allExercises;
    }

    public void addExercise(Exercise exercise) {
        allExercises.getExerciseList().add(exercise);
    }
}
