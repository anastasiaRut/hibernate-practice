package com.it.dao;

import com.it.model.TypeOfCourse;

import java.util.List;

public interface TypeOfCourseDAO extends GenericDAO<TypeOfCourse, Long> {

    List<TypeOfCourse> findAll(Integer firstResult, Integer maxResult);

    TypeOfCourse findByName(String name);
}