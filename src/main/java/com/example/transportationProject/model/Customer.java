package com.example.transportationProject.model;

import com.example.transportationProject.enums.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String userName;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String email;
    @ManyToOne
    private Address address;
    @Column
    private long phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "customer")
    private List<NewPacket> packets=new ArrayList<>();

    public Customer(String userName, String password, String name, String lastName, String email, Address address, long phoneNumber, Gender gender) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<NewPacket> getPackets() {
        return packets;
    }

    public void setPackets(List<NewPacket> packets) {
        this.packets = packets;
    }
}
