package com.beartell.animalmatchmaking.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class AdopterPetPair {

    @ValueRangeProvider(id = "AnimalList")
    @ProblemFactCollectionProperty
    private List<Animal> animals;

    /*
     * The Planning Entity Collection will be adopter
     */

    @PlanningEntityCollectionProperty
    private Adopter adopter;

    @PlanningScore
    private HardSoftScore score;

    public AdopterPetPair(List<Animal> animals, Adopter adopter) {
        this.animals = animals;
        this.adopter = adopter;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Adopter getAdopters() {
        return adopter;
    }

    public void setAdopters(Adopter adopter) {
        this.adopter = adopter;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}