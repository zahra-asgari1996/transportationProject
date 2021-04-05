package com.example.transportationProject.model.dao;

import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.model.entity.Customer;
import com.example.transportationProject.model.entity.DeliveryHistory;
import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.model.entity.NewPacket;
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

    public NewPacket findPacketById(int id){
        Session session= sessionFactory.openSession();
        NewPacket newPacket =session.get(NewPacket.class,id);
        session.close();
        return newPacket;
    }

    public int returnReserveCode(){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery(" select max (n.id) from NewPacket as n ");
        List<Integer> list=query.getResultList();
        txn.commit();
        session.close();
        if (!list.isEmpty()){
            return list.get(0);
        }return -1;

    }
    public void changeStateOfPacket(int number, Employee employee){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery("update NewPacket as n set n.state=:state,n.employeee=:employee where n.id=:id ")
                .setParameter("state", StateOfPacket.accepted)
                .setParameter("id",number)
                .setParameter("employee",employee);
        query.executeUpdate();
        txn.commit();
        session.close();
    }

    public List<NewPacket> findRegisteredHistory() {
        Session session = sessionFactory.openSession();
        List<NewPacket> list = session.createQuery("from NewPacket as n where n.state=:state  ")
                .setParameter("state", StateOfPacket.registered)
                .list();
        session.close();
        return list;
    }


    @Override
    public String toString() {
        return "NewPacketDao{}";
    }
}
