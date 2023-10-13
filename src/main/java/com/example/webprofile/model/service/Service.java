package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Group;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;

@RequestScoped
@Named
    public class Service implements Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    public Service() {
        System.out.println("Service - Created");
    }

    @Transactional
    public void test() {
        System.out.println("Service - test");
        Group root1 = Group.builder().title("Root1").build();
        entityManager.persist(root1);
        System.out.println(root1);
    }

    @Transactional
    public void save(Group group) {
        System.out.println("Service - Save " + group);
        entityManager.persist(group);
        System.out.println(group);
    }
}
