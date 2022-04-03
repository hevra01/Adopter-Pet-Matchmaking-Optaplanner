package com.beartell.animalmatchmaking.service;

import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import com.beartell.animalmatchmaking.solver.AnimalConstraintProvider;

@Service
public class SolverService {

    public SolverConfig solverConfig2() {
        SolverConfig solverConfig = SolverConfig
                .createFromXmlResource("com/beartell/animalmatchmaking/solver/SolverConfig.xml",
                        getClass().getClassLoader());

        long secondsSpentLimit2 = 40;

        TerminationConfig terminationConfig = new TerminationConfig();

        terminationConfig.setSecondsSpentLimit(secondsSpentLimit2);

        solverConfig.setTerminationConfig(terminationConfig);

        return solverConfig;
    }

    public SolverManager<AdopterPetPair, UUID> solverManager() {
        return SolverManager.create(solverConfig2());
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

}
