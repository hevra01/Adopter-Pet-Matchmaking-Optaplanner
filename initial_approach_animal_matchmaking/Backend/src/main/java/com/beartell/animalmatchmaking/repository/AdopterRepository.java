package com.beartell.animalmatchmaking.repository;

import com.beartell.animalmatchmaking.domain.Adopter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopterRepository extends JpaRepository<Adopter, Long> {
    Adopter findByUsername(String username);

    int deleteByUsername(String username); // returns the number of adopters deleted
}
