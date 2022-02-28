package com.beartell.animalmatchmaking.domain;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

    public Cat() {
    }

    public Cat(String animalType, int expenses, Adder adder, int emotionalNeed, int physicalActivityNeed,
            int shynessLevel) {
        super();
        // TODO Auto-generated constructor stub
    }

}
