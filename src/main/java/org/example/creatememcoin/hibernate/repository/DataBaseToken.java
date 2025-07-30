package org.example.creatememcoin.hibernate.repository;


import org.example.creatememcoin.model.TokenServiceModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DataBaseToken {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean createNewToken(TokenServiceModel tokenServiceModel);

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<TokenServiceModel> getAllToken();

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<TokenServiceModel> getNameToken(String nameToken);

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<TokenServiceModel> getUsernameToken(String username);

}
