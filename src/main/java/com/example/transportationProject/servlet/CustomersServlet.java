package com.example.transportationProject.servlet;

import com.example.transportationProject.model.dao.CustomerDoa;
import com.example.transportationProject.model.dao.EmployeeDao;
import com.example.transportationProject.model.entity.Customer;
import com.example.transportationProject.model.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomersServlet")
public class CustomersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDoa customerDoa=new CustomerDoa();
        List<Customer> customers=customerDoa.fetchAllCustomers();
        request.setAttribute("customers",customers);
        request.getRequestDispatcher("/Customers.jsp").forward(request,response);
    }
}
