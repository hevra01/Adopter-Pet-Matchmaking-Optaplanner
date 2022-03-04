package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

}
