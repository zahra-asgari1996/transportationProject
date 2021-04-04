package com.example.transportationProject.servlet;

import com.example.transportationProject.model.dao.DeliveryHistoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderTrackingServlet")
public class OrderTrackingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession(false);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (session!=null){
            String userName= (String) session.getAttribute("userName");
            out.println("welcome"+" "+userName);
            int number=Integer.valueOf(request.getParameter("order"));
            DeliveryHistoryDao deliveryHistoryDao=new DeliveryHistoryDao();
            if (deliveryHistoryDao.findPacket(number)==null){
                out.println("The order was not available!");
                out.println("<br><br><a href= 'OrderTrackingNumber.html'>Track Order</a>");
                out.println("<br><br><a href= 'index.jsp'>First page</a>");

            }else{
                out.println(deliveryHistoryDao.showInformation(number).toString());
                out.println("<br><br><a href= 'logout'>Log out</a><br>");
            }
        }else{
            out.println("Please Sign in or sign up first !");
            out.println("<br><br><a href= 'CustomerSignup.html'>Sign Up</a>");
            out.println("<br><br><a href= 'CustomerSignIn.html'>Sign In</a>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
