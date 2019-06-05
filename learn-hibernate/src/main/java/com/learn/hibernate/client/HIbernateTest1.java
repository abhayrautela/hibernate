package com.learn.hibernate.client;

import com.learn.hibernate.dto.UserDetails;
import com.learn.hibernate.dto.UserDetailsFieldAccess;
import com.learn.hibernate.dto.UserDetailsGetterAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HIbernateTest1 {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
        userDetails.setUserName("First User");
        userDetails.setAddress("First user address");
        userDetails.setDescription("First user description");
        userDetails.setJoinedDate(new Date());

        Transaction tx = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(userDetails);
            session.save(userDetails);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Exception occurred." + ex);
            tx.rollback();
        }
    }
}
