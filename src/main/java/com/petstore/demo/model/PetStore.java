package com.petstore.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PetStore {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long petId;
	
	private String petName;
	
	private String category;
	
	private String status;

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PetStore [petId=" + petId + ", petName=" + petName + ", category=" + category + ", status=" + status
				+ "]";
	}

	

}
