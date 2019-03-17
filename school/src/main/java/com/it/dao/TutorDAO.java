package com.it.dao;

import com.it.model.Tutor;

import java.util.List;

public interface TutorDAO extends GenericDAO<Tutor, Long> {

    List<Tutor> findTutorsByLanguage(String language, Integer firstResult, Integer maxResult);

}