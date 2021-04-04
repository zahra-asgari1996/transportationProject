package com.example.transportationProject.model.dao;

import com.example.transportationProject.model.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddressDao {
    private SessionFactory sessionFactory = HibernateUtil.sessionFactory;

    public void saveNewAddress(Address address) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
    }
}
