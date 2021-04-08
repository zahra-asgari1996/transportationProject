package com.example.transportationProject.model.dao;


import com.example.transportationProject.model.entity.Customer;
import com.example.transportationProject.model.entity.Employee;
import org.hibernate.*;

import java.util.List;

public class EmployeeDao {
    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;


    public List<Employee> findByUserName(String userName){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery("from Employee as e where e.userName=: user")
                .setParameter("user",userName);
        List<Employee> employee=query.getResultList();
        txn.commit();
        session.close();
        return employee;
    }
    public List<Employee> fetchAllEmployees(){
        Session session= sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Employee.class);
        List<Employee> employee=criteria.list();
        return employee;
    }
    public  void saveNewEmployee(Employee employee){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    public boolean findEmployeeByUserName(String userName){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery("from Employee as e where e.userName=:userName")
                .setParameter("userName",userName);
        List<Employee> employees=query.getResultList();
        txn.commit();
        session.close();
        if (!employees.isEmpty()){
            return true;
        }
        return false;
    }
    public boolean findEmployeeByEmail(String email){
        Session session= sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query=session.createQuery("from Employee as e where e.email=:email")
                .setParameter("email",email);
        List<Employee> employees=query.getResultList();
        txn.commit();
        session.close();
        if (!employees.isEmpty()){
            return true;
        }
        return false;
    }
}
