package com.petstore.demo;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.petstore.demo.model.PetStore;
import com.petstore.demo.service.PetStoreService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PetStoreAppTest {
	
	
	 @Autowired
	 private PetStoreService petStoreService;
	 
	 @Test
	    public void testfindPetById() {
	           Optional<PetStore> petStore = petStoreService.findPetById(34);
	           Assert.assertNotNull(petStore.get());
	           Assert.assertEquals("Cuckoo", petStore.get().getPetName());
	    }
	
	
	

}
