/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31423965
 */
public class UsuarioDAO implements DAO<Usuario> {

    @Override
    public void insert(Usuario e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Usuario> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select e from Usuario e");
        List<Usuario> usuarios = query.getResultList();
        em.close();
        return usuarios;
    }

    @Override
    public void update(Usuario e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Usuario e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloJPAPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, e.getIdUsuario());
        em.getTransaction().begin();
        em.remove(em);
        em.getTransaction().commit();
        em.close();
    }

}
