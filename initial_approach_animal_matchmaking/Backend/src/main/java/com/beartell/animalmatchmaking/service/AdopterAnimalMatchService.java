package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.solver.AnimalConstraintProvider;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import com.beartell.animalmatchmaking.domain.Animal;

@Service
public class AdopterAnimalMatchService {

    @Autowired
    private AdopterRepository adopterRepository;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AdopterService adopterService;
    @Autowired
    private SolverService solverService;

    // Finds the best match for the adopter.
    public AdopterPetPair match1() {
        UUID problemId = UUID.randomUUID();

        AdopterPetPair solution = new AdopterPetPair(animalService.findAll(), adopterService.findAllInMatcher());

        SolverJob<AdopterPetPair, UUID> solverJob = solverService.solverManager().solve(problemId, solution);

        // Wait until the solving ends
        try {
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return solution;
    }

    // this is problematic due to http timeouts!!
    public AdopterPetPair match2() {

        SolverFactory<AdopterPetPair> solverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(AdopterPetPair.class)
                .withEntityClasses(Adopter.class)
                .withConstraintProviderClass(AnimalConstraintProvider.class)

                // The solver runs only for 5 seconds on this small dataset.
                // It's recommended to run for at least 5 minutes ("5m") otherwise.
                .withTerminationSpentLimit(Duration.ofSeconds(5)));

        HardSoftScore score = HardSoftScore.ZERO;

        AdopterPetPair problem = new AdopterPetPair(animalService.findAll(), adopterService.findAllInMatcher());

        Solver<AdopterPetPair> solver = solverFactory.buildSolver();

        AdopterPetPair solution = solver.solve(problem); // solves the problem

        return solution;
    }

    // after the animal is matched with the adopter, we can add to the list of
    // animals adopted by the adopter. However, before adding and after matching,
    // ask the adopter is they want to adopt it or not.
    // they might take some time to respond and meanwhile, another adopter might
    // adopt the pet
    // so check the database again!!
    public void addToAnimalList(Animal animal, Adopter adopter) {
        adopter.getAnimals().add(animal); // dont we first need to check if its already there
        adopterRepository.save(adopter); // update the adopter after the addition of the animal
    }

}
