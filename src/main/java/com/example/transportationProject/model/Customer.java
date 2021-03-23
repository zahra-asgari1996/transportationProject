package com.example.transportationProject.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    private String userName;
    @Column
    private String password;
    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @ManyToOne
    private Address address;
    @Column
    private long phoneNumber;

    public Customer(String userName, String password, String name, String email, Address address, long phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public Customer() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
