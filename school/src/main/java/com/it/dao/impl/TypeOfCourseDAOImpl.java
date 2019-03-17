package com.it.dao.impl;

import com.it.dao.TypeOfCourseDAO;
import com.it.model.TypeOfCourse;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TypeOfCourseDAOImpl extends GenericDAOImpl<TypeOfCourse, Long> implements TypeOfCourseDAO {
    private static TypeOfCourseDAOImpl instance;

    private TypeOfCourseDAOImpl() {
        super(TypeOfCourse.class);
    }

    synchronized public static TypeOfCourseDAOImpl getInstance() {
        if (instance == null) {
            instance = new TypeOfCourseDAOImpl();
        }
        return instance;
    }

    /**
     * Find TypeOfCourse by name
     *
     * @param name - name of type
     * @return TypeOfCourse
     */
    @Override
    public TypeOfCourse findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM TypeOfCourse typeOfCourse WHERE typeOfCourse.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            return (TypeOfCourse) query.getSingleResult();
        }
    }

    /**
     * Find page of All TypesOfCourses
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<TypeOfCourse>
     */
    @Override
    public List<TypeOfCourse> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM TypeOfCourse";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
