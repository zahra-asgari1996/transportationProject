package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.Gender;
import com.example.transportationProject.model.Customer;
import com.example.transportationProject.service.CustomerDoa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signUpCustomeServlet")
public class signUpCustomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String userName=request.getParameter("userName");
        String pass=request.getParameter("pass");
        String name=request.getParameter("name");
        String lname=request.getParameter("lname");
        String email=request.getParameter("email");
        long phone=Integer.valueOf(request.getParameter("phone"));
        Gender gender=Gender.valueOf(request.getParameter("gender"));
        Customer customer=new Customer(userName,pass,name,lname,email,phone,gender);
        CustomerDoa customerDoa=new CustomerDoa();
        customerDoa.saveNewCustomer(customer);
        PrintWriter out = response.getWriter();
        out.println("welcome"+" "+ userName);




    }
}
