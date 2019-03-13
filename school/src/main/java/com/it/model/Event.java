package com.it.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal cost;

    @Column
    private Integer places;

    @ManyToOne
    @JoinColumn(name = "tutor_level_id", nullable = false)
    private TutorLevel tutorLevel;

    @OneToMany(mappedBy = "event")
    private Set<StudentEvent> studentEvents;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public TutorLevel getTutorLevel() {
        return tutorLevel;
    }

    public void setTutorLevel(TutorLevel tutorLevel) {
        this.tutorLevel = tutorLevel;
    }

    public Set<StudentEvent> getStudentEvents() {
        return studentEvents;
    }

    public void setStudentEvents(Set<StudentEvent> studentEvents) {
        this.studentEvents = studentEvents;
    }
}
