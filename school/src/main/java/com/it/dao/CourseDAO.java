package com.it.dao;

import com.it.model.Course;

import java.util.List;

public interface CourseDAO extends GenericDAO<Course, Long> {

    List<Course> findCoursesByLanguage(String language, Integer firstResult, Integer maxResult);

    List<Course> sortCoursesByFreePlaces(Integer firstResult, Integer maxResult);
}
