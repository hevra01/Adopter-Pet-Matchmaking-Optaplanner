package com.beartell.animalmatchmaking.repository;

import com.beartell.animalmatchmaking.domain.Adopter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdopterRepository extends JpaRepository<Adopter, Long> {

}
