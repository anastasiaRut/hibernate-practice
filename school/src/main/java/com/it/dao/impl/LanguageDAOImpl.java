package com.it.dao.impl;

import com.it.dao.LanguageDAO;
import com.it.model.Language;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LanguageDAOImpl extends GenericDAOImpl<Language, Long> implements LanguageDAO {
    private static LanguageDAOImpl instance;

    private LanguageDAOImpl() {
        super(Language.class);
    }

    synchronized public static LanguageDAOImpl getInstance() {
        if (instance == null) {
            instance = new LanguageDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Languages
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Language>
     */
    @Override
    public List<Language> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Language";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find Language and fetching Tutors
     *
     * @param language - language
     * @return Language
     */
    @Override
    public Language findLanguageWithTutors(String language) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Language language JOIN FETCH language.tutors WHERE language.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", language);
            return (Language) query.getSingleResult();
        }
    }

    /**
     * Find page of All Languages and fetching Tutors
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Language>
     */
    @Override
    public List<Language> findAllWithTutors(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Language language JOIN FETCH language.tutors";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
