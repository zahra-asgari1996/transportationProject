package com.example.transportationProject.model.entity;

import com.example.transportationProject.enums.Gender;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String userName;
    @Column
    private String password;
    @OneToMany(mappedBy = "employee")
    private List<DeliveryHistory> historyList=new ArrayList<>();
    @OneToMany(mappedBy = "employeee")
    private List<NewPacket> newPackets=new ArrayList<>();
    @Column
    private String phone;
    @Column
    private String name;
    @Column
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    private Address employeeAddress;
    @Column
    private String email;

    public Employee() {
    }

    public Employee(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Employee(String userName, String password, String phone, String name, String lastName, Gender gender, Address employeeAddress, String email) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.employeeAddress = employeeAddress;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<DeliveryHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<DeliveryHistory> historyList) {
        this.historyList = historyList;
    }

    public List<NewPacket> getNewPackets() {
        return newPackets;
    }

    public void setNewPackets(List<NewPacket> newPackets) {
        this.newPackets = newPackets;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(Address employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
