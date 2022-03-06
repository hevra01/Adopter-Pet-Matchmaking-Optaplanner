package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import com.beartell.animalmatchmaking.repository.AnimalRepository;
import com.beartell.animalmatchmaking.service.AdopterAnimalMatchService;
import com.beartell.animalmatchmaking.service.AdopterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    Now, we are ready to put everything together and create a REST service. 
    But solving planning problems on REST threads causes HTTP timeout issues. 
    Therefore, the Spring Boot starter injects a SolverManager, 
    which runs solvers in a separate thread pool and can solve multiple datasets in parallel.
*/

@RestController
@RequestMapping("/api/adopterPetPair")
public class AdopterAnimalMatchController {

    @Autowired
    private AdopterAnimalMatchService adopterAnimalMatchService;

    @Autowired
    private AdopterService adopterService;

    /*
     * AdopterPetPair is the @PlanningSolution which contains both
     * the @PlanningEntity and @PlanningVariable.
     * Before sending it to the solve function, the @PlanningEntity hasn't received
     * values yet.
     * However, after sending it to the solve function, the Planning Entity will get
     * values assigned to it.
     */
    @GetMapping("/findMatch")
    public AdopterPetPair solve(@RequestParam("username") String username) {
        Adopter adopter = adopterService.findByUsername(username);

        AdopterPetPair solution = adopterAnimalMatchService.moreAccurateMatch(adopter);
        return solution;
    }

    @GetMapping("/findMatch2")
    public AdopterPetPair solve2() {

        AdopterPetPair solution = adopterAnimalMatchService.match();
        return solution;
    }

}
