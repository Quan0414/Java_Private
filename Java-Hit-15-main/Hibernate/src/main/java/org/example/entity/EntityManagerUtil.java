package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("application-unit");
        }catch (Exception e){
            e.printStackTrace();
        }
        return entityManagerFactory.createEntityManager();
    }
}
