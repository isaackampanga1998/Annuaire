package com.example.serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurRMI {
    public static void main(String[] args) {
        try {
            AnnuaireImpl annuaire = new AnnuaireImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AnnuaireService", annuaire);
            System.out.println("Serveur RMI prêt !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
