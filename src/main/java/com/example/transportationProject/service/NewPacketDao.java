package com.example.transportationProject.service;

import com.example.transportationProject.model.Customer;
import com.example.transportationProject.model.NewPacket;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class NewPacketDao {
    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;

    public  void saveNewPacket(NewPacket newPacket){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(newPacket);
        session.getTransaction().commit();
        session.close();
    }

    public int returnReserveCode(){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery(" select max (n.id) from com.example.transportationProject.model.NewPacket as n ");
        List<Integer> list=query.getResultList();
        txn.commit();
        session.close();
        if (!list.isEmpty()){
            return list.get(0);
        }return -1;


    }

    @Override
    public String toString() {
        return "NewPacketDao{}";
    }
}
