package com.beartell.animalmatchmaking.repository;

import com.beartell.animalmatchmaking.domain.Adder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdderRepository extends JpaRepository<Adder, Long> {

}
