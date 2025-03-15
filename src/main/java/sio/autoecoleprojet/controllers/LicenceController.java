package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.Licence;
import sio.autoecoleprojet.services.LeconService;
import sio.autoecoleprojet.services.LicenceService;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceController {

    private LicenceService licenceService;

    public LicenceController() {
        this.licenceService = new LicenceService();
    }

    public ArrayList<Licence> getLicenceNonAcquis(int codeMoniteur) throws SQLException {
        return licenceService.getLicenceNonAcquis(codeMoniteur);

    }
    public ArrayList<Licence> getLicenceAcquis(int codeMoniteur) throws SQLException {
        return licenceService.getLicenceAcquis(codeMoniteur);


    }

    public void create(int codeLicence , int codeMoniteur , int codeCategorie , String dateObtention) throws SQLException {
        licenceService.create(codeLicence, codeMoniteur, codeCategorie, dateObtention);
    }
    public int getNewCodeLicence() throws SQLException {
        return licenceService.getNewCodeLicence();
    }


    }
