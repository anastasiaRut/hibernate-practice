package com.it.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "types")
public class TypeOfCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "time_type")
    private String timeType;

    @Column
    private BigDecimal cost;

    @OneToMany(mappedBy = "typeOfCourse")
    private Set<Course> courses;

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public TypeOfCourse() {

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

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost( BigDecimal cost) {
        this.cost = cost;
    }
}
