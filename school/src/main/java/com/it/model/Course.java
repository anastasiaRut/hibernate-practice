package com.it.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column
    private Short places;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private TypeOfCourse typeOfCourse;

    @ManyToOne
    @JoinColumn(name = "tutor_level_id", nullable = false)
    private TutorLevel tutorLevel;

    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> studentCourses;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Short getPlaces() {
        return places;
    }

    public void setPlaces(Short places) {
        this.places = places;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public TypeOfCourse getTypeOfCourse() {
        return typeOfCourse;
    }

    public void setTypeOfCourse(TypeOfCourse typeOfCourse) {
        this.typeOfCourse = typeOfCourse;
    }


    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public TutorLevel getTutorLevel() {
        return tutorLevel;
    }

    public void setTutorLevel(TutorLevel tutorLevel) {
        this.tutorLevel = tutorLevel;
    }
}
