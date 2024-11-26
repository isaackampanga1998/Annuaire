package com.example.client;

import com.example.serveur.AnnuaireImpl; // Changez ceci en fonction du chemin de votre ami
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            AnnuaireImpl annuaire = (AnnuaireImpl) registry.lookup("AnnuaireService");

            // Exemple d'utilisation
            annuaire.ajouterMembre("Jean", "Dupont", "jean.dupont@example.com");
            System.out.println(annuaire.rechercherMembre("Jean"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
