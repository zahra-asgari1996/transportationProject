package com.example.transportationProject.service;

import com.example.transportationProject.model.dao.EmployeeDao;
import com.example.transportationProject.model.dao.ManagerDao;
import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.model.entity.Manager;

import java.util.List;

public class ManagerService {

    public Manager returnManager(String userName) {
        ManagerDao managerDao = new ManagerDao();
        if (!managerDao.findByUserName(userName).isEmpty()) {
            managerDao.findByUserName(userName).get(0);
        }
        return null;
    }
}
