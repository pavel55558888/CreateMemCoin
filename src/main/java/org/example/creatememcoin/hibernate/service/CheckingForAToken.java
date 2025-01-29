package org.example.creatememcoin.hibernate.service;

import org.springframework.stereotype.Service;

@Service
public interface CheckingForAToken {
    public boolean checkingForAToken(String nameToken);
}
