package com.petstore.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petstore.demo.model.PetStore;
import com.petstore.demo.service.PetStoreService;


@RestController
@RequestMapping("/petstore")

public class PetStoreController {
	
	@Autowired
	PetStoreService petStoreService;

	@RequestMapping(value = "/pet/{petId}", method = RequestMethod.GET)
	public Optional<PetStore> findPet(@PathVariable(required = true) long petId) {
		Optional<PetStore> petStore = petStoreService.findPetById(petId);
		return petStore;
	}
	
	@RequestMapping(value = "/pet", method = RequestMethod.POST)
	public String addPet(@RequestBody(required = true) PetStore petStore) throws Exception {
		String successMesssage = petStoreService.addPet(petStore);
		return successMesssage;
	}
	
	@RequestMapping(value = "/pet", method = RequestMethod.PUT)
	public PetStore updatePet(@RequestBody(required = true) PetStore petStore) {
		PetStore pet = petStoreService.updatePet(petStore);
		return pet;
	}
	
	@RequestMapping(value = "/pet/list", method = RequestMethod.GET)
	public List<PetStore> petStoreList(){
		List<PetStore> petList = petStoreService.petStroeList();
		return petList;
	}
	
	@RequestMapping(value = "/pet/{petId}", method = RequestMethod.DELETE)
	public String deletePet(@PathVariable(required = true) long petId) {
		boolean petDeleted = petStoreService.deletePetById(petId);
		if(petDeleted) {
			return "Pet Deleted";
		} else {
			return "";
		}
		
	}
	
	@RequestMapping(value = "/pet/hello", method = RequestMethod.GET)
	public String petHello(){
		return "Meow Meow";
	}

}
