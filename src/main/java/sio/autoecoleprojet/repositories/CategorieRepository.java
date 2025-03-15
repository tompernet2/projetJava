package sio.autoecoleprojet.repositories;

import javafx.css.CssParser;
import sio.autoecoleprojet.models.Categorie;
import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.User;
import sio.autoecoleprojet.models.Vehicule;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieRepository implements RepositoryInterface<Categorie, String>{

    private Connection connexionBDD;

    public CategorieRepository()
    {
        this.connexionBDD = ConnexionBDD.getCnx();
    }



    @Override
    public void create(Categorie categorie) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("INSERT INTO categorie (Libelle , Prix , CodeCategorie) VALUES (?,?,?);");
        preparedStatement.setString(1, categorie.getLibelle());
        preparedStatement.setFloat(2, categorie.getPrix());
        preparedStatement.setInt(3, categorie.getCodeCategorie());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void update(Categorie categorie) throws SQLException {
        String query = "UPDATE categorie SET Libelle = ?, Prix = ? WHERE CodeCategorie = ?";
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(query);
        preparedStatement.setString(1, categorie.getLibelle());
        preparedStatement.setFloat(2, categorie.getPrix());
        preparedStatement.setInt(3, categorie.getCodeCategorie());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


    @Override
    public void delete(Categorie categorie) {

    }

    @Override
    public Categorie get(String s) {
        return null;
    }

    @Override
    public ArrayList<Categorie> getAll() throws SQLException {
        ArrayList<Categorie> categories = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("select CodeCategorie, Libelle, Prix from categorie");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            categories.add(new Categorie(resultSet.getInt("CodeCategorie"), resultSet.getString("Libelle"), resultSet.getFloat("Prix")));
        }
        return categories;
    }

    public int getNewCodeCategorie() throws SQLException {

        int newCodeCategorie = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT MAX(CodeCategorie) FROM categorie");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            newCodeCategorie = resultSet.getInt(1);
        }
        newCodeCategorie+= 1;
        return newCodeCategorie;
    }
}
