package com.it.repository;

import com.it.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Query("FROM Language language JOIN FETCH language.tutors WHERE language.name = :name")
    Language findLanguageWithTutors( @Param("name") String language);

    @Query("FROM Language language JOIN FETCH language.tutors")
    List<Language> findAllWithTutors();
}
