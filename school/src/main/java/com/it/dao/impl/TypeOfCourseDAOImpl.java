package com.it.dao.impl;

import com.it.dao.TypeOfCourseDAO;
import com.it.model.TypeOfCourse;

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

}
