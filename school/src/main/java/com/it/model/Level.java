package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "level")
    private Set<TutorLevel> tutorLevels;

    public Level() {
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

    public Set<TutorLevel> getTutorLevels() {
        return tutorLevels;
    }

    public void setTutorLevels(Set<TutorLevel> tutorLevels) {
        this.tutorLevels = tutorLevels;
    }
}
