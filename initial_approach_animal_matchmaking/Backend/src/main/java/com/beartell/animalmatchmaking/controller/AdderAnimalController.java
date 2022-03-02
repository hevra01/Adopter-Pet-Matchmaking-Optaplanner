package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.dto.AnimalDTO;
import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;
import com.beartell.animalmatchmaking.service.AdderAnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adderanimal")
public class AdderAnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AdderRepository adderRepository;

    @Autowired
    AdderAnimalService adderAnimalService;

    @PostMapping("/add")
    // we dont need adder because we have a foreign key to adder inside animal
    // we can have a max of one request body
    void addAnimal(@RequestBody AnimalDTO animalDTO) {
        adderAnimalService.addToAnimalList(animalDTO);
    }

}
