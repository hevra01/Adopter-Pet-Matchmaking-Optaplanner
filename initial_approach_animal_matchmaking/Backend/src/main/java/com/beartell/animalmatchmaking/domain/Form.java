package com.beartell.animalmatchmaking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "form")
public class Form {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "AdopterUsername", length = 50, nullable = false, unique = true)
    private String adopterUsername;

    // A form can be found by it adopter. It is a one to one relation.
    @OneToOne(mappedBy = "form")
    private Adopter adopter;

    // Used for hard constraint and the country of the adopter will also be a hard
    // constraint.
    @Column(name = "MoneySpentForPet", length = 5, nullable = false)
    private int moneyWillingToSpendForPetPerMonth;

    @Column(name = "PetType", length = 50, nullable = false)
    private String petType;

    // Used for soft constraint.
    @Column(name = "Busyness", length = 2, nullable = false)
    private int busyness; // this will be on a scale of 1 to 10. 10 implying the most busy.

    @Column(name = "PhysicalActivityTimeDevote", length = 3, nullable = false)
    private int physicalActivityTimeDevote; // this will be on a scale of 1 to 10. 10 implying a lot of time.

    @Column(name = "SocialLevel", length = 3, nullable = false)
    private int socialLevel; // this will be on a scale of 1 to 10. 10 implying very social.

    public Form() {
    }

    public Form(String adopterUsername, int moneyWillingToSpendForPetPerMonth, String petType, int busyness,
            int physicalActivityTimeDevote, int socialLevel) {
        this.adopterUsername = adopterUsername;
        this.moneyWillingToSpendForPetPerMonth = moneyWillingToSpendForPetPerMonth;
        this.petType = petType;
        this.busyness = busyness;
        this.physicalActivityTimeDevote = physicalActivityTimeDevote;
        this.socialLevel = socialLevel;
    }

    public String getAdopterUsername() {
        return adopterUsername;
    }

    public void setAdopterUsername(String adopterUsername) {
        this.adopterUsername = adopterUsername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoneyWillingToSpendForPetPerMonth() {
        return moneyWillingToSpendForPetPerMonth;
    }

    public void setMoneyWillingToSpendForPetPerMonth(int moneyWillingToSpendForPetPerMonth) {
        this.moneyWillingToSpendForPetPerMonth = moneyWillingToSpendForPetPerMonth;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public int getBusyness() {
        return busyness;
    }

    public void setBusyness(int busyness) {
        this.busyness = busyness;
    }

    public int getPhysicalActivityTimeDevote() {
        return physicalActivityTimeDevote;
    }

    public void setPhysicalActivityTimeDevote(int physicalActivityTimeDevote) {
        this.physicalActivityTimeDevote = physicalActivityTimeDevote;
    }

    public int getSocialLevel() {
        return socialLevel;
    }

    public void setSocialLevel(int socialLevel) {
        this.socialLevel = socialLevel;
    }

}
