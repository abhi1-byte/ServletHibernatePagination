package com.example.util;

import com.example.model.InsurancePolicy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    private HibernateUtil() {
    }

    static {
        sessionFactory = new Configuration().configure().addAnnotatedClass(InsurancePolicy.class).buildSessionFactory();
    }

    public static Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
            System.out.println("Session closed");
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("Session Factory closed");
        }
    }
}
