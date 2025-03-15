package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Categorie;
import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.User;
import sio.autoecoleprojet.repositories.CategorieRepository;
import sio.autoecoleprojet.repositories.EleveRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieService {

    private CategorieRepository categorieRepository;

    public CategorieService()
    {
        this.categorieRepository = new CategorieRepository();
    }
    public ArrayList<Categorie> getAll() throws SQLException {
        return categorieRepository.getAll();
    }

    public int getNewCodeCategorie() throws SQLException {
        return categorieRepository.getNewCodeCategorie();
    }

    public void create(int codeCategorie, String libelle, float prix) throws SQLException {
        Categorie categorie = new Categorie(codeCategorie , libelle , prix);
        categorieRepository.create(categorie);
    }

    public void update(int codeCategorie, String libelle, float prix) throws SQLException {
        Categorie categorie = new Categorie(codeCategorie, libelle, prix);
        categorieRepository.update(categorie);
    }

}
