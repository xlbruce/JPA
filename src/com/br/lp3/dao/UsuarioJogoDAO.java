/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.model.UsuarioJogo;
import com.br.lp3.model.UsuarioJogo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31423965
 */
public class UsuarioJogoDAO implements DAO<UsuarioJogo> {
     @Override
    public void insert(UsuarioJogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<UsuarioJogo> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select e from UsuarioJogo e");
        List<UsuarioJogo> jogos = query.getResultList();
        em.close();
        return jogos;
    }

    @Override
    public void update(UsuarioJogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(UsuarioJogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        UsuarioJogo j = em.find(UsuarioJogo.class,e.getIdUsuarioJogo());
        em.getTransaction().begin();
        em.remove(em);
        em.getTransaction().commit();
        em.close();
    }

    
}
