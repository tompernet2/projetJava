package sio.autoecoleprojet.repositories;

import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.Lecon;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeconRepository  implements RepositoryInterface<Lecon, String>{

    private Connection connexionBDD;

    public LeconRepository()
    {
        this.connexionBDD = ConnexionBDD.getCnx();
    }


    @Override
    public void create(Lecon lecon) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("INSERT INTO `lecon` (`CodeLecon`, `Date`, `Heure`, `CodeMoniteur`, `CodeEleve`, `Immatriculation`, `Reglee`, `codeCategorie`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
        preparedStatement.setInt(1, lecon.getCodeLecon());
        preparedStatement.setString(2, lecon.getDate());
        preparedStatement.setString(3, lecon.getHeure());
        preparedStatement.setInt(4, lecon.getCodeMoniteur());
        preparedStatement.setInt(5, lecon.getCodeEleve());
        preparedStatement.setString(6, lecon.getImmatriculation());
        preparedStatement.setInt(7, lecon.getReglee());
        preparedStatement.setInt(8, lecon.getCodeCategorie());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Lecon lecon) throws SQLException {

    }

    @Override
    public void delete(Lecon lecon) {

    }

    @Override
    public Lecon get(String s) {
        return null;
    }

    @Override
    public ArrayList<Lecon> getAll() throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT lecon.Date , lecon.Heure , moniteur.Prenom PrenomMoniteur , eleve.Prenom AS PrenomEleve , eleve.Nom AS NomEleve ,lecon.Immatriculation, lecon.Reglee ,categorie.Libelle AS TypePermis FROM lecon JOIN moniteur ON moniteur.CodeMoniteur = lecon.CodeMoniteur JOIN eleve ON eleve.CodeEleve = lecon.CodeEleve JOIN categorie ON categorie.CodeCategorie = lecon.codeCategorie;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            lecons.add(new Lecon(
                    resultSet.getString("Date"),
                    resultSet.getString("Heure"),
                    resultSet.getString("PrenomMoniteur"),
                    resultSet.getString("PrenomEleve"),
                    resultSet.getString("NomEleve"),
                    resultSet.getString("Immatriculation"),
                    resultSet.getInt("Reglee"),
                    resultSet.getString("TypePermis")
            ));
        }
        return lecons;
    }

    public ArrayList<Lecon> getAllBy(int codeEleve) throws SQLException {

        ArrayList<Lecon> lecons = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT CodeLecon, Date, Heure, CodeMoniteur, CodeELeve, Immatriculation, Reglee FROM lecon WHERE CodeEleve = ?;");
        preparedStatement.setInt(1, codeEleve);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lecons.add(new Lecon(resultSet.getInt("CodeLecon"), resultSet.getString("Date"),resultSet.getString("Heure"), resultSet.getInt("CodeMoniteur"), resultSet.getInt("CodeEleve"), resultSet.getString("Immatriculation"),resultSet.getInt("Reglee")  ));
        }
        return lecons;
    }


    public ArrayList<Lecon> getLeconEleve(int codeEleve) throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        String sql = "SELECT lecon.Date AS LeconDate, lecon.Heure AS LeconHeure, " +
                "moniteur.Nom AS MoniteurNom, vehicule.Marque AS VehiculeMarque, " +
                "vehicule.Modele AS VehiculeModele, categorie.Libelle AS TypePermis " +
                "FROM lecon " +
                "JOIN moniteur ON lecon.CodeMoniteur = moniteur.CodeMoniteur " +
                "JOIN vehicule ON lecon.Immatriculation = vehicule.Immatriculation " +
                "JOIN categorie ON lecon.codeCategorie = categorie.CodeCategorie " +
                "WHERE lecon.CodeEleve = ?";
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(sql);
        preparedStatement.setInt(1, codeEleve);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Lecon lecon = new Lecon(
                    resultSet.getString("LeconDate"),
                    resultSet.getString("LeconHeure"),
                    resultSet.getString("MoniteurNom"),
                    resultSet.getString("VehiculeMarque"),
                    resultSet.getString("VehiculeModele"),
                    resultSet.getString("TypePermis")
            );
            lecons.add(lecon);
        }
        return lecons;
    }


    public ArrayList<Lecon> getLeconMoniteur(int codeMoniteur) throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        String sql = "SELECT lecon.Date AS LeconDate, lecon.Heure AS LeconHeure, eleve.Nom AS EleveNom, eleve.prenom AS ElevePrenom ,vehicule.Marque AS VehiculeMarque, vehicule.Modele AS VehiculeModele, categorie.Libelle AS TypePermis FROM lecon JOIN eleve ON lecon.CodeEleve = eleve.CodeEleve JOIN vehicule ON lecon.Immatriculation = vehicule.Immatriculation JOIN categorie ON lecon.codeCategorie = categorie.CodeCategorie WHERE lecon.CodeMoniteur = ?;";
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(sql);
        preparedStatement.setInt(1, codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("ElevePrenom: " + resultSet.getString("ElevePrenom"));
            System.out.println("EleveNom: " + resultSet.getString("EleveNom"));

            Lecon lecon = new Lecon(
                    resultSet.getString("LeconDate"),
                    resultSet.getString("LeconHeure"),
                    resultSet.getString("EleveNom"),
                    resultSet.getString("ElevePrenom"),
                    resultSet.getString("VehiculeMarque"),
                    resultSet.getString("VehiculeModele"),
                    resultSet.getString("TypePermis")
            );
            lecons.add(lecon);
        }

        return lecons;
    }

    public ArrayList<Lecon> getLeconAffBy(int codeEleve) throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(

                "SELECT \n" +
                        "    lecon.Date AS LeconDate, \n" +
                        "    lecon.Heure AS LeconHeure, \n" +
                        "    moniteur.Nom AS MoniteurNom,\n" +
                        "    vehicule.Marque AS VehiculeMarque, \n" +
                        "    vehicule.Modele AS VehiculeModele,\n" +
                        "    categorie.Libelle AS TypePermis\n" +
                        "FROM lecon  \n" +
                        "JOIN moniteur ON lecon.CodeMoniteur = moniteur.CodeMoniteur \n" +
                        "JOIN vehicule ON lecon.Immatriculation = vehicule.Immatriculation \n" +
                        "JOIN categorie ON lecon.codeCategorie = categorie.CodeCategorie\n" +
                        "WHERE lecon.CodeEleve = ? AND lecon.Date >= CURRENT_DATE;\n");

        preparedStatement.setInt(1, codeEleve);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lecons.add(new Lecon(
                    resultSet.getString("LeconDate"),
                    resultSet.getString("LeconHeure"),
                    resultSet.getString("MoniteurNom"),
                    resultSet.getString("VehiculeMarque"),

                    resultSet.getString("VehiculeModele"),
                    resultSet.getString("TypePermis")
            ));
        }


        return lecons;
    }

    public ArrayList<Lecon> getLeconAffByMoniteur(int codeMoniteur) throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(

                "SELECT \n" +
                        "    eleve.Nom AS NomEleve, \n" +
                        "    lecon.Date AS DateLecon, \n" +
                        "    lecon.Heure AS HeureLecon, \n" +
                        "    vehicule.Modele AS ModeleVehicule,\n" +
                        "    categorie.Libelle AS TypePermis\n" +
                        "FROM \n" +
                        "    lecon \n" +
                        "INNER JOIN \n" +
                        "    eleve ON lecon.CodeEleve = eleve.CodeEleve \n" +
                        "INNER JOIN \n" +
                        "    vehicule ON lecon.Immatriculation = vehicule.Immatriculation \n" +
                        "INNER JOIN \n" +
                        "    categorie ON lecon.codeCategorie = categorie.CodeCategorie\n" +
                        "WHERE \n" +
                        "    lecon.CodeMoniteur = ? AND lecon.Date >= CURRENT_DATE;\n"

        );

        preparedStatement.setInt(1, codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            lecons.add(new Lecon(
                    resultSet.getString("DateLecon"),
                    resultSet.getString("HeureLecon"),
                    resultSet.getString("ModeleVehicule"),

                    resultSet.getString("NomEleve"),
                    resultSet.getString("TypePermis")

            ));
        }
        return lecons;
    }



    public int getNewCodeLecon() throws SQLException {

        int newCodeLecon = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT MAX(CodeLecon) FROM lecon");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            newCodeLecon = resultSet.getInt(1);
        }
        newCodeLecon+= 1;
        return newCodeLecon;
    }

    public boolean verifLecon(int codeEleve, String date, String heure) throws SQLException {

        boolean leconDejaPrise = false;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT CodeLecon FROM lecon WHERE CodeEleve = ? AND Date = ? AND Heure = ?");
        preparedStatement.setInt(1,codeEleve);
        preparedStatement.setString(2,date);
        preparedStatement.setString(3,heure);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            leconDejaPrise = true;
        }

        return leconDejaPrise;
    }



}


