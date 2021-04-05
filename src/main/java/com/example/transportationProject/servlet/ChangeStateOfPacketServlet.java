package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.service.DeliveryHistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangeStateOfPacketServlet")
public class ChangeStateOfPacketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        String state=request.getParameter("check");
        int number=Integer.valueOf(request.getParameter("number"));
        String des=request.getParameter("des");
        HttpSession session= request.getSession(false);
        DeliveryHistoryService service=new DeliveryHistoryService();
        if (session!=null){
            String userName= (String) session.getAttribute("userName");
            if (des!=null){
                service.saveNewDeliveryHistoryByEmployee(number,userName,des, StateOfPacket.valueOf(state));
            }else{
                service.saveNewDeliveryHistoryByEmployee(number,userName,StateOfPacket.valueOf(state));
            }
            request.getRequestDispatcher("/EmployeePage.jsp").forward(request,response);

        }else{
            out.println("you should login first");
            request.getRequestDispatcher("EmployeeLogin.html").include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
