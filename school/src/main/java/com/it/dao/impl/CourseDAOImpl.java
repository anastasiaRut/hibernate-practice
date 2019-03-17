package com.it.dao.impl;

import com.it.dao.CourseDAO;
import com.it.model.Course;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDAOImpl extends GenericDAOImpl<Course, Long> implements CourseDAO {
    private static CourseDAOImpl instance;

    private CourseDAOImpl() {
        super(Course.class);
    }

    synchronized public static CourseDAOImpl getInstance() {
        if (instance == null) {
            instance = new CourseDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Courses
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Course>
     */
    @Override
    public List<Course> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Course";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find Courses by Language
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Course>
     */
    @Override
    public List<Course> findCoursesByLanguage(String language, Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Course course WHERE course.language.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", language);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Sort Courses by free places
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Course>
     */
    @Override
    public List<Course> sortCoursesByFreePlaces(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Course course order by course.places desc";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
