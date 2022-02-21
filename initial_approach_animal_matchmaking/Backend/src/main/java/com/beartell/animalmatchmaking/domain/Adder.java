package com.beartell.animalmatchmaking.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Adder is a child class of User. It can add animals, cats and dogs to the
 * database.
 * So that these animals can be adopted by people who want to adopt.
 */
@Document
public class Adder extends User {

    private Long id;

    @OneToMany(mappedBy = "adder")
    private List<Animal> animals;

    public Adder() {
    }

    public Adder(Long id) {
        this.id = id;
        animals = new ArrayList<Animal>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
