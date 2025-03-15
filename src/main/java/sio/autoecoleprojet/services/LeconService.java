package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Lecon;
import sio.autoecoleprojet.repositories.EleveRepository;
import sio.autoecoleprojet.repositories.LeconRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class LeconService {
    private LeconRepository leconRepository;

    public LeconService()
    {
        this.leconRepository = new LeconRepository();
    }

    public ArrayList<Lecon> getAllBy(int codeEleve) throws SQLException {
        return leconRepository.getAllBy(codeEleve);
    }
    public ArrayList<Lecon> getLeconAffBy(int codeEleve) throws SQLException {
        return leconRepository.getLeconAffBy(codeEleve);
    }

    public ArrayList<Lecon> getLeconAffByMoniteur(int codeMoniteur) throws SQLException {
        return leconRepository.getLeconAffByMoniteur(codeMoniteur);
    }

    public ArrayList<Lecon> getAll() throws SQLException {
        return leconRepository.getAll();
    }

    public ArrayList<Lecon> getLeconEleve(int codeEleve) throws SQLException {
        return leconRepository.getLeconEleve(codeEleve);
    }

    public ArrayList<Lecon> getLeconMoniteur(int codeMoniteur) throws SQLException {
        return leconRepository.getLeconMoniteur(codeMoniteur);
    }

    public int getNewCodeLecon() throws SQLException {
        return  leconRepository.getNewCodeLecon();
    }

    public boolean verifLecon(int codeEleve, String date, String heure) throws SQLException {
        return  leconRepository.verifLecon(codeEleve, date, heure);
    }

    public void create(int codeLecon, String date, String heure, int codeMoniteur, int codeEleve, String immatriculation, int reglee, int codeCategorie) throws SQLException {
        Lecon lecon = new Lecon(codeEleve, codeLecon, date, heure, codeMoniteur, immatriculation, codeCategorie, reglee);
        leconRepository.create(lecon);
    }


}
