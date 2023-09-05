package com.example.demo;

public class Exercise {

    private Integer id;
    private String exerciseName;
    private String exerciseInstructions;


    // constructor
    public Exercise(Integer id, String exerciseName, String exerciseInstructions) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.exerciseInstructions = exerciseInstructions;
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseInstructions() {
        return exerciseInstructions;
    }

    public void setExerciseInstructions(String exerciseInstructions) {
        this.exerciseInstructions = exerciseInstructions;
    }

    @Override
    public String toString() {
        return "Exercise [id=" + id + ", exerciseName=" + exerciseName + ", exerciseInstructions=" + exerciseInstructions + "]";
    }
}
