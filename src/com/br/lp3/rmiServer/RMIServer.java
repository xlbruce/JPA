/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.rmiServer;

import com.br.lp3.dao.JogoDAO;
import com.br.lp3.dao.NoticiaJogoDAO;
import com.br.lp3.dao.UsuarioDAO;
import com.br.lp3.dao.UsuarioJogoDAO;
import com.br.lp3.model.Jogo;
import com.br.lp3.model.NoticiaJogo;
import com.br.lp3.model.Usuario;
import com.br.lp3.model.UsuarioJogo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faganello
 */
public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    public RMIServer() throws RemoteException {
    }

    @Override
    public boolean inserirUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        if ("".equals(usuario.getEmail()) || "".equals(usuario.getSenha()) || "".equals(usuario.getNome()) || "".equals(usuario.getSobrenome())) {
            return false;
        }

        dao.insert(usuario);
        return true;
    }

    @Override
    public Usuario readUsuario(String email) {
        UsuarioDAO dao = new UsuarioDAO();
        if ("".equals(email)) {
            return null;
        } 
        List p = dao.read();
        for (Object p1 : p) {
            Usuario a = (Usuario) p1;
            if (a.getEmail() == email) {
                return a;
            }
        }

        return null;
    }

    @Override
    public boolean updateUsario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        if ("".equals(usuario.getEmail()) || "".equals(usuario.getSenha()) || "".equals(usuario.getNome()) || "".equals(usuario.getSobrenome())) {
            return false;
        }
        dao.update(usuario);
        return true;
    }

    @Override
    public boolean removeUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        if ("".equals(usuario.getEmail()) || "".equals(usuario.getSenha()) || "".equals(usuario.getNome()) || "".equals(usuario.getSobrenome())) {
            return false;
        }
        dao.remove(usuario);
        return true;
    }

    @Override
    public boolean inserirJogo(Jogo jogo) {
        JogoDAO dao = new JogoDAO();
        if ("".equals(jogo.getNome()) || "".equals(jogo.getProdutora())){
            return false;
        }

        dao.insert(jogo);
        return true;
    }

    @Override
    public List<Jogo> readJogo(String nome) {
        JogoDAO dao = new JogoDAO();
        if ("".equals(nome)) {
            return null;
        } 
        List p = dao.read();
        List novaList = new ArrayList<>();
        
        for (Object p1 : p) {
            Jogo j = (Jogo) p1;
            if (j.getNome().equals(nome)) {
                novaList.add(j);
            }
        }

        if(novaList.size() > 0){
            return novaList;
        }
        
        return null;
    }

    @Override
    public boolean updateJogo(Jogo novo) {
        JogoDAO dao = new JogoDAO();
        if ("".equals(novo.getNome()) || "".equals(novo.getProdutora())){
            return false;
        }
        dao.update(novo);
        return true;
    }

    @Override
    public boolean removeJogo(Jogo jogo) {
        JogoDAO dao = new JogoDAO();
        if ("".equals(jogo.getNome()) || "".equals(jogo.getProdutora())){
            return false;
        }
        dao.remove(jogo);
        return true;
    }

    @Override
    public boolean inserirNoticia(NoticiaJogo n) {
        NoticiaJogoDAO dao = new NoticiaJogoDAO();
        if ("".equals(n.getIdJogo()) || "".equals(n.getTexto())){
            return false;
        }

        dao.insert(n);
        return true;
    
    }

    @Override
    public List<NoticiaJogo> readNoticiaJogo(Jogo j) {
        JogoDAO jogoDAO = new JogoDAO();
        List jogos = jogoDAO.read();
        List jogosFinal = new ArrayList();
        for (Object obj : jogos) {
            Jogo jogo = (Jogo) obj;
            if(jogo.getNome().contains(j.getNome())){
                jogosFinal.add(jogo);
            }
        }
        
        if (jogosFinal.size() <= 0){
            return jogosFinal;
        }
        
        NoticiaJogoDAO dao = new NoticiaJogoDAO();
        List noticias = dao.read();
        
        for (Object obj : noticias) {
            NoticiaJogo noticia = (NoticiaJogo)obj;
            
            for (Object obj2 : jogosFinal) {
                Jogo jogo = (Jogo)obj2;
                
                int a = jogo.getIdJogo();
                int b = noticia.getIdJogo().getIdJogo();
                
                if(a == b){
                    noticias.add(noticia);
                }
            }
        }
        
        return noticias;
        
    }

    @Override
    public boolean updateNoticia(NoticiaJogo novo) {
        NoticiaJogoDAO dao = new NoticiaJogoDAO();
        if ("".equals(novo.getTexto())){
            return false;
        } 
        dao.update(novo);
        return true;
    }

    @Override
    public boolean removeNoticia(NoticiaJogo noticia) {
        NoticiaJogoDAO dao = new NoticiaJogoDAO();
        if ("".equals(noticia.getTexto())){
            return false;
        }
        dao.remove(noticia);
        return true;
    }

    @Override
    public boolean inserirUsuarioJogo(UsuarioJogo usuarioJogo) {
        UsuarioJogoDAO dao = new UsuarioJogoDAO();
        dao.insert(usuarioJogo);
        return true;
    }

    @Override
    public List<UsuarioJogo> readUsuarioJogo(UsuarioJogo usuarioJogo) {
        UsuarioJogoDAO dao = new UsuarioJogoDAO();

        List u = dao.read();
        List novaList = new ArrayList<>();
        
        for (Object u1 : u) {
            UsuarioJogo novoUsuarioJogo = (UsuarioJogo) u1;
            if (novoUsuarioJogo.getIdUsuario() == usuarioJogo.getIdUsuario()) {
                novaList.add(novoUsuarioJogo);
            }
        }

        if(novaList.size() > 0){
            return novaList;
        }
        
        return null;
    }

    @Override
    public boolean updateUsuarioJogo(UsuarioJogo novo) {
        UsuarioJogoDAO dao = new UsuarioJogoDAO();
        dao.update(novo);
        return true;
    }

    @Override
    public boolean removeUsuarioJogo(UsuarioJogo usuarioJogo) {
        UsuarioJogoDAO dao = new UsuarioJogoDAO();
        dao.remove(usuarioJogo);
        return true;
    }

}
