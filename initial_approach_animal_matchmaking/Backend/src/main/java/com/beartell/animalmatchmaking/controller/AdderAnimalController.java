package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;
import com.beartell.animalmatchmaking.service.AdderAnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdderAnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AdderRepository adderRepository;

    @Autowired
    AdderAnimalService adderAnimalService;

    @PostMapping("/add")
    void addAnimal(@RequestBody Adder adder, Animal animal) {
        adderAnimalService.addToAnimalList(adder, animal);
    }
}
