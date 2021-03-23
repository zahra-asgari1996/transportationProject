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
    private String street;
    @Column
    private String alley;
    @Column
    private int plaque;
    @OneToMany(mappedBy = "address")
    private List<Customer> customerList=new ArrayList<>();

    public Address() {
    }

    public Address(String province, String city, String street, String alley, int plaque) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.alley = alley;
        this.plaque = plaque;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public int getPlaque() {
        return plaque;
    }

    public void setPlaque(int plaque) {
        this.plaque = plaque;
    }
}
