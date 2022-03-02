package com.beartell.animalmatchmaking.dto;

public class FormDTO {

    private int id;

    private long adopterId;
    private int moneyWillingToSpendForPetPerMonth;
    private String petType;
    private int busyness; // this will be on a scale of 1 to 10. 10 implying the most busy.
    private int physicalActivityTimeDevote; // this will be on a scale of 1 to 10. 10 implying a lot of time.
    private int socialLevel; // this will be on a scale of 1 to 10. 10 implying very social.

    public FormDTO() {
    }

    public FormDTO(int id, int adopterId, int moneyWillingToSpendForPetPerMonth, String petType, int busyness,
            int physicalActivityTimeDevote, int socialLevel) {
        this.id = id;
        this.adopterId = adopterId;
        this.moneyWillingToSpendForPetPerMonth = moneyWillingToSpendForPetPerMonth;
        this.petType = petType;
        this.busyness = busyness;
        this.physicalActivityTimeDevote = physicalActivityTimeDevote;
        this.socialLevel = socialLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
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
