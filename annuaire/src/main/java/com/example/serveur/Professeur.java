package com.example.serveur;

public class Professeur extends Membre {
    private String domaine;

    public Professeur(String nom, String prenom, String email, String domaine) {
        super(nom, prenom, email);
        this.domaine = domaine;
    }

    public String getDomaine() { return domaine; }
    public void setDomaine(String domaine) { this.domaine = domaine; }
}
