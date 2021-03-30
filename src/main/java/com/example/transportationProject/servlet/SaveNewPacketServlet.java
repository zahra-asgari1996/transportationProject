package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.Content;
import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.enums.TypeOfDelivery;
import com.example.transportationProject.enums.TypeOfPacket;
import com.example.transportationProject.model.Address;
import com.example.transportationProject.model.Customer;
import com.example.transportationProject.model.DeliveryHistory;
import com.example.transportationProject.model.NewPacket;
import com.example.transportationProject.service.AddressDao;
import com.example.transportationProject.service.CustomerDoa;
import com.example.transportationProject.service.DeliveryHistoryDao;
import com.example.transportationProject.service.NewPacketDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveNewPacketServlet")
public class SaveNewPacketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        AddressDao addressDao=new AddressDao();
        String oProvince=request.getParameter("Oprovince");
        String oCity=request.getParameter("Ocity");
        String oAddress=request.getParameter("Oaddress");
        Address origin=new Address(oProvince,oCity,oAddress);
        addressDao.saveNewAddress(origin);
        String dProvince=request.getParameter("Dprovince");
        String dCity=request.getParameter("Dcity");
        String dAddress=request.getParameter("Daddress");
        Address destination=new Address(dProvince,dCity,dAddress);
        addressDao.saveNewAddress(destination);
        String name=request.getParameter("name");
        long phone=Integer.valueOf(request.getParameter("phone"));
        int weight=Integer.valueOf(request.getParameter("weight"));
        TypeOfPacket doc= TypeOfPacket.valueOf(request.getParameter("doc"));
        TypeOfDelivery price= TypeOfDelivery.valueOf( request.getParameter("price"));
        HttpSession session=request.getSession(false);
        if (session!=null) {
            String userName= (String) session.getAttribute("userName");
            out.println("welcome" +" "+ userName );
            CustomerDoa customerDoa=new CustomerDoa();
            Customer customer= customerDoa.findCustomer(userName);
            if (doc == TypeOfPacket.doc) {
                NewPacket newPacket = new NewPacket(origin, destination, name, phone, price, weight, doc,customer);
                NewPacketDao newPacketDao = new NewPacketDao();
                newPacketDao.saveNewPacket(newPacket);
                DeliveryHistory deliveryHistory=new DeliveryHistory(StateOfPacket.registered,newPacket);
                DeliveryHistoryDao deliveryHistoryDao=new DeliveryHistoryDao();
                deliveryHistoryDao.saveNewHistory(deliveryHistory);
                out.println(newPacketDao.returnReserveCode());
            } else {
                Content content = Content.valueOf(request.getParameter("content"));
                double height = Integer.parseInt(request.getParameter("height"));
                double width = Integer.parseInt(request.getParameter("width"));
                double length = Integer.parseInt(request.getParameter("length"));
                NewPacket newPacket = new NewPacket(origin, destination, name, phone, price, weight, content, height, width, length, doc,customer);
                NewPacketDao newPacketDao = new NewPacketDao();
                newPacketDao.saveNewPacket(newPacket);
                DeliveryHistory deliveryHistory=new DeliveryHistory(StateOfPacket.registered,newPacket);
                DeliveryHistoryDao deliveryHistoryDao=new DeliveryHistoryDao();
                deliveryHistoryDao.saveNewHistory(deliveryHistory);
                out.println(newPacketDao.returnReserveCode());
                out.println("<br><br><a href= 'index.jsp'>back to first page</a>");
            }
        }else{
            out.println("You Should Login First");
            RequestDispatcher rd=request.getRequestDispatcher("CustomerSignIn.html");
            rd.include(request,response);

        }
        out.println("<br><br><a href= 'logout'>Log out</a>");

    }


}
