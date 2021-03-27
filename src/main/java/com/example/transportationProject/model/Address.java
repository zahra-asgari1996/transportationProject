package com.example.transportationProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String address;
    @OneToMany(mappedBy = "address")
    private List<Customer> customerList=new ArrayList<>();

    public Address() {
    }

    public Address(String province, String city, String address) {
        this.province = province;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
