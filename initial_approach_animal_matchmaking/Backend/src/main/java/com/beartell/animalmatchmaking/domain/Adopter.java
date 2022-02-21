package com.beartell.animalmatchmaking.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Document
@PlanningEntity
public class Adopter extends User {
  

    @PlanningId
    private Long id;

    @PlanningVariable(valueRangeProviderRefs = "AnimalList")
    private Animal myAnimal;

    /*
     * We don't want to loss the data of the animals adopted by an adopter.
     * We might need the data later on for analysis. For that reason, we are keeping
     * the
     * myAnimal attribute separetely with the animals list. animals being the pets
     * already
     * adopted by the adopter. Whereas, myAnimal being the pet to be matched now.
     */
    @OneToMany(mappedBy = "adopter")
    private List<Animal> animals;

    // Used for hard constraint and the country of the adopter will also be a hard
    // constraint.
    @Column(name = "MoneySpentForPet", length = 50, nullable = false)
    private int moneyWillingToSpendForPetPerMonth;

    @Column(name = "PetType", length = 50, nullable = false)
    private String petType;

    // Used for soft constraint.
    @Column(name = "Busyness", length = 3, nullable = false)
    private int busyness; // this will be on a scale of 1 to 10. 10 implying the most busy.

    @Column(name = "PhysicalActivityTimeDevote", length = 3, nullable = false)
    private int physicalActivityTimeDevote; // this will be on a scale of 1 to 10. 10 implying a lot of time.

    @Column(name = "SocialLevel", length = 3, nullable = false)
    private int socialLevel; // this will be on a scale of 1 to 10. 10 implying very social.

    
    public Adopter() {
    }
    
    /*
     * Initially, we can only initialize the id because the user has not adopted a
     * pet yet.
     */
    public Adopter(String name, String surname, String username, String emailAddress, String phoneNumber, Long id,
            List<Animal> animals, int moneyWillingToSpendForPetPerMonth, String petType, int busyness,
            int physicalActivityTimeDevote, int socialLevel) {
        super(name, surname, username, emailAddress, phoneNumber);
        this.id = id;
        this.animals = animals;
        this.moneyWillingToSpendForPetPerMonth = moneyWillingToSpendForPetPerMonth;
        this.petType = petType;
        this.busyness = busyness;
        this.physicalActivityTimeDevote = physicalActivityTimeDevote;
        this.socialLevel = socialLevel;
    }

    public int getMoneyWillingToSpendForPetPerMonth() {
        return moneyWillingToSpendForPetPerMonth;
    }

    public void setMoneyWillingToSpendForPetPerMonth(int moneyWillingToSpendForPetPerMonth) {
        this.moneyWillingToSpendForPetPerMonth = moneyWillingToSpendForPetPerMonth;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal getMyAnimal() {
        return myAnimal;
    }

    public void setMyAnimal(Animal myAnimal) {
        this.myAnimal = myAnimal;
    }

}
