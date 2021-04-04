package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.model.dao.DeliveryHistoryDao;
import com.example.transportationProject.model.entity.DeliveryHistory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TakeMoreOrderServlet")
public class TakeMoreOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        HttpSession session= request.getSession(false);
        if (session!=null){
            DeliveryHistoryDao dao=new DeliveryHistoryDao();
            List<DeliveryHistory> list=dao.findRegisteredHistory();
            request.setAttribute("histories",list);
            request.getRequestDispatcher("/TakeMoreOrder.jsp").forward(request,response);
            //تاریخ فعلی سیستم
            Date date=new Date();



        }else{
            out.println("You should login first");
            request.getRequestDispatcher("EmployeeLogin.html").include(request,response);
        }

    }
}
