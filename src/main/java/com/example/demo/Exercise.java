package com.example.demo;

public class Exercise {
    public Exercise() {}

    public Exercise(
            Integer id, String exerciseName,String exerciseInstructions)
    {
        super();
        this.id = id;
        this.exerciseName = exerciseName;
        this.exerciseInstructions = exerciseInstructions;
    }

    private Integer id;
    private String exerciseName;
    private String exerciseInstructions;

//    @Override
    public String toString()
    {
        return "Exercise [id=" + id + " , exerciseName=" + exerciseName + " , exerciseInstructions=" + exerciseInstructions + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
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



}
