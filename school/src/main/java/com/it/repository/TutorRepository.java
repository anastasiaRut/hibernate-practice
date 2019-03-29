package com.it.repository;

import com.it.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    @Query("FROM Tutor tutor WHERE tutor.language.name = :name")
    List<Tutor> findTutorsByLanguage(@Param("name") String language);

}