package com.controller;


import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VilleController {
    @Autowired
    VilleBLO villeBLOService;

    @GetMapping(value="/villes")
    public ArrayList<String> getAll(){
        ArrayList<Ville> villes = villeBLOService.getVilles();
        ArrayList<String> infos = new ArrayList<>();
        System.out.println(villes.size());
        for(Ville v: villes){
            infos.add(v.getInfo());
        }
        return infos;
    }

    @GetMapping(value="/ville")
    public ArrayList<String> getVillesParam(@RequestParam(required = false, value="codePostal") String codePostal,
                                            @RequestParam(required = false, value="codeCommuneINSEE") String codeCommune,
                                            @RequestParam(required = false, value="nom") String nom){
        ArrayList<String> infos = new ArrayList<>();
        if(codePostal != null || nom != null|| codeCommune != null){
            if(codePostal!= null){
                ArrayList<Ville> villes = villeBLOService.getVillesCodeP(codePostal);
                if (villes.size() == 0){
                    infos.add("Aucune ville ne possède ce code Postal");
                }
                for(Ville v: villes){
                    infos.add(v.getInfo());
                }
                return infos;
            } else if (nom != null) {
                ArrayList<Ville> villes = villeBLOService.getVillesNom(nom);
                if (villes.size() == 0){
                    infos.add("Aucune ville ne possède ce nom");
                }
                for(Ville v: villes){
                    infos.add(v.getInfo());
                }
                return infos;
            } else if (codeCommune != null) {
                ArrayList<Ville> villes = villeBLOService.getVillesCodeC(codeCommune);
                if (villes.size() == 0){
                    infos.add("Aucune ville ne possède ce code de commune de l'INSEE");
                }
                for(Ville v: villes){
                    infos.add(v.getInfo());
                }
                return infos;
            }
        }
        infos.add("Null");
        return infos;
    }
    @DeleteMapping(value="/ville/{codeCommune}")
    public void deleteVille(@RequestParam (value="codeCommune") String codeCommune){
        villeBLOService.deleteVille(codeCommune);
    }
}
