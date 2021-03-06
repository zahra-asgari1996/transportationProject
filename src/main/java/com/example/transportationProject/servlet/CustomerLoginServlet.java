package com.example.transportationProject.servlet;

import com.example.transportationProject.model.entity.Customer;
import com.example.transportationProject.model.dao.CustomerDoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        if (userName == "" || pass == "") {
            out.println("plz fill username and  pass");
            RequestDispatcher rd = request.getRequestDispatcher("CustomerLogin.html");
            rd.include(request, response);
        } else {
            CustomerDoa customerDoa = new CustomerDoa();
            Customer customer = customerDoa.findCustomer(userName);
            if (customer != null) {
                if (customer.getPassword().equals(pass)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userName", userName);
                    session.setAttribute("pass", pass);
                    out.println("welcome" + " " + userName);
                    //include a jsp file to print links
                    out.println("<br><br><a href= 'NewPacket.html'>New Delivery</a>");
                    out.println("<br><br><a href= 'OrderTrackingNumber.html'>Track Order</a>");
                    out.println("<br><br><a href= 'logout'>Log out</a>");


                } else {
                    out.println("your password is incorrect ");
                    RequestDispatcher rd = request.getRequestDispatcher("CustomerLogin.html");
                    rd.include(request, response);
                }
            } else {
                out.println("you do not have account plz signup first or user name and pass is incorrect");
                out.println("<br><br><a href= 'CustomerSignup.html'>Sign Up</a>");
                out.println("<br><br><a href= 'CustomerLogin.html'>Sign In</a>");

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
