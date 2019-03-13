package com.it.dao.impl;

import com.it.dao.CourseDAO;
import com.it.model.Course;

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
}
