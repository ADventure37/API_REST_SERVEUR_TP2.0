package com.dao;

import com.dto.Ville;

import java.util.ArrayList;
import java.util.List;

public interface VilleDAO {
    public ArrayList<Ville> findAllVilles();
    public ArrayList<Ville> recupererVilles() ;
    public ArrayList<Ville> recupererVillesCodeP(String codePostal) ;
    public ArrayList<Ville> recupererVillesCodeC(String codeCommune) ;
    public ArrayList<Ville> recupererVillesNom(String nom) ;

    public void deleteVille(String codeCommune);
    public void insertVille(Ville ville);
    public void updateVille(Ville ville);

}
