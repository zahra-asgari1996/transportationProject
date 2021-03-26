package com.example.transportationProject.servlet;

import com.example.transportationProject.model.Customer;
import com.example.transportationProject.service.CustomerDoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signinCustomerServlet")
public class signinCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        if (userName=="" || pass==""){
            out.println("plz fill username and  pass");
            RequestDispatcher rd = request.getRequestDispatcher("signinCustomer.jsp");
            rd.include(request, response);
        }
        CustomerDoa customerDoa = new CustomerDoa();
        Customer customer = customerDoa.findCustomer(userName);
        if (customer != null) {
            if (customer.getPassword().equals(pass)) {
                out.println("welcome"+" "+ userName);
            } else {
                out.println("your password is incorrect ");
                RequestDispatcher rd = request.getRequestDispatcher("signinCustomer.jsp");
                rd.include(request, response);
            }
        } else {
            out.println("you do not have account plz signup first");
            out.println("<br><br><a href= 'CustomerSignup.html'>Sign Up</a>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
