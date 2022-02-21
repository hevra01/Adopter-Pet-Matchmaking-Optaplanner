package com.beartell.animalmatchmaking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
    User is the parent class of Adopter and Adder.  
 */
@Entity
public class User {

    @Id
    private Long id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "Username", length = 50, nullable = false)
    private String username;

    @Column(name = "EmailAddress", length = 50, nullable = false, unique = true)
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
