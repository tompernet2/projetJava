package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.models.Vehicule;
import sio.autoecoleprojet.repositories.VehiculeRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeService() {
        this.vehiculeRepository = new VehiculeRepository();
    }

    public ArrayList<Vehicule> getAll() throws SQLException {
        return vehiculeRepository.getAll();
    }

    public void create(String immatriculation, String marque, String modele, int annee, int codeCategorie) throws SQLException {
        if (immatriculation == null || immatriculation.trim().isEmpty()) {
            throw new IllegalArgumentException("L'immatriculation ne peut pas être vide.");
        }
        Vehicule vehicule = new Vehicule(immatriculation, marque, modele, annee, codeCategorie);
        vehiculeRepository.create(vehicule);
    }

    public ArrayList<String> getCategorieVehicule() throws SQLException {
        return vehiculeRepository.getCategorieVehicule();
    }

    public int getCodeCategorieByLibelle(String libelle) throws SQLException {
        return vehiculeRepository.getCodeCategorieByLibelle(libelle);
    }

    public void update(String immatriculation, String marque, String modele, int annee, int codeCategorie) throws SQLException {
        Vehicule vehicule = new Vehicule(immatriculation, marque, modele, annee, codeCategorie);
        vehiculeRepository.update(vehicule);
    }

    public String recupImmatriculationDispo( int codeCategorie,String date, String heure) throws SQLException {
        return vehiculeRepository.recupImmatriculationDispo(codeCategorie, date, heure);
    }

    public ArrayList<Vehicule> getVehiculeDispo(int codeCategorie, String date, String heure) throws SQLException {
        return vehiculeRepository.getVehiculeDispo(codeCategorie,date, heure);
    }
}
