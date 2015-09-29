/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.model.NoticiaJogo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31423965
 */
public class NoticiaJogoDAO implements DAO<NoticiaJogo>{
     
    @Override
    public void insert(NoticiaJogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<NoticiaJogo> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select e from noticia_jogo e");
        List<NoticiaJogo> noticias = query.getResultList();
        em.close();
        return noticias;
    }

    @Override
    public void update(NoticiaJogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(NoticiaJogo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        NoticiaJogo u = em.find(NoticiaJogo.class, e.getIdNoticiaJogo());
        em.getTransaction().begin();
        em.remove(em);
        em.getTransaction().commit();
        em.close();
    }

}
