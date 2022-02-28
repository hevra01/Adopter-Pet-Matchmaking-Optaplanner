package com.beartell.animalmatchmaking.domain;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

    public Dog() {
    }

    public Dog(String animalType, int expenses, Adder adder, int emotionalNeed, int physicalActivityNeed,
            int shynessLevel) {
        super();
        // TODO Auto-generated constructor stub
    }

}
