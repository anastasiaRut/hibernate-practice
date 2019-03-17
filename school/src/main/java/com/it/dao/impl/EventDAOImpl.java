package com.it.dao.impl;

import com.it.dao.EventDAO;
import com.it.model.Event;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EventDAOImpl extends GenericDAOImpl<Event, Long> implements EventDAO {
    private static EventDAOImpl instance;

    private EventDAOImpl() {
        super(Event.class);
    }

    synchronized public static EventDAOImpl getInstance() {
        if (instance == null) {
            instance = new EventDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Events
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Event>
     */
    @Override
    public List<Event> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Event";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Sort Events by cost
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Event>
     */
    @Override
    public List<Event> sortEventsByCost(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Event event order by event.cost desc";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find page of All Events and fetching Students
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Event>
     */
    @Override
    public List<Event> findEventsWithStudents(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Event event JOIN FETCH event.students";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
