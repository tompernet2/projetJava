package sio.autoecoleprojet.repositories;

import sio.autoecoleprojet.models.Lecon;
import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.models.Vehicule;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeRepository implements RepositoryInterface<Vehicule, String>{

    private Connection connexionBDD;

    public VehiculeRepository()
    {
        this.connexionBDD = ConnexionBDD.getCnx();
    }

    @Override
    public void create(Vehicule vehicule) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("INSERT INTO `vehicule` (`Immatriculation`, `Marque`, `Modele`, `Annee`, `CodeCategorie`) VALUES (?,?,?,?,?);");
        preparedStatement.setString(1,vehicule.getImmatriculation());
        preparedStatement.setString(2, vehicule.getMarque());
        preparedStatement.setString(3, vehicule.getModele());
        preparedStatement.setInt(4, vehicule.getAnnee());
        preparedStatement.setInt(5, vehicule.getCodeCategorie());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Vehicule vehicule) throws SQLException {
        String query = "UPDATE vehicule SET Marque = ?, Modele = ?, Annee = ?, CodeCategorie = ? WHERE Immatriculation = ?";
        try (PreparedStatement preparedStatement = connexionBDD.prepareStatement(query)) {
            preparedStatement.setString(1, vehicule.getMarque());
            preparedStatement.setString(2, vehicule.getModele());
            preparedStatement.setInt(3, vehicule.getAnnee());
            preparedStatement.setInt(4, vehicule.getCodeCategorie());
            preparedStatement.setString(5, vehicule.getImmatriculation());
            preparedStatement.executeUpdate();
        }
    }


    @Override
    public void delete(Vehicule vehicule) {

    }

    @Override
    public Vehicule get(String s) {
        return null;
    }

    @Override
    public ArrayList<Vehicule> getAll() throws SQLException {
        ArrayList<Vehicule> vehicules = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT vehicule.Immatriculation , vehicule.Marque , vehicule.Modele , vehicule.Annee , categorie.Libelle AS categorieVehicule \n" +
                " FROM \n" +
                "vehicule INNER JOIN categorie ON vehicule.CodeCategorie = categorie.CodeCategorie;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            vehicules.add(new Vehicule(
                    resultSet.getString("Immatriculation"),
                    resultSet.getString("Marque"),
                    resultSet.getString("Modele"),
                    resultSet.getInt("Annee"),
                    resultSet.getString("categorieVehicule")
            ));
        }
        return vehicules;
    }


    public ArrayList<String> getCategorieVehicule() throws SQLException {
        ArrayList<String> categories = new ArrayList<>();
        String query = "SELECT libelle FROM categorie"; // Table indépendante des véhicules
        PreparedStatement stmt = connexionBDD.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            categories.add(resultSet.getString("libelle"));
        }
        return categories;
    }


    public int getCodeCategorieByLibelle(String libelle) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(
                "SELECT CodeCategorie FROM categorie WHERE Libelle = ?"
        );
        preparedStatement.setString(1, libelle);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("CodeCategorie");
        }
        throw new SQLException("Catégorie introuvable.");
    }

    public String recupImmatriculationDispo( int codeCategorie,String date, String heure) throws SQLException {
        String immat = null;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(
                "SELECT v.Immatriculation " +
                        "FROM vehicule v " +
                        "WHERE v.CodeCategorie = ? " +
                        "AND NOT EXISTS " +
                        "(SELECT 1 " +
                        "FROM lecon l " +
                        "WHERE l.Immatriculation = v.Immatriculation " +
                        "AND l.Date = ? " +
                        "AND l.Heure = ? );"
        );
        preparedStatement.setInt(1, codeCategorie);
        preparedStatement.setString(2, date);
        preparedStatement.setString(3, heure);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next())
        {
            immat = resultSet.getString("Immatriculation");
        }
        return immat;
    }



    public ArrayList<Vehicule> getVehiculeDispo(int codeCategorie, String date, String heure) throws SQLException {
        ArrayList<Vehicule> vehiculesDisponible = new ArrayList<>();

        String sql = "SELECT vehicule.Immatriculation, vehicule.CodeCategorie, vehicule.Modele, vehicule.Marque " +
                "FROM vehicule " +
                "WHERE vehicule.CodeCategorie = ? " +
                "AND vehicule.Immatriculation NOT IN ( " +
                "    SELECT lecon.Immatriculation " +
                "    FROM lecon " +
                "    WHERE lecon.Date = ? " +
                "    AND lecon.Heure = ? " +
                ");";

        try (PreparedStatement preparedStatement = connexionBDD.prepareStatement(sql)) {
            preparedStatement.setInt(1, codeCategorie);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, heure);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    vehiculesDisponible.add(new Vehicule(
                            resultSet.getString("Immatriculation"), // Use Immatriculation instead of CodeVehicule
                            resultSet.getString("Modele"),
                            resultSet.getString("Marque")
                    ));
                }
            }
        }

        return vehiculesDisponible;
    }




}
