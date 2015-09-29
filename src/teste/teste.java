/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.br.lp3.dao.UsuarioDAO;
import com.br.lp3.model.Usuario;

/**
 *
 * @author 31423965
 */
public class teste {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = new Usuario("joao", "auhauh", "sjjs", "nakka", "null");
        dao.insert(u);
        
    }
}
