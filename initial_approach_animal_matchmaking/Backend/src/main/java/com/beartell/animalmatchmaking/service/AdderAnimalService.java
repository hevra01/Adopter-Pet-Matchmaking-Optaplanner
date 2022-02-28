package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;
import com.github.javaparser.printer.lexicalpreservation.Added;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.dto.AnimalDTO;

@Service
public class AdderAnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AdderRepository adderRepository;

    // int id, String animalType, int expenses, Adder adder, int emotionalNeed, int
    // physicalActivityNeed,
    // int shynessLevel, boolean adopted, int age, boolean alive
    public void addToAnimalList(AnimalDTO animalDTO) {
        Adder adder = adderRepository.getById(animalDTO.getAdderID());

        Animal animal = new Animal(animalDTO.getId(), animalDTO.getAnimalType(), animalDTO.getExpenses(),
                adder, animalDTO.getEmotionalNeed(), animalDTO.getPhysicalActivityNeed(), animalDTO.getShynessLevel(),
                animalDTO.isAdopted(), animalDTO.getAge(), animalDTO.isAlive());

        animalRepository.save(animal);

        adder.getAnimals().add(animal);
        adderRepository.save(adder);
    }
}
