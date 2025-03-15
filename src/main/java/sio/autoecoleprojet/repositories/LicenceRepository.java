package sio.autoecoleprojet.repositories;

import sio.autoecoleprojet.models.Lecon;
import sio.autoecoleprojet.models.Licence;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceRepository implements RepositoryInterface<Licence, String>{

    private Connection connexionBDD;

    public LicenceRepository()
    {
        this.connexionBDD = ConnexionBDD.getCnx();
    }

    @Override
    public void create(Licence licence) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("INSERT INTO `licence` (`CodeLicence`, `CodeMoniteur`, `CodeCategorie`, `DateObtention`) " + "VALUES (?, ?, ?, ?);");
        preparedStatement.setInt(1, licence.getCodeLicence());
        preparedStatement.setInt(2, licence.getCodeMoniteur());
        preparedStatement.setInt(3, licence.getCodeCategorie());
        preparedStatement.setString(4, licence.getDateObtention());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void update(Licence licence) throws SQLException {

    }

    @Override
    public void delete(Licence licence) {

    }

    @Override
    public Licence get(String s) {
        return null;
    }

    @Override
    public ArrayList<Licence> getAll() throws SQLException {
        return null;
    }

    public ArrayList<Licence> getLicenceNonAcquis(int codeMoniteur) throws SQLException {
        ArrayList<Licence> licences = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(
                "SELECT c.Libelle, c.CodeCategorie " +
                        "FROM categorie c " +
                        "WHERE c.CodeCategorie NOT IN (SELECT l.CodeCategorie FROM licence l WHERE l.CodeMoniteur = ?);"
        );

        preparedStatement.setInt(1, codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            licences.add(new Licence(resultSet.getString("Libelle"), resultSet.getInt("CodeCategorie")));
        }
        return licences;
    }

    public ArrayList<Licence> getLicenceAcquis(int codeMoniteur) throws SQLException {
        ArrayList<Licence> licences = new ArrayList<>();

        PreparedStatement preparedStatement = connexionBDD.prepareStatement(
                "SELECT c.Libelle, c.CodeCategorie " +
                        "FROM categorie c " +
                        "WHERE c.CodeCategorie IN (SELECT l.CodeCategorie FROM licence l WHERE l.CodeMoniteur = ?);");
        preparedStatement.setInt(1, codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            licences.add(new Licence(resultSet.getString("Libelle"), resultSet.getInt("CodeCategorie")));
        }
        return licences;
    }


    public int getNewCodeLicence() throws SQLException {

        int newCodeLicence = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT MAX(CodeLicence) FROM licence");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            newCodeLicence = resultSet.getInt(1);
        }
        newCodeLicence+= 1;
        return newCodeLicence;
    }
}
