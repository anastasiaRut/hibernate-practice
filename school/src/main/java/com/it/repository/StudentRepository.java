package com.it.repository;

import com.it.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByPhoneNumber(String phoneNumber);
}
