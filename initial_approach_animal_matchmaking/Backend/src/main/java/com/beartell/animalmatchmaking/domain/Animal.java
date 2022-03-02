package com.beartell.animalmatchmaking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/*
    Animal is the parent class whose children are Cat and Dog.
 */
@Entity
public class Animal {

    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne
    protected Adder adder;

    @ManyToOne
    protected Adopter adopter;

    @Column(name = "AnimalType", length = 50, nullable = false)
    protected String animalType; // Animal type can either be C for cat or D for dog for the current
                                 // implementation

    @Column(name = "Expenses", length = 50, nullable = false)
    protected int expenses; // This will be specified in dollars.

    @Column(name = "EmotionalNeed", length = 50, nullable = false)
    protected int emotionalNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of emotional
                                 // care.

    @Column(name = "PhysicalActivityNeed", length = 50, nullable = false)
    protected int physicalActivityNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of physical
                                        // activity.

    @Column(name = "ShynessLevel", length = 50, nullable = false)
    protected int shynessLevel; // This will be on a scale of 1 to 10. 10 implying very shy.

    @Column(name = "Adopted", length = 10, nullable = false)
    protected boolean adopted; // This will be true if the animal is adopted and false if it still has not
                               // been.

    @Column(name = "Age", length = 2, nullable = false)
    protected int age;

    @Column(name = "Alive", length = 10, nullable = false)
    protected boolean alive; // This will be true if the animal is living.

    public Animal() {
    }

    /*
     * The constructor can not initialize the adopter because initially the animal
     * isn't adopted by anyone.
     */

    public String getAnimalType() {
        return animalType;
    }

    public Animal(int id, String animalType, int expenses, Adder adder, int emotionalNeed, int physicalActivityNeed,
            int shynessLevel, boolean adopted, int age, boolean alive) {
        this.id = id;
        this.animalType = animalType;
        this.expenses = expenses;
        this.adder = adder;
        this.emotionalNeed = emotionalNeed;
        this.physicalActivityNeed = physicalActivityNeed;
        this.shynessLevel = shynessLevel;
        this.adopted = adopted;
        this.age = age;
        this.alive = alive;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
