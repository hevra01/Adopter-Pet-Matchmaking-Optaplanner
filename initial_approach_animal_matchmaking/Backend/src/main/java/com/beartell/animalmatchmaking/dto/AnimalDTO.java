package com.beartell.animalmatchmaking.dto;

/*
    Animal is the parent class whose children are Cat and Dog.
 */
public class AnimalDTO {

    private int id;

    private String animalType; // Animal type can either be C for cat or D for dog for the current
                               // implementation
    private int expenses; // This will be specified in dollars.

    private long adderID;

    private int emotionalNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of emotional
                               // care.
    private int physicalActivityNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of physical
                                      // activity.
    private int shynessLevel; // This will be on a scale of 1 to 10. 10 implying very shy.
    private int age;
    private boolean adopted;
    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public AnimalDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public long getAdderID() {
        return adderID;
    }

    public void setAdderID(long adderID) {
        this.adderID = adderID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
