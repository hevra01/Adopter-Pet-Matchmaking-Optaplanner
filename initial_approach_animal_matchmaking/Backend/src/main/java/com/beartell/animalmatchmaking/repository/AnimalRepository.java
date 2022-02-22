package com.beartell.animalmatchmaking.repository;

import com.beartell.animalmatchmaking.domain.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
