package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.domain.Animal;

@Service
public class AdderAnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AdderRepository adderRepository;

    public void addToAnimalList(Adder adder, Animal animal) {
        adder.getAnimals().add(animal);
        adderRepository.save(adder);

    }
}
