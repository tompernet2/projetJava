package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.services.EleveService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class EleveController {
    private EleveService eleveService;

    public EleveController() {
        this.eleveService = new EleveService();
    }

    public void create(int codeEleve,String nom, String prenom, String sexe, String dateNaissance, String adresse, int codePostal, String ville, int tel, int numCompte) throws SQLException {
        eleveService.create(codeEleve ,nom, prenom, sexe, dateNaissance, adresse, codePostal, ville, tel, numCompte);
    }

    public int getNewCodeEleve() throws SQLException {
        return eleveService.getNewCodeEleve();
    }

    public Eleve recupEleveCo(int numCompte) throws SQLException {
        return eleveService.recupEleveCo(numCompte);
    }

    public void update(String nom, String prenom, String sexe, String dateNaissance, int codePostal, String ville, String adresse, int tel, int numCompte) throws SQLException {
        eleveService.update(nom, prenom, sexe, dateNaissance, codePostal, ville, adresse, tel, numCompte);
    }

    public ArrayList<Eleve> recupEleve() throws SQLException {
        return eleveService.recupEleve();
    }

    public boolean verifPermis(int codeEleve) throws SQLException {
        return eleveService.verifPermis(codeEleve);
    }
    public HashMap<String,Integer> getDatas() throws SQLException {
        return  eleveService.getDatas();
    }

    public int getNbLeconAVenir(int codeEleve) throws SQLException {
        return  eleveService.getNbLeconAVenir(codeEleve);
    }
    public int getNbLeconPasse(int codeEleve) throws SQLException {
        return  eleveService.getNbLeconPasse(codeEleve);
    }
    public int getNbLeconTotal(int codeEleve) throws SQLException {
        return  eleveService.getNbLeconTotal(codeEleve);
    }


}
