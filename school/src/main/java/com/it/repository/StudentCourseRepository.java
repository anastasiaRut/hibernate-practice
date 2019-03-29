package com.it.repository;

import com.it.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    @Query("FROM StudentCourse studentCourse WHERE studentCourse.status = false")
    List<StudentCourse> findUnacceptedApplications();

}
