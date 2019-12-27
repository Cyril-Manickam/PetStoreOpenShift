package com.petstore.demo;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.petstore.demo.model.PetStore;
import com.petstore.demo.repository.PetStoreRepository;
import com.petstore.demo.service.PetStoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PetStoreTest {
	
	@InjectMocks
	PetStoreServiceImpl petStoreServiceImpl;
	
	@Mock
	PetStoreRepository petStoreRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindPetById() {
		PetStore petStore = constructPetStoreObject();
		Mockito.when(petStoreRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(petStore));
		Optional<PetStore> pet = petStoreServiceImpl.findPetById(12);
		Assert.assertNotNull(pet);
		Assert.assertEquals("Dobermann", pet.get().getPetName());
	}
	
	public PetStore constructPetStoreObject(){
		PetStore petStore = new PetStore();
		petStore.setPetId(12);
		petStore.setPetName("Dobermann");
		petStore.setCategory("Dog");
		petStore.setStatus("Available");
		return petStore;
	}


	
	

}
