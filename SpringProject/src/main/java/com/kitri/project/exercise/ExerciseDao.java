package com.kitri.project.exercise;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public interface ExerciseDao {
	void insert(Exercise ad);
	
	Exercise select(int num); // �˻���

	void update(Exercise ad);

	void delete(int num);

	ArrayList<Exercise> selectAll();

	Exercise selectAdExercise(int num); // �����˻���

	void deleteAdExercise(int num); // ����

	ArrayList<Exercise> selectExerciseListF(int type);

	ArrayList<Exercise> selectExerciseDate(String date);

	int countExerciseDate(String date);

	ArrayList<Exercise> listAll(HashMap<String, Object> hashMap);

}
