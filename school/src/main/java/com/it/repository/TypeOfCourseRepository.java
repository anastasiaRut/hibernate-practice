package com.it.repository;

import com.it.model.TypeOfCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfCourseRepository extends JpaRepository<TypeOfCourse, Long> {

    TypeOfCourse findByName(String name);
}