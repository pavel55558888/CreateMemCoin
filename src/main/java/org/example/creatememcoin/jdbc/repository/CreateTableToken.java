package org.example.creatememcoin.jdbc.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CreateTableToken {
    public boolean createTable(String nameToken);
}
