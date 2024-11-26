package com.example.serveur;

import com.example.database.DatabaseManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class AnnuaireImpl extends UnicastRemoteObject {
    private DatabaseManager dbManager;

    public AnnuaireImpl() throws RemoteException {
        dbManager = new DatabaseManager();
    }

    public void ajouterMembre(String nom, String prenom, String email) throws RemoteException {
        dbManager.ajouterMembre(nom, prenom, email);
        System.out.println("Membre ajouté : " + nom + " " + prenom);
    }

    public String rechercherMembre(String nom) throws RemoteException {
        return dbManager.rechercherMembre(nom);
    }

    public void supprimerMembre(String nom) throws RemoteException {
        dbManager.supprimerMembre(nom);
        System.out.println("Membre supprimé : " + nom);
    }
}
