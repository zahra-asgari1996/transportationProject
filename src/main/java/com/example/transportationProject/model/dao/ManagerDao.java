package com.example.transportationProject.model.dao;

import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.model.entity.Manager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ManagerDao {
    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;


    public List<Manager> findByUserName(String userName){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery("from Manager as m where m.userName=: user")
                .setParameter("user",userName);
        List<Manager> managers=query.getResultList();
        txn.commit();
        session.close();
        return managers;
    }
}
