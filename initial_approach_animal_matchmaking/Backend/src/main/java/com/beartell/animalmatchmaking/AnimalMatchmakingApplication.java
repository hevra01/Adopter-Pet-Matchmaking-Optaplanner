package com.beartell.animalmatchmaking;

import com.beartell.animalmatchmaking.domain.Adopter;

import java.time.Duration;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.domain.Cat;
import com.beartell.animalmatchmaking.domain.Dog;
import com.beartell.animalmatchmaking.domain.User;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;

import com.beartell.animalmatchmaking.solver.AnimalConstraintProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AnimalMatchmakingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdopterPetPair.class);

    public static void main(String[] args) {
        SolverFactory<AdopterPetPair> solverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(AdopterPetPair.class)
                .withEntityClasses(Adopter.class)
                .withConstraintProviderClass(AnimalConstraintProvider.class)
                // The solver runs only for 5 seconds on this small dataset.
                // It's recommended to run for at least 5 minutes ("5m") otherwise.
                .withTerminationSpentLimit(Duration.ofSeconds(10)));

        // Load the problem
        // AdopterPetPair problem = generateDemoData();

        // Solve the problem
        Solver<AdopterPetPair> solver = solverFactory.buildSolver();
        AdopterPetPair solution = solver.solve(problem);

        // Visualize the solution
        // printTimetable(solution);
    }
}
