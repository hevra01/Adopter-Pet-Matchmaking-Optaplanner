package com.beartell.animalmatchmaking.repository;

import com.beartell.animalmatchmaking.domain.Animal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
