package com.example.transportationProject.service;

import com.example.transportationProject.model.dao.EmployeeDao;
import com.example.transportationProject.model.entity.Employee;

import java.util.List;

public class EmployeeService {
 public Employee returnEmployee(String userName){
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee>employee = employeeDao.findByUserName(userName);
        if (!employee.isEmpty()) {
            return employee.get(0);
        }
        return null;
    }
}
