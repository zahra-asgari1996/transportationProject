package com.example.transportationProject.service;

import com.example.transportationProject.model.Customer;
import com.example.transportationProject.model.NewPacket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NewPacketDao {
    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;

    public  void saveNewPacket(NewPacket newPacket){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(newPacket);
        session.getTransaction().commit();
        session.close();
    }
}
