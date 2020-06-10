package com.example.androidproject_iwim;

public class Model
{
    String id, nom, email, numtel, matiere, nbreheur;

    public Model() {
    }

    public Model(String id, String nom, String email, String numtel, String matiere, String nbreheur) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.numtel = numtel;
        this.matiere = matiere;
        this.nbreheur = nbreheur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getNbreheur() {
        return nbreheur;
    }

    public void setNbreheur(String nbreheur) {
        this.nbreheur = nbreheur;
    }
}
