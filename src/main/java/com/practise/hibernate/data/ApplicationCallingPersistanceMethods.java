package com.practise.hibernate.data;

import com.practise.hibernate.data.entities.User;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by pratik on 09-05-2018.
 */
public class ApplicationCallingPersistanceMethods {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("Developer");
        user.setCreatedDate(new Date());
        user.setEmailAddress("send@sender.sending");
        user.setFirstName("Sachin");
        user.setLastName("Tendulkar");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Pratik");

        session.save(user);

        //ensures above things are written to database
        session.getTransaction().commit();
        session.close();
    }
}


