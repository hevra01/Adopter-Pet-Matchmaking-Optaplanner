package com.beartell.animalmatchmaking.dto;

public class FormDTO {

    private String adopterUsername;
    private int moneyWillingToSpendForPetPerMonth;
    private String petType;
    private int busyness; // this will be on a scale of 1 to 10. 10 implying the most busy.
    private int physicalActivityTimeDevote; // this will be on a scale of 1 to 10. 10 implying a lot of time.
    private int socialLevel; // this will be on a scale of 1 to 10. 10 implying very social.

    public FormDTO() {
    }

    public FormDTO(String adopterUsername, int moneyWillingToSpendForPetPerMonth, String petType, int busyness,
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
