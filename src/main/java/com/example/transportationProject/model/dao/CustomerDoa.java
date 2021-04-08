package com.example.transportationProject.model.dao;

import com.example.transportationProject.model.entity.Customer;
import com.example.transportationProject.model.entity.Employee;
import org.hibernate.*;

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
        List<Customer> customer=query.getResultList();
        txn.commit();
        session.close();
        if (!customer.isEmpty()){
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

    public List<Customer> fetchAllCustomers(){
        Session session= sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Customer.class);
        List<Customer> customers=criteria.list();
        return customers;
    }

}
