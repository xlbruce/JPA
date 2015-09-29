/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31423965
 */
@Entity
@Table(name = "NOTICIA_JOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NoticiaJogo.findAll", query = "SELECT n FROM NoticiaJogo n"),
    @NamedQuery(name = "NoticiaJogo.findByIdNoticiaJogo", query = "SELECT n FROM NoticiaJogo n WHERE n.idNoticiaJogo = :idNoticiaJogo"),
    @NamedQuery(name = "NoticiaJogo.findByTexto", query = "SELECT n FROM NoticiaJogo n WHERE n.texto = :texto")})
public class NoticiaJogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTICIA_JOGO")
    private Integer idNoticiaJogo;
    @Column(name = "TEXTO")
    private String texto;
    @JoinColumn(name = "ID_JOGO", referencedColumnName = "ID_JOGO")
    @ManyToOne
    private Jogo idJogo;

    public NoticiaJogo() {
    }

    public NoticiaJogo(Integer idNoticiaJogo) {
        this.idNoticiaJogo = idNoticiaJogo;
    }

    public Integer getIdNoticiaJogo() {
        return idNoticiaJogo;
    }

    public void setIdNoticiaJogo(Integer idNoticiaJogo) {
        this.idNoticiaJogo = idNoticiaJogo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Jogo getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Jogo idJogo) {
        this.idJogo = idJogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNoticiaJogo != null ? idNoticiaJogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoticiaJogo)) {
            return false;
        }
        NoticiaJogo other = (NoticiaJogo) object;
        if ((this.idNoticiaJogo == null && other.idNoticiaJogo != null) || (this.idNoticiaJogo != null && !this.idNoticiaJogo.equals(other.idNoticiaJogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.NoticiaJogo[ idNoticiaJogo=" + idNoticiaJogo + " ]";
    }
    
}
