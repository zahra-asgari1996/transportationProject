package com.example.transportationProject.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutEmployeeServlet")
public class LogoutEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session= request.getSession(false);
        if(session!=null){
            session.invalidate();
            out.println("You Log out Successfully ");
            RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }else{
            //شما لاگین نیستی برو صفحه لاگین
            out.println("You should login first");
            RequestDispatcher rd= request.getRequestDispatcher("EmployeeLogin.html");
            rd.include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
