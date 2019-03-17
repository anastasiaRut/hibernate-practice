package com.it.dao;

import com.it.model.Course;
import com.it.model.Student;

public interface StudentDAO extends GenericDAO<Student, Long> {
    Student findByPhoneNumber(String phoneNumber);

    boolean enrolIInCourse(Course course, Student student, StudentCourseDAO instance);
}
