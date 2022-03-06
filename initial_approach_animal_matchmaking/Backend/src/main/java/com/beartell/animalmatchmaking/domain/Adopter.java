package com.beartell.animalmatchmaking.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 * 
 */
@Entity
@PlanningEntity
public class Adopter extends User {

    @Column(nullable = false, unique = true)
    @PlanningId
    private Long planningId;

    @Transient
    private Animal myAnimal;

    @Column(name = "InMatcher", length = 10, nullable = false)
    private boolean inMatcher;

    @JsonBackReference
    @OneToMany(mappedBy = "adopter")
    private List<Animal> animals;

    @OneToOne
    @JoinColumn(name = "formId")
    private Form form; // the adopter should be able to change this form whenever they want to

    public boolean isInMatcher() {
        return inMatcher;
    }

    public void setInMatcher(boolean inMatcher) {
        this.inMatcher = inMatcher;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Adopter() {
    }

    public Long getPlanningId() {
        return planningId;
    }

    public Adopter(Long planningId, Animal myAnimal, List<Animal> animals) {
        this.planningId = planningId;
        this.myAnimal = myAnimal;
        this.animals = animals;
    }

    public Adopter(String name, String surname, String username, String emailAddress, String phoneNumber,
            Long planningId, Animal myAnimal, List<Animal> animals) {
        super(name, surname, username, emailAddress, phoneNumber);
        this.planningId = planningId;
        this.myAnimal = myAnimal;
        this.animals = animals;
    }

    public void setPlanningId(Long planningId) {
        this.planningId = planningId;
    }

    @PlanningVariable(valueRangeProviderRefs = "AnimalList")
    public Animal getMyAnimal() {
        return myAnimal;
    }

    public void setMyAnimal(Animal myAnimal) {
        this.myAnimal = myAnimal;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
