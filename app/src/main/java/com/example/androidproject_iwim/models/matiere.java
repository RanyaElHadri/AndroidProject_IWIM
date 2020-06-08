package com.example.androidproject_iwim.models;

public class matiere {
    private String TitreMatiere,profMatiere,pid;

    public matiere() {
    }

    public matiere(String titreMatiere, String profMatiere, String pid) {
        TitreMatiere = titreMatiere;
        this.profMatiere = profMatiere;
        this.pid = pid;
    }

    public String getTitreMatiere() {
        return TitreMatiere;
    }

    public void setTitreMatiere(String titreMatiere) {
        TitreMatiere = titreMatiere;
    }

    public String getProfMatiere() {
        return profMatiere;
    }

    public void setProfMatiere(String profMatiere) {
        this.profMatiere = profMatiere;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
