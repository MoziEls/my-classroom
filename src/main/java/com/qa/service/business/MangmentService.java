package com.qa.service.business;

public interface MangmentService {
	String getAllTrainees();

	String createTrainee(String accout);

	String updateTrainee(Long id, String accountToUpdate);

	String deleteTrainee(Long id);

}



