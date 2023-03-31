package com.blo;

import com.dao.VilleDAO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VilleBLOImpl implements VilleBLO{

    @Autowired
    private VilleDAO villeDAO;

    @Override
    public ArrayList<Ville> getVillesCodeP(String codePostal) {
        return villeDAO.recupererVillesCodeP(codePostal);
    }
    @Override
    public ArrayList<Ville> getVillesCodeC(String codeCommune) {
        return villeDAO.recupererVillesCodeC(codeCommune);
    }
    @Override
    public ArrayList<Ville> getVillesNom(String nom) {
        return villeDAO.recupererVillesNom(nom);
    }

    @Override
    public ArrayList<Ville> getVilles() {
        return villeDAO.recupererVilles();
    }

    @Override
    public void deleteVille(String codeCommune){
        villeDAO.deleteVille(codeCommune);
    }
    @Override
    public void insertVille(Ville ville){
        villeDAO.insertVille(ville);
    }
    @Override
    public void putVille(Ville ville){
        villeDAO.updateVille(ville);
    }
}
