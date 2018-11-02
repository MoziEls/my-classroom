package com.qa.persistence.repository;

public interface TraineeRepository {
	String getAllTrainees();

	String createTrainee(String accout);

	String updateTrainee(Long id, String accountToUpdate);

	String deleteTrainee(Long id);

}

