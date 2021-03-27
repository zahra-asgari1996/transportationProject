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

@WebServlet(name = "SignInCustomerServlet")
public class SignInCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        if (userName=="" || pass==""){
            out.println("plz fill username and  pass");
            RequestDispatcher rd = request.getRequestDispatcher("CustomerSignIn.html");
            rd.include(request, response);
        }else {
            CustomerDoa customerDoa = new CustomerDoa();
            Customer customer = customerDoa.findCustomer(userName);
            if (customer != null) {
                if (customer.getPassword().equals(pass)) {
                    out.println("welcome"+" "+ userName);
                    out.println("<br><br><a href= 'NewPacket.html'>New Delivery</a>");


                } else {
                    out.println("your password is incorrect ");
                    RequestDispatcher rd = request.getRequestDispatcher("sCustomerSignIn.html");
                    rd.include(request, response);
                }
            } else {
                out.println("you do not have account plz signup first or user name and pass is incorrect");
                out.println("<br><br><a href= 'CustomerSignup.html'>Sign Up</a>");
                RequestDispatcher rd = request.getRequestDispatcher("CustomerSignIn.html");
                rd.include(request, response);

            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
