package com.beartell.animalmatchmaking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
    Animal is the parent class whose children are Cat and Dog.
 */
@Entity
public class Animal {

    @Id
    @GeneratedValue
    int id;

    @Column(unique = true)
    private String uuid;

    @JsonBackReference
    @ManyToOne
    private Adder adder;

    @JsonBackReference
    @ManyToOne
    private Adopter adopter;

    @Column(name = "AnimalType", length = 50, nullable = false)
    private String animalType; // Animal type can either be C for cat or D for dog for the current
                               // implementation

    @Column(name = "Expenses", length = 50, nullable = false)
    private int expenses; // This will be specified in dollars.

    @Column(name = "EmotionalNeed", length = 50, nullable = false)
    private int emotionalNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of emotional
                               // care.

    @Column(name = "PhysicalActivityNeed", length = 50, nullable = false)
    private int physicalActivityNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of physical
                                      // activity.

    @Column(name = "ShynessLevel", length = 50, nullable = false)
    private int shynessLevel; // This will be on a scale of 1 to 10. 10 implying very shy.

    @Column(name = "Adopted", length = 10, nullable = false)
    private boolean adopted;

    @Column(name = "Age", length = 2, nullable = false)
    private int age;

    @Column(name = "Alive", length = 10, nullable = false)
    private boolean alive;

    public Animal() {
    }

    /*
     * The constructor can not initialize the adopter because initially the animal
     * isn't adopted by anyone.
     */
    public Animal(String uuid, String animalType, int expenses, Adder adder, int emotionalNeed,
            int physicalActivityNeed,
            int shynessLevel, boolean adopted, int age, boolean alive) {
        this.uuid = uuid;
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

    public String getAnimalType() {
        return animalType;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adder == null) ? 0 : adder.hashCode());
        result = prime * result + (adopted ? 1231 : 1237);
        result = prime * result + ((adopter == null) ? 0 : adopter.hashCode());
        result = prime * result + age;
        result = prime * result + (alive ? 1231 : 1237);
        result = prime * result + ((animalType == null) ? 0 : animalType.hashCode());
        result = prime * result + emotionalNeed;
        result = prime * result + expenses;
        result = prime * result + id;
        result = prime * result + physicalActivityNeed;
        result = prime * result + shynessLevel;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (adder == null) {
            if (other.adder != null)
                return false;
        } else if (!adder.equals(other.adder))
            return false;
        if (adopted != other.adopted)
            return false;
        if (adopter == null) {
            if (other.adopter != null)
                return false;
        } else if (!adopter.equals(other.adopter))
            return false;
        if (age != other.age)
            return false;
        if (alive != other.alive)
            return false;
        if (animalType == null) {
            if (other.animalType != null)
                return false;
        } else if (!animalType.equals(other.animalType))
            return false;
        if (emotionalNeed != other.emotionalNeed)
            return false;
        if (expenses != other.expenses)
            return false;
        if (id != other.id)
            return false;
        if (physicalActivityNeed != other.physicalActivityNeed)
            return false;
        if (shynessLevel != other.shynessLevel)
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

}
