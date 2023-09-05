package com.example.demo;

import java.net.URI;
import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind
        .annotation.GetMapping;
import org.springframework.web.bind
        .annotation.PostMapping;
import org.springframework.web.bind
        .annotation.RequestBody;
import org.springframework.web.bind
        .annotation.RequestMapping;
import org.springframework.web.bind
        .annotation.RestController;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;

import com.example.demo.ExerciseList;
import com.example.demo.ExerciseDatabase;
import com.example.demo.Exercise;

@RestController
@RequestMapping(path = "/exerciseList")

public class ExerciseController {
//    @Autowired
    private ExerciseDatabase exerciseDatabase;

    @GetMapping(
            path = "/",
            produces = "application/json")

    public ExerciseList getExerciseList() {
        return exerciseDatabase.getAllExercises();
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json"
    )

    public ResponseEntity<Object> addExercise(@RequestBody Exercise exercise) {
        Integer id = exerciseDatabase.getAllExercises().getExerciseList().size() + 1;

        exercise.setId(id);

        exerciseDatabase.addExercise(exercise);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(exercise.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
