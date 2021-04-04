package com.example.transportationProject.model.entity;

import com.example.transportationProject.model.entity.DeliveryHistory;

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

    public Employee() {
    }

    public Employee(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
}
