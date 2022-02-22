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
     * The Planning Entity Collection will be the adopters who wanted to find the
     * best
     * match of pet for themselves at the same time.
     */

    @PlanningEntityCollectionProperty
    private List<Adopter> adopters;

    @PlanningScore
    private HardSoftScore score;

    public AdopterPetPair(List<Animal> animals, List<Adopter> adopters, HardSoftScore score) {
        this.animals = animals;
        this.adopters = adopters;
        this.score = score;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Adopter> getAdopters() {
        return adopters;
    }

    public void setAdopters(List<Adopter> adopters) {
        this.adopters = adopters;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}