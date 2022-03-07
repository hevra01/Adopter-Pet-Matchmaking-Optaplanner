package com.beartell.animalmatchmaking.service;

import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.SolverManagerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import com.beartell.animalmatchmaking.solver.AnimalConstraintProvider;

import org.optaplanner.core.api.solver.SolverFactory;

@Service
public class SolverService {

    public SolverConfig solverConfig2() {
        SolverConfig solverConfig = SolverConfig
                .createFromXmlResource("com/beartell/animalmatchmaking/solver/SolverConfig.xml");
        return solverConfig;
    }

    public SolverConfig solverConfig() {
        return new SolverConfig()
                .withSolutionClass(AdopterPetPair.class)
                .withEntityClasses(Adopter.class)
                .withConstraintProviderClass(AnimalConstraintProvider.class)

                // The solver runs only for 5 seconds on this small dataset.
                // It's recommended to run for at least 5 minutes ("5m") otherwise.
                .withTerminationSpentLimit(Duration.ofSeconds(5));
    }

    public SolverManager<AdopterPetPair, UUID> solverManager() {
        return SolverManager.create(solverConfig2(), new SolverManagerConfig());
    }
}
