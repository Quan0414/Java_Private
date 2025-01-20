package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.getTransaction().commit();
    }
}