package com.example.transportationProject.service;

import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.model.dao.DeliveryHistoryDao;
import com.example.transportationProject.model.dao.NewPacketDao;
import com.example.transportationProject.model.entity.DeliveryHistory;
import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.model.entity.NewPacket;

public class DeliveryHistoryService {

    public  void saveNewDeliveryHistoryByEmployee(int number,String userName ,StateOfPacket state){
        EmployeeService employeeService=new EmployeeService();
        Employee employee=employeeService.returnEmployee(userName);
        NewPacketDao newPacketDao=new NewPacketDao();
        NewPacket newPacket=newPacketDao.findPacketById(number);
        DeliveryHistoryDao deliveryHistoryDao=new DeliveryHistoryDao();
        DeliveryHistory deliveryHistory=new DeliveryHistory(state,employee,newPacket);
        deliveryHistoryDao.saveNewHistory(deliveryHistory);

    }
    public  void saveNewDeliveryHistoryByEmployee(int number,String userName,String description,StateOfPacket state){
        EmployeeService employeeService=new EmployeeService();
        Employee employee=employeeService.returnEmployee(userName);
        NewPacketDao newPacketDao=new NewPacketDao();
        NewPacket newPacket=newPacketDao.findPacketById(number);
        DeliveryHistoryDao deliveryHistoryDao=new DeliveryHistoryDao();
        DeliveryHistory deliveryHistory=new DeliveryHistory(state,employee,newPacket,description);
        deliveryHistoryDao.saveNewHistory(deliveryHistory);
        newPacketDao.changeStateOfPacket(number,employee);



    }
}
