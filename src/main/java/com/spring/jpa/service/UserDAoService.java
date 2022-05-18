package com.spring.jpa.service;


import com.spring.jpa.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAoService {
    @PersistenceContext
    private EntityManager entityManager;

    public long insert(Users user) {
        entityManager.persist(user);
        return user.getId();
    }
}
