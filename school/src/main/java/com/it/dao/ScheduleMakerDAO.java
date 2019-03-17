package com.it.dao;

import com.it.model.ScheduleMaker;

import java.util.List;

public interface ScheduleMakerDAO extends GenericDAO<ScheduleMaker, Long> {

    List<ScheduleMaker> findListByLanguage(String language, Integer firstResult, Integer maxResult);
}
