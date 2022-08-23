package com.visualnuts.vnjavaexercise;

import com.visualnuts.vnjavaexercise.exercises.one.ExerciseOne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VnJavaExerciseApplication {

	ExerciseOne exerciseOne = new ExerciseOne();

	public static void main(String[] args) {
		SpringApplication.run(VnJavaExerciseApplication.class, args);
	}

}
