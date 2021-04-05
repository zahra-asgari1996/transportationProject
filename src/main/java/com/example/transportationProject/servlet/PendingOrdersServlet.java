package com.example.transportationProject.servlet;

import com.example.transportationProject.model.dao.DeliveryHistoryDao;
import com.example.transportationProject.model.entity.DeliveryHistory;
import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PendingOrdersServlet")
public class PendingOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        PrintWriter out= response.getWriter();
        if (session!=null){
            String username= (String) session.getAttribute("userName");
            EmployeeService service=new EmployeeService();
            Employee employee= service.returnEmployee(username);
            DeliveryHistoryDao dao=new DeliveryHistoryDao();
            List<DeliveryHistory> list=dao.findAcceptedPackets(employee.getId());
            request.setAttribute("list",list);
            request.getRequestDispatcher("/PendingOrder.jsp").forward(request,response);
        }else {
            out.println("You should login first");
            request.getRequestDispatcher("EmployeeLogin.html").include(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
