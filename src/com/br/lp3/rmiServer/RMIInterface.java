/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.rmiServer;

import com.br.lp3.model.Jogo;
import com.br.lp3.model.NoticiaJogo;
import com.br.lp3.model.Usuario;
import com.br.lp3.model.UsuarioJogo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Faganello
 */
public interface RMIInterface extends Remote{
    public boolean inserirUsuario(Usuario usuario);
    public Usuario readUsuario(String email);
    public boolean updateUsario(Usuario novo);
    public boolean removeUsuario(Usuario usuario);
    
    public boolean inserirJogo(Jogo j);
    public List<Jogo> readJogo(String nome);
    public boolean updateJogo(Jogo novo);
    public boolean removeJogo(Jogo jogo);

    public boolean inserirNoticia(NoticiaJogo n);
    public List<NoticiaJogo> readNoticiaJogo(Jogo j);
    public boolean updateNoticia(NoticiaJogo novo);
    public boolean removeNoticia(NoticiaJogo noticia);
    
    public boolean inserirUsuarioJogo(UsuarioJogo usuarioJogo);
    public List<UsuarioJogo> readUsuarioJogo(UsuarioJogo usuarioJogo);
    public boolean updateUsuarioJogo(UsuarioJogo novo,UsuarioJogo velho);
    public boolean removeUsuarioJogo(UsuarioJogo usuarioJogo);

}
