package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.dto.AnimalDTO;

@Service
public class AdderAnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AdderRepository adderRepository;

    public boolean addToAnimalList(AnimalDTO animalDTO) {
        Adder adder = adderRepository.findByUsername(animalDTO.getAdderUsername());

        if (adder == null) {
            return false; // There is no such adder with the given username.
        }

        Animal animalPresent = animalRepository.findByUuid(animalDTO.getUuid());

        if (animalPresent != null) {
            return false; // animal is already present so we can not add it again.
        }

        Animal animal = new Animal(animalDTO.getUuid(), animalDTO.getAnimalType(), animalDTO.getExpenses(),
                adder, animalDTO.getEmotionalNeed(), animalDTO.getPhysicalActivityNeed(),
                animalDTO.getShynessLevel(),
                animalDTO.isAdopted(), animalDTO.getAge(), animalDTO.isAlive());

        animalRepository.save(animal);
        adder.getAnimals().add(animal);
        adderRepository.save(adder);
        return true;
    }
}
