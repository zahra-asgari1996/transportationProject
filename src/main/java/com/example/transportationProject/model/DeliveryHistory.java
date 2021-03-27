package com.example.transportationProject.model;

import com.example.transportationProject.enums.StateOfPacket;

import javax.persistence.*;
import java.util.Date;
@Entity
public class DeliveryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private StateOfPacket state;
    @ManyToOne
    private Employee employee;
    @Column
    private Date date;
    @ManyToOne
    private NewPacket packet;
    @Column
    private String description;

}
