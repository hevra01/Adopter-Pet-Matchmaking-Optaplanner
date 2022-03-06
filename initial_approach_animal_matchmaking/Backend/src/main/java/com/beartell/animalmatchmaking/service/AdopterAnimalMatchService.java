package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.scheduler.JobData;
import com.beartell.animalmatchmaking.scheduler.ScheduledJob;
import com.beartell.animalmatchmaking.solver.AnimalConstraintProvider;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.config.solver.SolverConfig;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.Scheduler;
import org.quartz.core.QuartzScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.function.ToIntBiFunction;

import java.lang.Math;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.domain.Form;
import com.beartell.animalmatchmaking.dto.FormDTO;

@Service
public class AdopterAnimalMatchService {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AdopterService adopterService;

    @Autowired
    private Scheduler quartzScheduler;

    // @Autowired
    private SolverManager<AdopterPetPair, UUID> solverManager;

    // Finds the best match for the adopter.
    public AdopterPetPair moreAccurateMatch(Adopter adopter) {
        // represents an immutable universally unique identifier (UUID)
        UUID problemId = UUID.randomUUID();

        HardSoftScore score = HardSoftScore.ZERO;

        AdopterPetPair problem = new AdopterPetPair(animalService.findAll(), Arrays.asList(adopter), score);

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

    // this is problematic due to http timeouts!!
    public AdopterPetPair match() {

        SolverFactory<AdopterPetPair> solverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(AdopterPetPair.class)
                .withEntityClasses(Adopter.class)
                .withConstraintProviderClass(AnimalConstraintProvider.class)

                // The solver runs only for 5 seconds on this small dataset.
                // It's recommended to run for at least 5 minutes ("5m") otherwise.
                .withTerminationSpentLimit(Duration.ofMinutes(2)));

        HardSoftScore score = HardSoftScore.ZERO;

        AdopterPetPair problem = new AdopterPetPair(animalService.findAll(), adopterService.findAllInMatcher(), score);

        // SolverFactory<AdopterPetPair> solverFactory =
        // SolverFactory.createFromXmlResource(
        // "org/optaplanner/examples/nqueens/solver/nqueensSolverConfig.xml");

        Solver<AdopterPetPair> solver = solverFactory.buildSolver();

        AdopterPetPair solution = solver.solve(problem); // solves the problem
        return solution;

    }

}
