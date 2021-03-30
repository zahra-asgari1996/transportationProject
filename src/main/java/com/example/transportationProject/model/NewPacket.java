package com.example.transportationProject.model;

import com.example.transportationProject.enums.Content;
import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.enums.TypeOfDelivery;
import com.example.transportationProject.enums.TypeOfPacket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NewPacket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Address origin;
    @ManyToOne
    private Address destination;
    @Column
    private String   receiverName;
    @Column
    private long   receiverPhone;
    @Enumerated(EnumType.STRING)
    private TypeOfDelivery typeOfDelivery;
    private double weight;
    @Enumerated(EnumType.STRING)
    private Content content;
    @Column
    private double height;
    @Column
    private double width;
    @Column
    private double length;
    @Enumerated(EnumType.STRING)
    private TypeOfPacket typeOfPacket;
    @Enumerated(EnumType.STRING)
    private StateOfPacket state;
    @OneToMany(mappedBy = "packet")
    private List<DeliveryHistory> deliveryHistoryList=new ArrayList<>();
    @ManyToOne
    private Customer customer;

    public NewPacket() {
    }

    public NewPacket(Address origin, Address destination, String receiverName, long receiverPhone, TypeOfDelivery typeOfDelivery, double weight, TypeOfPacket typeOfPacket, Customer customer) {
        this.origin = origin;
        this.destination = destination;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.typeOfDelivery = typeOfDelivery;
        this.weight = weight;
        this.typeOfPacket = typeOfPacket;

        this.customer = customer;
    }

    public NewPacket(Address origin, Address destination, String receiverName, long receiverPhone, TypeOfDelivery typeOfDelivery, double weight, Content content, double height, double width, double length, TypeOfPacket typeOfPacket,  Customer customer) {
        this.origin = origin;
        this.destination = destination;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.typeOfDelivery = typeOfDelivery;
        this.weight = weight;
        this.content = content;
        this.height = height;
        this.width = width;
        this.length = length;
        this.typeOfPacket = typeOfPacket;

        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getOrigin() {
        return origin;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public long getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(long receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public TypeOfDelivery getTypeOfDelivery() {
        return typeOfDelivery;
    }

    public void setTypeOfDelivery(TypeOfDelivery typeOfDelivery) {
        this.typeOfDelivery = typeOfDelivery;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public TypeOfPacket getTypeOfPacket() {
        return typeOfPacket;
    }

    public void setTypeOfPacket(TypeOfPacket typeOfPacket) {
        this.typeOfPacket = typeOfPacket;
    }

    public StateOfPacket getState() {
        return state;
    }

    public void setState(StateOfPacket state) {
        this.state = state;
    }

    public List<DeliveryHistory> getDeliveryHistoryList() {
        return deliveryHistoryList;
    }

    public void setDeliveryHistoryList(List<DeliveryHistory> deliveryHistoryList) {
        this.deliveryHistoryList = deliveryHistoryList;
    }

    @Override
    public String toString() {
        return "NewPacket{" +
                "id=" + id +
                ", origin=" + origin +
                ", destination=" + destination +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone=" + receiverPhone +
                ", typeOfDelivery=" + typeOfDelivery +
                ", weight=" + weight +
                ", typeOfPacket=" + typeOfPacket +
                ", state=" + state +
                ", customer=" + customer +
                '}';
    }
}
