package com.example.demo;
import org.springframework.stereotype.Component;
import org.springframework
        .stereotype
        .Repository;

import com.example.demo.ExerciseList;

@Component
public class ExerciseDatabase {
    private static ExerciseList allExercises = new ExerciseList();

    static {
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
