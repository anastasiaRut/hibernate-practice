package com.it.dao;

import com.it.model.Event;

import java.util.List;

public interface EventDAO extends GenericDAO<Event, Long> {

    List<Event> sortEventsByCost(Integer firstResult, Integer maxResult);

    List<Event> findEventsWithStudents(Integer firstResult, Integer maxResult);


}
