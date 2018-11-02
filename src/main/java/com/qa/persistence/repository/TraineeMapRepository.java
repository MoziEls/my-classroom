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
	private Map<Long, Trainee> accountMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public TraineeMapRepository() {
		this.accountMap = new HashMap<Long, Trainee>();
		ID = INITIAL_COUNT;
		initAccountMap();
	}

	
	public String getAllTrainees() {
		return util.getJSONForObject(accountMap.values());
	}

	
	public String createTrainee(String account) {
		ID++;
		Trainee newAccount = util.getObjectForJSON(account, Trainee.class);
		accountMap.put(ID, newAccount);
		return account;
	}

	
	public String updateTrainee(Long id, String accountToUpdate) {
		Trainee newAccount = util.getObjectForJSON(accountToUpdate, Trainee.class);
		accountMap.put(id, newAccount);
		return accountToUpdate;
	}

	
	public String deleteTrainee(Long id) {
		accountMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}

	private void initAccountMap() {
		Trainee account = new Trainee();
		accountMap.put(1L, account);
	}

}
