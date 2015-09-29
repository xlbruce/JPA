/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import java.util.List;

/**
 *
 * @author 31423965
 */
public interface DAO<E>{
    public void insert(E e);
    public List<E> read();
    public void update(E e);
    public void remove(E e);
}
