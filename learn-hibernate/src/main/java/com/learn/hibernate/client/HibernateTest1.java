package com.learn.hibernate.client;

import com.learn.hibernate.dto.Address;
import com.learn.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest1 {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        //userDetails.setUserId(1);
        userDetails.setUserName("First User");
        userDetails.setAddressString("First user address");
        userDetails.setDescription("First user description");
        userDetails.setJoinedDate(new Date());
        userDetails.setLargeString("Some large first string");
        Address homeAddress1 = new Address();
        homeAddress1.setCity("HomeCity1");
        homeAddress1.setPincode("HomePincode1");
        homeAddress1.setState("HomeState1");
        homeAddress1.setStreet("HomeStreet1");
        userDetails.setHomeAddress(homeAddress1);
        Address officeAddress1 = new Address();
        officeAddress1.setCity("OfficeCity1");
        officeAddress1.setPincode("OfficePincode1");
        officeAddress1.setState("OfficeState1");
        officeAddress1.setStreet("OfficeStreet1");
        userDetails.setOfficeAddress(officeAddress1);

        UserDetails userDetails1 = new UserDetails();
        //userDetails1.setUserId(2);
        userDetails1.setUserName("Second User");
        userDetails1.setAddressString("Second user address");
        userDetails1.setDescription("Second user description");
        userDetails1.setJoinedDate(new Date());
        userDetails1.setLargeString("Some large second string");
        Address homeAddress2 = new Address();
        homeAddress2.setCity("HomeCity2");
        homeAddress2.setPincode("HomePincode2");
        homeAddress2.setState("HomeState2");
        homeAddress2.setStreet("HomeStreet2");
        userDetails1.setHomeAddress(homeAddress2);
        Address officeAddress2 = new Address();
        officeAddress2.setCity("OfficeCity2");
        officeAddress2.setPincode("OfficePincode2");
        officeAddress2.setState("OfficeState2");
        officeAddress2.setStreet("OfficeStreet2");
        userDetails1.setOfficeAddress(officeAddress2);

        Transaction tx = null;
        Session session = null;
        Transaction tx1 = null;
        Session session1 = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(userDetails);
            session.save(userDetails1);
            tx.commit();

            userDetails = null;
            session1 = sessionFactory.openSession();
            tx1 = session1.beginTransaction();
            userDetails = session1.get(UserDetails.class, 1);
            System.out.println(userDetails);
        } catch (Exception ex) {
            System.out.println("Exception occurred." + ex);
            tx.rollback();
            tx1.rollback();
        } finally {
            session.close();
            session1.close();
        }
    }
}
