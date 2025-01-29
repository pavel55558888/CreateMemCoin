package org.example.creatememcoin.jdbc.service;

import org.springframework.stereotype.Service;

@Service
public interface CreateTableTokenService {
    public boolean createTable(String nameToken);
}
