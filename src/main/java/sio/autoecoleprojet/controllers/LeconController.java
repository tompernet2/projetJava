package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.Lecon;
import sio.autoecoleprojet.services.EleveService;
import sio.autoecoleprojet.services.LeconService;

import java.sql.SQLException;
import java.util.ArrayList;

public class LeconController {

    private LeconService leconService;

    public LeconController() {
        this.leconService = new LeconService();
    }

    public ArrayList<Lecon> getAllBy(int codeEleve) throws SQLException {
        return leconService.getAllBy(codeEleve);
    }


    public ArrayList<Lecon> getLeconAffBy(int codeEleve) throws SQLException {
        return  leconService.getLeconAffBy(codeEleve);
    }

    public ArrayList<Lecon> getLeconAffByMoniteur(int codeMoniteur) throws SQLException {
        return leconService.getLeconAffByMoniteur(codeMoniteur);
    }

    public ArrayList<Lecon> getAll() throws SQLException {
        return leconService.getAll();
    }

    public ArrayList<Lecon> getLeconEleve(int codeEleve) throws SQLException {
        return leconService.getLeconEleve(codeEleve);
    }
    public ArrayList<Lecon> getLeconMoniteur(int codeMoniteur) throws SQLException {
        return leconService.getLeconMoniteur(codeMoniteur);
    }

    public int getNewCodeLecon() throws SQLException {
        return  leconService.getNewCodeLecon();
    }

    public boolean verifLecon(int codeEleve, String date, String heure) throws SQLException {
        return  leconService.verifLecon(codeEleve, date, heure);
    }

    public void create(int codeLecon, String date, String heure, int codeMoniteur, int codeEleve, String immatriculation, int reglee, int codeCategorie) throws SQLException {
        leconService.create(codeLecon, date, heure, codeMoniteur, codeEleve, immatriculation, reglee, codeCategorie);
    }

}

