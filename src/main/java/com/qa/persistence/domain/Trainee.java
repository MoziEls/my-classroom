package com.qa.persistence.domain;

	import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

	@Entity
	public class Trainee {

		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		private Long traineeID;
		@ManyToOne
		@JoinColumn(name="trainerID")
		private Long trainerID;
		@Column(length=25)
		private String traineeFirstName;
		@Column(length=25)
		private String traineeLastName;
	
	


	public Trainee(){
		
		
		
		
	}




	public Long getTraineeID() {
		return traineeID;
	}




	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}




	public String getTraineeFirstName() {
		return traineeFirstName;
	}




	public void setTraineeFirstName(String traineeFirstName) {
		this.traineeFirstName = traineeFirstName;
	}




	public String getTraineeLastName() {
		return traineeLastName;
	}




	public void setTraineeLastName(String traineeLastName) {
		this.traineeLastName = traineeLastName;
	}



	}