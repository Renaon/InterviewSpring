package com.geekbrains.Interview.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {
    private static SessionFactory sessionFactory;

    private static void buildSessionFactory() {
        try {
            Configuration conf = new Configuration();
            conf.configure();
            sessionFactory = conf.buildSessionFactory();
        }catch (Throwable t){
            System.err.println("Initial SessionFactory creation failed. " + t);
            throw new ExceptionInInitializerError(t);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) buildSessionFactory();
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
