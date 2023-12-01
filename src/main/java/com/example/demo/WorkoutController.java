package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts-history")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.saveWorkout(workout);
    }

    @GetMapping("{id}")
    public Workout getWorkout(@PathVariable Long id) {
        return workoutService.getWorkout(id);
    }

    @DeleteMapping("{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }
}
