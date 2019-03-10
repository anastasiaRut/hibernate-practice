package com.it.app;

import com.it.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.toString());
        }
    }
}
