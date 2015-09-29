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
@Table(name = "USUARIO_JOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioJogo.findAll", query = "SELECT u FROM UsuarioJogo u"),
    @NamedQuery(name = "UsuarioJogo.findByIdUsuarioJogo", query = "SELECT u FROM UsuarioJogo u WHERE u.idUsuarioJogo = :idUsuarioJogo")})
public class UsuarioJogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO_JOGO")
    private Integer idUsuarioJogo;
    @JoinColumn(name = "ID_JOGO", referencedColumnName = "ID_JOGO")
    @ManyToOne
    private Jogo idJogo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public UsuarioJogo() {
    }

    public UsuarioJogo(Integer idUsuarioJogo) {
        this.idUsuarioJogo = idUsuarioJogo;
    }

    public Integer getIdUsuarioJogo() {
        return idUsuarioJogo;
    }

    public void setIdUsuarioJogo(Integer idUsuarioJogo) {
        this.idUsuarioJogo = idUsuarioJogo;
    }

    public Jogo getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Jogo idJogo) {
        this.idJogo = idJogo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioJogo != null ? idUsuarioJogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioJogo)) {
            return false;
        }
        UsuarioJogo other = (UsuarioJogo) object;
        if ((this.idUsuarioJogo == null && other.idUsuarioJogo != null) || (this.idUsuarioJogo != null && !this.idUsuarioJogo.equals(other.idUsuarioJogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.UsuarioJogo[ idUsuarioJogo=" + idUsuarioJogo + " ]";
    }
    
}
