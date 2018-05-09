package com.practise.hibernate.data;

import org.hibernate.Session;

/**
 * Created by pratik on 08-05-2018.
 */
public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
    }
}