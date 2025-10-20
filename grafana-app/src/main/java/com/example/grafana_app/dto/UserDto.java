package com.example.grafana_app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserDto {
    private Long id;
    private String username;
    private String userMail;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userMail='" + userMail + '\'' +
                '}';
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

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

}
