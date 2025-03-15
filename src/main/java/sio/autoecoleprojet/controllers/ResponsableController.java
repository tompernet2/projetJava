package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.Responsable;
import sio.autoecoleprojet.services.MoniteurService;
import sio.autoecoleprojet.services.ResponsableService;

import java.sql.SQLException;

public class ResponsableController {
    private ResponsableService responsableService;

    public ResponsableController() {
        this.responsableService = new ResponsableService();
    }

    public Responsable recupResponsableCo(int numCompte) throws SQLException {
        return responsableService.recupResponsableCo(numCompte);
    }
}
