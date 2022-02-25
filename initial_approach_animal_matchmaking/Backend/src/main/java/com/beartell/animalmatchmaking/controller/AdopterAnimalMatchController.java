package com.beartell.animalmatchmaking.controller;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
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
@RequestMapping("/AdopterPetPair")
public class AdopterAnimalMatchController {

    @Autowired
    private SolverManager<AdopterPetPair, UUID> solverManager;

    /*
     * AdopterPetPair is the @PlanningSolution which contains both
     * the @PlanningEntity and @PlanningVariable.
     * Before sending it to the solve function, the @PlanningEntity hasn't received
     * values yet.
     * However, after sending it to the solve function, the Planning Entity will get
     * values assigned to it.
     */
    @PostMapping("/solve")
    public AdopterPetPair solve(@RequestBody AdopterPetPair problem) {
        // represents an immutable universally unique identifier (UUID)
        UUID problemId = UUID.randomUUID();

        // Submit the problem to start solving
        SolverJob<AdopterPetPair, UUID> solverJob = solverManager.solve(problemId, problem);
        AdopterPetPair solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }
}
