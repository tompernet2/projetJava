package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.Categorie;
import sio.autoecoleprojet.services.CategorieService;
import sio.autoecoleprojet.services.EleveService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieController {
    private CategorieService categorieService;

    public CategorieController() {
        this.categorieService = new CategorieService();
    }

    public ArrayList<Categorie> getAll() throws SQLException {
        return categorieService.getAll();
    }
    public int getNewCodeCategorie() throws SQLException {
        return categorieService.getNewCodeCategorie();
    }

    public void create(int codeCategorie, String libelle, float prix) throws SQLException {
        categorieService.create(codeCategorie , libelle , prix);
    }
    public void update(int codeCategorie, String libelle, float prix) throws SQLException {
        categorieService.update(codeCategorie, libelle, prix);
    }

}
