package com.example.demo;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseByTarget(String target) {
        return exerciseRepository.findAll(target)
            .orElseThrow(() -> new ResourceNotFoundException("Exercise", "target", target));
    }


    @Value("${API_URL}")
    private static String API_URL;

    @Value("${API_KEY}")
    private static String API_KEY;

    @Value("${API_HOST}")
    private static String API_HOST;

    public List<Exercise> fetchWorkouts(String targetMuscle) throws Exception {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        CompletableFuture<Response> future = client.prepare("GET", API_URL + "/exercises/target/" + targetMuscle)
            .setHeader("X-RapidAPI-Key", API_KEY)
            .setHeader("X-RapidAPI-Host", API_HOST)
            .execute()
            .toCompletableFuture();

        List<Exercise> exercises = new ArrayList<>();

        future.thenAccept(response -> {
            if (response.getStatusCode() == 200) {
                JSONArray array = new JSONArray(response.getResponseBody());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String id = object.getString("id");
                    String name = object.getString("name");
                    String target = object.getString("target");
                    String description = object.getString("description");
                    String gifUrl = object.getString("gifUrl");
                    exercises.add(new Exercise(id, name, target, description, gifUrl));
                }
            } else {
                System.out.println("Failed to retrieve exercises: " + response.getResponseBody());
            }
        }).join();

        client.close();

        return exercises;
    }
}
