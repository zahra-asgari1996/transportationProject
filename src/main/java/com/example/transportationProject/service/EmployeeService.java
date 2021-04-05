package com.example.transportationProject.service;

import com.example.transportationProject.model.dao.EmployeeDao;
import com.example.transportationProject.model.entity.Employee;

import java.util.List;

public class EmployeeService {

    public boolean findEmployeeOrNot(String userName) {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee>employee = employeeDao.findByUserName(userName);
        if (employee != null) {
            return true;
        }
        return false;
    } public Employee returnEmployee(String userName){
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee>employee = employeeDao.findByUserName(userName);
        if (employee != null) {
            return employee.get(0);
        }
        return null;
    }
}
