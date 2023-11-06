package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.WorkoutDao"})
public class ExercisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercisesApplication.class, args);
	}

}
