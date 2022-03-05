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

    @PlanningEntityCollectionProperty
    private List<Adopter> adoptersInMatcher;

    @PlanningScore
    private HardSoftScore score;

    public AdopterPetPair() {
    }

    public AdopterPetPair(List<Animal> animals, List<Adopter> adoptersInMatcher, HardSoftScore score) {
        this.animals = animals;
        this.adoptersInMatcher = adoptersInMatcher;
        this.score = score;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Adopter> getAdoptersInMatcher() {
        return adoptersInMatcher;
    }

    public void setAdoptersInMatcher(List<Adopter> adoptersInMatcher) {
        this.adoptersInMatcher = adoptersInMatcher;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}