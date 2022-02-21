package com.beartell.animalmatchmaking.domain;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

    public Dog() {
    }

    public Dog(char animalType, int expenses, Adder adder, int emotionalNeed, int physicalActivityNeed,
            int shynessLevel) {
        super(animalType, expenses, adder, emotionalNeed, physicalActivityNeed, shynessLevel);
        // TODO Auto-generated constructor stub
    }

}
