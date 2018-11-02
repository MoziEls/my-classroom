package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Trainee> accounts = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	
	@Transactional(REQUIRED)
	public String createTrainee(String accout) {
		Trainee anAccount = util.getObjectForJSON(accout, Trainee.class);
		manager.persist(anAccount);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String accountToUpdate) {
		Trainee updatedAccount = util.getObjectForJSON(accountToUpdate, Trainee.class);
		Trainee accountFromDB = findTrainee(id);
		if (accountToUpdate != null) {
			accountFromDB = updatedAccount;
			manager.merge(accountFromDB);
		}
		return "{\"message\": \"trainee sucessfully updated\"}";
	}

	
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee accountInDB = findTrainee(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}

	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
