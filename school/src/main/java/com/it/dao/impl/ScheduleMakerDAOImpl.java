package com.it.dao.impl;

import com.it.dao.ScheduleMakerDAO;
import com.it.model.ScheduleMaker;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ScheduleMakerDAOImpl extends GenericDAOImpl<ScheduleMaker, Long> implements ScheduleMakerDAO {
    private static ScheduleMakerDAOImpl instance;

    private ScheduleMakerDAOImpl() {
        super(ScheduleMaker.class);
    }

    synchronized public static ScheduleMakerDAOImpl getInstance() {
        if (instance == null) {
            instance = new ScheduleMakerDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Schedule Makers
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<ScheduleMaker>
     */
    @Override
    public List<ScheduleMaker> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM ScheduleMaker";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find Schedule Makers by Language
     *
     * @param language    - language
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<ScheduleMaker>
     */
    @Override
    public List<ScheduleMaker> findListByLanguage(String language, Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM ScheduleMaker scheduleMaker WHERE scheduleMaker.language.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", language);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
