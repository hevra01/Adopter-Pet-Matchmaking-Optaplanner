package com.beartell.animalmatchmaking.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Entity
@PlanningEntity
public class Adopter extends User {

    @PlanningId
    private Long planningId;

    @PlanningVariable(valueRangeProviderRefs = "AnimalList")
    @Transient
    private Animal myAnimal;

    @Column(name = "InMatcher", length = 10, nullable = false)
    private boolean inMatcher;

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

    /*
     * We don't want to loss the data of the animals adopted by an adopter.
     * We might need the data later on for analysis. For that reason, we are keeping
     * the
     * myAnimal attribute separetely with the animals list. animals being the pets
     * already
     * adopted by the adopter. Whereas, myAnimal being the pet to be matched now.
     */

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
