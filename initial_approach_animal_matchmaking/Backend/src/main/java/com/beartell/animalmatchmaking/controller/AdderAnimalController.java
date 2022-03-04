package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.dto.AnimalDTO;
import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;
import com.beartell.animalmatchmaking.service.AdderAnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    boolean addAnimal(@RequestBody AnimalDTO animalDTO) {
        return adderAnimalService.addToAnimalList(animalDTO);
    }

}
