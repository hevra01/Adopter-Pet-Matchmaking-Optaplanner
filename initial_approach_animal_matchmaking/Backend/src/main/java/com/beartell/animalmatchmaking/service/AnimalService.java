package com.beartell.animalmatchmaking.service;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal findAnimalByUuid(String uuid) {
        return animalRepository.findByUuid(uuid);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

}
