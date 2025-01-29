package org.example.creatememcoin.hibernate.service.impl;

import org.example.creatememcoin.controller.CreateTokenController;
import org.example.creatememcoin.dto.CreateTokenDto;
import org.example.creatememcoin.model.TokenServiceModel;
import org.example.creatememcoin.hibernate.repository.DataBaseToken;
import org.example.creatememcoin.hibernate.service.CheckingForAToken;
import org.example.creatememcoin.hibernate.service.CreateNewToken;
import org.example.creatememcoin.hibernate.service.GetAllToken;
import org.example.creatememcoin.hibernate.service.GetNameToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataBaseTokenServiceImpl implements CreateNewToken, GetAllToken, GetNameToken, CheckingForAToken {
    @Autowired
    private DataBaseToken dataBaseToken;
    private final Logger logger = LoggerFactory.getLogger(CreateTokenController.class);
    @Override
    public boolean createNewToken(CreateTokenDto createTokenDto) {
        TokenServiceModel tokenServiceModel = new TokenServiceModel(createTokenDto.getNameToken(),
                createTokenDto.getUsername(), createTokenDto.getCapital(), createTokenDto.getDescription(), LocalDateTime.now());
        boolean info =  dataBaseToken.createNewToken(tokenServiceModel);
        logger.info("Создание нового токена. Статус: " + info);
        return info;
    }

    @Override
    public List<TokenServiceModel> getAllToken() {
        return dataBaseToken.getAllToken();
    }

    @Override
    public List<TokenServiceModel> getNameToken(String nameToken) {
        return dataBaseToken.getNameToken(nameToken);
    }

    @Override
    public boolean checkingForAToken(String nameToken) {
        return dataBaseToken.getNameToken(nameToken).isEmpty();
    }
}
