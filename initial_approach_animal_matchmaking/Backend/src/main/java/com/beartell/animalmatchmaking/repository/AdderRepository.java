package com.beartell.animalmatchmaking.repository;

import com.beartell.animalmatchmaking.domain.Adder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdderRepository extends JpaRepository<Adder, Long> {
    Adder findByUsername(String username);

    int deleteByUsername(String username); // returns the number of adders deleted
}
