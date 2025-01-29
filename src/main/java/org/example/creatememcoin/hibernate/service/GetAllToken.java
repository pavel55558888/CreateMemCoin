package org.example.creatememcoin.hibernate.service;

import org.example.creatememcoin.model.TokenServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GetAllToken {
    public List<TokenServiceModel> getAllToken();
}
