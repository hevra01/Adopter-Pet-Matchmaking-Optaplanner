package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import com.beartell.animalmatchmaking.repository.AnimalRepository;
import com.beartell.animalmatchmaking.service.AdopterAnimalMatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Now, we are ready to put everything together and create a REST service. 
    But solving planning problems on REST threads causes HTTP timeout issues. 
    Therefore, the Spring Boot starter injects a SolverManager, 
    which runs solvers in a separate thread pool and can solve multiple datasets in parallel.
*/

@RestController
@RequestMapping("/api/AdopterPetPair")
public class AdopterAnimalMatchController {

    @Autowired
    private AdopterAnimalMatchService adopterAnimalMatchService;

    @Autowired
    private AnimalRepository animalRepository;

    /*
     * AdopterPetPair is the @PlanningSolution which contains both
     * the @PlanningEntity and @PlanningVariable.
     * Before sending it to the solve function, the @PlanningEntity hasn't received
     * values yet.
     * However, after sending it to the solve function, the Planning Entity will get
     * values assigned to it.
     */

    @PostMapping("/findMatch") // this needs to be id/username.
    public AdopterPetPair solve(@RequestBody Adopter adopter) {
        AdopterPetPair solution = adopterAnimalMatchService.moreAccurateMatch(adopter);
        return solution;
    }

}
