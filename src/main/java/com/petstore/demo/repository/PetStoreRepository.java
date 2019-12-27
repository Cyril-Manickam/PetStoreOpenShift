package com.petstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petstore.demo.model.PetStore;

@Repository
public interface PetStoreRepository extends JpaRepository<PetStore, Long> {

}
