package com.example.transportationProject.servlet;

import com.example.transportationProject.model.entity.Employee;
import com.example.transportationProject.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String pass = request.getParameter("password");
        EmployeeService employeeService=new EmployeeService();
        //بیا اینجا پسورد رو توی لایه سرویس باید چک کنی
        Employee employee=employeeService.returnEmployee(userName);
       if (employee!=null){
           if (employee.getPassword().equalsIgnoreCase(pass)){
               HttpSession httpSession= request.getSession(true);
               httpSession.setAttribute("userName",userName);
               httpSession.setAttribute("password",pass);
               request.getRequestDispatcher("EmployeePage.jsp").forward(request,response);
           }


       }else {
           out.println("your account not found please try again");
           request.getRequestDispatcher("EmployeeLogin.html").include(request,response);
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
