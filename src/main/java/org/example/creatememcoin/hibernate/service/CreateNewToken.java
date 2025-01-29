package org.example.creatememcoin.hibernate.service;


import org.example.creatememcoin.dto.CreateTokenDto;
import org.springframework.stereotype.Service;

@Service
public interface CreateNewToken {
    public boolean createNewToken(CreateTokenDto createTokenDto);
}
