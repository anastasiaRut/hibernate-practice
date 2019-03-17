package com.it.dao.impl;

import com.it.dao.RoleDAO;
import com.it.model.Role;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoleDAOImpl extends GenericDAOImpl<Role, Long> implements RoleDAO {
    private static RoleDAOImpl instance;

    private RoleDAOImpl() {
        super(Role.class);
    }

    synchronized public static RoleDAOImpl getInstance() {
        if (instance == null) {
            instance = new RoleDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Roles
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Role>
     */
    @Override
    public List<Role> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Role";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find Role and fetching Users
     *
     * @param nameOfRole - nameOfRole
     * @return Role
     */
    @Override
    public Role findRoleWithUsers(String nameOfRole) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Role role JOIN FETCH role.users WHERE role.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", nameOfRole);
            return (Role) query.getSingleResult();
        }
    }

    /**
     * Find page of All Roles and fetching Users
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Role>
     */
    @Override
    public List<Role> findAllWithUsers(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Role role JOIN FETCH role.users";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
