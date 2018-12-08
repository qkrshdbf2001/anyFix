package com.kitri.project.adExercise;

import java.sql.Date;
import java.util.ArrayList;

public interface AdExerciseDao {
	void insert(AdExercise ad);
	
	AdExercise select(int num); // �˻���

	void update(AdExercise ad);

	void delete(int num);

	ArrayList<AdExercise> selectAll();

	AdExercise selectAdExercise(int num); // �����˻���

	void deleteAdExercise(int num); // ����

}
