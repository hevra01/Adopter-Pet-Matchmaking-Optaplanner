package com.beartell.animalmatchmaking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

/*
    Animal is the parent class whose children are Cat and Dog.
 */
@Entity
public class Animal {

    @Id
    protected int id;

    @Column(name = "AnimalType", length = 50, nullable = false)
    protected char animalType; // Animal type can either be C for cat or D for dog for the current
                               // implementation

    @Column(name = "Expenses", length = 5, nullable = false)
    protected int expenses; // This will be specified in dollars.

    @Column(name = "Adder", length = 5, nullable = false)
    @ManyToOne
    protected Adder adder;

    @Column(name = "Adopter", length = 5, nullable = true)
    @ManyToOne
    protected Adopter adopter;

    @Column(name = "EmotionalNeed", length = 5, nullable = true)
    protected int emotionalNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of emotional
                                 // care.

    @Column(name = "PhysicalActivityNeed", length = 5, nullable = true)
    protected int physicalActivityNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of physical
                                        // activity.

    @Column(name = "ShynessLevel", length = 5, nullable = true)
    protected int shynessLevel; // This will be on a scale of 1 to 10. 10 implying very shy.

    /*
     * The constructor can not initialize the adopter because initially the animal
     * isn't adopted by anyone.
     */

    public Animal(char animalType, int expenses, Adder adder, int emotionalNeed, int physicalActivityNeed,
            int shynessLevel) {
        this.animalType = animalType;
        this.expenses = expenses;
        this.adder = adder;
        this.emotionalNeed = emotionalNeed;
        this.physicalActivityNeed = physicalActivityNeed;
        this.shynessLevel = shynessLevel;
    }

    public int getEmotionalNeed() {
        return emotionalNeed;
    }

    public void setEmotionalNeed(int emotionalNeed) {
        this.emotionalNeed = emotionalNeed;
    }

    public int getPhysicalActivityNeed() {
        return physicalActivityNeed;
    }

    public void setPhysicalActivityNeed(int physicalActivityNeed) {
        this.physicalActivityNeed = physicalActivityNeed;
    }

    public int getShynessLevel() {
        return shynessLevel;
    }

    public void setShynessLevel(int shynessLevel) {
        this.shynessLevel = shynessLevel;
    }

    // Getters and setters
    public Adder getAdder() {
        return adder;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public void setAdder(Adder adder) {
        this.adder = adder;
    }

    public char getAnimalType() {
        return animalType;
    }

    public void setAnimalType(char animalType) {
        this.animalType = animalType;
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

}
