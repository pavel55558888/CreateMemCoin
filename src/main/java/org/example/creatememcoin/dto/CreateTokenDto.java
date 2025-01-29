package org.example.creatememcoin.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateTokenDto {
    @NotBlank(message = "поле nameToken пустое")
    private String nameToken;
    @NotBlank(message = "поле username пустое")
    private String username;
    @Min(value = 5, message = "Капитал не может быть менее 5 долларов")
    private int capital;
    @NotBlank(message = "поле description пустое")
    private String description;

    public CreateTokenDto() {
    }

    public CreateTokenDto(String nameToken, String username, int capital, String description) {
        this.nameToken = nameToken;
        this.username = username;
        this.capital = capital;
        this.description = description;
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

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
