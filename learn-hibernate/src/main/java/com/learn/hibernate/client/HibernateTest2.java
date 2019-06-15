package com.learn.hibernate.client;

import com.learn.hibernate.dto.Address;
import com.learn.hibernate.dto.UserDetails;
import com.learn.hibernate.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest2 {
    public static void main(String[] args) {

        UserDetails1 userDetails = new UserDetails1();
        userDetails.setUserId(1);
        userDetails.setUserName("Name1");
        Address homeAddress = new Address();
        homeAddress.setCity("HomeCity1");
        homeAddress.setPincode("HomePincode1");
        homeAddress.setState("HomeState1");
        homeAddress.setStreet("HomeStreet1");
        userDetails.getListOfAddresses().add(homeAddress);
        homeAddress = new Address();
        homeAddress.setCity("HomeCity2");
        homeAddress.setPincode("HomePincode2");
        homeAddress.setState("HomeState2");
        homeAddress.setStreet("HomeStreet2");
        userDetails.getListOfAddresses().add(homeAddress);
        homeAddress = new Address();
        homeAddress.setCity("HomeCity3");
        homeAddress.setPincode("HomePincode3");
        homeAddress.setState("HomeState3");
        homeAddress.setStreet("HomeStreet3");
        userDetails.getListOfAddresses().add(homeAddress);

        Transaction tx = null;
        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(userDetails);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Exception occurred." + ex);
            tx.rollback();
        } finally {
            session.close();
        }
    }
}
