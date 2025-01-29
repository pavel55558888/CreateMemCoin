package org.example.creatememcoin.jdbc.service.impl;

import org.example.creatememcoin.controller.CreateTokenController;
import org.example.creatememcoin.jdbc.repository.CreateTableToken;
import org.example.creatememcoin.jdbc.service.CreateTableTokenService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class CreateTableTokenServiceImpl  implements CreateTableTokenService {
    @Autowired
    CreateTableToken createTableToken;
    private final Logger logger = LoggerFactory.getLogger(CreateTokenController.class);
    @Override
    public boolean createTable(String nameToken) {
        boolean info = createTableToken.createTable(nameToken);
        logger.info("Создание новой таблицы " + nameToken + " Статус: " + info);
        return info;
    }
}
