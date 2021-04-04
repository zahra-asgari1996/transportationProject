package com.example.transportationProject.model.entity;

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

    public DeliveryHistory() {
    }

    public DeliveryHistory(StateOfPacket state, NewPacket packet) {
        this.state = state;
        this.packet = packet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StateOfPacket getState() {
        return state;
    }

    public void setState(StateOfPacket state) {
        this.state = state;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NewPacket getPacket() {
        return packet;
    }

    public void setPacket(NewPacket packet) {
        this.packet = packet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DeliveryHistory{" +
                "id=" + id +
                ", state=" + state +
                ", employee=" + employee +
                ", date=" + date +
                ", packet=" + packet +
                ", description='" + description + '\'' +
                '}';
    }
}
