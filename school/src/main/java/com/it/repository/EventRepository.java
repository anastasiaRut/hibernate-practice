package com.it.repository;

import com.it.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("FROM Event event order by event.cost desc")
    List<Event> sortEventsByCost(Integer firstResult, Integer maxResult);

    @Query("FROM Event event JOIN FETCH event.students")
    List<Event> findEventsWithStudents(Integer firstResult, Integer maxResult);


}
