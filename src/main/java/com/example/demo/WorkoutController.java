package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutController {
    private final WorkoutDao workoutDao;
    private final WorkoutHistory workoutHistory;

    public WorkoutController(WorkoutDao workoutDao, WorkoutHistory workoutHistory) {
        this.workoutDao = workoutDao;
        this.workoutHistory = workoutHistory;
    }

    @PostMapping("/exercises/complete")
    public ResponseEntity<String> completeWorkout(@RequestBody Workout workout) {
        workoutDao.save(workout);
        return ResponseEntity.ok("Workout completed!");
    }

    @GetMapping("/workouthistory")
    public List<Workout> getWorkoutHistory() {
        return workoutHistory.findAll();
    }
}