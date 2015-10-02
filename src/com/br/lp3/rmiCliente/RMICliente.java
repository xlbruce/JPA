/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.rmiCliente;

import com.br.lp3.model.Jogo;
import com.br.lp3.model.NoticiaJogo;
import com.br.lp3.model.Usuario;
import com.br.lp3.model.UsuarioJogo;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @author Faganello
 */
public class RMICliente {
    Registry registro;
    RMIInterface servico;

    public RMICliente() throws RemoteException, NotBoundException {
        registro = LocateRegistry.getRegistry("localhost",1099);
        RMIInterface servico = (RMIInterface)registro.lookup("RMIInterface");
    }
    
    public boolean insertUsuario(Usuario usuario){
     return servico.inserirUsuario(usuario);
    }
    
    public Usuario readUsuario(String email){
      return servico.readUsuario(email);
    }
    
    public boolean updateUsario(Usuario novo){
       return servico.updateUsario(novo);
    }
    public boolean removeUsuario(Usuario usuario){
      return servico.removeUsuario(usuario);
    }
    
    public boolean inserirJogo(Jogo j){
        return servico.inserirJogo(j);
    }
    public List<Jogo> readJogo(String nome){
        return servico.readJogo(nome);
    }
    public boolean updateJogo(Jogo novo){
       return servico.updateJogo(novo);
    }
    public boolean removeJogo(Jogo jogo){
        return servico.removeJogo(jogo);
    }
    
    public boolean inserirNoticia(NoticiaJogo n){
        return servico.inserirNoticia(n);
    }
    
    public List<NoticiaJogo> readNoticiaJogo(Jogo j){
        return servico.readNoticiaJogo(j);
    }
     public boolean updateNoticia(NoticiaJogo novo){
         return servico.updateNoticia(novo);
    }
     
    public boolean removeNoticia(NoticiaJogo noticia){
        return servico.removeNoticia(noticia);
    } 
    
    public boolean inserirUsuarioJogo(UsuarioJogo usuarioJogo){
        return servico.inserirUsuarioJogo(usuarioJogo);
    }
    public List<UsuarioJogo> readUsuarioJogo(UsuarioJogo usuarioJogo){
        return servico.readUsuarioJogo(usuarioJogo);
    }
    public boolean updateUsuarioJogo(UsuarioJogo novo){
        return servico.updateUsuarioJogo(novo);
    }
    public boolean removeUsuarioJogo(UsuarioJogo usuarioJogo){
        return servico.removeUsuarioJogo(usuarioJogo);
    }
    
   
}
