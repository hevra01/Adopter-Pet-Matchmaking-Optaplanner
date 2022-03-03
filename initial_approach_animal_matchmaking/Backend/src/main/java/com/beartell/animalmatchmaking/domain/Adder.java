package com.beartell.animalmatchmaking.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Adder is a child class of User. It can add animals, cats and dogs to the
 * database.
 * So that these animals can be adopted by people who want to adopt.
 */
@Entity
public class Adder extends User {

    @OneToMany(mappedBy = "adder")
    private List<Animal> animals = new ArrayList<Animal>();

    public Adder() {
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
