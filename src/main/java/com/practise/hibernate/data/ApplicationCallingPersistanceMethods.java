package com.practise.hibernate.data;

import com.practise.hibernate.data.entities.User;
import org.hibernate.Session;

import java.util.Calendar;
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
        user.setBirthDate(getMyBirthday());
        user.setCreatedBy("Developer");
        user.setCreatedDate(new Date());
        user.setEmailAddress("send@sender.sending");
        user.setFirstName("Sachin");
        user.setLastName("Tendulkar");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Pratik");
        //insertion operation
        session.save(user);
        //ensures above things are written to database
        session.getTransaction().commit();

        session.refresh(user);

        System.out.println(user.getAge());

        //get operation
/*
        session.beginTransaction();
        User dbUser = (User) session.get(User.class, user.getUserId());
        dbUser.setFirstName("UnSachin");
        session.update(dbUser);
        session.getTransaction().commit();
*/

        session.close();
        HibernateUtil.getSessionFactory().close();
    }

    private static Date getMyBirthday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1991);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 7);
        return calendar.getTime();
    }
}


