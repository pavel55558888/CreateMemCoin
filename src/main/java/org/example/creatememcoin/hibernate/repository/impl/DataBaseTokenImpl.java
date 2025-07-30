package org.example.creatememcoin.hibernate.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.creatememcoin.model.TokenServiceModel;
import org.example.creatememcoin.hibernate.repository.DataBaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataBaseTokenImpl implements DataBaseToken {
    @Autowired
    private EntityManager entityManager;
    @Override
    public boolean createNewToken(TokenServiceModel tokenServiceModel) {
        try {
            entityManager.persist(tokenServiceModel);
            return true;
        }catch(Exception e) {
            System.out.println("Ошибка создания токена " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<TokenServiceModel> getAllToken() {
        return entityManager.createQuery("from TokenServiceModel").getResultList();
    }

    @Override
    public List<TokenServiceModel> getNameToken(String nameToken) {
        return entityManager.createQuery("from TokenServiceModel where nameToken = :param1").setParameter("param1", nameToken).getResultList();
    }

    @Override
    public List<TokenServiceModel> getUsernameToken(String username) {
        return entityManager.createQuery("from TokenServiceModel where username = :param1").setParameter("param1", username).getResultList();
    }
}
