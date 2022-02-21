package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.Animal;

public class AdopterAnimalMatchService {

    // the adderService needs to be autowired with the repository so that it can
    // call its methods.
    @Autowired
    private AdopterRepository adderRepository;

    @Autowired
    AnimalRepository animalRepository;

    // we can perform the optaplanner search here.!! business logic

    public void match(Animal animal) {

    }

    // after the animal is matched with the adopter, we can add to the list of
    // animlas adopted by the adopter.
    public void addAnimalToAdopterList(Animal animal, Adopter adopter) {
        adopter.getAnimals().add(animal);
        adderRepository.save(adopter);
    }

}
