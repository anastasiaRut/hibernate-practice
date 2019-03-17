package com.it.model;

import javax.persistence.*;

@Entity
@Table(name = "schedule_makers")
@PrimaryKeyJoinColumn(name = "user_id")
public class ScheduleMaker extends User {

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
