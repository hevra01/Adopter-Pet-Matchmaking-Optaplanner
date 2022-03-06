package com.beartell.animalmatchmaking.repository;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adopter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdopterRepository extends JpaRepository<Adopter, Long> {
    Adopter findByUsername(String username);

    @Query(value = "SELECT * FROM Adopter WHERE in_matcher = true", nativeQuery = true)
    List<Adopter> findAllInMatcher();

    int deleteByUsername(String username); // returns the number of adopters deleted
}
