package com.example.transportationProject.filters;

import com.example.transportationProject.model.dao.EmployeeDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "EmployeeSignUpFilter")
public class EmployeeSignUpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        EmployeeDao employeeDao =new EmployeeDao();
        if (!employeeDao.findEmployeeByUserName(userName)){
            if (!employeeDao.findEmployeeByEmail(email)){
                chain.doFilter(req, resp);
            }else {
                out.println("Email is duplicated");
                req.getRequestDispatcher("EmployeeSignUp.html").forward(req,resp);
            }
        }else {
            out.println("User name is duplicated");
            req.getRequestDispatcher("EmployeeSignUp.html").forward(req,resp);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
