package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VilleDAOImpl implements VilleDAO{
    private Connection connexion;

    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twic_maven", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Ville> findAllVilles(){
        System.out.println("findAllVilles");
        ArrayList<Ville> listVille = new ArrayList<>();

        Ville ville = new Ville();
        ville.setCodePostal("49000");
        ville.setNom("Angers");
        ville.setLigne("ligne");
        listVille.add(ville);
        return listVille;
    }

    public ArrayList<Ville> recupererVillesCodeP(String codePostal) {
        ArrayList<Ville> villes = new ArrayList<Ville>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "SELECT * from ville_france WHERE Code_postal = ?;");
            preparedStatement.setString(1, codePostal);

            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setCodeCommune(resultat.getString("Code_commune_INSEE"));
                ville.setNom(resultat.getString("Nom_commune"));
                ville.setCodePostal(resultat.getString("Code_postal"));
                ville.setLigne(resultat.getString("Ligne_5"));
                villes.add(ville);
            }

        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return villes;
    }

    public ArrayList<Ville> recupererVillesCodeC(String codeCommune) {
        ArrayList<Ville> villes = new ArrayList<Ville>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "SELECT * from ville_france WHERE Code_commune_INSEE = ?;");
            preparedStatement.setString(1, codeCommune);

            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setCodeCommune(resultat.getString("Code_commune_INSEE"));
                ville.setNom(resultat.getString("Nom_commune"));
                ville.setCodePostal(resultat.getString("Code_postal"));
                ville.setLigne(resultat.getString("Ligne_5"));
                villes.add(ville);
            }

        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return villes;
    }

    public ArrayList<Ville> recupererVillesNom(String nom) {
        ArrayList<Ville> villes = new ArrayList<Ville>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "SELECT * from ville_france WHERE Nom_commune = ?;");
            preparedStatement.setString(1, nom);

            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setCodeCommune(resultat.getString("Code_commune_INSEE"));
                ville.setNom(resultat.getString("Nom_commune"));
                ville.setCodePostal(resultat.getString("Code_postal"));
                ville.setLigne(resultat.getString("Ligne_5"));
                villes.add(ville);
            }

        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return villes;
    }

    public ArrayList<Ville> recupererVilles() {
        ArrayList<Ville> villes = new ArrayList<Ville>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery(
                    "SELECT * from ville_france;");
            // Récupération des données
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setCodeCommune(resultat.getString("Code_commune_INSEE"));
                ville.setNom(resultat.getString("Nom_commune"));
                ville.setCodePostal(resultat.getString("Code_postal"));
                ville.setLigne(resultat.getString("Ligne_5"));
                villes.add(ville);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return villes;
    }
    public void deleteVille(String codeCommune) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "DELETE from ville_france WHERE Code_commune_INSEE = ?;");
            preparedStatement.setString(1, codeCommune);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertVille(Ville ville) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "INSERT INTO ville_france(Code_commune_INSEE, Nom_commune, Code_Postal, Libelle_acheminement) VALUES (?,?,?,?);");
            preparedStatement.setString(1, ville.getCodeCommune());
            preparedStatement.setString(2, ville.getNom());
            preparedStatement.setString(3, ville.getCodePostal());
            preparedStatement.setString(4, ville.getNom());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVille(Ville ville) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "UPDATE ville_france set Nom_commune =?, Code_Postal=?, Libelle_acheminement=?) Where Code_commune_INSEE = ?;");
            preparedStatement.setString(1,ville.getNom() );
            preparedStatement.setString(2, ville.getCodePostal());
            preparedStatement.setString(3, ville.getNom());
            preparedStatement.setString(4, ville.getCodeCommune());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
