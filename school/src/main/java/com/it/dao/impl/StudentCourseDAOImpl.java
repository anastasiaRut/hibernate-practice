package com.it.dao.impl;

import com.it.dao.StudentCourseDAO;
import com.it.model.StudentCourse;

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
}
