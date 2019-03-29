package com.it.repository;

import com.it.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("FROM Course course WHERE course.language.name = :name")
    List<Course> findCoursesByLanguage(@Param("name") String language);

    @Query("FROM Course course order by course.places desc")
    List<Course> sortCoursesByFreePlaces();

}
