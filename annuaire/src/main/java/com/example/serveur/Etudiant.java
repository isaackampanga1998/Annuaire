package com.example.serveur;

public class Etudiant extends Membre {
    private String matricule;

    public Etudiant(String nom, String prenom, String email, String matricule) {
        super(nom, prenom, email);
        this.matricule = matricule;
    }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
}

