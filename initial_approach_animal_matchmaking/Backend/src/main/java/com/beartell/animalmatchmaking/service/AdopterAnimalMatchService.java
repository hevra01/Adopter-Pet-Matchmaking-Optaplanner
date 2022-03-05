package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.scheduler.JobData;
import com.beartell.animalmatchmaking.scheduler.ScheduledJob;
import com.beartell.animalmatchmaking.solver.AnimalConstraintProvider;

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

        AdopterPetPair problem = new AdopterPetPair(animalService.findAll(), adopterService.findAll());

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

    public void scheduler(JobData data) {
        String jobName = data.getJobName();
        String jobGroup = data.getJobGroup();

        int counter = data.getCounter();

        // duration between two jobs
        int gapDuration = data.getGapDuration();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(data.getStarTime(), ZoneId.of("America/New_York"));

        JobDataMap dataMap = new JobDataMap();
        dataMap.put("test", "this is just for demo");

        JobDetail detail = JobBuilder.newJob(ScheduledJob.class).withIdentity(jobName, jobGroup).usingJobData(dataMap)
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
                .startAt(Date.from(zonedDateTime.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(gapDuration).withRepeatCount(counter))
                .build();
    }

    // this is problematic due to http timeouts!!
    public AdopterPetPair match() {
        /*
         * Use one SolverFactory per application.
         * This is because a specific application has fixed Planning Entity,
         * fixed Planning Variables, fixed constraints. Hence, fixed solution.
         */

        /*
         * SolverFactory has a generic parameter called Solution.
         * That is exactly our Planning Solution. It is generic because
         * different problems can have different Planning Solution.
         * Implemented for different data types.
         */

        /*
         * Both a Solver and a SolverFactory have a generic type called Solution_,
         * which is the class representing a planning problem and solution.
         */

        SolverFactory<AdopterPetPair> solverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(AdopterPetPair.class)
                .withEntityClasses(Adopter.class)
                .withConstraintProviderClass(AnimalConstraintProvider.class)

                // The solver runs only for 5 seconds on this small dataset.
                // It's recommended to run for at least 5 minutes ("5m") otherwise.
                .withTerminationSpentLimit(Duration.ofSeconds(10)));

        // Load the problem
        // AdopterPetPair problem = generateDemoData();

        Solver<AdopterPetPair> solver = solverFactory.buildSolver(); // builds the solving algorithm

        AdopterPetPair problem = new AdopterPetPair(animalService.findAll(), adopterService.findAll());

        AdopterPetPair solution = solver.solve(problem); // solves the problem
        return solution;

    }

}
