package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.repositories.EleveRepository;
import sio.autoecoleprojet.repositories.RepositoryInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class EleveService {
    private EleveRepository eleveRepository;

    public EleveService()
    {
        this.eleveRepository = new EleveRepository();
    }

    public void create(int codeEleve, String nom, String prenom, String sexe, String dateNaissance, String adresse, int codePostal, String ville, int tel, int numCompte) throws SQLException {
        Eleve eleve = new Eleve(codeEleve ,nom, prenom, sexe, dateNaissance, adresse, codePostal, ville, tel, numCompte);
        eleveRepository.create(eleve);
    }

    public int getNewCodeEleve() throws SQLException {
        return eleveRepository.getNewCodeEleve();
    }

    public Eleve recupEleveCo(int numCompte) throws SQLException {
        return eleveRepository.recupEleveCo(numCompte);
    }

    public void update(String nom, String prenom, String sexe, String dateNaissance, int codePostal, String ville, String adresse, int tel, int numCompte) throws SQLException {
        Eleve eleve = new Eleve(nom, prenom, sexe, dateNaissance, codePostal, ville, adresse, tel, numCompte);
        eleveRepository.update(eleve);
    }

    public ArrayList<Eleve> recupEleve() throws SQLException {
        return eleveRepository.recupEleve();
    }

    public boolean verifPermis(int codeEleve) throws SQLException {
        return eleveRepository.verifPermis(codeEleve);
    }

    public HashMap<String,Integer> getDatas() throws SQLException {
        return  eleveRepository.getDatas();
    }

    public int getNbLeconAVenir(int codeEleve) throws SQLException {
        return  eleveRepository.getNbLeconAVenir(codeEleve);
    }
    public int getNbLeconPasse(int codeEleve) throws SQLException {
        return  eleveRepository.getNbLeconPasse(codeEleve);
    }
    public int getNbLeconTotal(int codeEleve) throws SQLException {
        return  eleveRepository.getNbLeconTotal(codeEleve);
    }




    }
