package com.example.transportationProject.model.dao;

import com.example.transportationProject.model.entity.Customer;
import com.example.transportationProject.model.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {
    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;


    public List<Employee> findByUserName(String userName){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery("from com.example.transportationProject.model.entity.Employee as e where e.userName=: user")
                .setParameter("user",userName);
        List<Employee> employee=query.getResultList();
        txn.commit();
        session.close();
        return employee;
    }
}
