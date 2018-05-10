package com.practise.hibernate.data;

import com.practise.hibernate.data.entities.TimeTest;
import com.practise.hibernate.data.entities.User;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by pratik on 10-05-2018.
 */
public class TimeStampApplication {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();

            TimeTest test = new TimeTest(new Date());
//            session.save(test);
//            session.getTransaction().commit();

//            session.refresh(test);

            System.out.println(test.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }

}
