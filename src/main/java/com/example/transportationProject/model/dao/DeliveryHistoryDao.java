package com.example.transportationProject.model.dao;

import com.example.transportationProject.enums.StateOfPacket;
import com.example.transportationProject.model.entity.DeliveryHistory;
import com.example.transportationProject.model.entity.NewPacket;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DeliveryHistoryDao {
    private SessionFactory sessionFactory = HibernateUtil.sessionFactory;

    public List<DeliveryHistory> showInformation(int orderCode) {
        Session session = sessionFactory.openSession();
        List<DeliveryHistory> list = session.createQuery("from DeliveryHistory d where d.packet.id=:order")
                .setParameter("order", orderCode)
                .list();
        session.close();
        return list;
    }

    public void saveNewHistory(DeliveryHistory delivery) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(delivery);
        session.getTransaction().commit();
        session.close();
    }

    public DeliveryHistory findPacket(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from DeliveryHistory as d where d.packet.id=:id ")
                .setParameter("id", id);
        DeliveryHistory deliveryHistory= (DeliveryHistory) query.getSingleResult();
        session.close();
        return deliveryHistory;

    }

    public List<DeliveryHistory> findRegisteredHistory() {
        Session session = sessionFactory.openSession();
        List<DeliveryHistory> list = session.createQuery("from DeliveryHistory as d where d.state=:state ")
                .setParameter("state", StateOfPacket.registered)
                .list();
        session.close();
        return list;
    }

    public List<DeliveryHistory> findAcceptedPackets(int id) {
        Session session = sessionFactory.openSession();
        List<DeliveryHistory> list = session.createQuery("from DeliveryHistory as d  where d.employee.id=:id ")
                .setParameter("id",id)
                .list();
        session.close();
        return list;
    }


}
