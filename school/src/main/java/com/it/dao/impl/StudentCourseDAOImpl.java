package com.it.dao.impl;

import com.it.dao.StudentCourseDAO;
import com.it.model.StudentCourse;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentCourseDAOImpl extends GenericDAOImpl<StudentCourse, Long> implements StudentCourseDAO {
    private static StudentCourseDAOImpl instance;

    private StudentCourseDAOImpl() {
        super(StudentCourse.class);
    }

    synchronized public static StudentCourseDAOImpl getInstance() {
        if (instance == null) {
            instance = new StudentCourseDAOImpl();
        }
        return instance;
    }

    /**
     * Find all notes about Student and Courses
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<StudentCourse>
     */
    @Override
    public List<StudentCourse> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentCourse";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find unaccepted applications for enroll in Courses
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<StudentCourse>
     */
    @Override
    public List<StudentCourse> findUnacceptedApplications(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentCourse studentCourse WHERE studentCourse.status = false";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }
}
