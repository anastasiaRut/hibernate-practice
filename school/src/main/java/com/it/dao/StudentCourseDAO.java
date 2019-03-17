package com.it.dao;

import com.it.model.StudentCourse;

import java.util.List;

public interface StudentCourseDAO extends GenericDAO<StudentCourse, Long> {

    List<StudentCourse> findUnacceptedApplications(Integer firstResult, Integer maxResult);

}
