package com.example.transportationProject.servlet;

import com.example.transportationProject.enums.Content;
import com.example.transportationProject.enums.TypeOfDelivery;
import com.example.transportationProject.enums.TypeOfPacket;
import com.example.transportationProject.model.Address;
import com.example.transportationProject.model.NewPacket;
import com.example.transportationProject.service.NewPacketDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveNewPacketServlet")
public class SaveNewPacketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String oProvince=request.getParameter("Oprovince");
        String oCity=request.getParameter("Ocity");
        String oAddress=request.getParameter("Oaddress");
        Address origin=new Address(oProvince,oCity,oAddress);
        String dProvince=request.getParameter("Dprovince");
        String dCity=request.getParameter("Dcity");
        String dAddress=request.getParameter("Daddress");
        Address destination=new Address(dProvince,dCity,dAddress);
        String name=request.getParameter("name");
        long phone=Integer.valueOf(request.getParameter("phone"));
        int weight=Integer.valueOf(request.getParameter("weight"));
        TypeOfPacket doc= TypeOfPacket.valueOf(request.getParameter("doc"));

        TypeOfDelivery price= TypeOfDelivery.valueOf( request.getParameter("price"));
        if(doc==TypeOfPacket.doc){
            NewPacket newPacket=new NewPacket(origin,destination,name,phone,price,weight,doc);
            NewPacketDao newPacketDao=new NewPacketDao();
            newPacketDao.saveNewPacket(newPacket);
        }else{
            Content content=Content.valueOf(request.getParameter("content"));
            double height=Integer.parseInt(request.getParameter("height"));
            double width=Integer.parseInt(request.getParameter("width"));
            double length=Integer.parseInt(request.getParameter("length"));
            NewPacket newPacket=new NewPacket(origin,destination,name,phone,price,weight,content,height,width,length,doc);
            NewPacketDao newPacketDao=new NewPacketDao();
            newPacketDao.saveNewPacket(newPacket);
        }
    }
}
