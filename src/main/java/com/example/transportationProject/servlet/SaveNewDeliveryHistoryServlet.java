package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.model.entity.DeliveryHistory;
import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.service.DeliveryHistoryService;
import com.example.transportationProject.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveNewDeliveryHistoryServlet")
public class SaveNewDeliveryHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int number=Integer.valueOf(request.getParameter("number"));
        String description=request.getParameter("description");
        HttpSession session= request.getSession(false);
        DeliveryHistoryService service=new DeliveryHistoryService();
        if (session!=null){
            String userName= (String) session.getAttribute("userName");
            if (description!=null){
                service.saveNewDeliveryHistoryByEmployee(number,userName,description, StateOfPacket.accepted);
            }else{
                service.saveNewDeliveryHistoryByEmployee(number,userName,StateOfPacket.accepted);
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
