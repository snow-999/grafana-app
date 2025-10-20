package com.example.grafana_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Username;
    private String UserMail;

    public String getUsername() {
        return Username;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", UserMail='" + UserMail + '\'' +
                '}';
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserMail() {
        return UserMail;
    }

    public void setUserMail(String userMail) {
        UserMail = userMail;
    }
}
