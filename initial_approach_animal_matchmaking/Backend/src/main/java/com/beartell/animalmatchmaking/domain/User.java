package com.beartell.animalmatchmaking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
    User is the parent class of Adopter and Adder.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "UserName", length = 50, nullable = false)
    private String username;

    @Column(name = "EmailAddress", length = 50, nullable = false)
    private String emailAddress;

    @Column(name = "PhoneNumber", length = 50, nullable = false)
    private String phoneNumber;

    @Column(name = "Country", length = 50, nullable = false)
    private String Country;

    @Column(name = "City", length = 50, nullable = false)
    private String City;

    public User() {
    }

    public User(String name, String surname, String username, String emailAddress,
            String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
