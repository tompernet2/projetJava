package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.services.EleveService;
import sio.autoecoleprojet.services.MoniteurService;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;


public class MoniteurController {
    private MoniteurService moniteurService;

    public MoniteurController() {
        this.moniteurService = new MoniteurService();
    }
    public Moniteur recupMoniteurCo(int numCompte) throws SQLException {
        return moniteurService.recupMoniteurCo(numCompte);
    }
    public void update(String nom, String prenom, String sexe, String dateNaissance, String ville, int codePostal, String adresse, int tel, int numCompte) throws SQLException {
        moniteurService.update(nom, prenom, sexe, dateNaissance,  ville, codePostal,adresse, tel, numCompte);
    }
    public void create(int codeMoniteur , String nom, String prenom, String sexe, String dateNaissance, String ville, int codePostal, String adresse, int tel, int numCompte , String img) throws SQLException {
        moniteurService.create(codeMoniteur, nom, prenom, sexe, dateNaissance,  ville, codePostal,adresse, tel, numCompte , img);
    }

    public ArrayList<Moniteur> getMoniteursDisponibles(String date, String heure) throws SQLException {
        return moniteurService.getMoniteursDisponibles(date, heure);
    }
    public ArrayList<Moniteur> getMoniteurDispo(int codeCategorie, String date, String heure) throws SQLException {
        return moniteurService.getMoniteurDispo(codeCategorie,date, heure);
    }

    public ArrayList<Moniteur> getAll() throws SQLException {
        return moniteurService.getAll();
    }

    public int getNewCodeMoniteur() throws SQLException {
        return moniteurService.getNewCodeMoniteur();
    }

    public ArrayList<Moniteur> recupMoniteur() throws SQLException {
        return moniteurService.recupMoniteur();
    }

    public HashMap<String,Integer> getDatasMoniteur() throws SQLException {
        return  moniteurService.getDatasMoniteur();
    }

    public int getNblicence(int codeMoniteur) throws SQLException {
        return  moniteurService.getNblicence(codeMoniteur);
    }
    public int getNbLeconPasse(int codeMoniteur) throws SQLException {
        return  moniteurService.getNbLeconPasse(codeMoniteur);
    }
    public int getNbLeconAVenir(int codeMoniteur) throws SQLException {
        return  moniteurService.getNbLeconAVenir(codeMoniteur);
    }
    public int getNbLeconTotal(int codeMoniteur) throws SQLException {
        return  moniteurService.getNbLeconTotal(codeMoniteur);
    }

}
