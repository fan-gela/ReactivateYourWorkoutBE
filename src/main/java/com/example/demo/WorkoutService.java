package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout getWorkout(Long id) {
        return workoutRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Workout not found with id " + id));
    }

    public void deleteWorkout(Long id) {
        Workout workout = workoutRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Workout not found with id " + id));

        workoutRepository.delete(workout);
    }
}
