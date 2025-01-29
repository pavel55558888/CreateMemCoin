package org.example.creatememcoin.service;

import org.example.creatememcoin.controller.CreateTokenController;
import org.example.creatememcoin.dto.CreateTokenDto;
import org.example.creatememcoin.hibernate.service.CreateNewToken;
import org.example.creatememcoin.jdbc.service.CreateTableTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenService {
    private CreateTableTokenService createTableTokenService;
    private CreateNewToken createNewToken;
    private CreateTokenDto createTokenDto;
    private final Logger logger = LoggerFactory.getLogger(CreateTokenController.class);

    public TokenService(CreateTableTokenService createTableTokenService, CreateTokenDto createTokenDto, CreateNewToken createNewToken) {
        this.createTableTokenService = createTableTokenService;
        this.createTokenDto = createTokenDto;
        this.createNewToken = createNewToken;
    }


    public boolean startThreadAll(){
        try {
            new Thread1(createNewToken, createTokenDto);
            new Thread2(createTokenDto, createTableTokenService);
            logger.info("Потоки на создание токена запущены");
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }
}

class Thread1 extends Thread {
    private CreateNewToken createNewToken;
    private CreateTokenDto createTokenDto;
    private final Logger logger = LoggerFactory.getLogger(CreateTokenController.class);

    public Thread1(CreateNewToken createNewToken, CreateTokenDto createTokenDto) {
        this.createNewToken = createNewToken;
        this.createTokenDto = createTokenDto;
        this.start();
    }

    @Override
    public void run() {
        logger.info("Потоки 1 запуск");
        createNewToken.createNewToken(createTokenDto);
    }
}

class Thread2 extends Thread {
    private CreateTokenDto createTokenDto;
    private CreateTableTokenService createTableTokenService;
    private final Logger logger = LoggerFactory.getLogger(CreateTokenController.class);

    public Thread2(CreateTokenDto createTokenDto, CreateTableTokenService createTableTokenService) {
        this.createTokenDto = createTokenDto;
        this.createTableTokenService = createTableTokenService;
        this.start();
    }

    @Override
    public void run() {
        logger.info("Потоки 2 запуск");
        createTableTokenService.createTable(createTokenDto.getNameToken());
    }
}
