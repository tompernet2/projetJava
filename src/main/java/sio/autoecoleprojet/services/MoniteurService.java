package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.models.Vehicule;
import sio.autoecoleprojet.repositories.EleveRepository;
import sio.autoecoleprojet.repositories.MoniteurRepository;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;


public class MoniteurService {
    private MoniteurRepository moniteurRepository;

    public MoniteurService()
    {
        this.moniteurRepository = new MoniteurRepository();
    }

    public Moniteur recupMoniteurCo(int numCompte) throws SQLException {
        return moniteurRepository.recupMoniteurCo(numCompte);
    }

    public void update(String nom, String prenom, String sexe, String dateNaissance, String ville, int codePostal, String adresse, int tel, int numCompte) throws SQLException {
        Moniteur moniteur = new Moniteur(nom, prenom, sexe, dateNaissance, ville, codePostal, adresse, tel, numCompte);
        moniteurRepository.update(moniteur);
    }

    public void create(int codeMoniteur , String nom, String prenom, String sexe, String dateNaissance, String ville, int codePostal, String adresse,int tel, int numCompte , String img) throws SQLException {
        Moniteur moniteur = new Moniteur(codeMoniteur,nom, prenom, sexe, dateNaissance, ville, codePostal, adresse, tel, numCompte , img);
        moniteurRepository.create(moniteur);
    }


    public ArrayList<Moniteur> getMoniteursDisponibles(String date, String heure) throws SQLException {
        return moniteurRepository.getMoniteursDisponibles(date, heure);
    }

    public ArrayList<Moniteur> getMoniteurDispo(int codeCategorie, String date, String heure) throws SQLException {
        return moniteurRepository.getMoniteurDispo(codeCategorie,date, heure);
    }

    public ArrayList<Moniteur> getAll() throws SQLException {
        return moniteurRepository.getAll();
    }

    public int getNewCodeMoniteur() throws SQLException {
        return moniteurRepository.getNewCodeMoniteur();
    }

    public ArrayList<Moniteur> recupMoniteur() throws SQLException {
        return moniteurRepository.recupMoniteur();
    }
    public HashMap<String,Integer> getDatasMoniteur() throws SQLException {
        return  moniteurRepository.getDatasMoniteur();
    }

    public int getNblicence(int codeMoniteur) throws SQLException {
        return  moniteurRepository.getNblicence(codeMoniteur);
    }
    public int getNbLeconPasse(int codeMoniteur) throws SQLException {
        return  moniteurRepository.getNbLeconPasse(codeMoniteur);
    }
    public int getNbLeconAVenir(int codeMoniteur) throws SQLException {
        return  moniteurRepository.getNbLeconAVenir(codeMoniteur);
    }
    public int getNbLeconTotal(int codeMoniteur) throws SQLException {
        return  moniteurRepository.getNbLeconTotal(codeMoniteur);
    }

    }

