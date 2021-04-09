package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.Gender;
import com.example.transportationProject.model.dao.AddressDao;
import com.example.transportationProject.model.dao.EmployeeDao;
import com.example.transportationProject.model.entity.Address;
import com.example.transportationProject.model.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmployeeSignUpServlet")
public class EmployeeSignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String userName=request.getParameter("userName");
        String pass=request.getParameter("pass");
        String name=request.getParameter("name");
        String lname=request.getParameter("lname");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        Gender gender=Gender.valueOf(request.getParameter("gender"));
        String province=request.getParameter("province");
        String city=request.getParameter("city");
        String str=request.getParameter("address");
        Address address=new Address(province,city,str);
        AddressDao addressDao=new AddressDao();
        addressDao.saveNewAddress(address);
        Employee employee=new Employee(userName,pass,phone,name,lname,gender,address,email);
        EmployeeDao employeeDao=new EmployeeDao();
        employeeDao.saveNewEmployee(employee);
        out.println("welcome"+" "+ userName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
