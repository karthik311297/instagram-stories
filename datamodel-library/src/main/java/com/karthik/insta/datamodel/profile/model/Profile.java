package com.karthik.insta.datamodel.profile.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "userprofile", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(columnDefinition = "TEXT")
    private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) && Objects.equals(username, profile.username) && Objects.equals(summary, profile.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, summary);
    }
}
