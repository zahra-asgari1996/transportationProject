package com.example.transportationProject.model.dao;

import com.example.transportationProject.model.entity.DeliveryHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DeliveryHistoryDao {
    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;

    public List<DeliveryHistory> showInformation(int orderCode) {
        Session session = sessionFactory.openSession();
        List<DeliveryHistory> list = session.createQuery("from DeliveryHistory d where d.packet.id=:order")
                .setParameter("order", orderCode)
                .list();
        session.close();
        return list;
    }

    public  void saveNewHistory(DeliveryHistory delivery){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(delivery);
        session.getTransaction().commit();
        session.close();
    }

    public DeliveryHistory findPacket(int id){
        Session session= sessionFactory.openSession();
        DeliveryHistory deliveryHistory =session.get(DeliveryHistory.class,id);
        session.close();
        return deliveryHistory;

    }
}
