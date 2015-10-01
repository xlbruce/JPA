/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.rmiServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Faganello
 */
public class InicializarRMIServer {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("Mensagem", new RMIServer());
            System.out.println("Registrado com sucesso");
        } catch (RemoteException ex) {
            System.out.println(ex.toString());
        }
    }
}
