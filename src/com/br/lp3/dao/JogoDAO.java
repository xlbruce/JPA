/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.model.Jogo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31423965
 */
public class JogoDAO implements DAO<Jogo>{
     @Override
    public void insert(Jogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Jogo> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select e from Jogo e");
        List<Jogo> jogos = query.getResultList();
        em.close();
        return jogos;
    }

    @Override
    public void update(Jogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Jogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        Jogo j = em.find(Jogo.class,e.getIdJogo());
        em.getTransaction().begin();
        em.remove(em);
        em.getTransaction().commit();
        em.close();
    }

    

}
