package com.blo;

import com.dto.Ville;

import java.util.ArrayList;
import java.util.List;

public interface VilleBLO {
    public ArrayList<Ville> getVillesCodeP(String codePostal);
    public ArrayList<Ville> getVillesCodeC(String codeCommune);
    public ArrayList<Ville> getVillesNom(String nom);

    ArrayList<Ville> getVilles();

    public void deleteVille(String codeCommune);
    public void insertVille(Ville ville);

    void putVille(Ville ville);
}
