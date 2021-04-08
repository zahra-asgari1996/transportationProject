package com.example.transportationProject.service;

import com.example.transportationProject.model.dao.EmployeeDao;
import com.example.transportationProject.model.dao.ManagerDao;
import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.model.entity.Manager;

import java.util.List;

public class ManagerService {

    public Manager returnManager(String userName) {
        ManagerDao managerDao = new ManagerDao();
        List<Manager> manager = managerDao.findByUserName(userName);
        if (manager != null) {
            return manager.get(0);
        }
        return null;
    }
}
