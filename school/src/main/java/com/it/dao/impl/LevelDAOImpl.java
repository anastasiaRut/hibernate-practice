package com.it.dao.impl;

import com.it.dao.LevelDAO;
import com.it.model.Level;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LevelDAOImpl extends GenericDAOImpl<Level, Long> implements LevelDAO {
    private static LevelDAOImpl instance;

    private LevelDAOImpl() {
        super(Level.class);
    }

    synchronized public static LevelDAOImpl getInstance() {
        if (instance == null) {
            instance = new LevelDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Levels
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Level>
     */
    @Override
    public List<Level> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Level";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
