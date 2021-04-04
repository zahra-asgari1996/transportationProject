package com.example.transportationProject.filters;

import com.example.transportationProject.model.dao.CustomerDoa;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "emailAndUserNameFilter")
public class emailAndUserNameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        CustomerDoa customerDoa = new CustomerDoa();
        if (!customerDoa.findByUserName(userName)) {
            if (!customerDoa.findByEmail(email)) {
                chain.doFilter(req, resp);
            } else {
                out.println("email is duplicated ");
                RequestDispatcher rd = req.getRequestDispatcher("CustomerSignup.html");
                rd.include(req, resp);
            }

        } else {
            out.println("user name is duplicated ");
            RequestDispatcher rd = req.getRequestDispatcher("CustomerSignup.html");
            rd.include(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
