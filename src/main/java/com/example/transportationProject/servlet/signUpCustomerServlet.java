package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.Gender;
import com.example.transportationProject.model.entity.Address;
import com.example.transportationProject.model.entity.Customer;
import com.example.transportationProject.model.dao.AddressDao;
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

@WebServlet(name = "signUpCustomerServlet")
public class signUpCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userName=request.getParameter("userName");
        String pass=request.getParameter("pass");
        String name=request.getParameter("name");
        String lname=request.getParameter("lname");
        String email=request.getParameter("email");
        long phone=Integer.valueOf(request.getParameter("phone"));
        Gender gender=Gender.valueOf(request.getParameter("gender"));
        String province=request.getParameter("province");
        String city=request.getParameter("city");
        String str=request.getParameter("address");
        Address address=new Address(province,city,str);
        AddressDao addressDao=new AddressDao();
        addressDao.saveNewAddress(address);
        Customer customer=new Customer(userName,pass,name,lname,email,address,phone,gender);
        CustomerDoa customerDoa=new CustomerDoa();
        customerDoa.saveNewCustomer(customer);
        PrintWriter out = response.getWriter();
        out.println("welcome"+" "+ userName);
        HttpSession session= request.getSession(false);
        if (session!=null){
            out.println("<br><br><a href= 'NewPacket.html'>New Delivery</a>");
            out.println("<br><br><a href= 'OrderTrackingNumber.html'>Track Order</a>");
        }else{
            out.println("You Should Login First");
            RequestDispatcher rd=request.getRequestDispatcher("CustomerSignIn.html");
            rd.include(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
