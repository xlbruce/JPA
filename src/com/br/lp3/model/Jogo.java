/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 31423965
 */
@Entity
@Table(name = "JOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jogo.findAll", query = "SELECT j FROM Jogo j"),
    @NamedQuery(name = "Jogo.findByIdJogo", query = "SELECT j FROM Jogo j WHERE j.idJogo = :idJogo"),
    @NamedQuery(name = "Jogo.findByNome", query = "SELECT j FROM Jogo j WHERE j.nome = :nome"),
    @NamedQuery(name = "Jogo.findByProdutora", query = "SELECT j FROM Jogo j WHERE j.produtora = :produtora"),
    @NamedQuery(name = "Jogo.findByAnoLancamento", query = "SELECT j FROM Jogo j WHERE j.anoLancamento = :anoLancamento")})
public class Jogo implements Serializable {
    @OneToMany(mappedBy = "idJogo")
    private List<UsuarioJogo> usuarioJogoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_JOGO")
    private Integer idJogo;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "PRODUTORA")
    private String produtora;
    @Column(name = "ANO_LANCAMENTO")
    private Integer anoLancamento;
    @OneToMany(mappedBy = "idJogo")
    private List<NoticiaJogo> noticiaJogoList;

    public Jogo() {
    }

    public Jogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @XmlTransient
    public List<NoticiaJogo> getNoticiaJogoList() {
        return noticiaJogoList;
    }

    public void setNoticiaJogoList(List<NoticiaJogo> noticiaJogoList) {
        this.noticiaJogoList = noticiaJogoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJogo != null ? idJogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.idJogo == null && other.idJogo != null) || (this.idJogo != null && !this.idJogo.equals(other.idJogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.Jogo[ idJogo=" + idJogo + " ]";
    }

    @XmlTransient
    public List<UsuarioJogo> getUsuarioJogoList() {
        return usuarioJogoList;
    }

    public void setUsuarioJogoList(List<UsuarioJogo> usuarioJogoList) {
        this.usuarioJogoList = usuarioJogoList;
    }
    
}
