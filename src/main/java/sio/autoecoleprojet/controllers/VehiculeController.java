package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.Vehicule;
import sio.autoecoleprojet.services.VehiculeService;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController() {
        this.vehiculeService = new VehiculeService();
    }

    public ArrayList<Vehicule> getAll() throws SQLException {
        try {
            return vehiculeService.getAll();
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la récupération des véhicules.", e);
        }
    }

    public void create(String immatriculation, String marque, String modele, int annee, int codeCategorie) throws SQLException {
        try {
            vehiculeService.create(immatriculation, marque, modele, annee, codeCategorie);
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la création du véhicule.", e);
        }
    }

    public ArrayList<String> getCategorieVehicule() throws SQLException {
        try {
            return vehiculeService.getCategorieVehicule();
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la récupération des catégories de véhicules.", e);
        }
    }

    public int getCodeCategorieByLibelle(String libelle) throws SQLException {
        try {
            return vehiculeService.getCodeCategorieByLibelle(libelle);
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la recherche du code catégorie pour le libellé : " + libelle, e);
        }
    }

    public void update(String immatriculation, String marque, String modele, int annee, int codeCategorie) throws SQLException {
        vehiculeService.update(immatriculation, marque, modele, annee, codeCategorie);
    }

    public String recupImmatriculationDispo( int codeCategorie,String date, String heure) throws SQLException {
        return vehiculeService.recupImmatriculationDispo(codeCategorie, date, heure);
    }

    public ArrayList<Vehicule> getVehiculeDispo(int codeCategorie, String date, String heure) throws SQLException {
        return vehiculeService.getVehiculeDispo(codeCategorie,date, heure);
    }
}

