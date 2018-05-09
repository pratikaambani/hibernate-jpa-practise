package com.practise.hibernate.data;

import com.practise.hibernate.data.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by pratik on 08-05-2018.
 */
public class HibernateUtil {

    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            //Holds all hibernate specific properties
            //Holds all mapping information
            Configuration configuration = new Configuration();
//          configuration.addAnnotatedClass(User.class);
            return configuration
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory(new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while building Factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
