package com.example.transportationProject.servlet;

import com.example.transportationProject.model.dao.EmployeeDao;
import com.example.transportationProject.model.dao.ManagerDao;
import com.example.transportationProject.model.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       EmployeeDao employeeDao=new EmployeeDao();
        List<Employee> employees=employeeDao.fetchAllEmployees();
        request.setAttribute("employees",employees);
        request.getRequestDispatcher("/Employees.jsp").forward(request,response);
    }
}
