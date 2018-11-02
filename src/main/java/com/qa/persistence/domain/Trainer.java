package com.qa.persistence.domain;

	import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



import antlr.collections.List;

	@Entity
	public class Trainer {

		private Long classroomId;
	
		@Id
		private Long trainerID;
		@Column(length=25)
        private String trainerFirstName;
		@Column(length=25)
		private String trainerLastName;
		@OneToMany(cascade = CascadeType.ALL) 
		@JoinColumn(name="trainerID")
		
		private ArrayList trainees = new ArrayList();


	public Trainer(){
		
		
		
		
	}


	public Long getClassroomId() {
		return classroomId;
	}


	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}


	public Long getTrainerID() {
		return trainerID;
	}


	public void setTrainerID(Long trainerID) {
		this.trainerID = trainerID;
	}


	public String getTrainerFirstName() {
		return trainerFirstName;
	}


	public void setTrainerFirstName(String trainerFirstName) {
		this.trainerFirstName = trainerFirstName;
	}


	public String getTrainerLastName() {
		return trainerLastName;
	}


	public void setTrainerLastName(String trainerLastName) {
		this.trainerLastName = trainerLastName;
	}



	}