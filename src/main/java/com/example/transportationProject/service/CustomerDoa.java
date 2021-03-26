package com.example.transportationProject.service;

import com.example.transportationProject.model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDoa {
    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;


    public boolean findByUserName(String userName){
        Session session= sessionFactory.openSession();
        Customer customer =session.get(Customer.class,userName);
        session.close();
        if (customer!=null)
            return true;
        return false;
    }

    public  void saveNewCustomer(Customer customer){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }
    public  boolean findByEmail(String email){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery("from Customer as c where c.email=:email")
                .setParameter("email",email);
        Customer customer=(Customer)query.getSingleResult();
        txn.commit();
        session.close();
        if (customer!=null){
            return true;
        }
        return false;

    }

    public Customer findCustomer(String userName){
        Session session= sessionFactory.openSession();
        Customer customer =session.get(Customer.class,userName);
        session.close();
        return customer;

    }

}
