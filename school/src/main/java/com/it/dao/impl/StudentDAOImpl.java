package com.it.dao.impl;

import com.it.dao.StudentCourseDAO;
import com.it.dao.StudentDAO;
import com.it.model.Course;
import com.it.model.Student;
import com.it.model.StudentCourse;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl extends GenericDAOImpl<Student, Long> implements StudentDAO {
    private static StudentDAOImpl instance;

    private StudentDAOImpl() {
        super(Student.class);
    }

    synchronized public static StudentDAOImpl getInstance() {
        if (instance == null) {
            instance = new StudentDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Students
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Student>
     */
    @Override
    public List<Student> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Student";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find Student by phone number
     * HQL implementation
     *
     * @param phoneNumber - phone number
     * @return Student
     */
    @Override
    public Student findByPhoneNumber(String phoneNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Student student WHERE student.phoneNumber = :number";
            Query query = session.createQuery(hql);
            query.setParameter("number", phoneNumber);
            return (Student) query.getSingleResult();
        }
    }

    /**
     * Create and Insert StudentCourse object
     *
     * @param course   - Course
     * @param student  - Student
     * @param instance - StudentCourseDAO instance
     * @return true if course have free places
     */
    @Override
    public boolean enrolIInCourse(Course course, Student student, StudentCourseDAO instance) {
        if (course.getPlaces() == 0) {
            return false;
        }
        StudentCourse studentCourse = instance.getOne(1L);
        if (studentCourse == null) {
            studentCourse = new StudentCourse();
            studentCourse.setCourse(course);
            studentCourse.setStudent(student);
            studentCourse.setStatus(false);
            instance.save(studentCourse);
        }
        return true;
    }
}
