package com.petstore.demo.service;

import java.util.List;
import java.util.Optional;

import com.petstore.demo.model.PetStore;

public interface PetStoreService {
	
	public Optional<PetStore> findPetById(long petId);
	
	public PetStore updatePet(PetStore petStore);
	
	public String addPet(PetStore petStore) throws Exception;
	
	public List<PetStore> petStroeList();
	
	public boolean deletePetById(long petId);

}
