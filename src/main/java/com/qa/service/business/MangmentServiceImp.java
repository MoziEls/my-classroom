package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.TraineeRepository;

public class MangmentServiceImp implements MangmentService{

	private static final Logger LOGGER = Logger.getLogger(MangmentService.class);

	@Inject
	private MangmentService repo;

	public String getAllTrainees() {
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAllTrainees();
	}

	public String createTrainee(String account) {
		return repo.createTrainee(account);
	}

	public String updateTrainee(Long id, String account) {
		return repo.updateTrainee(id, account);
	}

	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);

	}

	public void setRepo(MangmentService repo) {
		this.repo = repo;
	}

	

	
	}



