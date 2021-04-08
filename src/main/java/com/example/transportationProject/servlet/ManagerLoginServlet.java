package com.example.transportationProject.servlet;

import com.example.transportationProject.model.entity.Manager;
import com.example.transportationProject.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String pass = request.getParameter("password");
        ManagerService managerService=new ManagerService();
        Manager manager= managerService.returnManager(userName);
        if (manager!=null){
            if (manager.getPassword().equalsIgnoreCase(pass)){
                HttpSession httpSession= request.getSession(true);
                httpSession.setAttribute("userName",userName);
                httpSession.setAttribute("password",pass);
                request.getRequestDispatcher("/ManagerPage.jsp").forward(request,response);
            }else{
                out.println("Your password is incorrect please try again");
                request.getRequestDispatcher("ManagerLogin.html").include(request,response);
            }
        }else{
            out.println("Your account not found please try again");
            request.getRequestDispatcher("ManagerLogin.html").include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
