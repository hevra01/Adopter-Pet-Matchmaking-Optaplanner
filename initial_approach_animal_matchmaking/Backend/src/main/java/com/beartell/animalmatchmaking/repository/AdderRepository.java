package com.beartell.animalmatchmaking.repository;

import java.util.Optional;

import com.beartell.animalmatchmaking.domain.Adder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdderRepository extends JpaRepository<Adder, Long> {
    Adder findByUsername(String username);

    void deleteByUsername(String username);
}
