package com.it.dao.impl;

import com.it.dao.UserDAO;
import com.it.model.User;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
    private static UserDAOImpl instance;

    private UserDAOImpl() {
        super(User.class);
    }

    synchronized public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    /**
     * Find User by username
     *
     * @param username - username
     * @return User
     */
    @Override
    public User findByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User user WHERE user.username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        }
    }

    /**
     * Find page of All Users
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<User>
     */
    @Override
    public List<User> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
