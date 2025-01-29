package org.example.creatememcoin.jdbc.repository.impl;

import org.example.creatememcoin.jdbc.repository.CreateTableToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateTableTokenImpl implements CreateTableToken {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean createTable(String nameToken) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS ")
                .append(nameToken)
                .append(" (")
                .append("id SERIAL PRIMARY KEY, ")
                .append("lastPrice INT NOT NULL, ")
                .append("currentNumber INT NOT NULL, ")
                .append("maximumNumber INT NOT NULL, ")
                .append("numberOfUsers INT NOT NULL, ")
                .append("totalCapital INT NOT NULL")
                .append(")");

        try {
            jdbcTemplate.execute(sql.toString());
            return true;
        } catch (Exception e) {
            System.err.println("Ошибка создания таблицы: " + e.getMessage());
            return false;
        }
    }
}
