package org.example.creatememcoin.hibernate.service;

import org.example.creatememcoin.model.TokenServiceModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface GetUsernameToken {
    public List<TokenServiceModel> getUsernameToken(String username);
}
