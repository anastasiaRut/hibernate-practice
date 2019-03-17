package com.it.dao;

import com.it.model.Language;

import java.util.List;

public interface LanguageDAO extends GenericDAO<Language, Long> {

    Language findLanguageWithTutors(String language);

    List<Language> findAllWithTutors(Integer firstResult, Integer maxResult);
}
