package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

//@RequestScoped
//implicit

@ApplicationScoped
@Alternative
public class TraineeMapRepository implements TraineeRepository {

	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Trainee> trainieetMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public TraineeMapRepository() {
		this.trainieetMap = new HashMap<Long, Trainee>();
		ID = INITIAL_COUNT;
		initAccountMap();
	}

	
	public String getAllTrainees() {
		return util.getJSONForObject(trainieetMap.values());
	}

	
	public String createTrainee(String trainee) {
		ID++;
		Trainee newAccount = util.getObjectForJSON(trainee, Trainee.class);
		trainieetMap.put(ID, newAccount);
		return trainee;
	}

	
	public String updateTrainee(Long id, String accountToUpdate) {
		Trainee newAccount = util.getObjectForJSON(accountToUpdate, Trainee.class);
		trainieetMap.put(id, newAccount);
		return accountToUpdate;
	}

	
	public String deleteTrainee(Long id) {
		trainieetMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}

	private void initAccountMap() {
		Trainee trainee = new Trainee();
		trainieetMap.put(1L, trainee);
	}

}
