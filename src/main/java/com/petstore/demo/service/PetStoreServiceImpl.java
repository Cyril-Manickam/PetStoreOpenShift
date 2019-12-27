package com.petstore.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.petstore.demo.exception.PetStoreException;
import com.petstore.demo.model.PetStore;
import com.petstore.demo.repository.PetStoreRepository;

@Service
public class PetStoreServiceImpl implements PetStoreService {
	
	@Autowired
	PetStoreRepository petStoreRepository;

	@CacheEvict(value="ten-second-cache",key="'pet'+#petId", condition = "#petId == 35")
	@Cacheable(value="ten-second-cache",key="'pet'+#petId", condition = "#petId <= 65 && #petId > 1")
	@Override
	public Optional<PetStore> findPetById(long petId) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Optional<PetStore> pet = petStoreRepository.findById(petId);
		return pet;
	}

	@Override
	public String addPet(PetStore petStore) throws Exception {
		if(null != petStore.getStatus() && !petStore.getStatus().equalsIgnoreCase("Available")) {
			throw new PetStoreException("Status Should be AVAILABLE");
		}
		petStoreRepository.save(petStore);
		return "Record Inserted";
	}

	@Override
	public List<PetStore> petStroeList() {
		List<PetStore> petStoreList = new ArrayList<>();
		petStoreList = petStoreRepository.findAll();
		return petStoreList;
	}

	@Override
	public PetStore updatePet(PetStore petStore) {
		Optional<PetStore> pet = petStoreRepository.findById(petStore.getPetId());
		PetStore modifiedPet = null;
		if(pet.isPresent()) {
			modifiedPet = pet.get();
			if(null != petStore.getCategory()) {
				modifiedPet.setCategory(petStore.getCategory());
			}
			
			if(null != petStore.getPetName()) {
				modifiedPet.setPetName(petStore.getPetName());
			}
			
			if(null != petStore.getStatus()) {
				modifiedPet.setStatus(petStore.getStatus());
			}
			
			petStoreRepository.save(modifiedPet);
		}
		return modifiedPet;
	}

	@Override
	public boolean deletePetById(long petId) {
		Optional<PetStore> pet = petStoreRepository.findById(petId);
		boolean petDeleted = false;
		if(pet.isPresent()) {
			petStoreRepository.deleteById(pet.get().getPetId());
			petDeleted = true;
		} else {
			try {
				throw new Exception("No employee record exist for given id");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return petDeleted;
	}

}
