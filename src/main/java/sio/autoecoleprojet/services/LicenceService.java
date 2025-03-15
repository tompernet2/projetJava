package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Licence;
import sio.autoecoleprojet.repositories.LeconRepository;
import sio.autoecoleprojet.repositories.LicenceRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceService {

    private LicenceRepository licenceRepository;

    public LicenceService()
    {
        this.licenceRepository = new LicenceRepository();
    }

    public ArrayList<Licence> getLicenceNonAcquis(int codeMoniteur) throws SQLException {
        return licenceRepository.getLicenceNonAcquis(codeMoniteur);

    }
    public ArrayList<Licence> getLicenceAcquis(int codeMoniteur) throws SQLException {
        return licenceRepository.getLicenceAcquis(codeMoniteur);

    }

    public void create(int codeLicence , int codeMoniteur , int codeCategorie , String dateObtention) throws SQLException {
        Licence licence = new Licence(codeLicence, codeMoniteur, codeCategorie, dateObtention);
        licenceRepository.create(licence);
    }

    public int getNewCodeLicence() throws SQLException {
        return licenceRepository.getNewCodeLicence();
    }


    }
