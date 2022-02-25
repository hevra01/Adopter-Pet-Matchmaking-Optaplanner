package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;
import com.beartell.animalmatchmaking.solver.AnimalConstraintProvider;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.function.ToIntBiFunction;

import java.lang.Math;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;
import com.beartell.animalmatchmaking.domain.Animal;

@Service
public class AdopterAnimalMatchService {

    // private static final Logger LOGGER =
    // LoggerFactory.getLogger(AdopterAnimalMatchService.class);

    // the adderService needs to be autowired with the repository so that it can
    // call its methods.
    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private AnimalRepository animalRepository;

    // question to ciya brother: can we somehow join the below two functions

    public ToIntBiFunction differenceInActivenessLevel() {

        ToIntBiFunction<Animal, Adopter> i = (x, y) -> Math
                .abs(x.getPhysicalActivityNeed() - y.getPhysicalActivityTimeDevote());
        return i;
    }

    public ToIntBiFunction differenceInBusynessLevel() {

        ToIntBiFunction<Animal, Adopter> i = (x, y) -> Math.abs(x.getEmotionalNeed() - y.getBusyness());
        return i;
    }

    public ToIntBiFunction differenceInSocializingLevel() {

        ToIntBiFunction<Animal, Adopter> i = (x, y) -> Math.abs(x.getShynessLevel() - y.getSocialLevel());
        return i;
    }

    public void match(Animal animal) {
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
        AdopterPetPair problem = generateDemoData();

        Solver<AdopterPetPair> solver = solverFactory.buildSolver(); // builds the solving algorithm
        AdopterPetPair solution = solver.solve(problem); // solves the problem

        printTimetable(solution);

    }

    // after the animal is matched with the adopter, we can add to the list of
    // animlas adopted by the adopter.
    public void addToAnimalList(Animal animal, Adopter adopter) {
        adopter.getAnimals().add(animal); // dont we first need to check if its already there
        adopterRepository.save(adopter); // update the adopter after the addition of the animal
    }

}
