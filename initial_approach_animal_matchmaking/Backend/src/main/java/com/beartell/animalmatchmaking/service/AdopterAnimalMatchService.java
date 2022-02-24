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

    // method to find the difference in activeness level
    public Score differenceInActivenessLevel(Animal animal, Adopter adopter) {
        int score = Math.abs(adopter.getPhysicalActivityTimeDevote() - animal.getPhysicalActivityNeed());
        return SimpleScore.of(score);
    }

    // method to find the difference in busyness level
    public Score differenceInBusynessLevel(Animal animal, Adopter adopter) {
        int score = Math.abs(adopter.getBusyness() - animal.getEmotionalNeed());
        return SimpleScore.of(score);
    }

    public void match(Animal animal) {
        SolverFactory<AdopterPetPair> solverFactory = SolverFactory.create(new SolverConfig()
        .withSolutionClass(AdopterPetPair.class)
        .withEntityClasses(Adopter.class)
        .withConstraintProviderClass(AnimalConstraintProvider.class)
        // The solver runs only for 5 seconds on this small dataset.
        // It's recommended to run for at least 5 minutes ("5m") otherwise.
        .withTerminationSpentLimit(Duration.ofSeconds(10)));
        
         // Load the problem
        AdopterPetPair problem = generateDemoData();
                              
        Solver the problem
        Solver<AdopterPetPair> solver = solverFactory.buildSolver();
        AdopterPetPair solution = solver.solve(problem);
        
        Visualize the solution
        printTimetable(solution);
                                        
    }

    // after the animal is matched with the adopter, we can add to the list of
    // animlas adopted by the adopter.
    public void addToAnimalList(Animal animal, Adopter adopter) {
        adopter.getAnimals().add(animal); // dont we first need to check if its already there
        adopterRepository.save(adopter); // update the adopter after the addition of the animal
    }

}
