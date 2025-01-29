package org.example.creatememcoin.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "token_service")
public class TokenServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameToken;
    private String username;
    private int startingCapital;
    private String description;
    private LocalDateTime date;

    public TokenServiceModel(String nameToken, String username, int startingCapital, String description, LocalDateTime date) {
        this.nameToken = nameToken;
        this.username = username;
        this.startingCapital = startingCapital;
        this.description = description;
        this.date = date;
    }

    public TokenServiceModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameToken() {
        return nameToken;
    }

    public void setNameToken(String nameToken) {
        this.nameToken = nameToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStartingCapital() {
        return startingCapital;
    }

    public void setStartingCapital(int startingCapital) {
        this.startingCapital = startingCapital;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenServiceModel that = (TokenServiceModel) o;
        return id == that.id && startingCapital == that.startingCapital && Objects.equals(nameToken, that.nameToken) && Objects.equals(username, that.username) && Objects.equals(description, that.description) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameToken, username, startingCapital, description, date);
    }
}
