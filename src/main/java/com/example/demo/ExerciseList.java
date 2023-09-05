package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ExerciseList {
    private List<Exercise> exerciseList;

    public List<Exercise> getExerciseList () {
        if (exerciseList == null) {
            exerciseList = new ArrayList<>();
        }
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }
}
