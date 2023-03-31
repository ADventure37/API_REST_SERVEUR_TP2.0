package com.dto;

public class Ville {
    private String codeCommune;
    private String nom;
    private String codePostal;
    private String ligne;

    public Ville(){
        this.setCodeCommune(null);
        this.setLigne(null);
        this.setNom(null);
        this.setCodePostal(null);
    }

    public String getInfo(){
        return "Nom : "+ this.getNom() + " Code Postal : " +this.getCodePostal();
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }


    public String info(){
        return "Code de la commune: " + this.getCodeCommune() + " ,Nom: " + this.getNom() + " ,Code postal: "
                + this.getCodePostal();
    }
}
