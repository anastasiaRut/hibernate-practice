package com.it.dao.impl;

import com.it.dao.TutorDAO;
import com.it.model.Tutor;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TutorDAOImpl extends GenericDAOImpl<Tutor, Long> implements TutorDAO {
    private static TutorDAOImpl instance;

    private TutorDAOImpl() {
        super(Tutor.class);
    }

    synchronized public static TutorDAOImpl getInstance() {
        if (instance == null) {
            instance = new TutorDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Tutors
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Tutor>
     */
    @Override
    public List<Tutor> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Tutor";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find Tutors by language
     *
     * @param language    - language
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Tutor>
     */
    @Override
    public List<Tutor> findTutorsByLanguage(String language, Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Tutor tutor WHERE tutor.language.name = :language";
            Query query = session.createQuery(hql);
            query.setParameter("language", language);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

}
