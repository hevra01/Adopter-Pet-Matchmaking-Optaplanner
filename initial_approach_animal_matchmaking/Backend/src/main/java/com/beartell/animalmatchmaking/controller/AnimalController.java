package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.service.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/get")
    public Animal findAnimalByUuid(@RequestParam("uuid") String uuid) {
        return animalService.findAnimalByUuid(uuid);
    }
}
