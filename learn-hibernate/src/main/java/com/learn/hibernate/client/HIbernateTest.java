package com.learn.hibernate.client;

import com.learn.hibernate.dto.UserDetailsFieldAccess;
import com.learn.hibernate.dto.UserDetailsGetterAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HIbernateTest {
    public static void main(String[] args) {
        UserDetailsFieldAccess userDetailsFieldAccess = new UserDetailsFieldAccess();
        userDetailsFieldAccess.setUserId(1);
        userDetailsFieldAccess.setUserName("First User");
        userDetailsFieldAccess.setUserMail("mail1@mail.com");

        UserDetailsGetterAccess userDetailsGetterAccess = new UserDetailsGetterAccess();
        userDetailsGetterAccess.setUserId(2);
        userDetailsGetterAccess.setUserName("Second User");
        userDetailsGetterAccess.setUserMail("mail2@mail.com");
        Transaction tx = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(userDetailsFieldAccess);
            session.save(userDetailsGetterAccess);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Exception occurred." + ex);
            tx.rollback();
        }
    }
}
