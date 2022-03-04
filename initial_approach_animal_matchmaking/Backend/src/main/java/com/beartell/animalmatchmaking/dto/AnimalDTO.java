package com.beartell.animalmatchmaking.dto;

/*
    Animal is the parent class whose children are Cat and Dog.
 */
public class AnimalDTO {

    private String uuid;
    private String animalType; // Animal type can either be C for cat or D for dog for the current
                               // implementation
    private int expenses; // This will be specified in dollars.
    private String adderUsername;
    private int emotionalNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of emotional
                               // care.
    private int physicalActivityNeed; // This will be on a scale of 1 to 10. 10 implying needing a lot of physical
                                      // activity.
    private int shynessLevel; // This will be on a scale of 1 to 10. 10 implying very shy.
    private int age;
    private boolean adopted;
    private boolean alive;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getAdderID() {
        return adderUsername;
    }

    public void setAdderID(String adderUsername) {
        this.adderUsername = adderUsername;
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

    public String getAdderUsername() {
        return adderUsername;
    }

    public void setAdderUsername(String adderUsername) {
        this.adderUsername = adderUsername;
    }

}
